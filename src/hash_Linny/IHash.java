package hash_Linny;

public interface IHash<K, T> {
	
	public boolean contains(K key);
	public int getSlot(K key);
	public void insert(K key, T element);
	public boolean isEmpty();
	public void remove(K key, T element);
	public ItemLinny<K, T> search(K key);
	public int size();

}
