package danfeeLinearDataEstructures;

import java.util.Collection;
import java.util.Set;

public interface IHashMap<K,V> extends ILinearDataEstructuresByDanfee<V> {

	void clear();
	boolean containsKey(Object key);
	boolean containsValue(Object value);
	V get(Object key);
	Set<K> keySet();
	V put(K key, V value);
	V remove(Object key);
	Collection<V> values();
}
