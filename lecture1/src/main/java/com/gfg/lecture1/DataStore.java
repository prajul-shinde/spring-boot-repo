package com.gfg.lecture1;

import java.util.HashMap;

public class DataStore {

	private HashMap<String, String>store=new HashMap<String, String>();
	
	public DataStore() {
		store.put("prajul", "java developer");
		store.put("swapnil", "react developer");
		store.put("vijay", "full stuck developer");
	}
	
	public String getFromDb(String word) {
		return store.get(word);
	}
}


