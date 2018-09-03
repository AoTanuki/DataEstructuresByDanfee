package danfeeLinearDataEstructures;
public interface DanfeeSimpleLinkedList <P> extends ILinearDataEstructuresByDanfee<P>{

	void add(P object);
	void remove(int index) throws Exception;
	P get(int index) throws Exception;
	void insertAt(P object, int index)throws Exception;
}
