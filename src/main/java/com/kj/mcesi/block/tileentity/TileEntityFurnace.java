package com.kj.mcesi.block.tileentity;

import com.kj.mcesi.block.container.ContFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class TileEntityFurnace extends KTileEntityMachine {
	public TileEntityFurnace() {
		super("tchest");
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public int getSizeInventory() {
		return 3;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContFurnace(playerInventory, this, playerIn);
	}
}
