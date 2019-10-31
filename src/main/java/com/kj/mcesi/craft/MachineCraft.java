package com.kj.mcesi.craft;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class MachineCraft {
	private ArrayList<ItemStack> m_Inputs;
	private ArrayList<ItemStack> m_Outputs;
	private boolean m_Strict = false;
	private int m_ProcessTime = 20;
	
	public MachineCraft(ArrayList<ItemStack> i, ArrayList<ItemStack> o) {
		m_Inputs = i;
		m_Outputs = o;
	}
	
	public MachineCraft(ItemStack i, ItemStack o) {
		m_Inputs = new ArrayList<ItemStack>(1);
		m_Outputs = new ArrayList<ItemStack>(1);
		m_Inputs.add(i);
		m_Outputs.add(o);
	}
	
	public void setStrict(boolean b) {
		m_Strict = b;
	}
	
	public boolean getStrict() {
		return m_Strict;
	}
	
	public ArrayList<ItemStack> getInputs() {
		return m_Inputs;
	}
	
	public ArrayList<ItemStack> getOutputs() {
		return m_Outputs;
	}

	public int getProcessTime() {
		return m_ProcessTime;
	}

	public void setProcessTime(int processTime) {
		m_ProcessTime = processTime;
	}
}
