package queue;

import linked_list.SinglyLinkedNode;

public class LinkedQueue<E> implements Queue<E> {

	private SinglyLinkedNode<E> head;
	private SinglyLinkedNode<E> tail;
	private int size;

	/**
	 * Initialize an empty queue.
	 */
	public LinkedQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Initialize a queue with one element (the first item of the queue).
	 */
	public LinkedQueue(E e) {
		this.head = new SinglyLinkedNode<E>(e, null);
		this.tail = this.head;
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
			throw new IllegalStateException("Queue is empty");
		}

		return this.head.getData();
	}

	public void enqueue(E e) {
		if (this.size == 0) {
			this.head = new SinglyLinkedNode<E>(e, null);

			this.tail = this.head;
		} else {
			SinglyLinkedNode<E> newTail = new SinglyLinkedNode<E>(e, null);

			this.tail.setNext(newTail);

			this.tail = this.tail.getNext();
		}

		this.size++;
	}

	public E dequeue() {
		if (this.size == 0) {
			throw new IllegalStateException("Queue is empty");
		}

		SinglyLinkedNode<E> firstNode = this.head;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = firstNode.getNext();
			firstNode.setNext(null);
		}

		this.size--;

		return firstNode.getData();
	}

}
