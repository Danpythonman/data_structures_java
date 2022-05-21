package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import queue.ArrayQueue;
import queue.Queue;

class ArrayQueueTest {

	@Test
	void testConstruction() {
		Queue<Integer> emptyQueue = new ArrayQueue<Integer>();

		assertTrue(emptyQueue.isEmpty());
		assertEquals(0, emptyQueue.size());

		Queue<Integer> oneItemQueue = new ArrayQueue<Integer>(1);

		assertFalse(oneItemQueue.isEmpty());
		assertEquals(1, oneItemQueue.size());
		assertEquals(1, oneItemQueue.first());
		assertEquals(1, oneItemQueue.dequeue());
	}

	@Test
	void testQueueEnqueueFirstDequeue() {
		Queue<String> queue = new ArrayQueue<String>("1");

		assertFalse(queue.isEmpty());
		assertEquals(1, queue.size());
		assertEquals("1", queue.first());

		queue.enqueue("2");

		assertFalse(queue.isEmpty());
		assertEquals(2, queue.size());
		assertEquals("1", queue.first());

		queue.enqueue("3");

		assertFalse(queue.isEmpty());
		assertEquals(3, queue.size());
		assertEquals("1", queue.first());

		assertEquals("1", queue.dequeue());

		assertEquals(2, queue.size());
		assertEquals("2", queue.first());

		assertEquals("2", queue.dequeue());

		assertEquals(1, queue.size());
		assertEquals("3", queue.first());

		assertEquals("3", queue.dequeue());

		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());

		queue.enqueue("a");

		assertEquals(1, queue.size());
		assertEquals("a", queue.first());

		queue.enqueue("b");

		assertEquals(2, queue.size());
		assertEquals("a", queue.first());

		queue.enqueue("c");

		assertEquals(3, queue.size());
		assertEquals("a", queue.first());

		assertEquals("a", queue.dequeue());

		assertEquals(2, queue.size());
		assertEquals("b", queue.first());

		assertEquals("b", queue.dequeue());

		assertEquals(1, queue.size());
		assertEquals("c", queue.first());

		assertEquals("c", queue.dequeue());

		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());
	}

}
