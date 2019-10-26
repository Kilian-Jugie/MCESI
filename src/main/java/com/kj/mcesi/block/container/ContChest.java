package com.kj.mcesi.block.container;

import com.kj.mcesi.block.tileentity.KTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class ContChest extends KContainer<KTileEntity> {
	public ContChest(InventoryPlayer playerInv, KTileEntity machineInv, EntityPlayer player) {
		super(playerInv, machineInv, player);
		super.setupPlayerHotbar();
		super.setupPlayerInventory();
		for(int i = 0; i<machineInv.getInventoryRows(); ++i) {
			for(int j = 0; j<machineInv.getInventoryCols(); ++j) {
				this.addSlot(8+j*STD_MARGIN, 18+i*STD_MARGIN);
			}
		}
	}
}
