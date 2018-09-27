package danfeeLinearDataEstructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface IHashMap<K,V> extends ILinearDataEstructuresByDanfee<V> {

	void clear();
	boolean containsKey(Object key);
	boolean containsValue(Object value);
	V get(Object key);
	Iterator<K> keySet();
	boolean put(K key, V value);
	boolean remove(Object key);
	Iterator<V> values();
}
