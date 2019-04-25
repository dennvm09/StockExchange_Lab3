package redBlack;

import java.util.List;

public class NodoRyN<T extends Comparable<T>> {

	public static final int BLACK = 1;
	public static final int RED = 0;
	public static final int DBLACK = 2;

	private int color;
	private T elem;
	private double key;
	protected boolean FLAG;

	private NodoRyN<T> leftSon;
	private NodoRyN<T> rightSon;
	private NodoRyN<T> father;

	public NodoRyN(T elem) {

		this.elem = elem;

		setLeftSon(new NodoRyN<T>(null));
		setRightSon(new NodoRyN<T>(null));
		father = null;

		FLAG = false;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public T getElem() {
		return elem;
	}

	public void setElem(T elem) {
		this.elem = elem;
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

	public boolean rightSLeaf() {
		return rightSon.getElem() == null;
	}

	public boolean leftSLeaf() {
		return leftSon.getElem() == null;
	}

	public boolean isLeaf() {

		if (leftSon != null || rightSon != null) {
			return true;
		} else {
			return false;
		}
	}

	public NodoRyN<T> getUncle() {

		if (father == null || father.father == null) {
			return null;
		} else {
			if (father.father.isRightS(father)) {
				return father.father.leftSon.leftSon;
			} else {
				return father.father.rightSon;
			}

		}
	}

	public boolean isRightS(NodoRyN<T> node) {

		return rightSon == node;
	}

	public boolean isLeftS(NodoRyN<T> node) {

		return leftSon == node;
	}

	public boolean isRightBlack() {

		return rightSon.color == BLACK;
	}

	public boolean isLeftBlack() {

		return leftSon.color == BLACK;
	}

	public boolean isChildsBlack() {
		return isRightBlack() && isLeftBlack();
	}

	public boolean isDBlack() {
		return color == DBLACK;
	}

	public NodoRyN<T> getHigher() {
		return rightSLeaf() ? this : rightSon.getHigher();
	}

	public NodoRyN<T> getSmaller() {
		return leftSLeaf() ? this : leftSon.getSmaller();
	}

	public int getHeight() {

		if (isLeaf())
			return 0;
		int h1 = leftSon.getHeight();
		int h2 = rightSon.getHeight();
		return (h1 >= h2) ? h1 + 1 : h2 + 1;
	}

	public NodoRyN<T> getBrother() {
		if (father == null)
			return null;
		else
			return father.isRightS(this) ? father.getLeftSon() : father.getRightSon();
	}

	public NodoRyN<T> sucesor(NodoRyN<T> x) {
		if (!x.rightSon.FLAG)
			return x.rightSon.getSmaller();
		NodoRyN<T> y = x.father;
		while (y != null && x == y.rightSon) {
			x = y;
			y = y.father;

		}
		return y;
	}

	public void getPreorden(List<T> preorden) {

		preorden.add(elem);
		if (!leftSLeaf())
			leftSon.getPreorden(preorden);
		if (!rightSLeaf())
			rightSon.getPreorden(preorden);
	}

	public boolean exist(T a) {
		try {
			getNode(a);
			return true;
		} catch (ElementoNoExisteException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public NodoRyN getNode(T elem) throws ElementoNoExisteException {

		int comp = elem.compareTo(this.elem);
		if (comp == 0)
			return this;
		else if (comp < 0) {
			if (!leftSLeaf())
				return leftSon.getNode(elem);
			else
				throw new ElementoNoExisteException("El element buscado no existe");
		} else {
			if (!rightSLeaf())
				return rightSon.getNode(elem);
			else
				throw new ElementoNoExisteException("El element buscado no existe");
		}
	}

	public void setElement(NodoRyN<T> node) {

		if (node.elem != null) {

			T aux = elem;
			elem = node.elem;
			node.elem = aux;
		} else {
			elem = null;
			color = BLACK;
			rightSon = null;
			leftSon = null;
		}

	}

}
