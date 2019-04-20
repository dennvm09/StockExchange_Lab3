package rojo_y_negro;

import model.CapitalAction;

public class ArbolRyN<T> implements IRojoYNegro<T> {

	public static final String NEGRO = "negro";
	public static final String ROJO = "rojo";
	private NodoRyN<T> root;

	public ArbolRyN() {
		root = null;

	}

	public NodoRyN<T> getRoot() {
		return root;
	}

	public void setRoot(NodoRyN<T> root) {
		this.root = root;
	}

	@Override
	public void leftRotate(NodoRyN<T> rotate) {

		NodoRyN<T> aux = rotate;
		rotate = rotate.getRightSon();
		aux.setRightSon(rotate.getLeftSon());
		rotate.setLeftSon(aux);

		if (aux.getFather().getLeftSon() == aux) {
			aux.getFather().setLeftSon(rotate);

		} else {
			aux.getFather().setRightSon(rotate);
			;
		}

		rotate.setFather(aux.getFather());
		aux.setFather(rotate);

		if (aux.getRightSon() != null) {
			aux.getRightSon().setFather(aux);
		}
	}

	@Override
	public void rightRotate(NodoRyN<T> rotate) {

		NodoRyN<T> aux = rotate;
		rotate = rotate.getLeftSon();
		aux.setLeftSon(aux.getRightSon());
		rotate.setRightSon(aux);

		if (aux.getFather().getLeftSon() == aux) {
			aux.getFather().setLeftSon(rotate);

		} else {
			aux.getFather().setRightSon(rotate);
			;
		}

		rotate.setFather(aux.getFather());
		aux.setFather(rotate);

		if (aux.getLeftSon() != null) {
			aux.getLeftSon().setFather(aux);
		}

	}

	public void searchT(NodoRyN<T> roots, NodoRyN<T> search, NodoRyN<T> found) {

		if (roots != null) {

			if (roots == search) {
				found = roots;

			} else {
				if (search.getKey() < roots.getKey()) {
					searchT(roots.getLeftSon(), search, found);
				} else if (search.getKey() > roots.getKey()) {
					searchT(roots.getRightSon(), search, found);
				}
			}

		}

	}

	@Override
	public boolean isElement(NodoRyN<T> search) {
		NodoRyN<T> found = null;
		searchT(root, search, found);

		return (found != null);
	}

	@Override
	public void addElement(NodoRyN<T> add) {

		add.setColor(ROJO);

		if (root == null) {
			root = add;
			root.setColor(NEGRO);
		} else {

		}

	}

	@Override
	public NodoRyN<T> searchElement(NodoRyN<T> search) {

		NodoRyN<T> found = null;
		searchT(root, search, found);
		return found;
	}

	@Override
	public void deleteAction(NodoRyN<T> delete) {

	}

	@Override
	public void deleteFixup(NodoRyN<T> delete) {

	}

}
