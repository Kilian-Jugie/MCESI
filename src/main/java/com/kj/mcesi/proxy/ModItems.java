package com.kj.mcesi.proxy;

import java.util.ArrayList;

import com.kj.mcesi.factories.ToolFactory;
import com.kj.mcesi.item.IKItem;
import com.kj.mcesi.item.KItemSuperCoal;

public class ModItems {
	private static ArrayList<IKItem> m_Items = new ArrayList<IKItem>();
	
	public static final String NAME_PICKAXE = "pickaxe";
	public static final String NAME_SHOVEL  = "shovel";
	public static final String NAME_AXE  = "axe";
	public static final String NAME_HOE  = "hoe";
	public static final String NAME_SWORD  = "sword";
	
	public static final String NAME_STEEL = "steel";
	
	public static final void addItem(IKItem ref) {
		m_Items.add(ref);
	}
	
	public static final ArrayList<IKItem> getItems() {
		return m_Items;
	}
	
	public static final void registerToolFactoryTools() {
		for(IKItem item : ToolFactory.arrayTools) {
			addItem(item);
		}
	}
	
	private ModItems() {}
	
	public static final void initInstances() {
		addItem(new KItemSuperCoal());
		
		int pickaxe_i 	= ToolFactory.createToolClass(NAME_PICKAXE, 2.f, 2.f);
		int shovel_i 	= ToolFactory.createToolClass(NAME_SHOVEL, 1.5f, 2.f);
		int axe_i 		= ToolFactory.createToolClass(NAME_AXE, 5.f, 1.f);
		int hoe_i 		= ToolFactory.createToolClass(NAME_HOE, 2.f, 2.5f);
		int sword_i 	= ToolFactory.createToolClass(NAME_SWORD, 7.f, 3.f);
		
		int steel_i 	= ToolFactory.createToolMaterial(NAME_STEEL, 1.f, 1.f, 1);
		
		ToolFactory.createFullToolSet(steel_i);
		
		//addItem(new SteelPickaxe());
		registerToolFactoryTools();
	}
}
