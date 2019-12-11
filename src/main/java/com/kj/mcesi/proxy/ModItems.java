package com.kj.mcesi.proxy;

import java.util.ArrayList;

import com.kj.mcesi.item.IKItem;
import com.kj.mcesi.item.KItemSuperCoal;
import com.kj.mcesi.item.tool.tools.pickaxes.SteelPickaxe;

public class ModItems {
	private static ArrayList<IKItem> m_Items = new ArrayList<IKItem>();
	
	public static final void addItem(IKItem ref) {
		m_Items.add(ref);
	}
	
	public static final ArrayList<IKItem> getItems() {
		return m_Items;
	}
	
	private ModItems() {}
	
	public static final void initInstances() {
		addItem(new KItemSuperCoal());
		addItem(new SteelPickaxe());
		
	}
}
