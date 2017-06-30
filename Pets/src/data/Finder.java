package data;

import java.util.ArrayList;

public class Finder<T> {
	public interface ContainsChecker<T>{
		public boolean containChecker(T object, Object patron);
	}
	
	public ArrayList<T> find(ArrayList<T> list, Object patron, ContainsChecker<T> checker){
		ArrayList<T> newList = new ArrayList<T>();
		
		for (T l: list){
			if (checker.containChecker(l,patron))
				newList.add(l);
		}
		
		return newList;
	}
}
