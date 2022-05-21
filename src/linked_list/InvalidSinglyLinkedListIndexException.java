package linked_list;

/**
 * Signals that a singly-linked list was indexed at an invalid index.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class InvalidSinglyLinkedListIndexException extends RuntimeException {

	/**
	 * Constructs an InvalidSinglyLinkedListIndexException without a message
	 * describing the particular exception.
	 */
	public InvalidSinglyLinkedListIndexException() {
		super();
	}

	/**
	 * Constructs an InvalidSinglyLinkedListIndexException with a message
	 * describing the particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public InvalidSinglyLinkedListIndexException(String message) {
		super(message);
	}

}
