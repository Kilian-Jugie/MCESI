package com.kj.mcesi.block.container.slot;

import net.minecraft.item.ItemStack;

public interface IKSlot {
	public void onSlotChange(ItemStack newStack, ItemStack oldStack);
	public boolean isItemValid(ItemStack stack);
}
