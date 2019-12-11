package com.kj.mcesi.block;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.item.tool.KMiningCapability;
import com.kj.mcesi.item.tool.ToolClass;
import com.kj.mcesi.util.IKRegistrable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KBlock extends Block implements IKBlock {

	public KBlock(Material materialIn, String name) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(MCESI.MODID, name);
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	public void onRegister() {
		
	}


	@Override
	public KMiningCapability getMiningCapability() {
		return KMiningCapability.DEFAULT_PICKAXE;
	}



	

}
