package com.kj.mcesi.block.tileentity;

import javax.annotation.Nullable;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.block.IKMultiController;
import com.kj.mcesi.block.multiblock.Pattern;
import com.kj.mcesi.util.Position;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class KTileMultiBlock extends KTileEntityMachine implements IKMultiController {
	private Item m_CheckItem;
	private boolean m_IsBuilt;
	protected Pattern m_Pattern;

	public KTileMultiBlock(String name, @Nullable Item checkItem, Pattern pattern) {
		super(name);
		m_CheckItem = checkItem;
		m_Pattern = pattern;
	}
	
	@Override
	public void onHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		m_IsBuilt = false;
		super.onHarvested(worldIn, pos, state, player);
	}
	
	@Override
	public boolean onActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		
		if(!m_IsBuilt) {
			if(m_CheckItem == null || m_CheckItem == playerIn.getActiveItemStack().getItem()) {
				m_IsBuilt = checkForPattern(worldIn, pos);
				if(m_IsBuilt)
					onBuilt();
				return true;
			}
		}
		
		return super.onActivated(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ);
	}
	
	@Override
	public boolean checkForPattern(World worldIn, BlockPos pos) {
		return checkForPattern(worldIn, pos, m_Pattern);
	}
	
	public boolean checkForPattern(World worldIn, BlockPos pos, Pattern pat, Rotation rota) {
		MCESI.logger.info("Checking pos with coef: "+rota);
		for(int i = 0; i<pat.size(); i++) {
			BlockPos patPos = pat.at(i).getPosition().getBlockPos();
			patPos = patPos.rotate(rota);
			BlockPos blockPos = new BlockPos(
					pos.getX()+(patPos.getX()),
					pos.getY()+(patPos.getY()),
					pos.getZ()+(patPos.getZ()));
			
			if(!Block.isEqualTo(worldIn.getBlockState(blockPos).getBlock(),
				pat.at(i).getBlock())) {
				MCESI.logger.info("Checking block "+i+" waiting for: "+pat.at(i).getBlock()+
						" at position "+blockPos+" (relative: "+pat.at(i).getPosition()+") getting: "+worldIn.getBlockState(blockPos).getBlock());
				return false;
			}
		}
		return true;
	}
	
	public boolean checkForPattern(World worldIn, BlockPos pos, Pattern pat) {
		return checkForPattern(worldIn, pos, pat, Rotation.NONE) ||
				checkForPattern(worldIn, pos, pat, Rotation.CLOCKWISE_90) ||
				checkForPattern(worldIn, pos, pat, Rotation.COUNTERCLOCKWISE_90) ||
				checkForPattern(worldIn, pos, pat, Rotation.CLOCKWISE_180);
	}
	
	@Override
	public void onBuilt() {
		MCESI.logger.info("Multiblock built !");
	}
}
