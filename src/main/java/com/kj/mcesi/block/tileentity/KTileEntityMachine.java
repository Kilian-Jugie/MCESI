package com.kj.mcesi.block.tileentity;

public abstract class KTileEntityMachine extends KTileEntity {
	//Default: 9 -> each 10 ticks refresh
	private static final int FIXED_UPDATE_TCOUNT = 9;
	private int m_Ticks = 0;
	
	public KTileEntityMachine(String name) {
		super(name);
	}
	
	@Override
	public void update() {
		if(m_Ticks>FIXED_UPDATE_TCOUNT) {
			m_Ticks = 0;
			fixedUpdate();
		}
		else
			m_Ticks++;
	}
}
