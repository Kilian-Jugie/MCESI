package com.kj.mcesi.proxy;

import java.util.ArrayList;

import com.kj.mcesi.world.gen.KMineralGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModWorldGenerators {
		private static ArrayList<IWorldGenerator> m_WorldGenerators = new ArrayList<IWorldGenerator>();
		
		public static final void addWorldGenerator(IWorldGenerator ref) {
			m_WorldGenerators.add(ref);
		}
		
		public static final ArrayList<IWorldGenerator> getWorldGenerators() {
			return m_WorldGenerators;
		}
		
		private ModWorldGenerators() {}
		
		public static final void initInstances() {
			addWorldGenerator(new KMineralGenerator(new WorldGenMinable(ModBlocks.getBlocks().get(0).getDefaultState(), 32), 1, 5, 0, 80,0));
		
		}
		
		public static void register() {
			for(IWorldGenerator gen : m_WorldGenerators) {
				GameRegistry.registerWorldGenerator(gen, 0);
			}
		}
}
