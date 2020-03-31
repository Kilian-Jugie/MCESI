package com.kj.mcesi.block;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.block.tileentity.IKTileEntity;
import com.kj.mcesi.item.tool.KMiningCapability;
import com.kj.mcesi.util.IKRegistrable;
import com.kj.mcesi.util.KHardness;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class KBlockContainer extends BlockContainer implements IKBlock {
	private final int m_GuiId;
	
	public KBlockContainer(String name, Material mat, int guiId) {
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(name);
		m_GuiId = guiId;
		this.setHardness(KHardness.MACHINE);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			playerIn.openGui(MCESI.instance, m_GuiId, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return false;
		}
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityLockableLoot) {
				((TileEntityLockableLoot) tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		IInventory tileentity = (IInventory) worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public void onRegister() {
		
	}
	
	@Override
	public KMiningCapability getMiningCapability() {
		return KMiningCapability.DEFAULT_PICKAXE;
	}
}
