package com.kj.mcesi.block.tileentity;

import net.minecraft.entity.player.EntityPlayer;

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
}
