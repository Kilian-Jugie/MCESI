package com.kj.mcesi.block.container;

import com.kj.mcesi.block.container.slot.KEventSlot;
import com.kj.mcesi.block.container.slot.KOutputSlot;
import com.kj.mcesi.block.tileentity.KTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class ContFurnace extends KContainer<KTileEntity> {
	public ContFurnace(InventoryPlayer playerInv, KTileEntity machineInv, EntityPlayer player) {
		super(playerInv, machineInv, player);
		super.setupPlayerHotbar(0,-91);
		super.setupPlayerInventory(0,-91);
		/*for(int i = 0; i<machineInv.getInventoryRows(); i++) {
			for(int j = 0; j<machineInv.getInventoryCols(); j++) {
				addSlot(12+(j*STD_MARGIN), 18+i*STD_MARGIN);
			}
		}*/
		//addSlot(56,17);
		addSlot(new KEventSlot(machineInv, m_TileEntity, getNewIndex(), 56, 17));
		addSlot(56,53);
		//addSlot(116,35);
		addSlot(new KOutputSlot(m_TileEntity, getNewIndex(), 116, 35));
		
	}
}
