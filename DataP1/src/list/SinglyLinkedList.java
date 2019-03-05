package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {

	private class SinglyLinkedListIterator<E> implements Iterator<E>{
		private int currentPosition;
		List<E> list;

		public SinglyLinkedListIterator(List<E> list){
			this.currentPosition = 0;
			this.list=list;
		}
		@Override
		public boolean hasNext() {
			return this.currentPosition < list.size();
		}

		@Override
		public E next() {
			if (this.hasNext()) {
				E result = null;
				result = (E) list.get(currentPosition);
				currentPosition++;
				return result;
			}
			else {
				throw new NoSuchElementException();
			}
		}

	}

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
		return new SinglyLinkedListIterator<>(this);
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
		for (int i = 0; i < this.size; i++) {
			if(this.get(i).equals(obj)) {
				this.remove(i);
				return true;
			}
		}
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
		int count=0;
		if(this.contains(obj)) {
		for (int i = 0; i < this.size; i++) {
			if(this.get(i).equals(obj)) {
				this.remove(i);
				count++;
			}
		}
		}
		return count;
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
		
		return this.header.getNext().getElement();
	}

	@Override
	public E last() {
		return this.get(this.size-1);
	}

	@Override
	public int firstIndex(E obj) {
		if(this.contains(obj) && !this.isEmpty()) {
			for (int i = 0; i < this.size; i++) {
				if(this.get(i).equals(obj)) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public int lastIndex(E obj) {
		if(this.contains(obj) && !this.isEmpty()) {
			for (int i = this.size-1; i >= 0; i--) {
				if(this.get(i).equals(obj)) {
					return i;
				}
			}
		}
		return -1;
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
