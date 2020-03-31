package com.kj.mcesi.block.tileentity;

import java.util.ArrayList;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.block.blocks.KBlockTest;
import com.kj.mcesi.block.container.ContFurnace;
import com.kj.mcesi.craft.MachineCraft;
import com.kj.mcesi.craft.MachineCraftRegistry;
import com.kj.mcesi.proxy.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;


public class TileEntityFurnace extends KTileEntityMachine {


	private static final int SLOT_INPUT = 0;
	private static final int SLOT_FUEL = 1;
	private static final int SLOT_OUTPUT = 2;

	public TileEntityFurnace() {
		super("tfurnace");
		/*ItemStack input = new ItemStack((Block)ModBlocks.getBlocks().get(0));
		ItemStack fuel = new ItemStack(Items.COAL);
		ItemStack output = new ItemStack((Block)ModBlocks.getBlocks().get(0));
		input.setCount(3);
		fuel.setCount(5);
		output.setCount(2);
		
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		
		inputs.add(input);
		inputs.add(fuel);
		
		outputs.add(output);
		
		addCraft(new MachineCraft(inputs,outputs));*/
		
		addInput(SLOT_INPUT);
		addInput(SLOT_FUEL);
		addOutput(SLOT_OUTPUT);
		
		addCraft(new MachineCraft(2,1))
			.addInput(new ItemStack(KBlockTest.INSTANCE))
			.setLastInputCount(3)
			.addInput(new ItemStack(Items.COAL))
			.setLastInputCount(5)
			.addOutput(new ItemStack(KBlockTest.INSTANCE))
			.setLastOutputCount(2);
		
		
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
