package danfeeLinearDataEstructures;
public interface DanfeeSimpleLinkedList <P> {

	void add(P object);
	void remove(int index) throws ArrayIndexOutOfBoundsException;
	void get(int index);
}
