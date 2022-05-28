package deque;

/**
 * Signals that a deque method with a precondition that the deque cannot be
 * empty has been invoked when the deque is empty.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class EmptyDequeException extends RuntimeException {

	/**
	 * Constructs an EmptyDequeException without a message describing the
	 * particular exception.
	 */
	public EmptyDequeException() {
		super();
	}

	/**
	 * Constructs an EmptyDequeException with a message describing the
	 * particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public EmptyDequeException(String message) {
		super(message);
	}

}
