package rojo_y_negro;

import model.CapitalAction;

public interface IRojoYNegro<T> {

	public void leftRotate(NodoRyN<T> rotate);
	public void rightRotate(NodoRyN<T> rotate);
	public boolean isElement(NodoRyN<T> search);
	public void addElement(NodoRyN<T> add);
	public NodoRyN<T> searchElement(NodoRyN<T> search);
	public void deleteAction(NodoRyN<T> delete);
	public void deleteFixup(NodoRyN<T> delete);
	
}
