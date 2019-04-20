package model;

public class ForexMarket {
	
	private String name;
	private ForexAction root;
	
	public ForexMarket(String name) {
		this.name = name;
		root = null;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public ForexAction getRoot() {
		return root;
	}

	public void setRoot(ForexAction root) {
		this.root = root;
	}
	
	public void addAction(ForexAction add) {
		
		
		
	}
	
	public void deletedAction(ForexAction delete) {
		
	}
	
	public boolean isAction(ForexAction search) {
		
		
		return false;
	}
	
	public ForexAction searchAction(ForexAction search) {
		
		return null;
	}
	
}
