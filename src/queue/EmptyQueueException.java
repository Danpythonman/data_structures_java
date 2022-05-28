package queue;

/**
 * Signals that a queue method with a precondition that the queue cannot be
 * empty has been invoked when the queue is empty.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends RuntimeException {

	/**
	 * Constructs an EmptyQueueException without a message describing the
	 * particular exception.
	 */
	public EmptyQueueException() {
		super();
	}

	/**
	 * Constructs an EmptyQueueException with a message describing the
	 * particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public EmptyQueueException(String message) {
		super(message);
	}

}
