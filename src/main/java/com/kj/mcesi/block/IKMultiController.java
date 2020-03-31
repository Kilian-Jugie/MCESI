package com.kj.mcesi.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IKMultiController {
	boolean checkForPattern(World worldIn, BlockPos pos);
	void onBuilt();
}
