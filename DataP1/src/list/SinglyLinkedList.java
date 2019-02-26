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
		if (this.isEmpty()) {
			this.header = new Node(obj, null);

		}
		else {
			Node<E> newNode = new Node<E>(obj,null );
			Node<E> temp = this.findNode(this.size() - 1);
			temp.setNext(newNode);
		}
		this.size++;
	}

	@Override
	public void add(int index, E obj) {
		if (index == this.size()) {
			this.add(obj);
			return;
		}
		this.checkIndex(index);

		if (index == 0) {
			Node<E> newNode = new Node<E>(obj, null);
			newNode.setNext(this.header);
			this.header = newNode;
		}
		else {
			Node<E> newNode = new Node<E>(obj, null);
			Node<E> temp = this.findNode(index-1);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
		this.size++;
	}
	@Override
	public boolean remove(E obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int index) {
		if (this.isEmpty()) {
			return false;
		}
		this.checkIndex(index);
		if (index == 0) {
			Node<E> temp = this.header;
			E result = temp.getElement();
			this.header = this.header.getNext();
			temp.setNext(null);
			temp.setElement(null);
			this.size--;
			return true;
		}
		else {
			Node<E> temp1 = this.findNode(index - 1);
			Node<E> temp2 = temp1.getNext();
			E result = temp2.getElement();
			temp1.setNext(temp2.getNext());
			temp2.setNext(null);
			temp2.setElement(null);
			this.size--;
			return true;
		}
	}
	

	@Override
	public int removeAll(E obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int index) {
		this.checkIndex(index);
		Node<E> target = this.findNode(index);
		return target.getElement();
	}

	@Override
	public E set(int index, E obj) {
		this.checkIndex(index);
		Node<E> target = this.findNode(index);
		E result = target.getElement();
		target.setElement(obj);
		return result;
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
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean contains(E obj) {
		Node<E> curr= header;
		while(curr.getNext()!= null) {
			if (curr.getElement().equals(obj)) {
				return true;
			}
		curr= curr.getNext();
		}
		return false;
	}

	@Override
	public void clear() {
		header.setNext(null);
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
