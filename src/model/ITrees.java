package model;

public interface ITrees<T> {

	public void leftRotate(T rotate);
	public void rightRotate(T rotate);
	public void isAction(T search);
	public void addAction(T add);
	public void deleteAction(T delete);
	public T searchAction(T delete);
	public void deleteFixup(T  delete);
	
}
