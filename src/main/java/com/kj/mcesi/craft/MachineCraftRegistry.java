package com.kj.mcesi.craft;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

/*
 * TO WORK AROUND :
 * When there is more input slots than inputs in
 * craft, recipes are not found and the user must
 * define the unused slots as ItemStack.EMPTY
 * 
 * Should we change this to automaticaly compare
 * these slots to ItemStack.EMPTY ?
 */
public class MachineCraftRegistry {
	private ArrayList<MachineCraft> m_Crafts = new ArrayList<>();
	
	
	public MachineCraftRegistry() {}
	
	public MachineCraft addCraft(MachineCraft c) {
		m_Crafts.add(c);
		return m_Crafts.get(m_Crafts.size()-1);
	}
	
	/*
	 * Only used for faster computation than with inputs
	 */
	public MachineCraft getCraftForInput(ItemStack input) {
		ItemStack cInp;
		for(MachineCraft c : m_Crafts) {
			cInp = c.getInputs().get(0);
			if(cInp.isItemEqual(input) &&
					input.getCount() >= cInp.getCount()) 
				return c;
		}
		return null;
	}
	
	public MachineCraft getCraftForInputs(ArrayList<ItemStack> inputs) {
		ItemStack cInp, inp;
		int equCount = 0;
		for(MachineCraft c : m_Crafts) {
			if(c.getInputs().size()==inputs.size()) {
				equCount = 0;
				for(int i = 0; i<inputs.size(); i++) {
					cInp = c.getInputs().get(i);
					inp = inputs.get(i);
					if(cInp.isItemEqual(inp) &&
							inp.getCount() >= cInp.getCount() )
						equCount++;
				}
				if(equCount == inputs.size()) 
					return c;
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
