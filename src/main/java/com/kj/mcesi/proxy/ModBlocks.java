package com.kj.mcesi.proxy;

import java.util.ArrayList;

import com.kj.mcesi.block.KBlock;
import com.kj.mcesi.block.KBlockChest;
import com.kj.mcesi.block.KBlockFurnace;
import com.kj.mcesi.block.KBlockTMachine;
import com.kj.mcesi.block.KBlockTest;
import com.kj.mcesi.block.IKBlock;

import net.minecraft.block.Block;

public class ModBlocks {
	private static ArrayList<IKBlock> m_Blocks = new ArrayList<IKBlock>();
	
	public static final void addBlock(IKBlock ref) {
		m_Blocks.add(ref);
	}
	
	public static final ArrayList<IKBlock> getBlocks() {
		return m_Blocks;
	}
	
	private ModBlocks() {}
	
	public static final void initInstances() {
		addBlock(new KBlockTest());
		addBlock(new KBlockTMachine());
		addBlock(new KBlockChest());
		addBlock(new KBlockFurnace());
	}
	
	//public static CBlock ctestblock;
}
