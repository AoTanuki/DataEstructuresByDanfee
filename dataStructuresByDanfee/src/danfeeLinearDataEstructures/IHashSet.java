package danfeeLinearDataEstructures;

import java.util.Iterator;

public interface IHashSet<E> extends ILinearDataEstructuresByDanfee<E>{

	boolean add(E element);
	Iterator<E> iterator();
	boolean contains(Object o);
	boolean remove(Object o);
	
}
