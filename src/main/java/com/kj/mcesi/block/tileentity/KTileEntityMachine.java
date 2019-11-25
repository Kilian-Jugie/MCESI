package com.kj.mcesi.block.tileentity;

import java.util.ArrayList;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.craft.MachineCraft;
import com.kj.mcesi.craft.MachineCraftRegistry;
import com.kj.mcesi.util.Util;

import net.minecraft.item.ItemStack;

public abstract class KTileEntityMachine extends KTileEntity {
	//Default: 9 -> each 10 ticks refresh
	private static final int FIXED_UPDATE_TCOUNT = 9;
	private int m_Ticks = 0;
	private int m_ProcessTicks = 0;
	private int m_BaseProcessTicks = 0;
	private boolean m_IsInProcess = false;
	private ArrayList<Integer> m_Inputs = new ArrayList<>();
	private ArrayList<Integer> m_Outputs = new ArrayList<>();
	
	protected MachineCraftRegistry m_CraftRegistry = new MachineCraftRegistry();
	protected MachineCraft m_CurrentCraft;
	
	public KTileEntityMachine(String name) {
		super(name);
	}
	
	@Override
	public void update() {
		if(m_Ticks>FIXED_UPDATE_TCOUNT) {
			m_Ticks = 0;
			fixedUpdate();
		}
		else
			m_Ticks++;
	}
	
	protected void addInput(int in) {
		m_Inputs.add(in);
	}
	
	protected void addOutput(int out) {
		m_Outputs.add(out);
	}
	
	protected MachineCraft addCraft(MachineCraft craft) {
		return m_CraftRegistry.addCraft(craft);
	}
	
	protected ArrayList<ItemStack> getInputsContent() {
		return Util.getIndexesOfArray(getItems(), m_Inputs);
	}
	
	protected ArrayList<ItemStack> getOutputsContent() {
		return Util.getIndexesOfArray(getItems(), m_Outputs);
	}
	
	protected boolean canStartProcess(ArrayList<ItemStack> outputs) {
		return Util.forAllIndexAND(getOutputsContent(),
				(item,index) -> { 
					if(index < outputs.size()) //if craft has less output than outputs slots we don't care
						return true;
					return item.isEmpty() || (
						ItemStack.areItemsEqual(item, outputs.get(index)) &&
						item.getCount()+outputs.get(index).getCount() < getInventoryStackLimit() ); 
				});
		
		
		/*return getItems().get(SLOT_OUTPUT).isEmpty() || (ItemStack.areItemsEqual(getItems().get(SLOT_OUTPUT), output) &&
				getItems().get(SLOT_OUTPUT).getCount()<getInventoryStackLimit());*/
	}
	
	@Override
	public void onSlotChanged(int index) {
		if(!this.world.isRemote) {
			MCESI.logger.info("Slot changed ! id:"+index);
			checkForProcess();
			markDirty();
		}
	}
	
	protected void checkForProcess() {
		if(!m_IsInProcess/*&&!Util.forAllAND(getInputsContent(), (item) -> {return item.isEmpty();}) */) {
			m_CurrentCraft = m_CraftRegistry.getCraftForInputs(getInputsContent());
			if(m_CurrentCraft != null&&canStartProcess(m_CurrentCraft.getOutputs())) {
				m_BaseProcessTicks = m_ProcessTicks = m_CurrentCraft.getProcessTime();
				m_IsInProcess = true;
				
				Util.forEachIndex(getInputsContent(), (item, index) -> {
					if(index < m_CurrentCraft.getInputs().size())
						item.shrink(m_CurrentCraft.getInputs().get(index).getCount());
				});
				
				//getInputsContent().forEach((item) -> item.shrink(1));
				//getItems().get(SLOT_INPUT).shrink(1);
			}
		}
	}
	
	protected void updateProcess() {
		if(!this.world.isRemote) {
			if(m_IsInProcess) {
				if(m_ProcessTicks < 0) {
					m_ProcessTicks = 0;
					m_IsInProcess = false;
					
					Util.forEachIndex(getOutputsContent(), (outItem, index) -> {
						if(outItem.isEmpty()) {
							getItems().set(m_Outputs.get(index), m_CurrentCraft.getOutputs().get(0).copy());
						}
						else {
							getItems().get(m_Outputs.get(index)).setCount(getItems().get(m_Outputs.get(index)).getCount()+1);
						}
					});

					checkForProcess();
					markDirty();
					
				}
				else {
					MCESI.logger.info("PROCESSING State: "+(m_BaseProcessTicks-m_ProcessTicks)+"/"+m_BaseProcessTicks);
					m_ProcessTicks--;
				}
			}
		}
	}
}
