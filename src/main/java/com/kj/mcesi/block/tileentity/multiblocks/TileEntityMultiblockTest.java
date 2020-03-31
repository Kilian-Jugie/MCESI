package com.kj.mcesi.block.tileentity.multiblocks;

import com.kj.mcesi.block.blocks.KBlockTest;
import com.kj.mcesi.block.container.multiblocks.ContainerMultiblockTest;
import com.kj.mcesi.block.multiblock.Pattern;
import com.kj.mcesi.block.tileentity.KTileMultiBlock;
import com.kj.mcesi.craft.MachineCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class TileEntityMultiblockTest extends KTileMultiBlock {
	private static final int SLOT_INPUT = 0;
	private static final int SLOT_FUEL = 1;
	private static final int SLOT_OUTPUT = 2;

	public TileEntityMultiblockTest() {
		super("tmultiblocktest",null,
				new Pattern("[aaa/aaa/aaa][b*b/bbb/bbb][aaa/aaa/aaa]", "ab", Blocks.COBBLESTONE, Blocks.STONEBRICK));
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
		return new ContainerMultiblockTest(playerInventory, this, playerIn);
	}
}
