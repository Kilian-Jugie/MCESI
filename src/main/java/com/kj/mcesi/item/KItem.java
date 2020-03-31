package com.kj.mcesi.item;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.util.IKRegistrable;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class KItem extends Item implements IKItem {
	private String m_Name;
	
	public KItem(String name) {
		m_Name = name;
		this.setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.setUnlocalizedName(m_Name);
		this.setRegistryName(MCESI.MODID, m_Name);
	}

	@Override
	public void onRegister() {
		
	}
	
	@Override
	public ResourceLocation getLocation() {
		return this.getRegistryName();
	}
}
