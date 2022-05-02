package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import linked_list.DoublyLinkedList;

class DoublyLinkedListTest {

	@Test
	void testAddingAndDeleting() {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();

		assertEquals(0, dll.size());

		dll.add(1);
		dll.add(2);

		assertEquals(1, dll.getFirst());
		assertEquals(2, dll.getLast());

		assertEquals(1, dll.get(0));
		assertEquals(2, dll.get(1));

		assertEquals(2, dll.size());

		dll.clear();

		assertEquals(0, dll.size());

		dll.add(1);
		dll.add(2);
		dll.add(3);

		assertEquals(1, dll.get(0));
		assertEquals(2, dll.get(1));
		assertEquals(3, dll.get(2));
		assertEquals(3, dll.size());

		dll.removeFirst();

		assertEquals(2, dll.get(0));
		assertEquals(3, dll.get(1));
		assertEquals(2, dll.size());

		dll.removeLast();

		assertEquals(2, dll.get(0));
		assertEquals(1, dll.size());

		dll.addFirst(1);

		assertEquals(1, dll.get(0));
		assertEquals(2, dll.get(1));
		assertEquals(2, dll.size());

		dll.addLast(3);

		assertEquals(1, dll.get(0));
		assertEquals(2, dll.get(1));
		assertEquals(3, dll.get(2));
		assertEquals(3, dll.size());

		dll.remove(1);

		assertEquals(1, dll.get(0));
		assertEquals(3, dll.get(1));
		assertEquals(2, dll.size());

		dll.remove(0);
		dll.remove(0);

		assertEquals(0, dll.size());
	}

	@Test
	void testSetting() {
		DoublyLinkedList<Double> dll = new DoublyLinkedList<Double>();

		assertEquals(0, dll.size());

		dll.add(1.0);
		dll.add(2.0);
		dll.add(3.0);

		assertEquals(1.0, dll.get(0));
		assertEquals(2.0, dll.get(1));
		assertEquals(3.0, dll.get(2));
		assertEquals(3, dll.size());

		dll.set(4.0, 0);
		dll.set(5.0, 1);
		dll.set(6.0, 2);

		assertEquals(4.0, dll.get(0));
		assertEquals(5.0, dll.get(1));
		assertEquals(6.0, dll.get(2));
		assertEquals(3, dll.size());

		dll.removeFirst();

		assertEquals(5.0, dll.get(0));
		assertEquals(6.0, dll.get(1));
		assertEquals(2, dll.size());

		dll.removeLast();

		assertEquals(5.0, dll.get(0));
		assertEquals(1, dll.size());

		dll.remove(0);

		assertEquals(0, dll.size());
	}

	@Test
	void testSearching() {
		DoublyLinkedList<String> dll = new DoublyLinkedList<String>();

		assertEquals(0, dll.size());

		dll.add("2");
		dll.add("3");
		dll.add("4");
		dll.set("wildcard", dll.size() - 1);
		dll.add("1", 0);
		dll.add("5", dll.size());

		assertEquals("1", dll.get(0));
		assertEquals("2", dll.get(1));
		assertEquals("3", dll.get(2));
		assertEquals("wildcard", dll.get(3));
		assertEquals("5", dll.get(4));
		assertEquals(5, dll.size());

		assertTrue(dll.contains("1"));
		assertTrue(dll.contains("2"));
		assertTrue(dll.contains("3"));
		assertFalse(dll.contains("4"));
		assertTrue(dll.contains("wildcard"));
		assertTrue(dll.contains("5"));

		assertEquals(0, dll.indexOf("1"));
		assertEquals(1, dll.indexOf("2"));
		assertEquals(2, dll.indexOf("3"));
		assertEquals(-1, dll.indexOf("4"));
		assertEquals(3, dll.indexOf("wildcard"));
		assertEquals(4, dll.indexOf("5"));

		dll.remove(dll.size() - 1);
		dll.set("4", dll.indexOf("wildcard"));

		assertEquals("1", dll.get(0));
		assertEquals("2", dll.get(1));
		assertEquals("3", dll.get(2));
		assertEquals("4", dll.get(3));
		assertEquals(4, dll.size());

		assertTrue(dll.contains("1"));
		assertTrue(dll.contains("2"));
		assertTrue(dll.contains("3"));
		assertTrue(dll.contains("4"));
		assertFalse(dll.contains("wildcard"));
		assertFalse(dll.contains("5"));

		assertEquals(0, dll.indexOf("1"));
		assertEquals(1, dll.indexOf("2"));
		assertEquals(2, dll.indexOf("3"));
		assertEquals(3, dll.indexOf("4"));
		assertEquals(-1, dll.indexOf("wildcard"));
		assertEquals(-1, dll.indexOf("5"));

		dll.remove(0);

		assertEquals("2", dll.get(0));
		assertEquals("3", dll.get(1));
		assertEquals("4", dll.get(2));
		assertEquals(3, dll.size());

		assertFalse(dll.contains("1"));
		assertTrue(dll.contains("2"));
		assertTrue(dll.contains("3"));
		assertTrue(dll.contains("4"));
		assertFalse(dll.contains("wildcard"));
		assertFalse(dll.contains("5"));

		assertEquals(-1, dll.indexOf("1"));
		assertEquals(0, dll.indexOf("2"));
		assertEquals(1, dll.indexOf("3"));
		assertEquals(2, dll.indexOf("4"));
		assertEquals(-1, dll.indexOf("wildcard"));
		assertEquals(-1, dll.indexOf("5"));

		dll.clear();

		assertEquals(0, dll.size());

		assertFalse(dll.contains("1"));
		assertFalse(dll.contains("2"));
		assertFalse(dll.contains("3"));
		assertFalse(dll.contains("4"));
		assertFalse(dll.contains("wildcard"));
		assertFalse(dll.contains("5"));

		assertEquals(-1, dll.indexOf("1"));
		assertEquals(-1, dll.indexOf("2"));
		assertEquals(-1, dll.indexOf("3"));
		assertEquals(-1, dll.indexOf("4"));
		assertEquals(-1, dll.indexOf("wildcard"));
		assertEquals(-1, dll.indexOf("5"));
	}

}
