package danfeeLinearDataEstructures;

public interface DanfeeQueue<P> extends ILinearDataEstructuresByDanfee<P> {

	void enQueue(P object);
	
	P deQueue() throws Exception;
}
