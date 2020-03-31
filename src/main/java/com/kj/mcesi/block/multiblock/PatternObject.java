package com.kj.mcesi.block.multiblock;

import com.kj.mcesi.util.Position;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public class PatternObject {
	private Block m_Block;
	private Position m_Position;
	
	public PatternObject(Block block, Position pos) {
		m_Block = block;
		m_Position = pos;
	}
	
	public Block getBlock() {
		return m_Block;
	}
	
	public Position getPosition() {
		return m_Position;
	}
}
