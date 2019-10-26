package com.kj.mcesi.block.gui;

import com.kj.mcesi.block.container.ContainerTMachine;
import com.kj.mcesi.block.tileentity.KTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiChest extends KGui {
	public GuiChest(InventoryPlayer playerInventory, KTileEntity machineInventory, EntityPlayer player) {
		super(new ContainerTMachine(playerInventory, machineInventory, player),
				176, 256, "tchest.png", playerInventory, machineInventory);
		setLabelsColors(16086784, 16086784);
	}
}
