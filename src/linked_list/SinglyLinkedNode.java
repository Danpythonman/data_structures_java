package linked_list;

public class SinglyLinkedNode<E> {

	private E data;
	private SinglyLinkedNode<E> next;

	public SinglyLinkedNode(E data, SinglyLinkedNode<E> next) {
		this.data = data;
		this.next = next;
	}

	public SinglyLinkedNode(E data) {
		this.data = data;
		this.next = null;
	}

	public E getData() {
		return this.data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public SinglyLinkedNode<E> getNext() {
		return this.next;
	}

	public void setNext(SinglyLinkedNode<E> next) {
		this.next = next;
	}

}
