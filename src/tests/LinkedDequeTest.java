package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import deque.LinkedDeque;
import deque.Deque;

class LinkedDequeTest {

	@Test
	void testConstruction() {
		Deque<Integer> emptyDeque= new LinkedDeque<Integer>();

		assertTrue(emptyDeque.isEmpty());
		assertEquals(0, emptyDeque.size());

		Deque<Integer> oneItemDeque = new LinkedDeque<Integer>(1);

		assertFalse(oneItemDeque.isEmpty());
		assertEquals(1, oneItemDeque.size());
		assertEquals(1, oneItemDeque.first());
		assertEquals(1, oneItemDeque.last());
	}

	@Test
	void testDequeOperations() {
		Deque<String> deque = new LinkedDeque<String>("2");

		assertFalse(deque.isEmpty());
		assertEquals(1, deque.size());
		assertEquals("2", deque.first());
		assertEquals("2", deque.last());

		deque.addFirst("1");

		assertFalse(deque.isEmpty());
		assertEquals(2, deque.size());
		assertEquals("1", deque.first());
		assertEquals("2", deque.last());

		deque.addLast("3");

		assertFalse(deque.isEmpty());
		assertEquals(3, deque.size());
		assertEquals("1", deque.first());
		assertEquals("3", deque.last());

		assertEquals("1", deque.removeFirst());

		assertEquals(2, deque.size());
		assertEquals("2", deque.first());
		assertEquals("3", deque.last());

		assertEquals("3", deque.removeLast());

		assertEquals(1, deque.size());
		assertEquals("2", deque.first());
		assertEquals("2", deque.last());

		assertEquals("2", deque.removeFirst());

		assertTrue(deque.isEmpty());
		assertEquals(0, deque.size());

		deque.addLast("b");

		assertEquals(1, deque.size());
		assertEquals("b", deque.first());
		assertEquals("b", deque.last());

		deque.addLast("c");

		assertEquals(2, deque.size());
		assertEquals("b", deque.first());
		assertEquals("c", deque.last());

		deque.addFirst("a");

		assertEquals(3, deque.size());
		assertEquals("a", deque.first());
		assertEquals("c", deque.last());

		assertEquals("c", deque.removeLast());

		assertEquals(2, deque.size());
		assertEquals("a", deque.first());
		assertEquals("b", deque.last());

		assertEquals("a", deque.removeFirst());

		assertEquals(1, deque.size());
		assertEquals("b", deque.first());
		assertEquals("b", deque.last());

		assertEquals("b", deque.removeLast());

		assertTrue(deque.isEmpty());
		assertEquals(0, deque.size());

		deque.addFirst("A");

		assertEquals(1, deque.size());
		assertEquals("A", deque.first());
		assertEquals("A", deque.last());

		assertEquals("A", deque.removeLast());

		assertTrue(deque.isEmpty());
		assertEquals(0, deque.size());
	}

}
