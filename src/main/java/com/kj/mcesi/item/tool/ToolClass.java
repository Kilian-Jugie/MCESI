package com.kj.mcesi.item.tool;

public class ToolClass {
	private float m_BaseAtkDamage;
	private float m_BaseAtkSpeed;
	private String m_Name;
	
	public ToolClass(String name, float baseAtkDamage, float baseAtkSpeed) {
		m_Name = name;
		m_BaseAtkDamage = baseAtkDamage;
		m_BaseAtkSpeed = baseAtkSpeed;
	}
	
	public final String getName() {
		return m_Name;
	}
	
	public final float getBaseAtkDamage() {
		return m_BaseAtkDamage;
	}
	
	public final float getBaseAtkSpeed() {
		return m_BaseAtkSpeed;
	}
	
	//public static final ToolClass PICKAXE_CLASS = new ToolClass(2, -2.f);
}
