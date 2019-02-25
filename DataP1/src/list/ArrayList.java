package list;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E>{
	private E[] element;
	private int size = 0;
	private int INITCAP = 10;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
			element = (E[]) new Object[INITCAP];
			size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E obj) {
			if (element.length - size <= element.length / 2) {
				this.reSizeArray();
			}

			element[size++] = obj;
		}
		
	

	@Override
	public void add(int index, E obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(E obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int removeAll(E obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int firstIndex(E obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndex(E obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	public void reSizeArray() {
		element = Arrays.copyOf(element, element.length * 2);
	}

}
