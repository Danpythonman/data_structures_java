package linked_list;

public class DoublyLinkedNode<E> {

		private E data;
		private DoublyLinkedNode<E> prev;
		private DoublyLinkedNode<E> next;

	public DoublyLinkedNode(E data, DoublyLinkedNode<E> prev, DoublyLinkedNode<E> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public E getData() {
		return this.data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public DoublyLinkedNode<E> getPrev() {
		return this.prev;
	}

	public void setPrev(DoublyLinkedNode<E> prev) {
		this.prev = prev;
	}

	public DoublyLinkedNode<E> getNext() {
		return this.next;
	}

	public void setNext(DoublyLinkedNode<E> next) {
		this.next = next;
	}

}
