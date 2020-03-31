package com.kj.mcesi.proxy;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.block.KBlock;
import com.kj.mcesi.block.blocks.KBlockTest;
import com.kj.mcesi.block.IKBlock;
import com.kj.mcesi.handlers.GuiHandler;
import com.kj.mcesi.handlers.TileEntityHandler;
import com.kj.mcesi.item.IKItem;
import com.kj.mcesi.item.KItem;
import com.kj.mcesi.util.IKRegistrable;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	private static GuiHandler m_GuiHandler = new GuiHandler();
	
	public static final GuiHandler getGuiHandler() {
		return m_GuiHandler;
	}
	
	public void preInit(FMLPreInitializationEvent e) {
		//ModTileEntities.serverPreInit();
	}
	
	public void init(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(MCESI.instance, m_GuiHandler);
		ModWorldGenerators.register();
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
		for(IKBlock b : ModBlocks.getBlocks()) {
			event.getRegistry().register((Block)b);
			b.onRegister();
		}
		TileEntityHandler.registerTileEntity();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	for(IKBlock b : ModBlocks.getBlocks()) {
    		event.getRegistry().register(new ItemBlock((Block) b).setRegistryName(((Block)b).getRegistryName()));
    	}
    	for(IKItem i : ModItems.getItems()) {
    		ModelLoader.setCustomModelResourceLocation((Item)i, 0, new ModelResourceLocation(((Item)i).getRegistryName(), "inventory"));
    		event.getRegistry().register((Item)i);
    		i.onRegister();
    	}
    }
}
