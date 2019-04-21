package rojo_y_negro;

public class NodoRyN<T>  {

	private String color;
	private T info; 
	private double key;
	
	private NodoRyN<T> leftSon;
	private NodoRyN<T> rightSon;
	private NodoRyN<T> father;
	
	public NodoRyN(T info, double key) {
		
		this.info = info;
		this.key = key;
		
		leftSon = null;
		rightSon = null;
		father = null;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public double getKey() {
		return key;
	}

	public void setKey(double key) {
		this.key = key;
	}

	public NodoRyN<T> getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(NodoRyN<T> leftSon) {
		this.leftSon = leftSon;
	}

	public NodoRyN<T> getRightSon() {
		return rightSon;
	}

	public void setRightSon(NodoRyN<T> rightSon) {
		this.rightSon = rightSon;
	}

	public NodoRyN<T> getFather() {
		return father;
	}

	public void setFather(NodoRyN<T> father) {
		this.father = father;
	}
	
	public boolean isLeaf() {
		
		if(leftSon != null || rightSon != null) {
			return true;
		}else {
			return false;
		}
	}

	
	
}
