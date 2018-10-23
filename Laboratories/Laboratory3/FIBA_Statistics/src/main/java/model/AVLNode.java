package model;

public interface AVLNode<P extends Number> extends IBalancedNode<P> {

	/**
	 * This constant contains the index that reference free throw percentage item in the hashmap.
	 */
	static final int FREE_THROW_PERCENTAGE = 3;
	
	/**
	 * This constant contains the index that reference  personal fouls item in the hashmap.
	 */
	static final int PERSONAL_FOULS = 4;
	
	/**
	* Constant that represents left balance in this node. 
	*/
	static final int LEFT_BALANCE = 1;

	/**
	* Constant that represents balance in this node.
	*/
    static final int BALANCE = 0;

	/**
	* Constant that represents right balance in this node. 
	*/
    static final int RIGHT_BALANCE = -1;
	
}
