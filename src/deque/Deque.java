package deque;

/**
 * A double-ended-queue (deque) data structure.
 *
 * <br><br>
 *
 * A queue-like data structure that allows accessing, insertion, and deletion,
 * from both ends of the queue. Items in the deque can be accessed from,
 * inserted to, or deleted from both the front and back of the structure.
 *
 * @author Daniel
 *
 * @param <E>
 */
public interface Deque<E> {

	/**
	 * Returns the number of elements in the deque.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The number of elements in the deque.
	 */
	public int size();

	/**
	 * Returns whether or not the deque is empty.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return True if there are no elements in the deque, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Return the first item in the deque
	 * (the item at the "front" of the deque).
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The first item in the deque.
	 */
	public E first();

	/**
	 * Return the last item in the deque
	 * (the element at the "back" of the deque).
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The last item in the deque.
	 */
	public E last();

	/**
	 * Add an item to the "front" of the deque.
	 *
	 * <h5>Running time:</h5>
	 * <ul>
	 *   <li>LinkedDeque: <strong>O(1)</strong></li>
	 *   <li>ArrayDeque: <strong>O(1)</strong> (amortized)</li>
	 * </ul>
	 *
	 * @param e - The item to be added to the "front" of the deque.
	 */
	public void addFirst(E e);

	/**
	 * Add an item to the "back" of the deque.
	 *
	 * <h5>Running time:</h5>
	 * <ul>
	 *   <li>LinkedDeque: <strong>O(1)</strong></li>
	 *   <li>ArrayDeque: <strong>O(1)</strong> (amortized)</li>
	 * </ul>
	 *
	 * @param e - The item to be added to the "back" of the deque.
	 */
	public void addLast(E e);

	/**
	 * Remove and return the first item of the deque
	 * (the item at the "front" of the deque).
	 *
	 * <h5>Running time:</h5>
	 * <ul>
	 *   <li>LinkedDeque: <strong>O(1)</strong></li>
	 *   <li>ArrayDeque: <strong>O(1)</strong> (amortized)</li>
	 * </ul>
	 *
	 * @return The first item in the deque
	 *         (which will be removed from the deque).
	 */
	public E removeFirst();

	/**
	 * Remove and return the last item of the deque
	 * (the item at the "back" of the deque).
	 *
	 * <h5>Running time:</h5>
	 * <ul>
	 *   <li>LinkedDeque: <strong>O(1)</strong></li>
	 *   <li>ArrayDeque: <strong>O(1)</strong> (amortized)</li>
	 * </ul>
	 *
	 * @return The first item in the deque
	 *         (which will be removed from the deque).
	 */
	public E removeLast();

}
