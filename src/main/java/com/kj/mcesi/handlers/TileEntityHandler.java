package com.kj.mcesi.handlers;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.block.tileentity.TileEntityChest;
import com.kj.mcesi.block.tileentity.TileEntityFurnace;
import com.kj.mcesi.block.tileentity.TileEntityTMachine;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityTMachine.class, new ResourceLocation(MCESI.MODID,"tmachine"));
		GameRegistry.registerTileEntity(TileEntityChest.class, new ResourceLocation(MCESI.MODID,"tchest"));
		GameRegistry.registerTileEntity(TileEntityFurnace.class, new ResourceLocation(MCESI.MODID,"tfurnace"));
	}
}
