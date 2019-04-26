package model;
import redBlack.RedBlackTree;

public class ForexMarket {

	private String name;
	private ForexAction root;
	private RedBlackTree actions;

	
	public ForexMarket(String name) {
		this.name = name;
		actions = null;
		root = null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ForexAction getRoot() {
		return root;
	}

	public void setRoot(ForexAction root) {
		this.root = root;
	}
	
	public void addForex(ForexAction forex) {
		actions.insert((Comparable) forex);
	}
	
	public void deleteForex(ForexAction forex) {
		
	}

	// menor accion de capital
	public CapitalAction lessAction() {

	

		return null;
	}

	// mayor accion de capital
	public CapitalAction higherAction() {

		return null;
	}

	public void modificed() {

	}

	public CapitalAction search(CapitalAction search) {

		return null;
	}

	public void addAction(CapitalAction add) {

	}

	public void deleteAction(CapitalAction delete) {

	}

}
