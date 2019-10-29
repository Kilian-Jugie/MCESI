package com.kj.mcesi.block.gui;

import com.kj.mcesi.MCESI;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class KGui extends GuiContainer {
	/*public KGui(InventoryPlayer playerInventory, TileEntity machineInventory,
			EntityPlayer player, Class<? extends KContainer<? extends TileEntity>> containerClass, int sizeX, int sizeY) 
					throws InstantiationException, IllegalAccessException, IllegalArgumentException,
					InvocationTargetException, NoSuchMethodException, SecurityException {
		super(containerClass.getDeclaredConstructor(InventoryPlayer.class, TileEntity.class, EntityPlayer.class)
				.newInstance(playerInventory, machineInventory, player));
	}*/
	private final ResourceLocation GUI_PATH;
	private final InventoryPlayer m_PlayerInventory;
	private final TileEntity m_TileEntity;
	private int m_TEContLabelX = 8, m_TEContLabelY = 6;
	private int m_PInvLabelX = 8, m_PInvLabelY;
	private int m_TEContColor = 0, m_PInvColor = 0;
	
	public KGui(Container c, int sizeX, int sizeY, String imgName, InventoryPlayer playerInv, TileEntity te) {
		super(c);
		this.xSize = sizeX;
		this.ySize = sizeY;
		GUI_PATH = new ResourceLocation(MCESI.MODID, "textures/gui/"+imgName);
		m_PlayerInventory = playerInv;
		m_TileEntity = te;
		m_PInvLabelY = this.ySize-92;
	}
	
	public void setContainerLabelPos(int x, int y) {
		m_TEContLabelX = x;
		m_TEContLabelY = y;
	}
	
	public void setInventoryLabelPos(int x, int y) {
		m_PInvLabelX = x;
		m_PInvLabelY = y;
	}
	
	public void setLabelsColors(int containerColor, int invColor) {
		m_TEContColor = containerColor;
		m_PInvColor = invColor;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(this.m_TileEntity.getDisplayName().getUnformattedText(), m_TEContLabelX, m_TEContLabelY, m_TEContColor);
		this.fontRenderer.drawString(this.m_PlayerInventory.getDisplayName().getFormattedText(), m_PInvLabelX, m_PInvLabelY, m_PInvColor);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.clearColor(1.f, 1.f, 1.f, 1.f);
		this.mc.getTextureManager().bindTexture(GUI_PATH);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
