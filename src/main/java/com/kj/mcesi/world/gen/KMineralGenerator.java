package com.kj.mcesi.world.gen;

import java.util.Random;

import com.kj.mcesi.MCESI;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class KMineralGenerator implements KSubGenerator, IWorldGenerator {
	WorldGenerator m_Generator;
	int m_MinChance, m_MaxChance, m_MinHeight, m_MaxHeight, m_World, m_HeightDifference, m_ChanceDifference;
	
	public KMineralGenerator(WorldGenerator generator, int minChance, int maxChance, int minHeight, int maxHeight, int worldId) {
		m_MinChance = minChance;
		m_MaxChance = maxChance;
		m_MinHeight = minHeight;
		m_MaxHeight = maxHeight;
		m_World = worldId;
		m_Generator = generator;
		m_HeightDifference = m_MaxHeight - m_MinHeight + 1;
		m_ChanceDifference = m_MaxChance - m_MinChance + 1;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if(world.provider.getDimension()==m_World) {
			int chance = random.nextInt(m_ChanceDifference)+m_MinChance;
			for(int i = 0; i<chance; i++) {
				int x = chunkX * 16 + random.nextInt(16);
				int y = m_MinHeight + random.nextInt(m_HeightDifference);
				int z = chunkZ * 16 + random.nextInt(16);
				m_Generator.generate(world, random, new BlockPos(x, y, z));
			}
		}
		
	}
}
