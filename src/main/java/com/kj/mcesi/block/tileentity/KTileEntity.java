package com.kj.mcesi.block.tileentity;


import com.kj.mcesi.MCESI;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

public abstract class KTileEntity extends TileEntityLockableLoot implements ITickable, IKTileEntity {
	protected NonNullList<ItemStack> content = NonNullList.<ItemStack>withSize(72, ItemStack.EMPTY);
	public int numPlayersUsing;
	private final String m_Name;
	
	public KTileEntity(String name) {
		m_Name = name;
	}
	
	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container."+m_Name;
	}
	
	@Override
	public String getGuiID() {
		return MCESI.MODID + ":"+m_Name;
	}
	
	@Override
	public int getSizeInventory() {
		return this.getInventoryCols()*this.getInventoryRows();
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isEmpty() {
		for(ItemStack stack : this.content) {
			if(!stack.isEmpty()) return false;
		}
		return true;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.content = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if(!this.checkLootAndRead(compound)) ItemStackHelper.loadAllItems(compound, content);
		if(compound.hasKey("CustomName", 8)) this.customName = compound.getString("CustomName");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		if(!this.checkLootAndWrite(compound)) ItemStackHelper.saveAllItems(compound, content);
		if(compound.hasKey("CustomName", 8)) compound.setString("CustomName", this.customName);
		return compound;
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() {
		return content;
	}
	
	@Override
	public void openInventory(EntityPlayer player) {
		++this.numPlayersUsing;
		this.world.addBlockEvent(pos, this.getBlockType(), 1, this.numPlayersUsing);
		this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
	}
	
	@Override
	public void closeInventory(EntityPlayer player) {
		--this.numPlayersUsing;
		this.world.addBlockEvent(pos, this.getBlockType(), 1, this.numPlayersUsing);
		this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
	}

	@Override
	public int getInventoryCols() {
		return 9;
	}
	
	@Override
	public int getInventoryRows() {
		return 0;
	}
	
	@Override
	public void fixedUpdate() {
		//NOOP
	}
}
