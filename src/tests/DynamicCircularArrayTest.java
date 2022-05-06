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

		// Second resizing
		arr.add(2);

		assertEquals(2, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));

		arr.add(3);

		assertEquals(3, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));

		// Third resizing
		arr.add(4);

		assertEquals(4, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));

		arr.add(5);

		assertEquals(5, arr.size());
		assertEquals(1, arr.get(0));
		assertEquals(2, arr.get(1));
		assertEquals(3, arr.get(2));
		assertEquals(4, arr.get(3));
		assertEquals(5, arr.get(4));
	}

	@Test
	void testInserting() {
		DynamicCircularArray<Double> arr = new DynamicCircularArray<Double>(1);

		assertEquals(0, arr.size());

		// First resizing
		arr.add(2.0, 0);

		assertEquals(1, arr.size());
		assertEquals(2.0, arr.get(0));

		// Second resizing
		arr.add(1.0, 0);

		assertEquals(2, arr.size());
		assertEquals(1.0, arr.get(0));
		assertEquals(2.0, arr.get(1));

		arr.add(5.0, arr.size());

		assertEquals(3, arr.size());
		assertEquals(1.0, arr.get(0));
		assertEquals(2.0, arr.get(1));
		assertEquals(5.0, arr.get(2));

		// Third resizing
		arr.add(4.0, arr.size() - 1);

		assertEquals(4, arr.size());
		assertEquals(1.0, arr.get(0));
		assertEquals(2.0, arr.get(1));
		assertEquals(4.0, arr.get(2));
		assertEquals(5.0, arr.get(3));

		arr.add(3.0, 2);

		assertEquals(5, arr.size());
		assertEquals(1.0, arr.get(0));
		assertEquals(2.0, arr.get(1));
		assertEquals(3.0, arr.get(2));
		assertEquals(4.0, arr.get(3));
		assertEquals(5.0, arr.get(4));
	}

}
