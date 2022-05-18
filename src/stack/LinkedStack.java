package stack;

import linked_list.SinglyLinkedNode;

public class LinkedStack<E> implements Stack<E> {

	private SinglyLinkedNode<E> head;
	private int size;

	/**
	 * Initialize an empty stack.
	 */
	public LinkedStack() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Initialize a stack with one element (the top of the stack).
	 */
	public LinkedStack(E e) {
		this.head = new SinglyLinkedNode<E>(e);
		this.size = 1;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E top() {
		if (this.size == 0) {
			throw new IllegalStateException("Stack is empty");
		}

		return this.head.getData();
	}

	public void push(E e) {
		this.head = new SinglyLinkedNode<E>(e, this.head);

		this.size++;
	}

	public E pop() {
		if (this.size == 0) {
			throw new IllegalStateException("Stack is empty");
		}

		SinglyLinkedNode<E> top = this.head;

		this.head = this.head.getNext();

		top.setNext(null);

		this.size--;

		return top.getData();
	}

}
