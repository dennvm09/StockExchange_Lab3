package list_Linny;

import java.security.NoSuchProviderException;

public class LinnyList<T> implements IList<T> {

	private LinnyNodo<T> firstNodo;
	private LinnyNodo<T> lastNodo;
	int counter = 0;

	public LinnyList() {
		counter = 0;
	}

	public LinnyNodo<T> getFirstNodo() {
		return firstNodo;
	}
	public void setFirstNodo(LinnyNodo<T> firstNodo) {
		this.firstNodo = firstNodo;
	}
	
	public LinnyNodo<T> getLastNodo() {
		return lastNodo;
	}
	public void setLastNodo(LinnyNodo<T> lastNodo) {
		this.lastNodo = lastNodo;
	}
	

	@Override
	public void linnyAdd(T n) {
		// TODO Auto-generated method stub
		LinnyNodo<T> linnyNew = new LinnyNodo<T>(n);

		if (firstNodo == null) {
			firstNodo = linnyNew;
			lastNodo = linnyNew;
			linnyNew.setNext(linnyNew);
			linnyNew.setPrevious(linnyNew);
			counter++;
		} else {
			
			lastNodo.setNext(linnyNew);
			linnyNew.setPrevious(lastNodo);
			linnyNew.setNext(null);
			lastNodo = linnyNew;
			counter++;
		}
	}
	
	@Override
	public void linnyDeleteObject(T element) {
		// TODO Auto-generated method stub

		if(firstNodo != null) {
			
			if (firstNodo.getInfo() == element) {
				firstNodo = firstNodo.getNext();
				counter--;
			} else {
				LinnyNodo<T> delete = firstNodo;
				LinnyNodo<T> deleteNext = delete.getNext();

				boolean stop = false;
				while (stop == false) {
					if (deleteNext.getInfo() == element) {
						delete.setNext(deleteNext.getNext());
						counter--;
						stop = true;
					} else {
						delete = delete.getNext();
						deleteNext = delete.getNext();
					}
				}
			}
		}
	}
	
	@Override
	public void linnyDelete(int i) {
		// TODO Auto-generated method stub
		LinnyNodo<T> node = firstNodo;
		LinnyNodo<T> nodeNX = node.getNext();
		int number = 1;
		boolean h = false;

		if (i < size()) {
			
			if(number == 0) {
				firstNodo.getNext().setPrevious(null);
				firstNodo = firstNodo.getNext();
				counter--;
			}
			else {
				while(nodeNX != null && h == false) {
					if(number == i) {
						
						
						if(nodeNX.getNext() != null) {
							node.setNext(nodeNX.getNext());
							nodeNX.getNext().setPrevious(node);
							h = true;
							counter--;
						}else {
							node.setNext(null);
							h = true;
							counter--;
						}
					}
					else {
						node = node.getNext();
						nodeNX = node.getNext();
						number++;
					}
				}
			}
		}	
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return counter;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return firstNodo == null;
	}
	
	@Override
	public T linnyGet(int i) {
		// TODO Auto-generated method stub
		T element = null;
		LinnyNodo<T> node = firstNodo;
		int number = 0;
		boolean h = false;

		if (i < size()) {
			while (node != null && h == false ) {
				if (number == i) {
					element = node.getInfo();
					h = true;
				} else {
					number++;
					node = node.getNext();
				}
			}
		}
		return element;
	}
	
	
	
	public static void main(String[] args) {
		LinnyList<Integer> n = new LinnyList<>();
		
		n.linnyAdd(6);
		n.linnyAdd(78989);
		n.linnyAdd(789);
		
		System.out.println(n.linnyGet(0));
		System.out.println(n.linnyGet(1));
		System.out.println(n.linnyGet(2));
		System.out.println(n.size());
		n.linnyDelete(1);
		System.out.println(n.size());
		System.out.println(n.linnyGet(1));
		n.linnyDelete(1);
		System.out.println(n.size());
		System.out.println(n.isEmpty());
		n.linnyDeleteObject(6);
		System.out.println(n.isEmpty());
	}

	

}
