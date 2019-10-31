package com.kj.mcesi.handlers;

import java.util.ArrayList;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.block.container.KContainer;
import com.kj.mcesi.block.gui.KGui;
import com.kj.mcesi.block.tileentity.KTileEntity;
import com.kj.mcesi.util.Pair;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/*
 * @brief Redirect to the correct GUI from an id
 */
public class GuiHandler implements IGuiHandler {
	private ArrayList<Pair<Class<? extends KGui>, Class<? extends KContainer>>> m_Guis = new ArrayList<>();
	
	public int registerGui(Class<? extends KGui> guiClass, Class<? extends KContainer<? extends KTileEntity>> containerClass ) {
		MCESI.logger.info("Registering gui of gui:"+guiClass+" container:"+containerClass);
		m_Guis.add(new Pair<>(guiClass, containerClass));
		return m_Guis.size()-1;
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		try {
			return m_Guis.get(ID).second.
					getConstructor(InventoryPlayer.class, KTileEntity.class, EntityPlayer.class).
					newInstance(player.inventory, (KTileEntity)world.getTileEntity(new BlockPos(x,y,z)), player);
		} catch (Throwable e) {
			MCESI.logger.error("Error during getServerGuiElement container instantiation : "+e.getMessage());
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		try {
			return m_Guis.get(ID).first.
					getConstructor(InventoryPlayer.class, KTileEntity.class, EntityPlayer.class).
					newInstance(player.inventory, (KTileEntity)world.getTileEntity(new BlockPos(x,y,z)), player);
		} catch (Throwable e) {
			MCESI.logger.error("Error during getClientGuiElement container instantiation : "+e.getMessage());
			return null;
		}
	}
	
	public static void registerGuis() {
		
	}
}
