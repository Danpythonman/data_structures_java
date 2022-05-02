package linked_list;

public class DoublyLinkedList<E> implements LinkedList<E> {

	private DoublyLinkedNode<E> header;
	private DoublyLinkedNode<E> trailer;
	private int size;

	public DoublyLinkedList() {
		this.header = new DoublyLinkedNode<E>(null, null, null);
		this.trailer = new DoublyLinkedNode<E>(null, null, null);
		this.header.setNext(this.trailer);
		this.trailer.setPrev(this.header);
		this.size = 0;
	}

	public void add(E e) {
		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(e, this.trailer.getPrev(), this.trailer);

		this.trailer.getPrev().setNext(newNode);
		this.trailer.setPrev(newNode);

		this.size++;
	}

	public void add(E e, int index) {
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("Invalid index - Index must be between 0 and the list size (inclusive).");
		}

		DoublyLinkedNode<E> previousNode = this.getNode(index - 1);
		DoublyLinkedNode<E> nextNode = previousNode.getNext();

		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(e, previousNode, nextNode);

		previousNode.setNext(newNode);
		nextNode.setPrev(newNode);

		this.size++;
	}

	public void addFirst(E e) {
		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(e, this.header, this.header.getNext());

		this.header.getNext().setPrev(newNode);
		this.header.setNext(newNode);

		this.size++;
	}

	public void addLast(E e) {
		this.add(e);
	}

	public void set(E e, int index) {
		this.getNode(index).setData(e);
	}

	public E get(int index) {
		if (this.size == 0 && index == 0) {
			return null;
		} else if (index < 0 || index > this.size - 1) {
			throw new IllegalArgumentException("Invalid index - Index must be between 0 and the list size - 1 (inclusive).");
		}

		return this.getNode(index).getData();
	}

	public E getFirst() {
		return this.size > 0 ? this.header.getNext().getData() : null;
	}

	public E getLast() {
		return this.size > 0 ? this.trailer.getPrev().getData() : null;
	}

	private DoublyLinkedNode<E> getNode(int index) {
		if (index < -1 || index > this.size) {
			throw new IllegalArgumentException("Invalid index - Index must be between -1 and the list size (inclusive).");
		} else if (index == -1) {
			// Header at index -1
			return this.header;
		} else if (index == this.size) {
			// Trailer at index this.size
			return this.trailer;
		} else {
			DoublyLinkedNode<E> current = this.header.getNext();
	
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
	
			return current;
		}
	}

	public int size() {
		return this.size;
	}

	public int indexOf(E e) {
		if (this.size == 0) {
			return -1;
		}

		DoublyLinkedNode<E> current = this.header.getNext();

		int index = 0;

		while (current != this.trailer) {
			if (current.getData().equals(e)) {
				break;
			}

			current = current.getNext();
			index++;
		}

		return current != this.trailer ? index : -1;
	}

	public boolean contains(E e) {
		return this.indexOf(e) > -1;
	}

	public void remove(int index) {
		if (this.size == 0) {
			throw new IllegalStateException("List empty, cannot remove from empty list");
		} else if (index < 0 || index > this.size - 1) {
			throw new IllegalArgumentException("Invalid index - Index must be between 0 and the list size - 1 (inclusive).");
		}

		DoublyLinkedNode<E> removal = this.getNode(index);
		DoublyLinkedNode<E> previousNode = removal.getPrev();
		DoublyLinkedNode<E> nextNode = removal.getNext();

		removal.setPrev(null);
		removal.setNext(null);

		previousNode.setNext(nextNode);
		nextNode.setPrev(previousNode);

		this.size--;
	}

	public void removeFirst() { 
		this.remove(0);
	}

	public void removeLast() {
		this.remove(this.size - 1);
	}

	public void clear() {
		this.header.setNext(this.trailer);
		this.trailer.setPrev(this.header);
		this.size = 0;
	}

}
