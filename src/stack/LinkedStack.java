package stack;

import linked_list.SinglyLinkedNode;

/**
 * Implements the stack data structure where the collection of objects in the
 * stack is a singly-linked list.
 *
 * <br><br>
 *
 * The head of the singly-linked list is used as the top of the stack. Since
 * only the head of the list will be accessed, updated, or removed, a full
 * singly-linked list object is not used. Instead, just the head and size of the
 * list is defined, and all list operations are done to the head attribute.
 *
 * @author Daniel
 *
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {

	/**
	 * The top of the stack. Also represents the head of the singly-linked list
	 * that holds the collection of objects in the stack.
	 */
	private SinglyLinkedNode<E> head;

	/*
	 * The size of the stack. Also is the size of the singly-linked list that
	 * holds the collection of objects in the stack.
	 */
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
			throw new EmptyStackException("Stack is empty: "
				+ "top of stack cannot be accessed when empty");
		}

		return this.head.getData();
	}

	public void push(E e) {
		this.head = new SinglyLinkedNode<E>(e, this.head);

		this.size++;
	}

	public E pop() {
		if (this.size == 0) {
			throw new EmptyStackException("Stack is empty: "
				+ "top of stack cannot be accessed when empty");
		}

		SinglyLinkedNode<E> top = this.head;

		this.head = this.head.getNext();

		top.setNext(null);

		this.size--;

		return top.getData();
	}

}
