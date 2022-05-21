package deque;

import dynamic_circular_array.DynamicCircularArray;

public class ArrayDeque<E> implements Deque<E> {

	private DynamicCircularArray<E> data;

	/**
	 * Initialize an empty deque.
	 */
	public ArrayDeque() {
		this.data = new DynamicCircularArray<E>();
	}

	/**
	 * Initialize a deque with one element.
	 */
	public ArrayDeque(E e) {
		this.data = new DynamicCircularArray<E>();
		this.data.add(e);
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public E first() {
		if (this.data.size() == 0) {
			throw new IllegalStateException("Deque is empty");
		}

		return this.data.getFirst();
	}

	public E last() {
		if (this.data.size() == 0) {
			throw new IllegalStateException("Deque is empty");
		}

		return this.data.getLast();
	}

	public void addFirst(E e) {
		this.data.addFirst(e);
	}

	public void addLast(E e) {
		this.data.addLast(e);
	}

	public E removeFirst() {
		if (this.data.size() == 0) {
			throw new IllegalStateException("Deque is empty");
		}

		E first = this.data.getFirst();

		this.data.removeFirst();

		return first;
	}

	public E removeLast() {
		if (this.data.size() == 0) {
			throw new IllegalStateException("Deque is empty");
		}

		E last = this.data.getLast();

		this.data.removeLast();

		return last;
	}

}
