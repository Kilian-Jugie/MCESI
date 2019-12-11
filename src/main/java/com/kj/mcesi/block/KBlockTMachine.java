package com.kj.mcesi.block;

import com.kj.mcesi.block.container.ContainerTMachine;
import com.kj.mcesi.block.gui.GuiTMachine;
import com.kj.mcesi.block.tileentity.TileEntityTMachine;
import com.kj.mcesi.proxy.CommonProxy;
import com.kj.mcesi.util.IKRegistrable;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class KBlockTMachine extends KBlockContainer {
	public static KBlockTMachine INSTANCE;
	
	public KBlockTMachine() {
		//super(Material.IRON, "cblocktmachine");
		//this.setHardness(CHardness.METAL_BLOCK);
		super("cblocktmachine", Material.IRON, /*CGuiIds.GUI_TMACHINE_ID*/ CommonProxy.getGuiHandler().registerGui(GuiTMachine.class, ContainerTMachine.class) );
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		INSTANCE = this;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTMachine();
	}

	@Override
	public void onRegister() {
	}


}
