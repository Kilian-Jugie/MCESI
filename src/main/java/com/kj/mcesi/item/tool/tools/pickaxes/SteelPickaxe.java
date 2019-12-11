package com.kj.mcesi.item.tool.tools.pickaxes;

import com.kj.mcesi.item.tool.KToolMaterialClass;
import com.kj.mcesi.item.tool.tools.KToolPickaxe;

public class SteelPickaxe extends KToolPickaxe {

	public SteelPickaxe() {
		super("steel_pickaxe", KToolMaterialClass.STEEL);
		this.setMaxDamage(500);
	}
	
}
