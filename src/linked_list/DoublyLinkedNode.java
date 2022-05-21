package linked_list;

/**
 * A node in a doubly-linked list. Contains a reference to the data it stores,
 * as well as references to the next and previous nodes in the list.
 *
 * @author Daniel
 *
 * @param <E>
 */
public class DoublyLinkedNode<E> {

	/**
	 * The data being stored by the node.
	 */
	private E data;

	/**
	 * The reference to the previous doubly-linked node in the list.
	 */
	private DoublyLinkedNode<E> prev;

	/**
	 * The reference to the next doubly-linked node in the list.
	 */
	private DoublyLinkedNode<E> next;

	/**
	 * Instantiates a doubly-linked node.
	 *
	 * @param data - The data to be stored by the node.
	 * @param prev - The previous node in the list.
	 * @param next - The next node in the list.
	 */
	public DoublyLinkedNode(E data, DoublyLinkedNode<E> prev, DoublyLinkedNode<E> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	/**
	 * Instantiates a doubly-linked node with its next reference null.
	 *
	 * @param prev - The previous node in the list.
	 * @param data - The data to be stored by the node.
	 */
	public DoublyLinkedNode(DoublyLinkedNode<E> prev, E data) {
		this.data = data;
		this.prev = prev;
		this.next = null;
	}

	/**
	 * Instantiates a doubly-linked node with its previous reference null.
	 *
	 * @param data - The data to be stored by the node.
	 * @param next - The next node in the list.
	 */
	public DoublyLinkedNode(E data, DoublyLinkedNode<E> next) {
		this.data = data;
		this.prev = null;
		this.next = next;
	}

	/**
	 * Instantiates a doubly-linked node with its previous and next references null.
	 *
	 * @param data - The data to be stored by the node.
	 */
	public DoublyLinkedNode(E data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	/**
	 * Gets the data stored in the doubly-linked node.
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
	 * Gets the previous reference of the doubly-linked node.
	 *
	 * @return - The node previous to this node.
	 */
	public DoublyLinkedNode<E> getPrev() {
		return this.prev;
	}

	/**
	 * Sets the previous reference of the doubly-linked node.
	 *
	 * @param prev - The node to be set as the previous node to this node.
	 */
	public void setPrev(DoublyLinkedNode<E> prev) {
		this.prev = prev;
	}

	/**
	 * Gets the next reference of the doubly-linked node.
	 *
	 * @return - The node next to (after) this node.
	 */
	public DoublyLinkedNode<E> getNext() {
		return this.next;
	}

	/**
	 * Sets the next reference of the doubly-linked node.
	 *
	 * @param next - The node to be set as the next node to this node.
	 */
	public void setNext(DoublyLinkedNode<E> next) {
		this.next = next;
	}

}
