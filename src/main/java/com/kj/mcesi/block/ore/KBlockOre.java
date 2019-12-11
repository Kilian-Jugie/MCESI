package com.kj.mcesi.block.ore;

import com.kj.mcesi.block.KBlock;
import com.kj.mcesi.block.KMaterial;
import com.kj.mcesi.proxy.ModWorldGenerators;
import com.kj.mcesi.util.KHardness;
import com.kj.mcesi.util.KHarvestLvl;
import com.kj.mcesi.world.gen.KMineralGenerator;

import net.minecraft.world.gen.feature.WorldGenMinable;

public class KBlockOre extends KBlock {

	public KBlockOre(String name) {
		super(KMaterial.ORE, name);
		this.setHarvestLevel("pickaxe", KHarvestLvl.WOOD);
		this.setHardness(KHardness.ORE);
	}
	
	protected void setupWorldGen(int size, int minChance, int maxChance, int minHeight, int maxHeight, int worldId) {
		ModWorldGenerators.addWorldGenerator(
				new KMineralGenerator(
						new WorldGenMinable(this.getDefaultState(), size),
						minChance, maxChance, minHeight, maxHeight, worldId));
	}
	
	

}
