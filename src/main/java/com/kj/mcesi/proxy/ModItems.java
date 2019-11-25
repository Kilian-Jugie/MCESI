package com.kj.mcesi.proxy;

import java.util.ArrayList;

import com.kj.mcesi.item.KItem;
import com.kj.mcesi.item.KItemSuperCoal;

public class ModItems {
	private static ArrayList<KItem> m_Items = new ArrayList<KItem>();
	
	public static final void addItem(KItem ref) {
		m_Items.add(ref);
	}
	
	public static final ArrayList<KItem> getItems() {
		return m_Items;
	}
	
	private ModItems() {}
	
	public static final void initInstances() {
		addItem(new KItemSuperCoal());
	
	}
}
