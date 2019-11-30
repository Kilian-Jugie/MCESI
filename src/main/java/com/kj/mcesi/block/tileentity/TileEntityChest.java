package com.kj.mcesi.block.tileentity;

import com.kj.mcesi.block.container.ContChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class TileEntityChest extends KInventoryTileEntity {
	public TileEntityChest() {
		super("tchest");
	}

	@Override
	public void update() {
	}

	@Override
	public int getInventoryRows() {
		return 8;
	}
	
	@Override
	public int getInventoryCols() {
		return 13;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContChest(playerInventory, this, playerIn);
	}
}
