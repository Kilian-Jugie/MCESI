package com.kj.mcesi.block.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class KOutputSlot extends KSlot {

	public KOutputSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
}
