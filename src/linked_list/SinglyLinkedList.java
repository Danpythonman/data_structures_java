package linked_list;

/**
 * A linear sequence of connected nodes, where each node has a reference to the data stored in the node,
 * as well as a reference to the next node in the sequence.
 *
 * @author Daniel
 *
 * @param <E>
 */
public class SinglyLinkedList<E> implements LinkedList<E> {

	/**
	 * The first node in the singly-linked list.
	 */
	private SinglyLinkedNode<E> head;

	/**
	 * The last node in the singly-linked list.
	 */
	private SinglyLinkedNode<E> tail;

	/**
	 * The size of the singly-linked list.
	 */
	private int size;

	/**
	 * Initialize an empty singly-linked list.
	 */
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Initialize a singly-linked list with one element.
	 *
	 * @param node - The initial node to be stored in the singly-linked list.
	 */
	public SinglyLinkedList(SinglyLinkedNode<E> node) {
		this.head = node;
		this.tail = node;
		this.size = 0;
	}

	public void add(E e) {
		if (this.size == 0) {
			this.addFirst(e);
		} else {
			this.addLast(e);
		}
	}

	public void add(E e, int index) {
		if (index == 0) {
			this.addFirst(e);
		} else if (index == this.size) {
			this.addLast(e);
		} else {
			SinglyLinkedNode<E> previous = this.getNode(index - 1);

			SinglyLinkedNode<E> newNode = new SinglyLinkedNode<E>(e, previous.getNext());

			previous.setNext(newNode);

			this.size++;
		}
	}

	public void addFirst(E e) {
		if (this.size == 0) {
			this.head = new SinglyLinkedNode<E>(e);
			this.tail = this.head;
		} else {
			this.head = new SinglyLinkedNode<E>(e, this.head);
		}

		this.size++;
	}

	public void addLast(E e) {
		if (this.size == 0) {
			this.addFirst(e);
		} else {
			this.tail.setNext(new SinglyLinkedNode<E>(e));
			this.tail = tail.getNext();
			this.size++;
		}
	}

	public void set(E e, int index) {
		this.getNode(index).setData(e);
	}

	public E get(int index) {
		return this.getNode(index).getData();
	}

	public E getFirst() {
		return this.head.getData();
	}

	public E getLast() {
		return this.tail.getData();
	}

	private SinglyLinkedNode<E> getNode(int index) {
		if (index < 0 || index >= this.size) {
			throw new IllegalArgumentException("Invalid index - Index must be between 0 and the list size (inclusive).");
		}

		SinglyLinkedNode<E> current = this.head;

		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}

		return current;
	}

	public int size() {
		return this.size;
	}

	public int indexOf(E e) {
		SinglyLinkedNode<E> current = this.head;

		int index = 0;

		while (current != null) {
			if (current.getData().equals(e)) {
				break;
			}

			current = current.getNext();
			index++;
		}

		return current != null ? index : -1;
	}

	public boolean contains(E e) {
		return this.indexOf(e) > -1;
	}

	public void remove(int index) {
		if (this.size == 0) {
			throw new IllegalStateException("List empty, cannot remove from empty list");
		} else if (this.size == 1) {
			this.head = null;
			this.tail = null;

			this.size--;
		} else {
			if (index == 0) {
				this.removeFirst();
			} else if (index == this.size - 1) {
				this.removeLast();
			} else {
				SinglyLinkedNode<E> removalPrevious = this.getNode(index - 1);

				SinglyLinkedNode<E> removal = removalPrevious.getNext();

				removalPrevious.setNext(removal.getNext());

				removal.setNext(null);

				this.size--;
			}
		}
	}

	public void removeFirst() {
		if (this.size == 0) {
			throw new IllegalStateException("List empty, cannot remove from empty list");
		} else if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			SinglyLinkedNode<E> oldHead = this.head;

			this.head = oldHead.getNext();

			oldHead.setNext(null);
		}

		this.size--;
	}

	public void removeLast() {
		if (this.size == 0) {
			throw new IllegalStateException("List empty, cannot remove from empty list");
		} else if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = this.getNode(this.size - 2);

			this.tail.setNext(null);
		}

		this.size--;
	}

	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

}
