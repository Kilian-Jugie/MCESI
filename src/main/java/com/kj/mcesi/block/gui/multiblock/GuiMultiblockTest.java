package com.kj.mcesi.block.gui.multiblock;

import com.kj.mcesi.block.container.multiblocks.ContainerMultiblockTest;
import com.kj.mcesi.block.gui.KGui;
import com.kj.mcesi.block.tileentity.KInventoryTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiMultiblockTest extends KGui {
	public GuiMultiblockTest(InventoryPlayer playerInventory, KInventoryTileEntity machineInventory, EntityPlayer player) {
		super(new ContainerMultiblockTest(playerInventory, machineInventory, player),
				176, 166, "tfurnace.png", playerInventory, machineInventory);
		setLabelsColors(16086784, 16086784);
	}
}
