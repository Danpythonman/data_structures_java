package deque;

import linked_list.DoublyLinkedNode;

/**
 * Implements the deque data structure where the collection of objects in the
 * deque is a doubly-linked list.
 *
 * <br><br>
 *
 * The head of the doubly-linked list is used as the front of the deque, and the
 * tail of the doubly-linked list is used as the back of the deque. Since only
 * the head and tail of the list will be accessed, updated, or removed, a
 * full doubly-linked list object is not used. Instead, just the header,
 * trailer, and size of the list is defined, and all list operations are done to
 * the header and trailer attributes. Header and trailer is used instead of head
 * and tail to simplify the implementation list operations.
 *
 * @author Daniel
 *
 * @param <E>
 */
public class LinkedDeque<E> implements Deque<E> {

	/**
	 * The first node in the doubly-linked list that represents the collection
	 * of objects in the deque. The header's next node is the front of the
	 * deque, which is the first item (head) of the doubly-linked list.
	 *
	 * <br><br>
	 *
	 * If the header's next node is the trailer, then the deque (and,
	 * correspondingly, the doubly-linked list) is empty.
	 */
	private DoublyLinkedNode<E> header;

	/**
	 * The last node in the doubly-linked list that represents the collection
	 * of objects in the deque. The trailer's previous node is the back of the
	 * deque, which is the last item (tail) of the doubly-linked list.
	 *
	 * <br><br>
	 *
	 * If the trailer's previous node is the header, then the deque (and,
	 * correspondingly, the doubly-linked list) is empty.
	 */
	private DoublyLinkedNode<E> trailer;

	/**
	 * The size of the deque. Also is the size of the doubly-linked list that
	 * holds the collection of objects in the deque.
	 */
	private int size;

	/**
	 * Initialize an empty deque.
	 */
	public LinkedDeque() {
		this.header = new DoublyLinkedNode<E>(null, null, null);
		this.trailer = new DoublyLinkedNode<E>(null, this.header, null);
		this.header.setNext(trailer);

		this.size = 0;
	}

	/**
	 * Initialize a deque with one element.
	 *
	 * @param e - The initial item to be added to the deque.
	 */
	public LinkedDeque(E e) {
		this.header = new DoublyLinkedNode<E>(null, null, null);
		this.trailer = new DoublyLinkedNode<E>(null, this.header, null);
		this.header.setNext(trailer);

		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(e, this.header, this.trailer);
		this.header.setNext(newNode);
		this.trailer.setPrev(newNode);

		this.size = 1;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E first() {
		if (this.size == 0) {
			throw new EmptyDequeException("Deque is empty: the front of the"
					+ "deque cannot be accessed when the deque is empty");
		}

		return this.header.getNext().getData();
	}

	public E last() {
		if (this.size == 0) {
			throw new EmptyDequeException("Deque is empty: the back of the"
					+ "deque cannot be accessed when the deque is empty");
		}

		return this.trailer.getPrev().getData();
	}

	public void addFirst(E e) {
		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(e, this.header, this.header.getNext());

		this.header.getNext().setPrev(newNode);
		this.header.setNext(newNode);

		this.size++;
	}

	public void addLast(E e) {
		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(e, this.trailer.getPrev(), this.trailer);

		this.trailer.getPrev().setNext(newNode);
		this.trailer.setPrev(newNode);

		this.size++;
	}

	public E removeFirst() {
		if (this.size == 0) {
			throw new EmptyDequeException("Deque is empty: cannot remove the"
					+ "first item of the deque when the deque is empty");
		}

		DoublyLinkedNode<E> firstNode = this.header.getNext();

		firstNode.getNext().setPrev(this.header);
		this.header.setNext(firstNode.getNext());

		firstNode.setPrev(null);
		firstNode.setNext(null);

		this.size--;

		return firstNode.getData();
	}

	public E removeLast() {
		if (this.size == 0) {
			throw new EmptyDequeException("Deque is empty: cannot remove the"
					+ "last item of the deque when the deque is empty");
		}

		DoublyLinkedNode<E> lastNode = this.trailer.getPrev();

		lastNode.getPrev().setNext(this.trailer);
		this.trailer.setPrev(lastNode.getPrev());

		lastNode.setPrev(null);
		lastNode.setNext(null);

		this.size--;

		return lastNode.getData();
	}

}
