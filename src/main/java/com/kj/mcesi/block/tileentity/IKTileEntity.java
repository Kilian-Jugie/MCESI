package com.kj.mcesi.block.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IKTileEntity {
	/*
	 * @brief Get the number of rows in inventory
	 */
	public int getInventoryRows();
	/*
	 * @brief Get the number of columns in inventory
	 */
	public int getInventoryCols();
	/*
	 * @brief Event called when inventory is open
	 * @param player The player which opens it
	 */
	public void openInventory(EntityPlayer player);
	/*
	 * @brief Is called each 10 ticks by default to
	 * avoid updating blocks each ticks just for make
	 * them progress in process
	 */
	public void fixedUpdate();
	
	public void onSlotChanged(int index);
	
	public boolean onActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ);
	
	public void onHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player);
}
