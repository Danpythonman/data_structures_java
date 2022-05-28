package queue;

import dynamic_circular_array.DynamicCircularArray;

/**
 * Implements the queue data structure where the collection of objects in the
 * queue is a dynamic circular array.
 *
 * @author Daniel
 *
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

	/**
	 * The contents of the queue.
	 *
	 * The first element (at index 0) is treated as the front of the queue, and
	 * the last element (at index this.data.size - 1) is treated as the back of
	 * the queue.
	 */
	private DynamicCircularArray<E> data;

	/**
	 * Initialize an empty queue.
	 */
	public ArrayQueue() {
		this.data = new DynamicCircularArray<E>();
	}

	/**
	 * Initialize a queue with one element (the first item of the queue).
	 *
	 * @param e - The initial item to be added to the queue.
	 */
	public ArrayQueue(E e) {
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
			throw new EmptyQueueException("Queue is empty: the front of the"
					+ "queue cannot be accessed when the queue is empty");
		}

		return this.data.getFirst();
	}

	public void enqueue(E e) {
		this.data.addLast(e);
	}

	public E dequeue() {
		if (this.data.size() == 0) {
			throw new EmptyQueueException("Queue is empty: cannot dequeue from"
					+ "empty queue");
		}

		E first = this.data.getFirst();

		this.data.removeFirst();

		return first;
	}

}
