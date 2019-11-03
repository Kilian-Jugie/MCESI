package com.kj.mcesi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Util {
	public static final <E> ArrayList<E> getIndexesOfArray(List<E> array, ArrayList<Integer> indexes) {
		ArrayList<E> ret = new ArrayList<>();
		for(Integer it : indexes)
			ret.add(array.get(it));
		return ret;
	}
	
	public static final <E> boolean forAllAND(List<E> array, Function<? super E, Boolean> action) {
		for(E it : array)
			if(!action.apply(it)) return false;
		return true;
	}
	
	public static final <E> boolean forAllOR(List<E> array, Function<? super E, Boolean> action) {
		for(E it : array)
			if(action.apply(it)) return true;
		return false;
	}
	
	public static final <E> boolean forAllIndexAND(List<E> array, BiFunction<? super E, Integer, Boolean> action) {
		for(int i = 0; i<array.size(); i++)
			if(!action.apply(array.get(i), i)) return false;
		return true;
	}
	
	public static final <E> void forEachIndex(List<E> array, BiConsumer<? super E, Integer> action) {
		for(int i=0; i<array.size(); i++) 
			action.accept(array.get(i), i);
	}
	
	/*public static final <R,T> R forEachFunction(ArrayList<T> arr, Function<? super T,R> func) {
		
	}*/
}
