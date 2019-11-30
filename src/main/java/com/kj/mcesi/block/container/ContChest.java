package com.kj.mcesi.block.container;

import com.kj.mcesi.block.tileentity.KInventoryTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class ContChest extends KContainer<KInventoryTileEntity> {
	public ContChest(InventoryPlayer playerInv, KInventoryTileEntity machineInv, EntityPlayer player) {
		super(playerInv, machineInv, player);
		super.setupPlayerHotbar(40,0);
		super.setupPlayerInventory(40,0);
		for(int i = 0; i<machineInv.getInventoryRows(); i++) {
			for(int j = 0; j<machineInv.getInventoryCols(); j++) {
				addSlot(12+(j*STD_MARGIN), 18+i*STD_MARGIN);
			}
		}
	}
}
