package model;

import model.Node.Result;

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
    
    /**
	 * this method insert a node.
	 * @param node the node to be inserted.
	 * @return the new root of the of the tree or null whether did not appear any change.
     * @throws Exception 
	 */
    AVLNode<P> insertAVL (Item<P> item) throws Exception;
	
    /**
	 * This method remove this node by the tree
     * @throws ItemDoesNotFoundException 
	 */
	AVLNode<P> removeAVL(Item<P> item) throws ItemDoesNotFoundException;
	
	/**
	 * This methdo insert an item.
	 * @param item
	 * @param result
	 * @throws Exception 
	 */
	void auxiliarInsertAVL(Item<P> item, Node<P>.Result result) throws Exception;
	
	/**
	 * returns the balance factor
	 */
	int getBalanceFactor();
	
	/**
	 * This method change the balance factor
	 */
	void setBalanceFactor(int balance);
	
	/**
	 * This method balance the tree by right balance
	 * @return
	 */
	AVLNode<P> AVLRightBalance();
	
	/**
	 * This method balance the tree by left balance
	 * @return
	 */
	AVLNode<P> AVLLeftBalance();
	
	/**
	 * This method remove 
	 * @param item
	 * @param result
	 * @throws ItemDoesNotFoundException 
	 */
	void auxiliarRemoveAVL(Item<P> item, Node<P>.Result result) throws ItemDoesNotFoundException;
	
	/**
	 * This method balance tree when a item is removed
	 * @param result
	 */
	void AVLRemoveLeftBalance(Node<P>.Result result);
	
	/**
	 * This method balance tree when a items is removed
	 * @param result
	 */
	void AVLRemoveRightBalance(Node<P>.Result result);
}
