package rojo_y_negro;

import javafx.scene.transform.Rotate;
import model.CapitalAction;

public class ArbolRyN<T> implements IRojoYNegro<T> {

	public static final String NEGRO = "negro";
	public static final String ROJO = "rojo";
	public static final String DNEGRO = "doble negro";

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

		NodoRyN<T> aux = rotate; // x
		rotate = rotate.getRightSon(); // y
		aux.setRightSon(rotate.getLeftSon());
		rotate.setLeftSon(aux);
		rotate.setFather(aux.getFather());

		if (aux.getFather() == null) {
			root = rotate;
		} else if (aux.getFather().getLeftSon() == aux) {
			aux.getFather().setLeftSon(rotate);

		} else {
			aux.getFather().setRightSon(rotate);

		}

		aux.setFather(rotate);
		rotate.setLeftSon(aux);

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
		rotate.setFather(aux.getFather());

		if (aux.getFather() == null) {
			root = rotate;
		} else if (aux.getFather().getLeftSon() == aux) {
			aux.getFather().setLeftSon(rotate);

		} else {
			aux.getFather().setRightSon(rotate);
			;
		}

		aux.setFather(rotate);
		rotate.setRightSon(aux);

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

	public void addE(NodoRyN<T> add, NodoRyN<T> roots) {

		if (roots != null) {

			if (roots != add) {
				// si roots es mayor que agregar
				if (roots.getKey() > add.getKey()) {

					// pregunto si su hijo es izq es null y coloco hay a add
					if (roots.getLeftSon() == null) {
						roots.setLeftSon(add);
						add.setFather(roots);
					} else {
						// si no sigo bajando
						addE(add, roots.getLeftSon());
					}

				} else {
					if (roots.getRightSon() == null) {
						roots.setRightSon(add);
						add.setFather(roots);
					} else {
						addE(add, roots.getRightSon());
					}
				}
			}
		}
	}

	@Override
	public void addElement(NodoRyN<T> add) {

		add.setColor(ROJO);

		if (root == null) {
			root = add;
			root.setColor(NEGRO);
		} else {

			addE(add, root);

			NodoRyN<T> father = add.getFather();
			if (father.getColor().equals(ROJO)) {

				NodoRyN<T> grandF = father.getFather();
				casesAdd(grandF, father);
			}
		}
	}

	public void casesAdd(NodoRyN<T> grandF, NodoRyN<T> father) {
		NodoRyN<T> actual = father;
		NodoRyN<T> uncle = null;
		while (actual.getColor().equals(ROJO)) {

			if (grandF.getLeftSon() == actual) {
				// CASO 1
				uncle = grandF.getRightSon();
				if (uncle.getColor().equals(ROJO)) {
					actual.setColor(NEGRO);
					uncle.setColor(NEGRO);
					grandF.setColor(ROJO);
					actual = grandF;

					// Caso 2: Triangulo
				} else {
					if (actual.getFather() != null) {
						if (actual.getFather().getRightSon() == actual) {
							actual = actual.getFather();
							leftRotate(actual);

						}
						// caso 2: Linea
						actual.getFather().setColor(NEGRO);
						actual.getFather().getFather().setColor(ROJO);
						rightRotate(actual.getFather().getFather());
					}
				}
			} else {

				uncle = grandF.getLeftSon();
				if (uncle.getColor().equals(ROJO)) {
					actual.setColor(NEGRO);
					uncle.setColor(NEGRO);
					grandF.setColor(ROJO);
					actual = grandF;

					// Caso 2: Triangulo
				} else {
					if (actual.getFather() != null) {
						if (actual.getFather().getLeftSon() == actual) {
							actual = actual.getFather();
							rightRotate(actual);
						}
						actual.getFather().setColor(NEGRO);
						actual.getFather().getFather().setColor(ROJO);
						leftRotate(actual.getFather().getFather());
					}
				}
			}

		}
		root.setColor(NEGRO);
	}

	@Override
	public NodoRyN<T> searchElement(NodoRyN<T> search) {

		NodoRyN<T> found = null;
		searchT(root, search, found);
		return found;
	}

	public void preOrden(NodoRyN<T> a) {

		if (!a.isLeaf()) {
			System.out.println(a);
			preOrden(a.getLeftSon());
			preOrden(a.getRightSon());
		}

	}

	@Override
	public void deleteAction(NodoRyN<T> delete) {

		NodoRyN<T> deleteF = searchElement(delete);
		if (deleteF.getColor().equals(ROJO)) {
			if (deleteF.isLeaf() == true) {
				deleteF = null;
			} else if (deleteF.getRightSon() != null && deleteF.getLeftSon() != null) {
				// si los dos hijos son diferentes de null
				NodoRyN<T> actual = deleteF.getLeftSon();
				while (actual.isLeaf() == false) {
					actual = actual.getLeftSon();
				}

				if (deleteF.getFather().getLeftSon() == deleteF) {
					actual.getFather().setLeftSon(null);
					actual.setFather(deleteF.getFather());
					deleteF.getFather().setLeftSon(actual);
				} else {
					actual.getFather().setLeftSon(null);
					actual.setFather(deleteF.getFather());
					deleteF.getFather().setRightSon(actual);
				}

				actual.setLeftSon(deleteF.getLeftSon());
				actual.setRightSon(deleteF.getRightSon());

			} else {

				if (deleteF.getLeftSon() == null) {
					if (deleteF.getFather().getLeftSon() == deleteF) {
						deleteF.getFather().setLeftSon(deleteF.getRightSon());
						deleteF.getRightSon().setFather(deleteF.getFather());
					} else {
						deleteF.getFather().setRightSon(deleteF.getRightSon());
						deleteF.getRightSon().setFather(deleteF.getFather());
					}
				} else {
					if (deleteF.getFather().getLeftSon() == deleteF) {
						deleteF.getFather().setLeftSon(deleteF.getLeftSon());
						deleteF.getLeftSon().setFather(deleteF.getFather());
					} else {
						deleteF.getFather().setRightSon(deleteF.getLeftSon());
						deleteF.getLeftSon().setFather(deleteF.getFather());
					}

				}

			}
		} else {

			deleteF.setColor(DNEGRO);
			deleteFixup(deleteF);
		}

	}

	@Override
	public void deleteFixup(NodoRyN<T> delete) {

		// Casos Deletion
		NodoRyN<T> actual = delete;
		while (actual.getColor().equals(DNEGRO)) {
			// Caso 2
			NodoRyN<T> brother = null;
			if (actual.getFather().getLeftSon() != null && actual.getFather().getLeftSon() == actual) {
				brother = actual.getFather().getRightSon();
			} else if (actual.getFather().getRightSon() != null && actual.getFather().getRightSon() == actual) {
				brother = actual.getFather().getLeftSon();
			}

			if (actual.getFather().getColor().equals(NEGRO) && brother.getColor().equals(ROJO)) {
				if (brother.isLeaf() == false) {
					if (brother.getLeftSon().getColor().equals(NEGRO)
							&& brother.getRightSon().getColor().equals(NEGRO)) {
						if (actual.getFather().getLeftSon() == actual) {
							leftRotate(actual.getFather());
						} else {
							rightRotate(actual.getFather());
						}
					}
				}
			}
			// Caso 3
			else if (actual.getFather().getColor().equals(NEGRO) && brother.getColor().equals(NEGRO)) {
				if (brother.isLeaf() == false) {
					if (brother.getLeftSon().getColor().equals(NEGRO)
							&& brother.getRightSon().getColor().equals(NEGRO)) {

						actual.setColor(NEGRO);
						actual.getFather().setColor(DNEGRO);
						brother.setColor(ROJO);
						actual = actual.getFather();

					}
				}

			}
			// Caso 4: Terminal
			else if (actual.getFather().getColor().equals(ROJO) && brother.getColor().equals(NEGRO)) {
				if (brother.isLeaf() == false) {
					if (brother.getLeftSon().getColor().equals(NEGRO)
							&& brother.getRightSon().getColor().equals(NEGRO)) {
						actual.getFather().setColor(NEGRO);
						actual.setColor(NEGRO);
						brother.setColor(ROJO);
					}
				}
			}

			// Caso 5
			else if (actual.getFather().getColor().equals(NEGRO) && brother.getColor().equals(NEGRO)) {
				if (brother.getLeftSon().getColor().equals(ROJO) && brother.getRightSon().getColor().equals(NEGRO)) {
					brother.setColor(ROJO);
					rightRotate(brother);
				} else if (brother.getLeftSon().getColor().equals(NEGRO)
						&& brother.getRightSon().getColor().equals(ROJO)) {
					brother.setColor(ROJO);
					leftRotate(brother);
				}

			}
			// caso 6: Terminal
			else if (brother.getColor().equals(NEGRO)) {
				if (actual.getFather().getLeftSon() == actual) {
					if (brother.getRightSon().getColor().equals(ROJO)) {

						brother.setColor(brother.getFather().getColor());
						brother.getRightSon().setColor(NEGRO);
						actual.getFather().setColor(NEGRO);
						actual.setColor(NEGRO);
						leftRotate(brother);
					}
				} else if (actual.getFather().getRightSon() == actual) {
					if (brother.getRightSon().getColor().equals(ROJO)) {

						brother.setColor(brother.getFather().getColor());
						brother.getRightSon().setColor(NEGRO);
						actual.getFather().setColor(NEGRO);
						actual.setColor(NEGRO);
						rightRotate(brother);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ArbolRyN<Integer> R = new ArbolRyN<>();

		NodoRyN<Integer> j = new NodoRyN<>(11, 11.0);
		R.addElement(j);
		NodoRyN<Integer> f = new NodoRyN<>(14, 14.0);
		NodoRyN<Integer> h = new NodoRyN<>(2, 2.0);
		R.addElement(f);
		R.addElement(h);

		R.preOrden(j);

	}

}
