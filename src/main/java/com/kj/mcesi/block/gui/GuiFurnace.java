package com.kj.mcesi.block.gui;

import com.kj.mcesi.block.container.ContChest;
import com.kj.mcesi.block.container.ContFurnace;
import com.kj.mcesi.block.tileentity.KInventoryTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiFurnace extends KGui {
	public GuiFurnace(InventoryPlayer playerInventory, KInventoryTileEntity machineInventory, EntityPlayer player) {
		super(new ContFurnace(playerInventory, machineInventory, player),
				176, 166, "tfurnace.png", playerInventory, machineInventory);
		setLabelsColors(16086784, 16086784);
	}
}
