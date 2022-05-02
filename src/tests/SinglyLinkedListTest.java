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

	@Test
	void testSetting() {
		SinglyLinkedList<Double> sll = new SinglyLinkedList<Double>();

		assertEquals(0, sll.size());

		sll.add(1.0);
		sll.add(2.0);
		sll.add(3.0);

		assertEquals(1.0, sll.get(0));
		assertEquals(2.0, sll.get(1));
		assertEquals(3.0, sll.get(2));
		assertEquals(3, sll.size());

		sll.set(4.0, 0);
		sll.set(5.0, 1);
		sll.set(6.0, 2);

		assertEquals(4.0, sll.get(0));
		assertEquals(5.0, sll.get(1));
		assertEquals(6.0, sll.get(2));
		assertEquals(3, sll.size());

		sll.removeFirst();

		assertEquals(5.0, sll.get(0));
		assertEquals(6.0, sll.get(1));
		assertEquals(2, sll.size());

		sll.removeLast();

		assertEquals(5.0, sll.get(0));
		assertEquals(1, sll.size());

		sll.remove(0);

		assertEquals(0, sll.size());
	}

	@Test
	void testSearching() {
		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();

		assertEquals(0, sll.size());

		sll.add("2");
		sll.add("3");
		sll.add("4");
		sll.set("wildcard", sll.size() - 1);
		sll.add("1", 0);
		sll.add("5", sll.size());

		assertEquals("1", sll.get(0));
		assertEquals("2", sll.get(1));
		assertEquals("3", sll.get(2));
		assertEquals("wildcard", sll.get(3));
		assertEquals("5", sll.get(4));
		assertEquals(5, sll.size());

		assertTrue(sll.contains("1"));
		assertTrue(sll.contains("2"));
		assertTrue(sll.contains("3"));
		assertFalse(sll.contains("4"));
		assertTrue(sll.contains("wildcard"));
		assertTrue(sll.contains("5"));

		assertEquals(0, sll.indexOf("1"));
		assertEquals(1, sll.indexOf("2"));
		assertEquals(2, sll.indexOf("3"));
		assertEquals(-1, sll.indexOf("4"));
		assertEquals(3, sll.indexOf("wildcard"));
		assertEquals(4, sll.indexOf("5"));

		sll.remove(sll.size() - 1);
		sll.set("4", sll.indexOf("wildcard"));

		assertEquals("1", sll.get(0));
		assertEquals("2", sll.get(1));
		assertEquals("3", sll.get(2));
		assertEquals("4", sll.get(3));
		assertEquals(4, sll.size());

		assertTrue(sll.contains("1"));
		assertTrue(sll.contains("2"));
		assertTrue(sll.contains("3"));
		assertTrue(sll.contains("4"));
		assertFalse(sll.contains("wildcard"));
		assertFalse(sll.contains("5"));

		assertEquals(0, sll.indexOf("1"));
		assertEquals(1, sll.indexOf("2"));
		assertEquals(2, sll.indexOf("3"));
		assertEquals(3, sll.indexOf("4"));
		assertEquals(-1, sll.indexOf("wildcard"));
		assertEquals(-1, sll.indexOf("5"));

		sll.remove(0);

		assertEquals("2", sll.get(0));
		assertEquals("3", sll.get(1));
		assertEquals("4", sll.get(2));
		assertEquals(3, sll.size());

		assertFalse(sll.contains("1"));
		assertTrue(sll.contains("2"));
		assertTrue(sll.contains("3"));
		assertTrue(sll.contains("4"));
		assertFalse(sll.contains("wildcard"));
		assertFalse(sll.contains("5"));

		assertEquals(-1, sll.indexOf("1"));
		assertEquals(0, sll.indexOf("2"));
		assertEquals(1, sll.indexOf("3"));
		assertEquals(2, sll.indexOf("4"));
		assertEquals(-1, sll.indexOf("wildcard"));
		assertEquals(-1, sll.indexOf("5"));

		sll.clear();

		assertEquals(0, sll.size());

		assertFalse(sll.contains("1"));
		assertFalse(sll.contains("2"));
		assertFalse(sll.contains("3"));
		assertFalse(sll.contains("4"));
		assertFalse(sll.contains("wildcard"));
		assertFalse(sll.contains("5"));

		assertEquals(-1, sll.indexOf("1"));
		assertEquals(-1, sll.indexOf("2"));
		assertEquals(-1, sll.indexOf("3"));
		assertEquals(-1, sll.indexOf("4"));
		assertEquals(-1, sll.indexOf("wildcard"));
		assertEquals(-1, sll.indexOf("5"));
	}

}
