package list;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {
	
private static class Node<T>{
		
		private T element;
		private Node<T> next;
		
		public Node(){
			this.element = null;
			this.next = null;
		}
		
		public Node(T e, Node<T> N) {
			this.element = e;
			this.next = N;
		}

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
}
	private Node<E> header;
	private int size;

	public SinglyLinkedList() {
		this.header = null;
		this.size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E obj) {
		// TODO Auto-generated method stub
		
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
		return this.size;
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
	
	private Node<E> findNode(int index) {
		Node<E> temp = this.header;
		int i = 0;
		
		while (i < index) {
			temp = temp.getNext();
			i++;
		}
		return temp;
		
	}

	private void checkIndex(int index) {
		if ((index < 0) || (index >= this.size())){
			throw new IndexOutOfBoundsException();
		}
}
	
	

}
