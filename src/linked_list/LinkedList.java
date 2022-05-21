package linked_list;

/**
 * A linear sequence of connected nodes.
 * The nodes are connected by referencing other nodes in the sequence.
 *
 * @author Daniel
 *
 * @param <E>
 */
public interface LinkedList<E> {

	/**
	 * Add an element to the end of the list.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @param e - The element to be added to the list.
	 */
	public void add(E e);

	/**
	 * Add an element to the list at the at the specified index.
	 *
	 * <h5>Running time: <strong>O(n)</strong></h5>
	 *
	 * @param e     - The element to be added to the list.
	 * @param index - The index at which to add the new element.
	 */
	public void add(E e, int index);

	/**
	 * Add an element to the beginning of the list.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @param e - The element to be added to the list.
	 */
	public void addFirst(E e);

	/**
	 * Add an element to the end of the list.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @param e - The element to be added to the list.
	 */
	public void addLast(E e);

	/**
	 * Update the value of the element at the specified index to the new value.
	 *
	 * <h5>Running time: <strong>O(n)</strong></h5>
	 *
	 * @param e     - The new value of the element.
	 * @param index - The index of the element to be updated.
	 */
	public void set(E e, int index);

	/**
	 * Get the element at the specified index.
	 *
	 * <h5>Running time: <strong>O(n)</strong></h5>
	 *
	 * @param index - The index of the element to be retrieved.
	 *
	 * @return The element at the specified index.
	 */
	public E get(int index);

	/**
	 * Get the first element of the list.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The first element of the list.
	 */
	public E getFirst();

	/**
	 * Get the last element of the list.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The last element of the list.
	 */
	public E getLast();

	/**
	 * Get the size of the list.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The size of the list.
	 */
	public int size();

	/**
	 * Returns the index of the element with the specified value in the list.
	 * If there are more than one elements with the specified value, the index
	 * of the first instance is returned.
	 * If not found, -1 is returned.
	 *
	 * <h5>Running time: <strong>O(n)</strong></h5>
	 *
	 * @param e - The value of the element to search for in the list.
	 *
	 * @return The index of the (first) element with the specified value in the
	 *         list (-1 if not found).
	 */
	public int indexOf(E e);

	/**
	 * Returns whether or not an element with the specified value exists in the list.
	 *
	 * <h5>Running time: <strong>O(n)</strong></h5>
	 *
	 * @param e - The value of the element to search for in the list.
	 *
	 * @return True if an element with the specified value exists in the list,
	 *         false otherwise.
	 */
	public boolean contains(E e);

	/**
	 * Removes the element at the specified index.
	 *
	 * <h5>Running time: <strong>O(n)</strong></h5>
	 *
	 * @param index - The index at which to remove the element.
	 */
	public void remove(int index);

	/**
	 * Removes the first element of the list.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 */
	public void removeFirst();

	/**
	 * Removes the last element of the list.
	 *
	 * <h5>Running time:</h5>
	 * <ul>
	 *   <li>Singly-linked list: <strong>O(n)</strong></li>
	 *   <li>Doubly-linked list: <strong>O(1)</strong></li>
	 * </ul>
	 */
	public void removeLast();

	/**
	 * Removes all elements from the list.
	 *
	 * <h5>Running time: O(1)</h5>
	 */
	public void clear();

}
