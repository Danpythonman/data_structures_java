package queue;

import dynamic_circular_array.DynamicCircularArray;

public class ArrayQueue<E> implements Queue<E> {

	private DynamicCircularArray<E> data;

	/**
	 * Initialize an empty queue.
	 */
	public ArrayQueue() {
		this.data = new DynamicCircularArray<E>();
	}

	/**
	 * Initialize a queue with one element (the first item of the queue).
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
			throw new IllegalStateException("Queue is empty");
		}

		return this.data.getFirst();
	}

	public void enqueue(E e) {
		this.data.addLast(e);
	}

	public E dequeue() {
		if (this.data.size() == 0) {
			throw new IllegalStateException("Queue is empty");
		}

		E first = this.data.getFirst();

		this.data.removeFirst();

		return first;
	}

}
