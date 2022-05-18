package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stack.Stack;
import stack.LinkedStack;

class LinkedStackTest {

	@Test
	void testConstruction() {
		Stack<Integer> emptyStack = new LinkedStack<Integer>();

		assertTrue(emptyStack.isEmpty());
		assertEquals(0, emptyStack.size());

		Stack<Integer> oneItemStack = new LinkedStack<Integer>(1);

		assertFalse(oneItemStack.isEmpty());
		assertEquals(1, oneItemStack.size());
		assertEquals(1, oneItemStack.top());
		assertEquals(1, oneItemStack.pop());
	}

	@Test
	void testStackPushTopPop() {
		Stack<String> stack = new LinkedStack<String>("1");

		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
		assertEquals("1", stack.top());

		stack.push("2");

		assertFalse(stack.isEmpty());
		assertEquals(2, stack.size());
		assertEquals("2", stack.top());

		stack.push("3");

		assertFalse(stack.isEmpty());
		assertEquals(3, stack.size());
		assertEquals("3", stack.top());

		assertEquals("3", stack.pop());

		assertFalse(stack.isEmpty());
		assertEquals(2, stack.size());
		assertEquals("2", stack.top());

		assertEquals("2", stack.pop());

		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
		assertEquals("1", stack.top());

		assertEquals("1", stack.pop());

		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());

		stack.push("a");

		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
		assertEquals("a", stack.top());

		stack.push("b");

		assertFalse(stack.isEmpty());
		assertEquals(2, stack.size());
		assertEquals("b", stack.top());

		assertEquals("b", stack.pop());

		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
		assertEquals("a", stack.top());

		assertEquals("a", stack.pop());

		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

}
