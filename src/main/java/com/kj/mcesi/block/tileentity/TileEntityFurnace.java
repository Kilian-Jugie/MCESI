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
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/*
 * TODO IMPORTANT:
 *  - cached item update to update only once when same item
 *  	is in input slot and cannot be processed
 * 
 */

public class TileEntityFurnace extends KTileEntityMachine {
	private int m_ProcessTicks = 0;
	private boolean m_IsInProcess = false;
	
	private static final int SLOT_INPUT = 0;
	private static final int SLOT_OUTPUT = 2;
	
	private MachineCraftRegistry craftRegistry = new MachineCraftRegistry();
	private MachineCraft m_CurrentCraft;
	
	public TileEntityFurnace() {
		super("tfurnace");
		craftRegistry.addCraft(
				new MachineCraft(new ItemStack((Block)ModBlocks.getBlocks().get(0)),
						new ItemStack((Block)ModBlocks.getBlocks().get(0))));
	}

	@Override
	public void update() {
		super.update();
	}
	
	private boolean canStartProcess(ItemStack output) {
		
		return ItemStack.areItemsEqual(getItems().get(SLOT_OUTPUT), output) &&
				getItems().get(SLOT_OUTPUT).getCount()<getInventoryStackLimit();
	}
	
	private void updateProcess() {
		if(m_IsInProcess) {
			if(m_ProcessTicks < 0) {
				MCESI.logger.info("PROCESS ENDED !");
				m_ProcessTicks = 0;
				m_IsInProcess = false;
				
				//getItems().set(SLOT_OUTPUT, new ItemStack((Block)ModBlocks.getBlocks().get(0)));
				if(getItems().get(SLOT_OUTPUT).isEmpty()) {
					getItems().set(SLOT_OUTPUT, m_CurrentCraft.getOutputs().get(0));
				}
				else {
					getItems().get(SLOT_OUTPUT).setCount(getItems().get(SLOT_OUTPUT).getCount()+1);
				}
			}
			else {
				MCESI.logger.info("PROCESSING State: "+m_ProcessTicks);
				m_ProcessTicks--;
			}
		}
		else if(!getItems().get(SLOT_INPUT).isEmpty()) {
			m_CurrentCraft = craftRegistry.getCraftForInput(getItems().get(SLOT_INPUT));
			if(m_CurrentCraft != null&&canStartProcess(m_CurrentCraft.getOutputs().get(0))) {
				m_ProcessTicks = m_CurrentCraft.getProcessTime();
				m_IsInProcess = true;
				getItems().get(SLOT_INPUT).shrink(1);
			}
			
			/*if(ItemStack.areItemsEqual(getItems().get(0), new ItemStack((Block)ModBlocks.getBlocks().get(0)))) {
				MCESI.logger.info("EQUALS !");
				m_ProcessTicks = 20;
				m_IsInProcess = true;
				getItems().get(SLOT_INPUT).shrink(1);
				//getItems().set(SLOT_INPUT, );
				//getItems().set(SLOT_INPUT, ItemStack.EMPTY);
				
			}*/
		}
		
		
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
