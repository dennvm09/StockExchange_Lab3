package model;
import list_Linny.LinnyList;

public class Customer {

	private String name;
	private String id;
	private double budget;
	
	private LinnyList<CapitalMarket> walletActions;
	private LinnyList<ForexMarket> walletMarket;
	
	public Customer(String name, String id, double budget) {
		
		this.name = name;
		this.id = id;
		this.budget = budget;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public LinnyList<CapitalMarket> getWalletActions() {
		return walletActions;
	}

	public void setWalletActions(LinnyList<CapitalMarket> walletActions) {
		this.walletActions = walletActions;
	}

	public LinnyList<ForexMarket> getWalletMarket() {
		return walletMarket;
	}

	public void setWalletMarket(LinnyList<ForexMarket> walletMarket) {
		this.walletMarket = walletMarket;
	}
	
	
	
}
