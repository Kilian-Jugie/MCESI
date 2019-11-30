package com.kj.mcesi.block.container;

import com.kj.mcesi.block.tileentity.KInventoryTileEntity;
import com.kj.mcesi.block.tileentity.TileEntityTMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTMachine extends KContainer<KInventoryTileEntity> {
	//private final int numRows;
	//private final TileEntityTMachine machineInventory;
	
	public ContainerTMachine(InventoryPlayer playerInv, KInventoryTileEntity machineInv, EntityPlayer player) {
		super(playerInv, machineInv, player);
		super.setupPlayerHotbar();
		super.setupPlayerInventory();
		for(int i = 0; i<machineInv.getInventoryRows(); i++) {
			for(int j = 0; j<machineInv.getInventoryCols(); j++) {
				this.addSlot(8+j*STD_MARGIN, 18+i*STD_MARGIN);
			}
		}
		
		/*this.machineInventory = machineInv;
		this.numRows = machineInv.getSizeInventory() / 9;
		machineInventory.openInventory(player);
		
		for(int i = 0; i<numRows; ++i) {
			for(int j = 0; j<9; ++j) {
				this.addSlotToContainer(new Slot(machineInventory, j+i*9, 8+j*18, 18+i*18));
			}
		}
		for(int y = 0; y<3; ++y) {
			for(int x = 0; x<9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x+y*9+9, 8+x*18, 175 + y*18));
			}
		}
		
		for(int x=0; x<9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, 8+x*18, 233));
		}*/
		
	}
	
	/*@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.machineInventory.isUsableByPlayer(playerIn);
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		machineInventory.closeInventory(playerIn);
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
 
            if (index < this.numRows * 9)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
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
	
	public TileEntityTMachine getMachineInventory() {
		return machineInventory;
	}*/
}
