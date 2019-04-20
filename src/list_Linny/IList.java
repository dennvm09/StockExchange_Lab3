package list_Linny;

public interface IList<T> {
	public void linnyAdd(T element);
	public T linnyGet(int i);
	public void linnyDeleteObject(T element);
	public void linnyDelete(int i);
	public boolean isEmpty();
	public int size();

}
