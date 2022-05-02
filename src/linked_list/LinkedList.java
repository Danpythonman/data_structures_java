package linked_list;

public interface LinkedList<E> {

	public void add(E e);
	public void add(E e, int index);
	public void addFirst(E e);
	public void addLast(E e);

	public void set(E e, int index);

	public E get(int index);
	public E getFirst();
	public E getLast();

	public int size();

	public int indexOf(E e);
	public boolean contains(E e);

	public void remove(int index);
	public void removeFirst();
	public void removeLast();
	public void clear();

}
