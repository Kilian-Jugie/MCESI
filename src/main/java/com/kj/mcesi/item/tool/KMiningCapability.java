package com.kj.mcesi.item.tool;

public class KMiningCapability {
	ToolClass m_ToolClass;
	float m_HarvestLvl;
	
	public KMiningCapability(ToolClass toolClass, KToolMaterialClass materialClass) {
		m_ToolClass = toolClass;
		m_HarvestLvl = materialClass.getHarvestLvl();
	}
	
	public ToolClass getToolClass() {
		return m_ToolClass;
	}
	
	public float getHarvestLvl() {
		return m_HarvestLvl;
	}
	
	public static final KMiningCapability DEFAULT_PICKAXE = new KMiningCapability(ToolClass.PICKAXE_CLASS, KToolMaterialClass.BASE);
	public static final KMiningCapability STEEL_PICKAXE = new KMiningCapability(ToolClass.PICKAXE_CLASS, KToolMaterialClass.STEEL);
	
	public static final KMiningCapability CREATIVE_PICKAXE = new KMiningCapability(ToolClass.PICKAXE_CLASS, KToolMaterialClass.CREATIVE);
}
