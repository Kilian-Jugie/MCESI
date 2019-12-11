package com.kj.mcesi.block;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.util.KHardness;
import com.kj.mcesi.util.IKRegistrable;

import net.minecraft.block.material.Material;

public class KBlockTest extends KBlock {
	
	public static KBlockTest INSTANCE;
	
	public KBlockTest() {
		super(Material.GROUND, "ctestblock");
		this.setHardness(KHardness.METAL_BLOCK);
		INSTANCE = this;
		
		//MCESI.logger.info("CBlockTest constructor");
		//this.setUnlocalizedName("ctestblock");
		//this.setRegistryName("ctestblock");
		//ModBlocks.addBlock();
	}
}




