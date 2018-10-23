package model;

public interface BTSNode<P extends Number> extends INoBalancedNode<P> {

	/**
	 * This constant contains the index that reference  field goals percentage item in the hashmap.
	 */
	static final int FIELD_GOALS_PERCENTAGE = 1;
	
	/**
	 * This constant contains the index that reference  tree point field goals percentage item in the hashmap.
 
	 */
	static final int THREE_POINT_FIELD_GOALS_PERCENTAGE = 2;
	
	/**
	 * This constant contains the index that reference free throw percentage item in the hashmap.
	 */
	static final int FREE_THROW_PERCENTAGE = 3;
	
	/**
	 * This constant contains the index that reference  personal fouls item in the hashmap.
	 */
	static final int PERSONAL_FOULS = 4;

}
