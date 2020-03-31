package com.kj.mcesi;

import org.apache.logging.log4j.Logger;

import com.kj.mcesi.proxy.CommonProxy;
import com.kj.mcesi.proxy.ModBlocks;
import com.kj.mcesi.proxy.ModItems;
import com.kj.mcesi.proxy.ModWorldGenerators;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MCESI.MODID, name = MCESI.NAME, version = MCESI.VERSION)
public class MCESI {
	public static final String MODID = "mcesi";
    public static final String NAME = "MCESI";
    public static final String VERSION = "1.0";

    public static Logger logger;
    
    @Mod.Instance
    public static MCESI instance;
    
    @SidedProxy(clientSide="com.kj.mcesi.proxy.ClientProxy", serverSide="com.kj.mcesi.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
        ModItems.initInstances();
        ModBlocks.initInstances();
        ModWorldGenerators.initInstances();
        //ModTileEntities.initTileEntities();
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit(e);
    }
}
