package com.kj.mcesi.block.container.slot;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.block.tileentity.IKTileEntity;

import net.minecraft.inventory.IInventory;

public class KEventSlot extends KSlot {
	private IKTileEntity m_Parent;
	
	public KEventSlot(IKTileEntity parent, IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		m_Parent = parent;
	}
	
	@Override
	public void onSlotChanged() {
		m_Parent.onSlotChanged(slotNumber);
		super.onSlotChanged();
	}

}
