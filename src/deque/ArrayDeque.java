package deque;

import dynamic_circular_array.DynamicCircularArray;

/**
 * Implements the deque data structure where the collection of objects in the
 * deque is a dynamic circular array.
 *
 * @author Daniel
 *
 * @param <E>
 */
public class ArrayDeque<E> implements Deque<E> {

	/**
	 * The contents of the deque.
	 *
	 * The first element (at index 0) is treated as the front of the deque, and
	 * the last element (at index this.data.size - 1) is treated as the back of
	 * the deque.
	 */
	private DynamicCircularArray<E> data;

	/**
	 * Initialize an empty deque.
	 */
	public ArrayDeque() {
		this.data = new DynamicCircularArray<E>();
	}

	/**
	 * Initialize a deque with one element.
	 *
	 * @param e - The initial item to be added to the deque.
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
			throw new EmptyDequeException("Deque is empty: the front of the"
					+ "deque cannot be accessed when the deque is empty");
		}

		return this.data.getFirst();
	}

	public E last() {
		if (this.data.size() == 0) {
			throw new EmptyDequeException("Deque is empty: the back of the"
					+ "deque cannot be accessed when the deque is empty");
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
			throw new EmptyDequeException("Deque is empty: cannot remove the"
					+ "first item of the deque when the deque is empty");
		}

		E first = this.data.getFirst();

		this.data.removeFirst();

		return first;
	}

	public E removeLast() {
		if (this.data.size() == 0) {
			throw new EmptyDequeException("Deque is empty: cannot remove the"
					+ "last item of the deque when the deque is empty");
		}

		E last = this.data.getLast();

		this.data.removeLast();

		return last;
	}

}
