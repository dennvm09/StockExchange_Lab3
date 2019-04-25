package model;

import hash_Linny.HashTableLinny;

public class StockExchange {
	
	private String name;
	
	private HashTableLinny<Integer,ForexMarket> forex;
	private HashTableLinny<Integer,CapitalMarket> markets;
	
	public StockExchange(String name) {
		this.name = name; 
		forex = null;
		markets = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashTableLinny<Integer,ForexMarket> getforex() {
		return forex;
	}

	public void setforex(HashTableLinny<Integer,ForexMarket> forex) {
		this.forex = forex;
	}

	public HashTableLinny<Integer,CapitalMarket> getMarkets() {
		return markets;
	}

	public void setMarkets(HashTableLinny<Integer,CapitalMarket> markets) {
		this.markets = markets;
	}
	
	public int createKey(String name) {
		
		int key = 0;
		for (int i = 0; i < name.length(); i++) {
			key += name.charAt(i);	
		}
		return key;
		
	}
	
	public void addCapitalMarket(CapitalMarket add) {	
		int key = createKey(add.getName());
		markets.insert(key, add);
	}
	
	public void addForexMarket(ForexMarket add) {
		int key = createKey(add.getName());
		forex.insert(key, add);
	}
	
	public void deleteCapitalMarket(CapitalMarket delete) {
		int key = createKey(delete.getName());
		markets.remove(key, delete);
	}

	public void deleteForexMarket(ForexMarket delete) {
		int key = createKey(delete.getName());
		forex.remove(key, delete);
	}
	
}
