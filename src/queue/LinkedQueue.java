package queue;

import linked_list.SinglyLinkedNode;

/**
 * Implements the queue data structure where the collection of objects in the
 * queue is a singly-linked list.
 *
 * <br><br>
 *
 * The head of the singly-linked list is used as the front of the queue, and the
 * tail is used as the back of the queue. Since only the head and tail of the
 * list will be accessed, updated, or removed, a full singly-linked list object
 * is not used. Instead, just the head, tail, and size of the list is defined,
 * and all list operations are done to the head and tail attributes.
 *
 * @author Daniel
 *
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E> {

	/**
	 * The front of the queue. Also represents the head of the singly-linked
	 * list that holds the collection of objects in the queue.
	 */
	private SinglyLinkedNode<E> head;

	/**
	 * The back of the queue. Also represents the tail of the singly-linked
	 * list that holds the collection of objects in the queue.
	 */
	private SinglyLinkedNode<E> tail;

	/**
	 * The size of the queue. Also is the size of the singly-linked list that
	 * holds the collection of objects in the queue.
	 */
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
	 *
	 * @param e - The initial item to be added to the queue.
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
			throw new EmptyQueueException("Queue is empty: the front of the"
					+ "queue cannot be accessed when the queue is empty");
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
			throw new EmptyQueueException("Queue is empty: cannot dequeue from"
					+ "empty queue");
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
