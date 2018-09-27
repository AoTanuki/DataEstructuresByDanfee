package danfeeLinearDataEstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class HashMap<K, V> implements IHashMap<K, V> {

	public static final int DEFAULT_INITIAL_CAPACITY = 16;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;

	// ---
	private K[] keys;
	private V[] values;
	private int size;
	private int capacity;
	private float loadFactor;
	private float currentLoadFactor;

	public HashMap() {
		this.size = 0;
		this.capacity = DEFAULT_INITIAL_CAPACITY;
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		this.keys = (K[]) new Object[capacity];
		this.values = (V[]) new Object[capacity];
		this.currentLoadFactor = size / capacity;
	}

	public HashMap(int initialCapacity) {
		if (initialCapacity < 1) {
			this.capacity = 1;
		} else {
			this.capacity = initialCapacity;
		}
		this.size = 0;
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		this.keys = (K[]) new Object[capacity];
		this.values = (V[]) new Object[capacity];
		this.currentLoadFactor = size / capacity;
	}

	public HashMap(int initialCapacity, float loadFactor) {
		if (initialCapacity < 1) {
			this.capacity = 1;
		} else {
			this.capacity = initialCapacity;
		}

		if (loadFactor <= 0) {
			this.loadFactor = 0.1f;
		} else if (!(loadFactor > 1)) {
			this.loadFactor = loadFactor;
		}

		this.size = 0;
		this.loadFactor = loadFactor;
		this.keys = (K[]) new Object[capacity];
		this.values = (V[]) new Object[capacity];
		this.currentLoadFactor = size / capacity;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		for (int i = 0; i < keys.length; i++) {
			this.keys[i] = null;
			this.values[i] = null;
		}
	}

	@Override
	public boolean containsKey(Object key) {
		boolean finded = false;
		if (key != null) {
			for (int i = 0; i < keys.length; i++) {
				if (this.keys[i] != null) {
					if (this.keys[i].equals((K) key))
						finded = true;
				}
			}
		}
		return finded;
	}

	@Override
	public boolean containsValue(Object value) {
		boolean finded = false;
		if (value != null) {
			for (int i = 0; i < values.length; i++) {
				if (this.values[i] != null) {
					if (this.values[i].equals((V) value))
						finded = true;
				}
			}
		}
		return finded;
	}

	@Override
	public V get(Object key) {
		V value = null;
		if(this.containsKey(key)) {
			int index = hashFunction((K) key);
			if(this.keys[index].equals(key)) {
				value = this.values[index];
			}else {
				boolean find=false;
				int i =1;
				while(!find) {
					index = quadraticProve((K)key, i);
					if(this.keys[index].equals(key)) {
						value = this.values[index];
						find = true;
					}
					i++;
				}
			}
		}
		return value;
	}

	@Override
	public Iterator<K> keySet() {
		ArrayList<K> array = new ArrayList<>();

		for (int i = 0; i < keys.length; i++) {
			array.add(keys[i]);
		}

		Iterator<K> iterator = (Iterator<K>) array;
		return iterator;
	}

	@Override
	public boolean put(K key, V value) {
		boolean added = false;
		if (key != null) {
			if (this.isEmpty()) {
				added = add(key, value);
			} else {
				if (needIncrease()) {
					increaseCapacity();
				}
				added = add(key, value);
			}
			if (added)
				this.size++;
			recalculateCurrentLoadFactor();


		}
		return added;
	}

	@Override
	public boolean remove(Object key) {
		boolean removed = false;
		if(this.containsKey(key)) {
			int index = hashFunction((K) key);
			if(this.keys[index].equals(key)) {
				this.values[index] = null;
				this.keys[index] = null;
				removed = true;
			}else {
				boolean find=false;
				int i =1;
				while(!find) {
					index = quadraticProve((K)key, i);
					if(this.keys[index].equals(key)) {
						this.values[index] = null;
						this.keys[index] = null;
						removed = true;
						find = true;
					}
					i++;
				}
			}
		}
		return removed;
	}

	@Override
	public Iterator<V> values() {
		ArrayList<V> array = new ArrayList<>();
		for (int i = 0; i < values.length; i++) {
			array.add(values[i]);
		}

		Iterator<V> iterator = (Iterator<V>) array;
		return iterator;
	}

	private boolean add(K key, V value) {
		boolean added = false;
		if (key != null) {
			int index = hashFunction(key);

			if (keys[index] != null) {
				if (!keys[index].equals(key)) {
					if (keys[index] == null) {
						added = true;
						this.keys[index] = key;
						this.values[index] = value;

					} else {
						int i = 1;
						while (!added) {
							index = quadraticProve(key, i);
							if (keys[index] == null) {
								added = true;
								this.keys[index] = key;
								this.values[index] = value;
							}
							i++;
						}
					}

				}else {
					this.values[index]= value;
				}
				
				
				
			} else {
				added = true;
				this.keys[index] = key;
				this.values[index] = value;
			}

		}
		return added;
	}

	private int hashFunction(K key) {
		return (int) (Math.abs(key.hashCode()) % capacity);
	}

	private int quadraticProve(K key, int i) {

		return (int) ((hashFunction(key) + i + Math.pow(i, 2)) % capacity);
	}

	private void increaseCapacity() {
		K[] tempKeys = this.keys.clone();
		V[] tempValues = this.values.clone();
		capacity *= 2;
		this.keys = (K[]) new Object[capacity];
		this.values = (V[]) new Object[capacity];

		for (int i = 0; i < keys.length; i++) {
			add(keys[i], values[i]);
		}

		recalculateCurrentLoadFactor();
	}

	private void recalculateCurrentLoadFactor() {
		this.currentLoadFactor = (float) size / (float) capacity;
	}

	private boolean needIncrease() {
		return currentLoadFactor >= loadFactor;
	}
}
