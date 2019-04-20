package model;

import stack_Linny.LinnyStack;

public class StockExchange {
	
	private String name;
	private LinnyStack<CapitalMarket> actions;
	private LinnyStack<ForexMarket> markets;
	
	public StockExchange(String name) {
		this.name = name; 
		actions = null;
		markets = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinnyStack<CapitalMarket> getActions() {
		return actions;
	}

	public void setActions(LinnyStack<CapitalMarket> actions) {
		this.actions = actions;
	}

	public LinnyStack<ForexMarket> getMarkets() {
		return markets;
	}

	public void setMarkets(LinnyStack<ForexMarket> markets) {
		this.markets = markets;
	}
	
	

}
