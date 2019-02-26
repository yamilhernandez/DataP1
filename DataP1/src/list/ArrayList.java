package list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{
	
	private class ArrayListIterator<T> implements Iterator<T>{
		private int currentPosition;
		
		public ArrayListIterator(){
			this.currentPosition = 0;
		}
		@Override
		public boolean hasNext() {
			return this.currentPosition < size();
		}

		@Override
		public T next() {
			if (this.hasNext()) {
				T result = null;
				result = (T) element[this.currentPosition++];
				return result;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
}
	private E[] element;
	private int size = 0;
	private static final int INITCAP = 10;
	private static final int CAPTOAR = INITCAP*2;
	private static final int MAXEMPTYPOS = 2;

	
	@SuppressWarnings("unchecked")
	public ArrayList() {
			element = (E[]) new Object[INITCAP];
			size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator<E>();
		
	}

	@Override
	public void add(E obj) {
			if (element.length - size <= element.length / 2) {
				this.reSizeArray(CAPTOAR);
			}

			element[size++] = obj;
		}
		
	

	@Override
	public void add(int index, E obj) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("add: invalid index = " + index);
		if (element.length == size)
			reSizeArray(CAPTOAR);
		moveDataOnePositionTR(index, size - 1);
		element[index] = obj;
		size++;

		
	}

	@Override
	public boolean remove(E obj) {
		if(this.contains(obj)) {
			for (int i = 0; i < size; i++) {
				if(element[i].equals(obj)) {
					this.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("remove: invalid index = " + index);
		E removed = element[index];
		moveDataOnePositionTL(index + 1, size - 1);
		element[size - 1] = null;
		size--;
		if (element.length - size > MAXEMPTYPOS)
			reSizeArray(CAPTOAR);
		
		return true;

		
	}

	@Override
	public int removeAll(E obj) {
		int count=0;
		if(this.contains(obj)) {
			for (int i = 0; i < size; i++) {
				if(element[i].equals(obj)) {
					this.remove(i);
					count++;
					
				}
			}
		}
		
		return count;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if ((index < 0 ) || (index >= this.size())) {
			throw new IndexOutOfBoundsException();
		}
		return this.element[index];

	}

	@Override
	public E set(int index, E obj) throws IndexOutOfBoundsException{
		if ((index < 0 ) || (index >= this.size())) {
			throw new IndexOutOfBoundsException();
		}
		E result = this.element[index];
		this.element[index] = obj;
		return result;
		
	}

	@Override
	public E first() {
		
		return element[0];
	}

	@Override
	public E last() {
		
		return element[size-1];
	}

	@Override
	public int firstIndex(E obj) {
		if(!this.isEmpty()) {
			for (int i = 0; i < size; i++) {
				if(element[i].equals(obj)) {
					return i;
				}
			}	
		}
		return -1;
	}

	@Override
	public int lastIndex(E obj) {
		if(!this.isEmpty()) {
			for (int i = size; i < 0; i--) {
				if(element[i].equals(obj)) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(E obj) {
		if(!this.isEmpty()) {
			for (int i = 0; i <size; i++) {
				if(element[i].equals(obj)) {
					return true;
				}
			}
		}
		return false;
	}
	

	@Override
	public void clear() {
		if(!this.isEmpty()) {
			for (int i = 0; i < size; i++) {
				element[i]= null;
			}
		}
		
	}
	public void reSizeArray(int change) {
		int newCapacity = element.length + change;
		E[] newElement = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElement[i] = element[i];
			element[i] = null;
		}
		element = newElement;

	}
	
	private void moveDataOnePositionTL(int low, int sup) {
		// pre: 0 < low <= sup <= (element.length - 1)
		for (int pos = low; pos <= sup; pos++)
			element[pos - 1] = element[pos];
	}
	
	private void moveDataOnePositionTR(int low, int sup) {
		// pre: 0 <= low <= sup < (element.length - 1)
		for (int pos = sup; pos >= low; pos--)
			element[pos + 1] = element[pos];
	}



}
