package dynamic_circular_array;

/**
 * A sequence of indexed elements (array) where the size of the sequence grows
 * and shrinks (dynamic) according to the number of elements in the sequence,
 * and the indexes of the first and last elements of the array are variable
 * (circular), so the first element is not necessarily at index 0, and the last
 * element is not necessarily at index array size - 1.
 *
 * @author Daniel
 *
 * @param <E>
 */
public class DynamicCircularArray<E> {

	/**
	 * The elements of the circular array.
	 */
	private E[] data;

	/**
	 * Starting index of the circular array.
	 */
	private int front;

	/**
	 * Next available slot in the circular array.
	 */
	private int next;

	/**
	 * The size of the array that holds the elements of the circular array (this.data).
	 */
	private int capacity;

	private final int MINIMUM_SIZE = 10;

	/**
	 * Initialize a dynamic circular array.
	 *
	 * The array will be initialized with a size of 10 elements.
	 */
	@SuppressWarnings("unchecked")
	public DynamicCircularArray() {
		this.capacity = this.MINIMUM_SIZE;
		this.data = (E[]) new Object[this.capacity];
		this.front = 0;
		this.next = 0;
	}

	/**
	 * Initialize the dynamic circular array with an initial size.
	 *
	 * @param size - The initial size of the array.
	 */
	@SuppressWarnings("unchecked")
	public DynamicCircularArray(int size) {
		if (size < 1) {
			String message = "Invalid initial size for dynamic circular array: "
				+ "Initial array size must be at least 1.\n"
				+ "Specified size: " + size;

			throw new InvalidInitialDynamicCircularArraySizeException(message);
		}

		this.capacity = size;
		this.data = (E[]) new Object[this.capacity];
		this.front = 0;
		this.next = 0;
	}

	/**
	 * Doubles the size of the data array.
	 *
	 * <br><br>
	 *
	 * Note that no matter where the front and next available slot indexes are located,
	 * after resizing the front will be 0 and the next available slot will be the
	 * original capacity - 1.
	 * (This means that, after resizing, all the elements in the array will
	 * occupy the first half of the array.)
	 */
	@SuppressWarnings("unchecked")
	private void grow() {
		E[] newData = (E[]) new Object[this.capacity * 2];

		/*
		 * Example:
		 *
		 * Let f = this.front and r = this.next
		 *
		 * Before resizing:
		 *
		 *    r f
		 * |d| |a|b|c|
		 *
		 * After resizing:
		 *
		 *  f       r
		 * |a|b|c|d| | | | | | |
		 *
		 * Note that the elements occupy the first half of the larger array.
		 */

		for (int i = this.front, j = 0; i != this.next; i = (i + 1) % this.capacity, j++) {
			newData[j] = this.data[i];
		}

		// After the resizing, all the elements will in the first half of the resized array
		this.data = newData;
		this.front = 0;
		this.next = this.capacity - 1;
		this.capacity *= 2;
	}

	/**
	 * Halves the size of the array.
	 *
	 * <br><br>
	 *
	 * Note that no matter where the front and next available slot indexes are located,
	 * after resizing the front will be 0 and the next available slot will be the
	 * the number of elements in the original array.
	 */
	@SuppressWarnings("unchecked")
	private void shrink() {
		if (this.size() > this.capacity / 2) {
			String message = "Too many elements to shrink array: "
				+ "Array size must be less than or equal to the capacity / 2"
				+ "(" + (this.capacity / 2) + ").\n"
				+ "Current size: " + this.size();

			throw new TooManyElementsToShrinkException(message);
		}

		E[] newData = (E[]) new Object[this.capacity / 2];
		int newNext = 0;

		for (int i = this.front, j = 0; i != this.next; i = (i + 1) % this.capacity, j++) {
			newData[j] = this.data[i];
			newNext++;
		}

		this.data = newData;
		this.front = 0;
		this.next = newNext;
		this.capacity /= 2;
	}

	/**
	 * Given an index of the circular array, calculates its corresponding index
	 * in the primitive array that holds the values of the array.
	 *
	 * @param index - The desired index of the circular array.
	 *
	 * @return The corresponding index in the primitive array.
	 */
	private int getPrimitiveIndex(int index) {
		if (index < 0 || index >= this.size()) {
			String message = "Invalid index: "
				+ "index must be between 0 and the list size ("
				+ this.size() + "),"
				+ " where it can be equal to 0 but not the list size.\n"
				+ " Provided index: " + index;

			throw new InvalidDynamicCircularArrayIndexException(message);
		}

		if (index < this.capacity - this.front) {
			return this.front + index;
		} else {
			return index - (this.capacity - this.front);
		}
	}

	/**
	 * Add an element to the end of the list.
	 *
	 * <br><br>
	 *
	 * If this method is called when the array is full, a resizing will be triggered
	 * (array size will double).
	 *
	 * <h5>Amortized running time over <code>n</code> calls to this method: <strong>O(1)</strong></h5>
	 *
	 * @param e - The element to be added to the list.
	 */
	public void add(E e) {
		// If the slot after the next available slot is the front of the array,
		// then the array is full
		if ((this.next + 1) % this.capacity == this.front) {
			this.grow();
		}

		// Add the new element
		this.data[this.next] = e;
		this.next = (this.next + 1) % this.capacity;
	}

	/**
	 * Add an element to the list at the at the specified index.
	 *
	 * <br><br>
	 *
	 * If this method is called when the array is full, a resizing will be triggered
	 * (array size will double).
	 *
	 * <h5>Amortized running time over <code>n</code> calls to this method: <strong>O(n)</strong></h5>
	 *
	 * @param e     - The element to be added to the list.
	 * @param index - The index at which to add the new element.
	 */
	public void add(E e, int index) {
		// If the slot after the next available slot is the front of the array,
		// then the array is full
		if ((this.next + 1) % this.capacity == this.front) {
			this.grow();
		}

		if (index == this.size()) {
			this.add(e);
		} else {
			// Get the index in the primitive array that the given index (of the circular array) is mapped to
			int primitiveIndex = this.getPrimitiveIndex(index);

			E currentElement = this.data[primitiveIndex], nextElement;

			// Shift the elements after the specified index to the right
			for (int i = primitiveIndex; i != this.next; i = (i + 1) % this.capacity) {
				nextElement = this.data[(i + 1) % this.capacity];

				this.data[(i + 1) % this.capacity] = currentElement;

				currentElement = nextElement;
			}

			// Fill in the specified index with the given value
			this.data[primitiveIndex] = e;

			// Increment the index of the next available slot
			this.next = (this.next + 1) % this.capacity;
		}
	}

	/**
	 * Add an element to the beginning of the list.
	 *
	 * <br><br>
	 *
	 * If this method is called when the array is full, a resizing will be triggered
	 * (array size will double).
	 *
	 * <h5>Amortized running time over <code>n</code> calls to this method: <strong>O(1)</strong></h5>
	 *
	 * @param e - The element to be added to the list.
	 */
	public void addFirst(E e) {
		// If the slot after the next available slot is the front of the array,
		// then the array is full
		if ((this.next + 1) % this.capacity == this.front) {
			this.grow();
		}

		this.front = (this.front - 1) % this.capacity;

		// Correction for negative indexes
		if (this.front < 0) {
			this.front += this.capacity;
		}

		this.data[this.front] = e;
	}

	/**
	 * Add an element to the end of the list.
	 *
	 * <br><br>
	 *
	 * If this method is called when the array is full, a resizing will be triggered
	 * (array size will double).
	 *
	 * <h5>Amortized running time over <code>n</code> calls to this method: <strong>O(1)</strong></h5>
	 *
	 * @param e - The element to be added to the list.
	 */
	public void addLast(E e) {
		this.add(e);
	}

	/**
	 * Update the value of the element at the specified index to the new value.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @param e     - The new value of the element.
	 * @param index - The index of the element to be updated.
	 */
	public void set(E e, int index) {
		if (index < this.capacity - this.front) {
			this.data[this.front + index] = e;
		} else {
			this.data[index - (this.capacity - this.front)] = e;
		}
	}

	/**
	 * Get the element at the specified index.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @param index - The index of the element to be retrieved.
	 *
	 * @return The element at the specified index.
	 */
	public E get(int index) {
		if (index < 0 || index >= this.size()) {
			String message = "Invalid index: "
				+ "index must be between 0 and the list size ("
				+ this.size() + "),"
				+ " where it can be equal to 0 but not the list size.\n"
				+ " Provided index: " + index;

			throw new InvalidDynamicCircularArrayIndexException(message);
		}

		if (index < this.capacity - this.front) {
			return this.data[this.front + index];
		} else {
			return this.data[index - (this.capacity - this.front)];
		}
	}

	/**
	 * Get the first element of the list.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The first element of the list.
	 */
	public E getFirst() {
		return this.data[this.front];
	}

	/**
	 * Get the last element of the list.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The last element of the list.
	 */
	public E getLast() {
		// Correction for negative indexes
		if ((this.next - 1) % this.capacity < 0) {
			return this.data[(this.next - 1) % this.capacity + this.capacity];
		}

		return this.data[(this.next - 1) % this.capacity];
	}

	/**
	 * Get the size of the list.
	 *
	 * <h5>Running time: <strong>O(1)</strong></h5>
	 *
	 * @return The size of the list.
	 */
	public int size() {
		if (this.next == this.front) {
			/* Empty list */
			return 0;
		} else if (this.next > this.front) {
			/*
			 * Example:
			 *
			 * Let f = this.front and r = this.next
			 *
			 *    f     r
			 * | |a|b|c| |
			 *
			 * f = 1, r = 4
			 * size = r - f = 4 - 1 = 3
			 */
			return this.next - this.front;
		} else {
			/*
			 * Example:
			 *
			 * Let f = this.front, r = this.next, and n = this.capacity
			 *
			 *    r   f
			 * |c| | |a|b|
			 *
			 * f = 3, r = 1, n = 5
			 * size = n - f + r = 5 - 3 + 1 = 3
			 */
			return this.capacity - this.front + this.next;
		}
	}

	/**
	 * Returns the index of the element with the specified value in the list.
	 * If there are more than one elements with the specified value, the index
	 * of the first instance is returned.
	 * If not found, -1 is returned.
	 *
	 * <h5>Running time: <strong>O(n)</strong></h5>
	 *
	 * @param e - The value of the element to search for in the list.
	 *
	 * @return The index of the (first) element with the specified value in the
	 *         list (-1 if not found).
	 */
	public int indexOf(E e) {
		int primitiveIndex = this.front;
		int index = 0;

		while (primitiveIndex != this.next && !this.data[primitiveIndex].equals(e)) {
			primitiveIndex = (primitiveIndex + 1) % this.capacity;
			index++;
		}

		return primitiveIndex != this.next ? index : -1;
	}

	/**
	 * Returns whether or not an element with the specified value exists in the list.
	 *
	 * <h5>Running time: <strong>O(n)</strong></h5>
	 *
	 * @param e - The value of the element to search for in the list.
	 *
	 * @return True if an element with the specified value exists in the list,
	 *         false otherwise.
	 */
	public boolean contains(E e) {
		return this.indexOf(e) > -1;
	}

	/**
	 * Removes the element at the specified index.
	 *
	 * <h5>Running time: <strong>O(n)</strong></h5>
	 *
	 * @param index - The index at which to remove the element.
	 */
	public void remove(int index) {
		if (this.size() == 0) {
			String message = "Dynamic circular array is empty: "
				+ "cannot remove an element from an empty array.";

			throw new EmptyDynamicCircularArrayException(message);
		}

		// Get the index to be removed in the primitive array
		int current = this.getPrimitiveIndex(index);
		this.data[current] = null;

		if (index < this.size() / 2) {
			/*
			 * If the index of the element that was removed is less than the list size,
			 * then shift the elements to the right.
			 *
			 * Start at the removal index and move left, shifting each element
			 * to the right as they are traversed.
			 */
			while (current != this.front) {
				this.data[current] = this.data[(current - 1) % this.capacity];

				current = (current - 1) % this.capacity;

				// Correction for negative numbers
				if (current < 0) {
					current += this.capacity;
				}

			}

			// Move the front one slot to the right (since the elements were shifted to the right)
			this.front = (this.front + 1) % this.capacity;
		} else {
			/*
			 * If the index of the element that was removed is greater than (or equal to)
			 * the list size, then shift the elements to the left.
			 *
			 * Start at the removal index and move right, shifting each element
			 * to the left as they are traversed.
			 */
			while ((current + 1) % this.capacity != this.next) {
				this.data[current] = this.data[(current + 1) % this.capacity];

				current = (current + 1) % this.capacity;
			}

			// Move the next available slot one slot to the left (since the elements were shifted to the left)
			this.next = (this.next - 1) % this.capacity;

			// Correction for negative numbers
			if (this.next < 0) {
				this.next += this.capacity;
			}

			this.data[this.next] = null;
		}

		// If, after removal, the size of the array is less than a quarter of the capacity,
		// while still having at least the minimum size, then shrink the array (half its size).
		if (this.size() < this.capacity / 4 && this.size() >= this.MINIMUM_SIZE) {
			this.shrink();
		}
	}

	/**
	 * Removes the first element of the list.
	 *
	 * <h5>Amortized running time over <code>n</code> calls to this method: <strong>O(1)</strong></h5>
	 */
	public void removeFirst() {
		if (this.size() == 0) {
			String message = "Dynamic circular array is empty: "
				+ "cannot remove an element from an empty array.";

			throw new EmptyDynamicCircularArrayException(message);
		}

		this.data[this.front] = null;
		this.front = (this.front + 1) % this.capacity;

		// If, after removal, the size of the array is less than a quarter of the capacity,
		// while still having at least the minimum size, then shrink the array (half its size).
		if (this.size() < this.capacity / 4 && this.size() >= this.MINIMUM_SIZE) {
			this.shrink();
		}
	}

	/**
	 * Removes the last element of the list.
	 *
	 * <h5>Amortized running time over <code>n</code> calls to this method: <strong>O(1)</strong></h5>
	 */
	public void removeLast() {
		if (this.size() == 0) {
			if (this.size() == 0) {
				String message = "Dynamic circular array is empty: "
					+ "cannot remove an element from an empty array.";

				throw new EmptyDynamicCircularArrayException(message);
			}
		}

		this.next = (this.next - 1) % this.capacity;

		// Correction for negative indexes
		if (this.next < 0) {
			this.next += this.capacity;
		}

		this.data[this.next] = null;

		// If, after removal, the size of the array is less than a quarter of the capacity,
		// while still having at least the minimum size, then shrink the array (half its size).
		if (this.size() < this.capacity / 4 && this.size() >= this.MINIMUM_SIZE) {
			this.shrink();
		}
	}

	/**
	 * Removes all elements from the list.
	 *
	 * <h5>Running time: O(1)</h5>
	 */
	@SuppressWarnings("unchecked")
	public void clear() {
		this.capacity = this.MINIMUM_SIZE;
		this.data = (E[]) new Object[this.capacity];
		this.front = 0;
		this.next = 0;
	}

}
