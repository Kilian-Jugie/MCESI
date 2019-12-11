package com.kj.mcesi.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class KMaterial extends Material {

	public static final Material ORE = (new KMaterial(MapColor.STONE)).setRequiresTool();
	public static final Material MACHINE = (new KMaterial(MapColor.IRON)).setRequiresTool();
	
	public KMaterial(MapColor color) {
		super(color);
	}

}
