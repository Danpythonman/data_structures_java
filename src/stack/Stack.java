package stack;

public interface Stack<E> {

	/**
	 * Returns the number of elements in the stack.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The number of elements in the stack.
	 */
	public int size();

	/**
	 * Returns whether or not the stack is empty.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return True if there are no elements in the stack, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Return the top of the stack (the item most recently pushed to the stack).
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The element at the top of the stack.
	 */
	public E top();

	/**
	 * Pushes an item to the top of the stack.
	 *
	 * <h5>Running time:</h5>
	 * <ul>
	 *   <li>LinkedStack: <strong>O(1)</strong></li>
	 *   <li>ArrayStack: <strong>O(1)</strong> (amortized)</li>
	 * </ul>
	 *
	 * @param e The item to be pushed to the top of the stack.
	 */
	public void push(E e);

	/**
	 * Removes and returns the item at the top of the stack.
	 *
	 * <h5>Running time:</h5>
	 * <ul>
	 *   <li>LinkedStack: <strong>O(1)</strong></li>
	 *   <li>ArrayStack: <strong>O(1)</strong> (amortized)</li>
	 * </ul>
	 *
	 * @return The item at the top of the stack (which will be removed from the stack).
	 */
	public E pop();

}
