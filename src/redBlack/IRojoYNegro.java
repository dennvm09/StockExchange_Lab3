package redBlack;

import model.CapitalAction;

public interface IRojoYNegro<T extends Comparable <T>> {

	public void leftRotate(NodoRyN<T> rotate);
	public void rightRotate(NodoRyN<T> rotate);
	public void creatSentinel(NodoRyN<T> x);
	public void deleteRB(T elem);
	public void fixedUp(NodoRyN<T> x);
	public void inOrder( NodoRyN<T> r);
	public void preOrder( NodoRyN<T> r);
	public void postOrder( NodoRyN<T> r);
	public void insertRB(T elem);
	public void insert_balance(NodoRyN<T> z);
	public void Limpiar();
	public void deleteSentinels( NodoRyN<T> x);
	
}
