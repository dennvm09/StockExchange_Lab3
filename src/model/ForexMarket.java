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

	public String getName() {
		return name;
	}

	public ForexAction getRoot() {
		return root;
	}

	public void setRoot(ForexAction root) {
		this.root = root;
	}

	// menor accion de capital
	public CapitalAction lessAction() {

		// yamado al menor del arbol rojo y negro

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
