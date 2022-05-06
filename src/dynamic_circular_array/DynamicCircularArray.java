package dynamic_circular_array;

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
			throw new IllegalArgumentException("Initial array size must be at least 1");
		}

		this.capacity = size;
		this.data = (E[]) new Object[this.capacity];
		this.front = 0;
		this.next = 0;
	}

	/**
	 * Doubles the size of the data array.
	 * Note that no matter where the front and next available slot indexes are located,
	 * after resizing the front will be 0 and the next available slot will be the
	 * original capacity - 1.
	 * (This means that, after resizing, all the elements in the array will
	 * occupy the first half of the array.)
	 */
	@SuppressWarnings("unchecked")
	private void resize() {
		E[] newData = (E[]) new Object[this.capacity * 2];

		// Add the elements from the front of the circular array to the element
		// at the capacity limit (the last element of the primitive array).
		for (int i = this.front; i < this.capacity; i++) {
			newData[i] = this.data[i];
		}

		if (this.next < this.front) {
			/*
			 * If there are elements at the beginning of the array before
			 * the front of the circular array, we add them here.
			 *
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
			 * Note that first we add the elements from the front to the capacity,
			 * which are a, b, and c, to the resized array, then we add the
			 * remaining elements that would be at the beginning of the array,
			 * which is just d in this case.
			 */
			for (int i = 0; i < this.next; i++) {
				newData[i] = this.data[i];
			}
		}

		// After the resizing, all the elements will in the first half of the resized array
		this.data = newData;
		this.front = 0;
		this.next = this.capacity - 1;
		this.capacity *= 2;
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
			throw new IllegalArgumentException("Invalid index - Index must be between 0 and the list size (inclusive).");
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
		// If the next available slot is the front of the array, then the array is full.
		if ((this.next + 1) % this.capacity == this.front) {
			this.resize();
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
	 * <h5>Amortized running time over <code>n</code> calls to this method: <strong>O(1)</strong></h5>
	 *
	 * @param e     - The element to be added to the list.
	 * @param index - The index at which to add the new element.
	 */
	public void add(E e, int index) {
		// If the next available slot is the front of the array, then the array is full.
		if ((this.next + 1) % this.capacity == this.front) {
			this.resize();
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
		// If the next available slot is the front of the array, then the array is full.
		if ((this.next + 1) % this.capacity == this.front) {
			this.resize();
		}

		this.front = (this.front - 1) % this.capacity;
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
		// If the next available slot is the front of the array, then the array is full.
		if ((this.next + 1) % this.capacity == this.front) {
			this.resize();
		}

		this.add(e);
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
			throw new IllegalArgumentException("Invalid index - Index must be between 0 and the list size (inclusive).");
		}

		if (index < this.capacity - this.front) {
			return this.data[this.front + index];
		} else {
			return this.data[index - (this.capacity - this.front)];
		}
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
			return 0;
		} else if (this.next > this.front) {
			return this.next - this.front;
		} else {
			return this.capacity - this.front + this.next;
		}
	}

}
