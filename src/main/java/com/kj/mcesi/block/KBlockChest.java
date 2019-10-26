package com.kj.mcesi.block;

import com.kj.mcesi.block.container.ContChest;
import com.kj.mcesi.block.gui.GuiChest;
import com.kj.mcesi.block.tileentity.TileEntityChest;
import com.kj.mcesi.proxy.CommonProxy;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class KBlockChest extends KBlockContainer implements IKBlock {
	public KBlockChest() {
		//super(Material.IRON, "cblocktmachine");
		//this.setHardness(CHardness.METAL_BLOCK);
		super("cblockchest", Material.IRON, /*CGuiIds.GUI_TMACHINE_ID*/ CommonProxy.getGuiHandler().registerGui(GuiChest.class, ContChest.class) );
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityChest();
	}
}
