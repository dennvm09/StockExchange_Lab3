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
				// CASO 1
				NodoRyN<T> grandF = father.getFather();
				if (grandF.getLeftSon() == father) {
					// Si tio es derecho y a su vez es rojo
					
					if (grandF.getRightSon() != null && grandF.getRightSon().getColor().equals(ROJO)) {
						AddCaso1(grandF, father, grandF.getRightSon());
					}
				} else{
					if (grandF.getLeftSon() != null && grandF.getLeftSon().getColor().equals(ROJO)) {
						AddCaso1(grandF, father, grandF.getLeftSon());
					}
				}
			}
		}
	}

	public void AddCaso1(NodoRyN<T> grandF, NodoRyN<T> father, NodoRyN<T> uncle) {

		NodoRyN<T> actual = null;
		father.setColor(NEGRO);
		uncle.setColor(NEGRO);
		grandF.setColor(ROJO);
		actual = grandF;
		
		if(actual.getFather().getColor().equals(ROJO)) {
			NodoRyN<T> grandA = actual.getFather().getFather();
			
			//si el tio es negro y el padre es rojo se rota al lado contrario  
			if(grandA.getLeftSon() != null && grandA.getLeftSon() == actual.getFather()) {
				if(grandA.getRightSon() != null && grandA.getRightSon().getColor().equals(NEGRO)) {
				
					//SE PUEDE HACER EL CASO 3: LINEA O TRIANGULO
					addCaso2(grandA, actual.getFather(), actual);
				}
			}else if(grandA.getRightSon() != null && grandA.getRightSon() == actual.getFather()) {
				if(grandA.getLeftSon() != null && grandA.getLeftSon().getColor().equals(NEGRO)) {
					
					addCaso2(grandA, actual.getFather(), actual);
				}
			}
		}
	
		
	}
	
	public void addCaso3(NodoRyN<T> grandF,NodoRyN<T> father, NodoRyN<T> actual) {
		
		//CASO: linea
		// SI el padre es el hijo izq se rota a la derecka 
		
		if(grandF.getLeftSon() == father && father.getLeftSon() == actual) {
			
			if(grandF.getColor().equals(ROJO)) {
				grandF.setColor(NEGRO);
				if(father.getColor().equals(ROJO)) {
					father.setColor(NEGRO);
				}else {
					father.setColor(ROJO);
				}
				rightRotate(father);	
			}else {
				grandF.setColor(ROJO);
				if(father.getColor().equals(ROJO)) {
					father.setColor(NEGRO);
				}else {
					father.setColor(ROJO);
				}
				rightRotate(father);	
			}
			
		}else if(grandF.getRightSon() == father && father.getRightSon() == actual) {
			
			if(grandF.getColor().equals(ROJO)) {
				grandF.setColor(NEGRO);
				if(father.getColor().equals(ROJO)) {
					father.setColor(NEGRO);
				}else {
					father.setColor(ROJO);
				}
				leftRotate(father);	
			}else {
				grandF.setColor(ROJO);
				if(father.getColor().equals(ROJO)) {
					father.setColor(NEGRO);
				}else {
					father.setColor(ROJO);
				}
				leftRotate(father);	
			}
			
		}
		
	}
	public void addCaso2(NodoRyN<T> grandF,NodoRyN<T> father, NodoRyN<T> actual) {
	
		//caso 3: Triangulo
		if(grandF.getLeftSon() == father && father.getRightSon() == actual) {
			leftRotate(actual);
			
		}else if(grandF.getRightSon()== father && father.getLeftSon()== actual) {
			rightRotate(actual);
		}
		//relacion caso 3
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
