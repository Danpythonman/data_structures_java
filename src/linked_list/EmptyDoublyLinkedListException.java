package linked_list;

/**
 * Signals that a doubly-linked list method with a precondition that the list
 * cannot be empty has been invoked when the list is empty.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class EmptyDoublyLinkedListException extends RuntimeException {

	/**
	 * Constructs an EmptyDoublyLinkedListException without a message describing
	 * the particular exception.
	 */
	public EmptyDoublyLinkedListException() {
		super();
	}

	/**
	 * Constructs an EmptyDoublyLinkedListException with a message describing
	 * the particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public EmptyDoublyLinkedListException(String message) {
		super(message);
	}

}
