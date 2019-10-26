package com.kj.mcesi.proxy;

import com.kj.mcesi.block.KBlock;
import com.kj.mcesi.block.IKBlock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        //ModTileEntities.clientPreInit();
	}

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	for(IKBlock b : ModBlocks.getBlocks()) {
    		b.initModel();
    	}
    }
}
