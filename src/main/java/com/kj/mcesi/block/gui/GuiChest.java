package com.kj.mcesi.block.gui;

import com.kj.mcesi.block.container.ContChest;
import com.kj.mcesi.block.tileentity.KInventoryTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiChest extends KGui {
	public GuiChest(InventoryPlayer playerInventory, KInventoryTileEntity machineInventory, EntityPlayer player) {
		super(new ContChest(playerInventory, machineInventory, player),
				256, 256, "tchest.png", playerInventory, machineInventory);
		setLabelsColors(16086784, 16086784);
	}
}
