package com.kj.mcesi.block.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class KSlot extends Slot implements IKSlot {
	public KSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	public void onSlotChange(ItemStack newStack, ItemStack oldStack) {
       
    }
	
	public boolean isItemValid(ItemStack stack) {
		return true;
	}
}
