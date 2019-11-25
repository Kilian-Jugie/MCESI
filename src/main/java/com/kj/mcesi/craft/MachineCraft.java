package com.kj.mcesi.craft;

import java.util.ArrayList;

import com.kj.mcesi.MCESI;

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
	
	public MachineCraft(int inputSize, int outputSize) {
		m_Inputs = new ArrayList<ItemStack>(inputSize);
		m_Outputs = new ArrayList<ItemStack>(outputSize);
	}
	
	public MachineCraft addInput(ItemStack in) {
		m_Inputs.add(in);
		return this;
	}
	
	public MachineCraft addOutput(ItemStack in) {
		m_Outputs.add(in);
		return this;
	}
	
	public void setStrict(boolean b) {
		m_Strict = b;
	}
	
	public boolean getStrict() {
		return m_Strict;
	}
	
	public MachineCraft setLastInputCount(int count) {
		m_Inputs.get(m_Inputs.size()-1).setCount(count);
		return this;
	}
	
	public MachineCraft setLastOutputCount(int count) {
		m_Outputs.get(m_Outputs.size()-1).setCount(count);
		return this;
	}
	
	//Id might never be implemented
	/*
	public void setInputCount(int id, int count) {
		m_Inputs.get(id).setCount(count);
	}
	
	public void setOutputCount(int id, int count) {
		m_Outputs.get(id).setCount(count);
	}*/
	
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
	
	//It seems that count is initialized to 1 so we don't need this
	/*
	private void checkCount(ItemStack i) {
		if(i.getCount() == 0)
			i.setCount(1);
	}*/
}
