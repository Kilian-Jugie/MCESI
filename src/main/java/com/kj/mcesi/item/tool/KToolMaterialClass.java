package com.kj.mcesi.item.tool;

public class KToolMaterialClass {
	private float m_AtkDmgRatio;
	private float m_AtkSpdRatio;
	private int m_HarvestLvl;
	private String m_Name;
	
	public KToolMaterialClass(String name, float atkDmgRatio, float atkSpdRatio, int harvestLvl) {
		m_AtkDmgRatio = atkDmgRatio;
		m_AtkSpdRatio = atkSpdRatio;
		m_HarvestLvl = harvestLvl;
		m_Name = name;
	}
	
	public String getName() {
		return m_Name;
	}
	
	public float getAtkDmgRatio() {
		return m_AtkDmgRatio;
	}
	
	public float getAtkSpdRatio() {
		return m_AtkSpdRatio;
	}
	
	public float getHarvestLvl() {
		return m_HarvestLvl;
	}
	
	/*public static final KToolMaterialClass BASE = new KToolMaterialClass(1.f, 1.f, 0);
	public static final KToolMaterialClass STEEL = new KToolMaterialClass(1.f, 1.f, 1);
	public static final KToolMaterialClass CREATIVE = new KToolMaterialClass(1000.f, 1000.f, 100);*/
	
}
