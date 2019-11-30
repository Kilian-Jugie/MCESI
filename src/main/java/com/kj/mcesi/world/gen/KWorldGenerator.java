package com.kj.mcesi.world.gen;

import java.util.ArrayList;


public abstract class KWorldGenerator {
	private ArrayList<KSubGenerator> m_Generators = new ArrayList<>();
	
	protected void addGenerator(KSubGenerator wg) {
		m_Generators.add(wg);
	}
}
