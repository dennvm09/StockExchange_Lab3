package rojo_y_negro;

import javafx.scene.transform.Rotate;
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

		NodoRyN<T> aux = rotate; //x
		rotate = rotate.getRightSon(); //y
		aux.setRightSon(rotate.getLeftSon());
		rotate.setLeftSon(aux);
		rotate.setFather(aux.getFather());
		
		if(aux.getFather() == null) {
			root = rotate;
		}
		else if (aux.getFather().getLeftSon() == aux) {
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

		if(aux.getFather() == null) {
			root = rotate;
		}
		else if (aux.getFather().getLeftSon() == aux) {
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
		while(actual.getColor().equals(ROJO)) {
			
			if(grandF.getLeftSon() == actual) {
				//CASO 1
				uncle = grandF.getRightSon();
				if(uncle.getColor().equals(ROJO)) {
					actual.setColor(NEGRO);
					uncle.setColor(NEGRO);
					grandF.setColor(ROJO);
					actual = grandF;
					
					//Caso 2: Triangulo
				}else {
					if(actual.getFather() != null) {
						if(actual.getFather().getRightSon() == actual) {
							actual = actual.getFather();
							leftRotate(actual);
							
						}
						//caso 2: Linea
						actual.getFather().setColor(NEGRO);
						actual.getFather().getFather().setColor(ROJO);
						rightRotate(actual.getFather().getFather());
					}
				}
			}else {
				
				uncle = grandF.getLeftSon();
				if(uncle.getColor().equals(ROJO)) {
					actual.setColor(NEGRO);
					uncle.setColor(NEGRO);
					grandF.setColor(ROJO);
					actual = grandF;
					
					//Caso 2: Triangulo
				}else {
					if(actual.getFather() != null) {
						if(actual.getFather().getLeftSon() == actual) {
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

	@Override
	public void deleteAction(NodoRyN<T> delete) {

	}

	@Override
	public void deleteFixup(NodoRyN<T> delete) {

	}

}
