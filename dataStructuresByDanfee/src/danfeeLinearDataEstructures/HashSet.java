package danfeeLinearDataEstructures;

import java.util.ArrayList;
import java.util.Iterator;

public class HashSet<E> {

	public static final int DEFAULT_INITIAL_CAPACITY = 16;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;

	// ---
	private E[] elements;
	private int size;
	private int capacity;
	private float loadFactor;
	private float currentLoadFactor;

	public HashSet() {
		this.size = 0;
		this.capacity = DEFAULT_INITIAL_CAPACITY;
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		this.elements = (E[]) new Object[capacity];
		this.currentLoadFactor = size / capacity;
	}

	public HashSet(int initialCapacity) {
		this.size = 0;
		this.capacity = initialCapacity;
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		this.elements = (E[]) new Object[capacity];
		this.currentLoadFactor = size / capacity;
	}

	public HashSet(int initialCapacity, float loadFactor) {
		if(initialCapacity<1) {
			this.capacity = 1;
		}else {
			this.capacity = initialCapacity;
		}
		
		if(loadFactor<=0) {
			this.loadFactor = 0.1f;
		}else if(!(loadFactor>1)) {
			this.loadFactor = loadFactor;
		}
		
		this.size = 0;
		this.loadFactor = loadFactor;
		this.elements = (E[]) new Object[capacity];
		this.currentLoadFactor = size / capacity;
	}

	public boolean add(E element) {
		boolean added = false;
		if (this.isEmpty()) {
			added = put(element);

		} else {
			if (needIncrease()) {
				increaseCapacity();
			}
			added = put(element);
		}

		if (added)
			this.size++;
		recalculateCurrentLoadFactor();
		return added;
	}

	private boolean needIncrease() {
		return currentLoadFactor >= loadFactor;
	}

	private boolean put(E element) {
		boolean added = false;
		if (element != null) {
			int index = hashFunction(element);

			if (elements[index] != null) {
				if (!elements[index].equals(element)) {
					if (elements[index] == null) {
						added = true;
						this.elements[index] = element;

					} else {
						int i = 1;
						while (!added) {
							index = quadraticProve(element, i);
							if (elements[index] == null) {
								added = true;
								this.elements[index] = element;
							}
							i++;
						}
					}

				}
			} else {
				added = true;
				this.elements[index] = element;
			}

		}
		return added;
	}

	private int hashFunction(E element) {
		return (int) (Math.abs(element.hashCode()) % capacity);
	}

	private int quadraticProve(E element, int i) {

		return (int) ((hashFunction(element) + i + Math.pow(i, 2)) % capacity);
	}

	private void increaseCapacity() {
		E[] temp = this.elements.clone();
		capacity *= 2;
		this.elements = (E[]) new Object[capacity];

		for (int i = 0; i < temp.length; i++) {
			put(temp[i]);
		}

		recalculateCurrentLoadFactor();
	}

	private void recalculateCurrentLoadFactor() {
		this.currentLoadFactor = (float) size / (float) capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Iterator<E> iterator() {
		ArrayList<E> list = new ArrayList<>();

		for (int i = 0; i < elements.length; i++) {
			list.add(this.elements[i]);
		}

		Iterator<E> iterator = (Iterator<E>) list;
		return iterator;
	}

	public boolean contains(Object o) {
		int index = hashFunction((E) o);
		boolean find = false;
		if (this.elements[index].equals(o)) {
			find = true;
		} else {
			int i = 1;
			while (!find) {
				index = quadraticProve((E) o, i);
				if (this.elements[index].equals(o)) {
					find = true;
				}
				i++;
			}
		}
		return find;
	}

	public boolean remove(Object o) {
		boolean removed = false;

		int index = hashFunction((E) o);
		if (this.elements[index].equals(o)) {
			this.elements[index] = null;
			removed = true;
		}

		return removed;
	}

	public int size() {
		return this.size;
	}
}
