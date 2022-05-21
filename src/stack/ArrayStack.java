package stack;

import dynamic_circular_array.DynamicCircularArray;

/**
 * Implements the stack data structure where the collection of objects in the
 * stack is a dynamic circular array.
 *
 * @author Daniel
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

	/**
	 * The contents of the stack.
	 *
	 * The first element (at index 0) is treated as the top of the stack.
	 */
	private DynamicCircularArray<E> data;

	/**
	 * Initialize an empty stack.
	 */
	public ArrayStack() {
		this.data = new DynamicCircularArray<>();
	}

	/**
	 * Initialize a stack with one element (the top of the stack).
	 */
	public ArrayStack(E e) {
		this.data = new DynamicCircularArray<>();

		this.data.addFirst(e);
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public E top() {
		if (this.data.size() == 0) {
			throw new EmptyStackException("Stack is empty: "
				+ "top of stack cannot be accessed when empty");
		}

		return this.data.get(0);
	}

	public void push(E e) {
		this.data.addFirst(e);
	}

	public E pop() {
		if (this.data.size() == 0) {
			throw new EmptyStackException("Stack is empty: "
				+ "stack cannot be popped when empty");
		}

		E top = this.data.get(0);

		this.data.removeFirst();

		return top;
	}

}
