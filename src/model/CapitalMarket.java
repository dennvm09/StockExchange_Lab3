package model;

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

	
	public void leftRotate(CapitalAction rotate) {
		
		CapitalAction aux = rotate;
		rotate = rotate.getRightSon();
		aux.setRightSon(rotate.getLeftSon());
		rotate.setLeftSon(aux);
		
		if (aux.getFather().getLeftSon() == aux) {
			aux.getFather().setLeftSon(rotate);
			
		} else {
			aux.getFather().setRightSon(rotate);;	
		}
		
		rotate.setFather(aux.getFather());
		aux.setFather(rotate);
		
		if (aux.getRightSon() != null) {
			aux.getRightSon().setFather(aux);
		}
		
	}

	
	public void rightRotate(CapitalAction rotate) {
		
		
	}

	
	public void isAction(CapitalAction search) {
		
		
	}

	
	public void addAction(CapitalAction add) {
		
		
	}

	
	public void deleteAction(CapitalAction delete) {
		
		
	}

	
	public CapitalAction searchAction(CapitalAction delete) {
		
		return null;
	}

	
	public void deleteFixup(CapitalAction delete) {
		
		
	}
	
	
	
}
