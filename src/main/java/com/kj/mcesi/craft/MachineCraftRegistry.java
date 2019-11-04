package com.kj.mcesi.craft;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class MachineCraftRegistry {
	private ArrayList<MachineCraft> m_Crafts = new ArrayList<>();
	
	
	public MachineCraftRegistry() {}
	
	public void addCraft(MachineCraft c) {
		m_Crafts.add(c);
	}
	
	/*
	 * Only used for faster computation than with inputs
	 */
	public MachineCraft getCraftForInput(ItemStack input) {
		ItemStack cInp;
		for(MachineCraft c : m_Crafts) {
			cInp = c.getInputs().get(0);
			if(cInp.isItemEqual(input) &&
					cInp.getCount() == input.getCount()) 
				return c;
		}
		return null;
	}
	
	public MachineCraft getCraftForInputs(ArrayList<ItemStack> inputs) {
		ItemStack cInp, inp;
		for(MachineCraft c : m_Crafts) {
			if(c.getInputs().size()==inputs.size()) {
				for(int i = 0; i<inputs.size(); i++) {
					cInp = c.getInputs().get(i);
					inp = inputs.get(i);
					if(cInp.isItemEqual(inp) &&
							cInp.getCount() == inp.getCount())
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
