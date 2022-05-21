package linked_list;

/**
 * A node in a singly-linked list. Contains a reference to the data it stores,
 * as well as a reference to the next node in the list.
 *
 * @author Daniel
 *
 * @param <E>
 */
public class SinglyLinkedNode<E> {

	/**
	 * The data being stored by the node.
	 */
	private E data;

	/**
	 * The reference to the next doubly-linked node in the list.
	 */
	private SinglyLinkedNode<E> next;

	/**
	 * Instantiates a singly-linked node.
	 *
	 * @param data - The data to be stored by the node.
	 * @param next - The next node in the list.
	 */
	public SinglyLinkedNode(E data, SinglyLinkedNode<E> next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * Instantiates a singly-linked node with its next reference null.
	 *
	 * @param data - The data to be stored by the node.
	 */
	public SinglyLinkedNode(E data) {
		this.data = data;
		this.next = null;
	}

	/**
	 * Gets the data stored in the singly-linked node.
	 *
	 * @return The data stored in the node.
	 */
	public E getData() {
		return this.data;
	}

	/**
	 * Sets the data stored in the doubly-linked node.
	 *
	 * @param data - The data to be stored in the node.
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Gets the next reference of the singly-linked node.
	 *
	 * @return - The node next to (after) this node.
	 */
	public SinglyLinkedNode<E> getNext() {
		return this.next;
	}

	/**
	 * Sets the next reference of the doubly-linked node.
	 *
	 * @param next - The node to be set as the next node to this node.
	 */
	public void setNext(SinglyLinkedNode<E> next) {
		this.next = next;
	}

}
