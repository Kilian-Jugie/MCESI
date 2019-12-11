package com.kj.mcesi.item.tool;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

public class KMiningTool extends KTool {
	protected int m_HarvestLevel;

	protected KMiningTool(String name, ToolClass toolClass, KToolMaterialClass materialClass) {
		super(name, materialClass, toolClass);
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) {
		return this.efficiency;
	}

}
