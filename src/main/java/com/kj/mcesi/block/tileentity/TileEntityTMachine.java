package com.kj.mcesi.block.tileentity;

import com.kj.mcesi.block.container.ContainerTMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class TileEntityTMachine extends KTileEntity /* extends TileEntityLockableLoot implements ITickable, IKTileEntity*/ {

	public TileEntityTMachine() {
		super("tmachine");
	}

	@Override
	public void update() {
	}

	@Override
	public int getInventoryRows() {
		return 8;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerTMachine(playerInventory, this, playerIn);
	}

	
	
	/*private NonNullList<ItemStack> content = NonNullList.<ItemStack>withSize(72, ItemStack.EMPTY);
	public int numPlayersUsing, ticksSinceSync;
	public float lidAngle, prevLidAngle;
	
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
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.tmachine";
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
		// TODO Auto-generated method stub
		super.writeToNBT(compound);
		if(!this.checkLootAndWrite(compound)) ItemStackHelper.saveAllItems(compound, content);
		if(compound.hasKey("CustomName", 8)) compound.setString("CustomName", this.customName);
		return compound;
	}
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerTMachine(playerInventory, this, playerIn);
	}
	
	@Override
	public String getGuiID() {
		return MCESI.MODID + ":tmachine";
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() {
		return content;
	}
	
	@Override
    public void update()
    {

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
	public int getInventoryRows() {
		return 8;
	}

	@Override
	public int getInventoryCols() {
		return 9;
	}*/
}
