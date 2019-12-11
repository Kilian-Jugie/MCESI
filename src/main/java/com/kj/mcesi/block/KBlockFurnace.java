package com.kj.mcesi.block;

import com.kj.mcesi.block.container.ContFurnace;
import com.kj.mcesi.block.gui.GuiFurnace;
import com.kj.mcesi.block.tileentity.TileEntityFurnace;
import com.kj.mcesi.proxy.CommonProxy;
import com.kj.mcesi.util.IKRegistrable;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class KBlockFurnace extends KBlockContainer {
	public static KBlockFurnace INSTANCE;
	
	public KBlockFurnace() {
		super("cblockfurnace", KMaterial.MACHINE, CommonProxy.getGuiHandler().registerGui(GuiFurnace.class, ContFurnace.class) );
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		INSTANCE = this;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityFurnace();
	}

	@Override
	public void onRegister() {
	}


}
