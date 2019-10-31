package com.kj.mcesi.craft;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class MachineCraftRegistry {
	private ArrayList<MachineCraft> m_Crafts;
	
	
	public MachineCraftRegistry() {}
	
	public void addCraft(MachineCraft c) {
		m_Crafts.add(c);
	}
	
	public MachineCraft getCraftForInput(ItemStack input) {
		for(MachineCraft c : m_Crafts) {
			if(c.getInputs().get(0).isItemEqual(input)) 
				return c;
		}
		return null;
	}
	
	public MachineCraft getCraftForInputs(ArrayList<ItemStack> inputs) {
		for(MachineCraft c : m_Crafts) {
			if(c.getInputs().size()==inputs.size()) {
				for(int i = 0; i<inputs.size(); i++) {
					if(c.getInputs().get(i).isItemEqual(inputs.get(i)))
						return c;
				}
			}
		}
		return null;
	}
	
	public ArrayList<ItemStack> getOutputsForInputs(ArrayList<ItemStack> inputs) {
		MachineCraft c = getCraftForInputs(inputs);
		if(c != null)
			return c.getOutputs();
		return null;
	}
}
