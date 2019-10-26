package com.kj.mcesi.block.gui;

import com.kj.mcesi.block.container.ContainerTMachine;
import com.kj.mcesi.block.tileentity.KTileEntity;
import com.kj.mcesi.block.tileentity.TileEntityTMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiTMachine extends KGui {
	public GuiTMachine(InventoryPlayer playerInventory, KTileEntity machineInventory, EntityPlayer player) {
		super(new ContainerTMachine(playerInventory, machineInventory, player),
				179, 256, "tmachine.png", playerInventory, machineInventory);
		setLabelsColors(16086784, 16086784);
	}
}
