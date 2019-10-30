package com.kj.mcesi.block.container;


import com.kj.mcesi.MCESI;
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
	}
	
	/*
	 * @brief add a slot at a given position
	 * @param x X coordinate
	 * @param y Y coordinate
	 * 
	 * This function avoid the managment of ids
	 */
	protected void addSlot(int x, int y) {
		this.addSlotToContainer(new Slot(m_TileEntity, m_SlotIndex++, x, y));
	}
	
	/* TODO: Uniformization
	 * @brief Setup the default player inventory
	 * @param xMargin Margin in pixels on the X axis
	 * @param yMargin Margin in pixels on the Y axis
	 */
	protected void setupPlayerInventory(int xMargin, int yMargin) {
		for(int y = 0; y<3; ++y) {
			for(int x = 0; x<9; ++x) {
				this.addSlotToContainer(new Slot(m_PlayerInventory, x+y*9+9, 8+x*STD_MARGIN+xMargin, 175 + y*STD_MARGIN+yMargin));
			}
		}
	}
	
	/* TODO: Uniformization
	 * @brief Setup the default player hotbar
	 * @param xMargin Margin in pixels on the X axis
	 * @param yMargin Margin in pixels on the Y axis
	 */
	protected void setupPlayerHotbar(int xMargin, int yMargin) {
		for(int x=0; x<9; ++x) {
			this.addSlotToContainer(new Slot(m_PlayerInventory, x, 8+x*STD_MARGIN+xMargin, 233+yMargin));
		}
	}
	
	//TODO: deprecation
	protected void setupPlayerInventory() {
		setupPlayerInventory(0,0);
	}
	
	//TODO: deprecation
	protected void setupPlayerHotbar() {
		setupPlayerHotbar(0,0);
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
