package com.kj.mcesi.block.tileentity;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.block.container.ContFurnace;
import com.kj.mcesi.craft.MachineCraft;
import com.kj.mcesi.craft.MachineCraftRegistry;
import com.kj.mcesi.proxy.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;


public class TileEntityFurnace extends KTileEntityMachine {


	private static final int SLOT_INPUT = 0;
	private static final int SLOT_OUTPUT = 2;

	public TileEntityFurnace() {
		super("tfurnace");
		ItemStack input = new ItemStack((Block)ModBlocks.getBlocks().get(0));
		ItemStack output = new ItemStack((Block)ModBlocks.getBlocks().get(0));
		input.setCount(3);
		output.setCount(2);
		addCraft(new MachineCraft(input,output));
		addInput(SLOT_INPUT);
		addOutput(SLOT_OUTPUT);
	}
	
	/*@Override
	public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(getItems(), index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(getItems(), index);
    }*/
	
	
	
	

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void fixedUpdate() {
		updateProcess();
	}

	@Override
	public int getSizeInventory() {
		return 3;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContFurnace(playerInventory, this, playerIn);
	}
}
