package com.kj.mcesi.item.tool;

public class KToolMaterialClass {
	private float m_AtkDmgRatio;
	private float m_AtkSpdRatio;
	private float m_HarvestLvl;
	
	public KToolMaterialClass(float atkDmgRatio, float atkSpdRatio, float harvestLvl) {
		m_AtkDmgRatio = atkDmgRatio;
		m_AtkSpdRatio = atkSpdRatio;
		m_HarvestLvl = harvestLvl;
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
	
	public static final KToolMaterialClass BASE = new KToolMaterialClass(1.f, 1.f, 0);
	public static final KToolMaterialClass STEEL = new KToolMaterialClass(1.f, 1.f, 1);
	public static final KToolMaterialClass CREATIVE = new KToolMaterialClass(1000.f, 1000.f, 100);
	
}
