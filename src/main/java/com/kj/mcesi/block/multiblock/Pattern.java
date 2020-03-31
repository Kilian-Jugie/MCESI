package com.kj.mcesi.block.multiblock;

import java.util.ArrayList;
import java.util.HashMap;

import com.kj.mcesi.MCESI;
import com.kj.mcesi.util.Position;
import com.kj.mcesi.util.Util;

import net.minecraft.block.Block;
import scala.Char;

public class Pattern {
	private ArrayList<PatternObject> m_Objects = new ArrayList<>();
	public static final int MAX_WIDTH = 32;
	public static final int MAX_HEIGHT = 128;
	
	public int size() {
		return m_Objects.size();
	}
	
	public PatternObject at(int index) {
		return m_Objects.get(index);
	}
	
	
	/*
	 * Structure :
	 * Floor 0:
	 * aaa
	 * aaa
	 * aaa
	 * 
	 * Floor 1:
	 * bbb
	 * bbb
	 * bbb
	 * 
	 * Floor 2:
	 * aaa
	 * a*a
	 * aaa
	 * 
	 * With: a as Stone, b as Brick and * as controller
	 * 
	 * "[aaa/aaa/aaa][bbb/bbb/bbb][aaa/a*a/aaa]", "ab", Stone, Brick
	 */
	public Pattern(String strPat, String vars, Block... blocks) {
		//Format: construct[x][z][y]
		boolean inExpr = false;
		char[][][] construct = new char[MAX_WIDTH][MAX_WIDTH][MAX_HEIGHT];
		Position contPos = null;
		int xIndex = 0, zIndex = 0, yIndex = 0, errored = 0;
		int xIMax = 1, zIMax = 1;
		/*
		 * I don't know if this function caches its result so i will
		 * do it for it. This is not memory wasting because this should
		 * be a reference (if java works correctly)
		 */
		char[] chArr = strPat.toCharArray();
		for(int i=0; i<chArr.length&&errored==0; i++) {
			switch(chArr[i]) {
			case '[': {
				inExpr = true;
				//MCESI.logger.info("Entering expression: "+i);
			}break;
			case ']': {
				yIndex++;
				//MCESI.logger.info("Closing expression "+xIndex+";"+yIndex+";"+zIndex+": "+i);
				if(zIndex>zIMax) zIMax = zIndex;
				if(zIndex>zIMax) xIMax = xIndex;
				zIndex = 0;
				xIndex = 0;
				inExpr = false;
				if(yIndex >= MAX_HEIGHT) {
					MCESI.logger.error("Multiblock height excess maximal allowed ! Considering multiblock stop at height "+MAX_HEIGHT);
					errored = 1;
				}
			}break;
			case '/': {
				zIndex++;
				if(zIndex>zIMax) xIMax = xIndex;
				//MCESI.logger.info("Step "+xIndex+";"+yIndex+";"+zIndex+": "+i);
				xIndex=0;
				
				if(zIndex >= MAX_WIDTH) {
					MCESI.logger.error("Multiblock width ('z') excess maximal allowed ! Considering multiblock stop at width "+MAX_WIDTH);
					errored = 2;
				}
			}break;
			default: {
				if(inExpr) {
					construct[xIndex][zIndex][yIndex] = chArr[i];
					if(chArr[i]=='*') contPos = new Position(xIndex, yIndex, zIndex);
					//MCESI.logger.info("Block "+xIndex+";"+yIndex+";"+zIndex+": "+i);
					xIndex++;
					if(xIndex >= MAX_WIDTH) {
						MCESI.logger.error("Multiblock width ('x') excess maximal allowed ! Considering multiblock stop at width "+MAX_WIDTH);
						errored = 3;
					}
				}
			}break;
			}
		}
		if(inExpr) {
			MCESI.logger.error("Missing closing bracket on expression: '"+strPat+"'");
			MCESI.logger.info("Considering they are closed at the end of the expression... But you might fix it");
			inExpr = false;
		}
		
		HashMap<Character, Block> blockMap = new HashMap<>();
		
		for(int i = 0, size = vars.length(); i<size; i++) {
			//MCESI.logger.info("Var n"+vars.charAt(i)+" block: "+blocks[i].getUnlocalizedName());
			blockMap.put(vars.charAt(i), blocks[i]);
		}
		++zIMax;
		char c;
		int generalIndex = 0;
		//MCESI.logger.info("Maxes: "+xIMax+";"+yIndex+";"+zIMax);
		for(int iX = 0; iX < xIMax; iX++) {
			for(int iY = 0; iY < yIndex; iY++) {
				for(int iZ = 0; iZ < zIMax; iZ++) {
					c = construct[iX][iZ][iY];
					if(c!='*') {
						//MCESI.logger.info("Adding for "+c+": "+blockMap.get(c)+" at "+new Position(iX, iY, iZ).subEq(contPos));
						m_Objects.add(new PatternObject(blockMap.get(c), new Position(iX, iY, iZ).subEq(contPos)));
					}
					generalIndex++;
				}
			}
		}
		
	}
}
