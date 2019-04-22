package hash_Linny;

public class ItemLinny<K, T> {
	
	private K key;
	private T element;
	private int priority;
	
	private ItemLinny<K, T> next;
	private ItemLinny<K, T> previous;
	
	public ItemLinny(K key, T element){
		
		this.key = key;
		this.element = element;
		next = null;
		previous = null;
		
	}
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public ItemLinny<K, T> getNext() {
		return next;
	}

	public void setNext(ItemLinny<K, T> next) {
		this.next = next;
	}

	public ItemLinny<K, T> getPrevious() {
		return previous;
	}

	public void setPrevious(ItemLinny<K, T> previous) {
		this.previous = previous;
	}

	
	
}
