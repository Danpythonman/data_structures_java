package linked_list;

/**
 * Signals that a singly-linked list method with a precondition that the list
 * cannot be empty has been invoked when the list is empty.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class EmptySinglyLinkedListException extends RuntimeException {

	/**
	 * Constructs an EmptySinglyLinkedListException without a message describing
	 * the particular exception.
	 */
	public EmptySinglyLinkedListException() {
		super();
	}

	/**
	 * Constructs an EmptySinglyLinkedListException with a message describing
	 * the particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public EmptySinglyLinkedListException(String message) {
		super(message);
	}

}
