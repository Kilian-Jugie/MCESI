package com.kj.mcesi.block;

import com.kj.mcesi.item.tool.KMiningCapability;
import com.kj.mcesi.util.IKRegistrable;

import net.minecraft.block.state.IBlockState;

public interface IKBlock extends IKRegistrable {

	/*
	 * @brief Initialize the model of the itemblock
	 * from this block with a custom location
	 */
	void initModel();
	
	IBlockState getDefaultState();
	
	KMiningCapability getMiningCapability();

}