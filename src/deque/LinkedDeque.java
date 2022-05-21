package deque;

import linked_list.DoublyLinkedNode;

public class LinkedDeque<E> implements Deque<E> {

	private DoublyLinkedNode<E> header;
	private DoublyLinkedNode<E> trailer;
	private int size;

	/**
	 * Initialize an empty deque.
	 */
	public LinkedDeque() {
		this.header = new DoublyLinkedNode<E>(null, null, null);
		this.trailer = new DoublyLinkedNode<E>(null, this.header, null);
		this.header.setNext(trailer);

		this.size = 0;
	}

	/**
	 * Initialize a deque with one element.
	 */
	public LinkedDeque(E e) {
		this.header = new DoublyLinkedNode<E>(null, null, null);
		this.trailer = new DoublyLinkedNode<E>(null, this.header, null);
		this.header.setNext(trailer);

		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(e, this.header, this.trailer);
		this.header.setNext(newNode);
		this.trailer.setPrev(newNode);

		this.size = 1;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E first() {
		if (this.size == 0) {
			throw new IllegalStateException("Deque is empty");
		}

		return this.header.getNext().getData();
	}

	public E last() {
		if (this.size == 0) {
			throw new IllegalStateException("Deque is empty");
		}

		return this.trailer.getPrev().getData();
	}

	public void addFirst(E e) {
		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(e, this.header, this.header.getNext());

		this.header.getNext().setPrev(newNode);
		this.header.setNext(newNode);

		this.size++;
	}

	public void addLast(E e) {
		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(e, this.trailer.getPrev(), this.trailer);

		this.trailer.getPrev().setNext(newNode);
		this.trailer.setPrev(newNode);

		this.size++;
	}

	public E removeFirst() {
		if (this.size == 0) {
			throw new IllegalStateException("Deque is empty");
		}

		DoublyLinkedNode<E> firstNode = this.header.getNext();

		firstNode.getNext().setPrev(this.header);
		this.header.setNext(firstNode.getNext());

		firstNode.setPrev(null);
		firstNode.setNext(null);

		this.size--;

		return firstNode.getData();
	}

	public E removeLast() {
		if (this.size == 0) {
			throw new IllegalStateException("Deque is empty");
		}

		DoublyLinkedNode<E> lastNode = this.trailer.getPrev();

		lastNode.getPrev().setNext(this.trailer);
		this.trailer.setPrev(lastNode.getPrev());

		lastNode.setPrev(null);
		lastNode.setNext(null);

		this.size--;

		return lastNode.getData();
	}

}
