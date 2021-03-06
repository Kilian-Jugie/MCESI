package com.kj.mcesi.block.blocks;

import com.kj.mcesi.block.KBlockContainer;
import com.kj.mcesi.block.KMaterial;
import com.kj.mcesi.block.container.ContChest;
import com.kj.mcesi.block.gui.GuiChest;
import com.kj.mcesi.block.tileentity.TileEntityChest;
import com.kj.mcesi.proxy.CommonProxy;
import com.kj.mcesi.util.IKRegistrable;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class KBlockChest extends KBlockContainer {
	public static KBlockChest INSTANCE;
	
	public KBlockChest() {
		//super(Material.IRON, "cblocktmachine");
		//this.setHardness(CHardness.METAL_BLOCK);
		super("cblockchest", KMaterial.MACHINE, /*CGuiIds.GUI_TMACHINE_ID*/ CommonProxy.getGuiHandler().registerGui(GuiChest.class, ContChest.class) );
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		INSTANCE = this;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityChest();
	}
}
