package linked_list;

/**
 * Signals that a doubly-linked list was indexed at an invalid index.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class InvalidDoublyLinkedListIndexException extends RuntimeException {

	/**
	 * Constructs an InvalidDoublyLinkedListIndexException without a message
	 * describing the particular exception.
	 */
	public InvalidDoublyLinkedListIndexException() {
		super();
	}

	/**
	 * Constructs an InvalidDoublyLinkedListIndexException with a message
	 * describing the particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public InvalidDoublyLinkedListIndexException(String message) {
		super(message);
	}

}
