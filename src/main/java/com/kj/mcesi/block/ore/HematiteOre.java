package com.kj.mcesi.block.ore;

import com.kj.mcesi.item.tool.KMiningCapability;
import com.kj.mcesi.item.tool.KToolMaterialClass;
import com.kj.mcesi.item.tool.ToolClass;

public class HematiteOre extends KBlockOre {
	public static HematiteOre INSTANCE;
	
	public HematiteOre() {
		super("ore_hematite");
		INSTANCE = this;
	}
	
	@Override
	public void onRegister() {
		this.setupWorldGen(32, 1, 20, 0, 255, 0);
	}
	
	@Override
	public KMiningCapability getMiningCapability() {
		return new KMiningCapability(ToolClass.PICKAXE_CLASS, KToolMaterialClass.BASE);
	}
}
