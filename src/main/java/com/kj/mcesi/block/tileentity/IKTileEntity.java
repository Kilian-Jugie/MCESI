package com.kj.mcesi.block.tileentity;

import net.minecraft.entity.player.EntityPlayer;

public interface IKTileEntity {
	public int getInventoryRows();
	public int getInventoryCols();
	public void openInventory(EntityPlayer player);
}
