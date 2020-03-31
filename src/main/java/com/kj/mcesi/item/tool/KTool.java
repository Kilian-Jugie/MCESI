package com.kj.mcesi.item.tool;

import com.kj.mcesi.block.IKBlock;
import com.kj.mcesi.item.IKItem;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemTool;

public class KTool extends ItemTool implements IKItem {
	protected ToolClass m_Class;
	protected KToolMaterialClass m_Material;
	
	protected KTool(String name, KToolMaterialClass material, ToolClass toolClass) {
		super(material.getAtkDmgRatio()*toolClass.getBaseAtkDamage(),
				material.getAtkSpdRatio()*toolClass.getBaseAtkSpeed(),
				ToolMaterial.DIAMOND, null); //Diamond means nothing other than to avoid nullptrex
		
		m_Class = toolClass;
		m_Material = material;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
	}

	@Override
	public void onRegister() {
		
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState blockIn) {
		IKBlock kb;
		try {
			kb = (IKBlock)blockIn.getBlock();
		}catch(Exception e) {
			return super.canHarvestBlock(blockIn);
		}
		if(kb.getMiningCapability().getToolClass() == m_Class &&
				kb.getMiningCapability().getHarvestLvl() <= m_Material.getHarvestLvl()) {
			return true;
		}
		
		return false;
	}
	
	
	
}
