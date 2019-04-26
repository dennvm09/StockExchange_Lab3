package model;
import avl.DennAVLTree;

public class CapitalMarket{
	
	private String name;
	
	private CapitalAction root;

	public CapitalMarket(String name) {
		this.name = name;
		root = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CapitalAction getRoot() {
		return root;
	}

	public void setRoot(CapitalAction root) {
		this.root = root;
	}

	//menor accion de capital
	public CapitalAction lessAction() {
		
		//yamado al menor del arbol rojo y negro
		
		return null;
	}
	
	//mayor accion de capital
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
