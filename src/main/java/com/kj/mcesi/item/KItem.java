package com.kj.mcesi.item;

import com.kj.mcesi.MCESI;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class KItem extends Item {
	String m_Name;
	
	public KItem(String name) {
		m_Name = name;
		this.setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.setUnlocalizedName(m_Name);
		this.setRegistryName(MCESI.MODID, m_Name);
	}


}
