package com.kj.mcesi.block.gui;

import com.kj.mcesi.block.container.ContainerTMachine;
import com.kj.mcesi.block.container.multiblocks.ContainerMultiblockTest;
import com.kj.mcesi.block.tileentity.KInventoryTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiTMultiblock extends KGui {
	public GuiTMultiblock(InventoryPlayer playerInventory, KInventoryTileEntity machineInventory, EntityPlayer player) {
		super(new ContainerMultiblockTest(playerInventory, machineInventory, player),
				179, 256, "tmachine.png", playerInventory, machineInventory);
		setLabelsColors(16086784, 16086784);
	}
}
