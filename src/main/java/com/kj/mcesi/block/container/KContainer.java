package com.kj.mcesi.block.container;


import com.kj.mcesi.block.tileentity.KTileEntity;
import com.kj.mcesi.block.tileentity.TileEntityTMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class KContainer<_T extends KTileEntity> extends Container {
	protected final int m_Rows;
	protected final int m_Cols;
	protected final _T m_TileEntity;
	protected final InventoryPlayer m_PlayerInventory;
	private int m_SlotIndex;
	
	public static final int STD_MARGIN = 18;
	
	public KContainer(InventoryPlayer playerInv, _T machineInv, EntityPlayer player) {
		m_PlayerInventory = playerInv;
		m_TileEntity = machineInv;
		m_Rows = machineInv.getInventoryRows();
		m_Cols = machineInv.getInventoryCols();
		
		m_TileEntity.openInventory(player);
		
		/*for(int i = 0; i<m_Rows; ++i) {
			for(int j = 0; j<m_Cols; ++j) {
				this.addSlotToContainer(new Slot((IInventory)m_TileEntity, j+i*9, 8+j*18, 18+i*18));
			}
		}*/
	}
	
	protected void addSlot(int x, int y) {
		this.addSlotToContainer(new Slot(m_TileEntity, m_SlotIndex++, x, y));
	}
	
	protected void setupPlayerInventory() {
		for(int y = 0; y<3; ++y) {
			for(int x = 0; x<9; ++x) {
				this.addSlotToContainer(new Slot(m_PlayerInventory, x+y*9+9, 8+x*STD_MARGIN, 175 + y*STD_MARGIN));
			}
		}
	}
	
	protected void setupPlayerHotbar() {
		for(int x=0; x<9; ++x) {
			this.addSlotToContainer(new Slot(m_PlayerInventory, x, 8+x*STD_MARGIN, 233));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return m_TileEntity.isUsableByPlayer(playerIn);
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		m_TileEntity.closeInventory(playerIn);
	}
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
 
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
 
            if (index < m_Rows * m_Cols)
            {
                if (!this.mergeItemStack(itemstack1, m_Rows * m_Cols, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, m_Rows * m_Cols, false))
            {
                return ItemStack.EMPTY;
            }
 
            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }
 
        return itemstack;
    }
	
	public _T getMachineInventory() {
		return m_TileEntity;
	}
}
