package hash_Linny;
import list_Linny.*;

public class HashTableLinny<K, T> implements IHash<K, T>{

	public final static int SIZE = 3000;
	public int busy;
	public ItemLinny<K,T>[] table;
	public K[] keys;
	
	public HashTableLinny() {
		keys = (K[]) new Object[SIZE];
		table = new ItemLinny[SIZE];
		busy = 1;
		
	}
	
	@Override
	public void insert(K key, T element) {
		
		int k = getSlot(key);
		
		ItemLinny<K, T> newItem = new ItemLinny<K, T>(key, element);
		int i = k;
		int h = 0;
		do {
			
			if(keys[i] == null) {
				keys[i] = key;
				table[i] = newItem;
				busy++;
			}
			
			if(keys[i] == key) {
				table[i] = newItem;
			}
			i = (i+h*h++)%SIZE;
		}while(i != k);
	}

	@Override
	public void remove(K key, T element) {
		
		if(!contains(key)) {
			return;
		}
		
		int i = getSlot(key);
		int h = 1;
		
		while(key != keys[i]) {
			i = (i+h*h++)%SIZE;
		}
		
		keys[i] = null;
		table[i] = null;
		
		for ( i = (i+h*h++)%SIZE; keys[i] != null; i = (i+h*h++)%SIZE) {
			
			K tmp = keys[i];
			ItemLinny<K, T> temp = table[i];
			keys[i] = null;
			table[i] = null;
			busy--;
			insert(tmp, element);
		}
	}

	@Override
	public boolean isEmpty() {
		
		return busy == 0;
	}

	@Override
	public int size() {
		
		return SIZE;
	}

	@Override
	public ItemLinny<K, T> search(K key) {
		
		int i = getSlot(key);
		int h = 1;
		ItemLinny<K, T> actual = null;
		
		while(keys[i] != null) {
			if(keys[i] == key) {
				actual = table[i];
				
			i = (i + h * h++) % SIZE;
			}
		}
		return actual;
	}

	@Override
	public boolean contains(K key) {
		return search(key) != null;
	}

	@Override
	public int getSlot(K key) {
		
		int val = key.hashCode() % SIZE;
		if(val < 0) {
			val = val * -1;
		}
		return val;
	}

	
}
