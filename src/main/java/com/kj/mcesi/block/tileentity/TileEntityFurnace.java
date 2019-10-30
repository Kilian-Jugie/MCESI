package com.kj.mcesi.block.tileentity;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.block.container.ContFurnace;
import com.kj.mcesi.proxy.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class TileEntityFurnace extends KTileEntityMachine {
	private int m_ProcessTicks = 0;
	private boolean m_IsInProcess = false;
	
	public TileEntityFurnace() {
		super("tfurnace");
	}

	@Override
	public void update() {
		super.update();
	}
	
	@Override
	public void fixedUpdate() {
		if(m_IsInProcess) {
			if(m_ProcessTicks < 0) {
				MCESI.logger.info("PROCESS ENDED !");
				m_ProcessTicks = 0;
				m_IsInProcess = false;
				
				getItems().set(2, new ItemStack((Block)ModBlocks.getBlocks().get(0)));
				
			}
			else {
				MCESI.logger.info("PROCESSING State: "+m_ProcessTicks);
				m_ProcessTicks--;
			}
		}
		else if(ItemStack.areItemStacksEqual(getItems().get(0), new ItemStack((Block)ModBlocks.getBlocks().get(0)))) {
			MCESI.logger.info("EQUALS !");
			m_ProcessTicks = 20;
			m_IsInProcess = true;
			getItems().set(0, ItemStack.EMPTY);
		}
		
		
		
		
		
		//m_ProcessTicks++;
		
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
