package queue;

public interface Queue<E> {

	/**
	 * Returns the number of elements in the queue.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The number of elements in the queue.
	 */
	public int size();

	/**
	 * Returns whether or not the queue is empty.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return True if there are no elements in the queue, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Return the first item in the queue
	 * (the element that has been in the queue the longest).
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The first item in the queue.
	 */
	public E first();

	/**
	 * Enqueue an item. This adds the item to the "back" of the queue.
	 *
	 * <h5>Running time:</h5>
	 * <ul>
	 *   <li>LinkedQueue: <strong>O(1)</strong></li>
	 *   <li>ArrayQueue: <strong>O(1)</strong> (amortized)</li>
	 * </ul>
	 *
	 * @param e - The item to be enqueued.
	 */
	public void enqueue(E e);

	/**
	 * Remove and return the first item of the queue.
	 *
	 * <h5>Running time:</h5>
	 * <ul>
	 *   <li>LinkedQueue: <strong>O(1)</strong></li>
	 *   <li>ArrayQueue: <strong>O(1)</strong> (amortized)</li>
	 * </ul>
	 *
	 * @return The first item in the queue (which will be removed from the queue).
	 */
	public E dequeue();

}
