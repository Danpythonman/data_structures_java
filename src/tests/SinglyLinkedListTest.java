package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import linked_list.SinglyLinkedList;

class SinglyLinkedListTest {

	@Test
	void testAddingAndDeleting() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();

		assertEquals(0, sll.size());

		sll.add(1);
		sll.add(2);

		assertEquals(1, sll.getFirst());
		assertEquals(2, sll.getLast());

		assertEquals(1, sll.get(0));
		assertEquals(2, sll.get(1));

		assertEquals(2, sll.size());

		sll.clear();

		assertEquals(0, sll.size());

		sll.add(1);
		sll.add(2);
		sll.add(3);

		assertEquals(1, sll.get(0));
		assertEquals(2, sll.get(1));
		assertEquals(3, sll.get(2));
		assertEquals(3, sll.size());

		sll.removeFirst();

		assertEquals(2, sll.get(0));
		assertEquals(3, sll.get(1));
		assertEquals(2, sll.size());

		sll.removeLast();

		assertEquals(2, sll.get(0));
		assertEquals(1, sll.size());

		sll.addFirst(1);

		assertEquals(1, sll.get(0));
		assertEquals(2, sll.get(1));
		assertEquals(2, sll.size());

		sll.addLast(3);

		assertEquals(1, sll.get(0));
		assertEquals(2, sll.get(1));
		assertEquals(3, sll.get(2));
		assertEquals(3, sll.size());

		sll.remove(1);

		assertEquals(1, sll.get(0));
		assertEquals(3, sll.get(1));
		assertEquals(2, sll.size());

		sll.remove(0);
		sll.remove(0);

		assertEquals(0, sll.size());
	}

}
