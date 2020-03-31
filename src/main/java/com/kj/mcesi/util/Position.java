package com.kj.mcesi.util;

import net.minecraft.util.math.BlockPos;

public class Position {
	private int m_X;
	private int m_Y;
	private int m_Z;
	
	public Position(int x, int y, int z) {
		m_X = x;
		m_Y = y;
		m_Z = z;
	}
	
	public BlockPos getBlockPos() {
		return new BlockPos(m_X, m_Y, m_Z);
	}
	
	public int x() {
		return m_X;
	}
	
	public int y() {
		return m_Y;
	}
	
	public int z() {
		return m_Z;
	}
	
	public void setX(int x) {
		m_X = x;
	}
	
	public void setY(int y) {
		m_Y = y;
	}
	
	public void setZ(int z) {
		m_Z = z;
	}
	
	public void set(int x, int y, int z) {
		m_X = x;
		m_Y = y;
		m_Z = z;
	}
	
	public void set(Position pos) {
		m_X = pos.x();
		m_Y = pos.y();
		m_Z = pos.z();
	}
	
	public Position subEq(Position p2) {
		m_X -= p2.x();
		m_Y -= p2.y();
		m_Z -= p2.z();
		return this;
	}
	
	public Position addEq(Position p2) {
		m_X += p2.x();
		m_Y += p2.y();
		m_Z += p2.z();
		return this;
	}
	
	public static Position sub(Position p1, Position p2) {
		return new Position(p1.x()-p2.x(), p1.y()-p2.y(), p1.z()-p2.z());
	}
	
	public static Position add(Position p1, Position p2) {
		return new Position(p1.x()+p2.x(), p1.y()+p2.y(), p1.z()+p2.z());
	}
	
	@Override
	public String toString() {
		return "Position{x="+m_X+",y="+m_Y+",z="+m_Z+"}";
	}
}
