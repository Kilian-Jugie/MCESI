package com.kj.mcesi.block;

import com.kj.mcesi.block.container.ContFurnace;
import com.kj.mcesi.block.gui.GuiFurnace;
import com.kj.mcesi.block.tileentity.TileEntityFurnace;
import com.kj.mcesi.proxy.CommonProxy;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class KBlockFurnace extends KBlockContainer implements IKBlock {
	public KBlockFurnace() {
		super("cblockfurnace", Material.IRON, CommonProxy.getGuiHandler().registerGui(GuiFurnace.class, ContFurnace.class) );
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityFurnace();
	}
}
