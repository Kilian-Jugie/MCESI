package com.kj.mcesi.block;

import com.kj.mcesi.block.tileentity.IKTileEntity;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class KBlockContainerMulti extends KBlockContainer {
	public KBlockContainerMulti(String name, Material mat, int guiId) {
		super(name, mat, guiId);
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		IKTileEntity tile = (IKTileEntity)worldIn.getTileEntity(pos);
		tile.onHarvested(worldIn, pos, state, player);
		super.onBlockHarvested(worldIn, pos, state, player);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(worldIn.isRemote)
			return true;
		IKTileEntity tile = (IKTileEntity)worldIn.getTileEntity(pos);
		if(tile.onActivated(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ)) return true;
		
		
		//return false;
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ);
	}

	
}
