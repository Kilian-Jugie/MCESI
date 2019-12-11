package com.kj.mcesi.item.tool.tools;

import com.kj.mcesi.item.tool.KToolMaterialClass;
import com.kj.mcesi.item.tool.KMiningTool;
import com.kj.mcesi.item.tool.ToolClass;

public class KToolPickaxe extends KMiningTool {

	protected KToolPickaxe(String name, KToolMaterialClass material) {
		super(name, ToolClass.PICKAXE_CLASS, material);
	}

}
