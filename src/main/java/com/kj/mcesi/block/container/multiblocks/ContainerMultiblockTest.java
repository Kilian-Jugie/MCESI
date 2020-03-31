package com.kj.mcesi.block.container.multiblocks;

import com.kj.mcesi.block.container.KContainer;
import com.kj.mcesi.block.container.slot.KEventSlot;
import com.kj.mcesi.block.container.slot.KOutputSlot;
import com.kj.mcesi.block.tileentity.KInventoryTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerMultiblockTest extends KContainer<KInventoryTileEntity> {
	public ContainerMultiblockTest(InventoryPlayer playerInv, KInventoryTileEntity machineInv, EntityPlayer player) {
		super(playerInv, machineInv, player);
		super.setupPlayerHotbar(0,-91);
		super.setupPlayerInventory(0,-91);

		addSlot(new KEventSlot(machineInv, m_TileEntity, getNewIndex(), 56, 17));
		addSlot(new KEventSlot(machineInv, m_TileEntity, getNewIndex(), 56, 53));
		addSlot(new KOutputSlot(m_TileEntity, getNewIndex(), 116, 35));
		
	}
}
