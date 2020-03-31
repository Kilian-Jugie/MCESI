package com.kj.mcesi.factories;

import java.util.ArrayList;
import java.util.HashMap;

import com.kj.mcesi.item.tool.KMiningCapability;
import com.kj.mcesi.item.tool.KTool;
import com.kj.mcesi.item.tool.KToolMaterialClass;
import com.kj.mcesi.item.tool.ToolClass;

public class ToolFactory {
	public static ArrayList<ToolClass> arrayToolClass = new ArrayList<>();
	public static HashMap<String, Integer> toolClasses = new HashMap<>();
	
	public static ArrayList<KToolMaterialClass> arrayToolMaterials = new ArrayList<>();
	public static HashMap<String, Integer> toolMaterials = new HashMap<>();
	
	public static ArrayList<KTool> arrayTools = new ArrayList<>();
	public static HashMap<String, Integer> tools = new HashMap<>();
	
	public static final int createToolClass(String typeName, float baseAtkDamage, float baseAtkSpeed) {
		int index = arrayToolClass.size();
		toolClasses.put(typeName, index);
		arrayToolClass.add(new ToolClass(typeName, baseAtkDamage, baseAtkSpeed));
		return index;
	}
	
	public static final int createToolMaterial(String matName, float atkDmgRatio, float atkSpdRatio, int harvestLvl) {
		int index = arrayToolMaterials.size();
		toolMaterials.put(matName, index);
		arrayToolMaterials.add(new KToolMaterialClass(matName, atkDmgRatio, atkSpdRatio, harvestLvl));
		return index;
	}
	
	public static final int createTool(String toolName, int toolClass, int toolMaterial) {
		int index = arrayTools.size();
		tools.put(toolName, index);
		arrayTools.add(new KTool(toolName, arrayToolMaterials.get(toolMaterial), arrayToolClass.get(toolClass)));
		return index;
	}
	
	public static final void createFullToolSet(int toolMaterial) {
		for(int i=0; i<arrayToolClass.size(); i++) {
			createTool(arrayToolClass.get(i).getName()+"_"+arrayToolMaterials.get(toolMaterial).getName(), i, toolMaterial);
		}
	}
	
	public static final KMiningCapability getMiningCapability(String toolClass, String toolMaterial) {
		return getMiningCapability(toolClasses.get(toolClass), toolMaterials.get(toolMaterial));
	}
	
	public static final KMiningCapability getMiningCapability(int toolClass, int toolMaterial) {
		return new KMiningCapability(arrayToolClass.get(toolClass), arrayToolMaterials.get(toolMaterial));
	}
}
