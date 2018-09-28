package danfeeLinearDataEstructures;

public interface DanfeeQueue<P> extends ILinearDataEstructuresByDanfee<P> {

	void enQueue(P object);
	P peek()throws Exception;
	P deQueue() throws Exception;
}
