package com.kj.mcesi.block.blocks.multiblock;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.block.KBlockContainerMulti;
import com.kj.mcesi.block.KMaterial;
import com.kj.mcesi.block.container.multiblocks.ContainerMultiblockTest;
import com.kj.mcesi.block.gui.multiblock.GuiMultiblockTest;
import com.kj.mcesi.block.multiblock.Pattern;
import com.kj.mcesi.block.tileentity.multiblocks.TileEntityMultiblockTest;
import com.kj.mcesi.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KBlockTestController extends KBlockContainerMulti {
	public static KBlockTestController INSTANCE;
	
	
	public KBlockTestController() {
		super("tmultiblocktest", KMaterial.MACHINE,
				CommonProxy.getGuiHandler().registerGui(GuiMultiblockTest.class, ContainerMultiblockTest.class));
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		INSTANCE = this;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityMultiblockTest();
	}

	@Override
	public void onRegister() {
	}

	
}
