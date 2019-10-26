package com.kj.mcesi.block;

import com.kj.mcesi.MCESI;

import net.minecraft.block.material.Material;

public class KBlockTest extends KBlock {
	
	public KBlockTest() {
		super(Material.GROUND, "ctestblock");
		this.setHardness(KHardness.METAL_BLOCK);
		
		//MCESI.logger.info("CBlockTest constructor");
		//this.setUnlocalizedName("ctestblock");
		//this.setRegistryName("ctestblock");
		//ModBlocks.addBlock();
	}
}




