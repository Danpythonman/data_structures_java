package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dynamic_circular_array.DynamicCircularArray;

class DynamicCircularArrayTest {

	@Test
	void testAppending() {
		DynamicCircularArray<Integer> arr = new DynamicCircularArray<Integer>(1);

		assertEquals(0, arr.size());

		// First resizing
		arr.add(1);

		assertEquals(1, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(1, arr.getFirst());
		assertEquals(1, arr.getLast());

		// Second resizing
		arr.add(2);

		assertEquals(2, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(1, arr.getFirst());
		assertEquals(2, arr.getLast());

		arr.add(3);

		assertEquals(3, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(1, arr.getFirst());
		assertEquals(3, arr.getLast());

		// Third resizing
		arr.add(4);

		assertEquals(4, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));
		assertEquals(1, arr.getFirst());
		assertEquals(4, arr.getLast());

		arr.add(5);

		assertEquals(5, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));
		assertEquals(5, arr.get(4));
		assertEquals(1, arr.getFirst());
		assertEquals(5, arr.getLast());
	}

	@Test
	void testInserting() {
		DynamicCircularArray<Double> arr = new DynamicCircularArray<Double>(1);

		assertEquals(0, arr.size());

		// First resizing
		arr.add(2.0, 0);

		assertEquals(1, arr.size());
		assertEquals(2.0, arr.get(0));
		assertEquals(2.0, arr.getFirst());
		assertEquals(2.0, arr.getLast());

		// Second resizing
		arr.add(1.0, 0);

		assertEquals(2, arr.size());
		assertEquals(1.0, arr.get(0));
		assertEquals(2.0, arr.get(1));
		assertEquals(1.0, arr.getFirst());
		assertEquals(2.0, arr.getLast());

		arr.add(5.0, arr.size());

		assertEquals(3, arr.size());
		assertEquals(1.0, arr.get(0));
		assertEquals(2.0, arr.get(1));
		assertEquals(5.0, arr.get(2));
		assertEquals(1.0, arr.getFirst());
		assertEquals(5.0, arr.getLast());

		// Third resizing
		arr.add(4.0, arr.size() - 1);

		assertEquals(4, arr.size());
		assertEquals(1.0, arr.get(0));
		assertEquals(2.0, arr.get(1));
		assertEquals(4.0, arr.get(2));
		assertEquals(5.0, arr.get(3));
		assertEquals(1.0, arr.getFirst());
		assertEquals(5.0, arr.getLast());

		arr.add(3.0, 2);

		assertEquals(5, arr.size());
		assertEquals(1.0, arr.get(0));
		assertEquals(2.0, arr.get(1));
		assertEquals(3.0, arr.get(2));
		assertEquals(4.0, arr.get(3));
		assertEquals(5.0, arr.get(4));
		assertEquals(1.0, arr.getFirst());
		assertEquals(5.0, arr.getLast());
	}

	@Test
	void testSetting() {
		DynamicCircularArray<String> arr = new DynamicCircularArray<String>(1);

		assertEquals(0, arr.size());

		// First resizing
		arr.add("a", 0);

		assertEquals(1, arr.size());
		assertEquals("a", arr.get(0));
		assertEquals("a", arr.getFirst());
		assertEquals("a", arr.getLast());

		arr.set("1", 0);

		assertEquals(1, arr.size());
		assertEquals("1", arr.get(0));
		assertEquals("1", arr.getFirst());
		assertEquals("1", arr.getLast());

		// Second resizing
		arr.add("c");

		assertEquals(2, arr.size());
		assertEquals("1", arr.get(0));
		assertEquals("c", arr.get(1));
		assertEquals("1", arr.getFirst());
		assertEquals("c", arr.getLast());

		arr.add("b", 1);

		assertEquals(3, arr.size());
		assertEquals("1", arr.get(0));
		assertEquals("b", arr.get(1));
		assertEquals("c", arr.get(2));
		assertEquals("1", arr.getFirst());
		assertEquals("c", arr.getLast());

		arr.set("2", 1);

		assertEquals(3, arr.size());
		assertEquals("1", arr.get(0));
		assertEquals("2", arr.get(1));
		assertEquals("c", arr.get(2));
		assertEquals("1", arr.getFirst());
		assertEquals("c", arr.getLast());

		arr.set("3", 2);

		assertEquals(3, arr.size());
		assertEquals("1", arr.get(0));
		assertEquals("2", arr.get(1));
		assertEquals("3", arr.get(2));
		assertEquals("1", arr.getFirst());
		assertEquals("3", arr.getLast());
	}

	@Test
	void testIndexOfAndContains() {
		DynamicCircularArray<Integer> arr = new DynamicCircularArray<Integer>(1);

		arr.add(1);

		arr.add(2);

		arr.removeFirst();

		arr.add(3);

		// Third expanding
		arr.add(4);
		arr.add(5);

		/*
		 * Array:
		 *
		 * | |2|3|4|5| | | |
		 */

		assertEquals(4, arr.size());
		assertEquals(2, arr.get(0));
		assertEquals(3, arr.get(1));
		assertEquals(4, arr.get(2));
		assertEquals(5, arr.get(3));
		assertEquals(2, arr.getFirst());
		assertEquals(5, arr.getLast());

		assertEquals(0, arr.indexOf(2));
		assertEquals(1, arr.indexOf(3));
		assertEquals(2, arr.indexOf(4));
		assertEquals(3, arr.indexOf(5));
		assertEquals(-1, arr.indexOf(6));

		assertTrue(arr.contains(2));
		assertTrue(arr.contains(3));
		assertTrue(arr.contains(4));
		assertTrue(arr.contains(5));
		assertFalse(arr.contains(6));
	}

	@Test
	void testRemoval() {
		DynamicCircularArray<Integer> arr = new DynamicCircularArray<Integer>(1);

		// First expanding
		arr.add(1);
		// Second expanding
		arr.add(2);
		arr.add(3);
		// Third expanding
		arr.add(4);
		arr.add(5);

		assertEquals(5, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));
		assertEquals(5, arr.get(4));
		assertEquals(1, arr.getFirst());
		assertEquals(5, arr.getLast());

		arr.remove(1);

		assertEquals(4, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(3, arr.get(1));
		assertEquals(4, arr.get(2));
		assertEquals(5, arr.get(3));
		assertEquals(1, arr.getFirst());
		assertEquals(5, arr.getLast());

		arr.add(2, 1);

		assertEquals(5, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));
		assertEquals(5, arr.get(4));
		assertEquals(1, arr.getFirst());
		assertEquals(5, arr.getLast());

		arr.remove(3);

		assertEquals(4, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(5, arr.get(3));
		assertEquals(1, arr.getFirst());
		assertEquals(5, arr.getLast());

		arr.remove(0);

		assertEquals(3, arr.size());
		assertEquals(2, arr.get(0));
		assertEquals(3, arr.get(1));
		assertEquals(5, arr.get(2));
		assertEquals(2, arr.getFirst());
		assertEquals(5, arr.getLast());

		arr.remove(arr.size() - 1);

		assertEquals(2, arr.size());
		assertEquals(2, arr.get(0));
		assertEquals(3, arr.get(1));
		assertEquals(2, arr.getFirst());
		assertEquals(3, arr.getLast());

		arr.remove(1);

		assertEquals(1, arr.size());
		assertEquals(2, arr.get(0));
		assertEquals(2, arr.getFirst());
		assertEquals(2, arr.getLast());

		arr.remove(0);

		assertEquals(0, arr.size());

		// First resizing
		arr.add(1);

		assertEquals(1, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(1, arr.getFirst());
		assertEquals(1, arr.getLast());

		// Second resizing
		arr.add(2);

		assertEquals(2, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(1, arr.getFirst());
		assertEquals(2, arr.getLast());

		arr.add(3);

		assertEquals(3, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(1, arr.getFirst());
		assertEquals(3, arr.getLast());

		// Third resizing
		arr.add(4);

		assertEquals(4, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));
		assertEquals(1, arr.getFirst());
		assertEquals(4, arr.getLast());

		arr.add(5);

		assertEquals(5, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));
		assertEquals(5, arr.get(4));
		assertEquals(1, arr.getFirst());
		assertEquals(5, arr.getLast());
	}

	@Test
	void testComplexRemoval() {
		DynamicCircularArray<Integer> arr = new DynamicCircularArray<Integer>(1);

		// First expanding
		arr.add(1);

		// Second expanding
		arr.add(2);

		/*
		 * Array:
		 *
		 * |1|2| | |
		 */

		arr.removeFirst();

		/*
		 * Array:
		 *
		 * | |2| | |
		 */

		arr.add(3);

		// Third expanding
		arr.add(4);
		arr.add(5);

		/*
		 * Array:
		 *
		 * | |2|3|4|5| | | |
		 */

		assertEquals(4, arr.size());
		assertEquals(2, arr.get(0));
		assertEquals(3, arr.get(1));
		assertEquals(4, arr.get(2));
		assertEquals(5, arr.get(3));
		assertEquals(2, arr.getFirst());
		assertEquals(5, arr.getLast());
	}

	@Test
	void testRemovalShrink() {
		// DEBUG THIS TEST TO TEST FOR ARRAY SHRINKING

		DynamicCircularArray<Integer> arr = new DynamicCircularArray<Integer>(50);

		for (int i = 1; i <= 12; i++) {
			arr.add(i);
		}

		// This will resize the array because 11 elements is less than a quarter
		// of the capacity (which is 50 elements).
		arr.removeLast();

		assertEquals(11, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));
		assertEquals(5, arr.get(4));
		assertEquals(6, arr.get(5));
		assertEquals(7, arr.get(6));
		assertEquals(8, arr.get(7));
		assertEquals(9, arr.get(8));
		assertEquals(10, arr.get(9));
		assertEquals(11, arr.get(10));
		assertEquals(1, arr.getFirst());
		assertEquals(11, arr.getLast());
	}

	@Test
	void testFrontRemovalShrink() {
		// DEBUG THIS TEST TO TEST FOR ARRAY SHRINKING

		DynamicCircularArray<Integer> arr = new DynamicCircularArray<Integer>(50);

		for (int i = 1; i <= 12; i++) {
			arr.add(i);
		}

		// This will resize the array because 11 elements is less than a quarter
		// of the capacity (which is 50 elements).
		arr.removeFirst();

		assertEquals(11, arr.size());
		assertEquals(2, arr.get(0));
		assertEquals(3, arr.get(1));
		assertEquals(4, arr.get(2));
		assertEquals(5, arr.get(3));
		assertEquals(6, arr.get(4));
		assertEquals(7, arr.get(5));
		assertEquals(8, arr.get(6));
		assertEquals(9, arr.get(7));
		assertEquals(10, arr.get(8));
		assertEquals(11, arr.get(9));
		assertEquals(12, arr.get(10));
		assertEquals(2, arr.getFirst());
		assertEquals(12, arr.getLast());
	}

	@Test
	void testComplexRemovalShrink() {
		// DEBUG THIS TEST TO TEST FOR ARRAY SHRINKING

		DynamicCircularArray<Integer> arr = new DynamicCircularArray<Integer>(50);

		for (int i = 1; i <= 9; i++) {
			arr.add(1);
		}

		for (int i = 1; i <= 8; i++) {
			arr.removeFirst();
		}

		assertEquals(1, arr.size());
		assertEquals(1, arr.get(0));

		for (int i = 2; i <= 12; i++) {
			arr.add(i);
		}

		// This will resize the array because 11 elements is less than a quarter
		// of the capacity (which is 50 elements).
		arr.remove(5);

		assertEquals(11, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));
		assertEquals(5, arr.get(4));
		assertEquals(7, arr.get(5));
		assertEquals(8, arr.get(6));
		assertEquals(9, arr.get(7));
		assertEquals(10, arr.get(8));
		assertEquals(11, arr.get(9));
		assertEquals(12, arr.get(10));
		assertEquals(1, arr.getFirst());
		assertEquals(12, arr.getLast());
	}

	@Test
	void testClear() {
		DynamicCircularArray<Integer> arr = new DynamicCircularArray<Integer>(1);

		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);

		assertEquals(5, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));
		assertEquals(5, arr.get(4));
		assertEquals(1, arr.getFirst());
		assertEquals(5, arr.getLast());

		arr.clear();

		assertEquals(0, arr.size());

		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.removeFirst();
		arr.remove(2);
		arr.removeLast();

		assertEquals(2, arr.size());
		assertEquals(2, arr.get(0));
		assertEquals(3, arr.get(1));
		assertEquals(2, arr.getFirst());
		assertEquals(3, arr.getLast());
	}

}
