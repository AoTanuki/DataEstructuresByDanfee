package danfeeLinearDataEstructures;

public interface DanfeeStack <P>extends ILinearDataEstructuresByDanfee<P> {

	void push (P value) throws Exception;
	
	P pop()throws Exception;
	
	P peek()throws Exception;
	
	boolean isFull();
	
	void setOverFlow(int overFlow);
	
	void setHasOverFlow(boolean hasOverFlow);
	
	boolean hasOverFlow();
	
	int getOverFlow();
	
	void toAbleOverFlow(int overflow);
	
	void toDisableOverFlow();
	
}
