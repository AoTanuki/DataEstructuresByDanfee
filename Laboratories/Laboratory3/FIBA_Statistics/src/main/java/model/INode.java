package model;

public interface INode<P extends Number> {

	/**
	 * This method returns the left child node of this node
	 * 
	 * @return left child of this node.
	 */
	INode<P> getleftChild();

	/**
	 * This method allows set the left child node of this node.
	 * 
	 * @param node new node that will be new left child.
	 */
	void setLeftChild(INode<P> node);

	/**
	 * This method returns the right child node of this node.
	 * 
	 * @return right child of this node.
	 */
	INode<P> getRightChild();

	/**
	 * This method allows set the right child node of this node.
	 * 
	 * @param node new node that will be new right child.
	 */
	void setRightChild(INode<P> node);

	/**
	 * This method add a item with its corresponding item type. For example, if we
	 * want to add a personal fouls item, we create a item with this value and a
	 * index to corresponding player's txt. next, indicate that this item
	 * corresponding to a personal foul in the parameter "itemType". finally, this
	 * method add in corresponding node type way. this item will be added in the
	 * hash attribute.
	 * 
	 * @param itemType indicate in what space of the hash this item will be added.
	 * @param item A item instance
	 */
	void addItem(int itemType, Item<P> item);
	
	/**
	 * this method returns the item that contains
	 */
	Item<P> getItem();
	
	/**
	 * This method set the item contained into.
	 */
	void setItem(Item<P> item);
	
	/**
	* This method search a node that contains same value than given item
	*
	* @param item is the item to compare
	* @return the node that satisfy that condition
	* @throws ItemDoesNotFoundException appears when that node did not founded.
	*/
	INode<P> getNodewithEqualsValues( Item<P> item ) throws ItemDoesNotFoundException;
	
	/**
	* This method search a node that contains same value than given item and contains the same file index.
	*
	* @param item is the item to compare
	* @return the node that satisfy that condition
	* @throws ItemDoesNotFoundException appears when that node did not founded.
	*/
	INode<P> getNodeWithEqualsValuesAndSamePlayer(Item<P> item) throws ItemDoesNotFoundException;
	
	/**
	 * This method verify if both given items contains the same value and the same file index
	 * @param item1 is the first item to be evaluate
	 * @param item2 is the second item to be evaluate
	 * @return true if both items have the same value and txtfile index, false in otherwise.
	 */
	boolean itemsHasSamePlayerAndValue(Item<P> item1, Item<P> item2);
	
	/**
	 *  this method returns the maximun value of this node.
	 */
	
	INode<P> getMaximun();
	
	/**
	 * This method returns the minimun value of this node.
	 */
	
	INode<P> getMinimun();
	
	/**
	 * This method verify if this right son is a leaf;
	 * 
	 * @return <code>true</code> whether this right son is a leafe or
	 *         <code>false</code> in otherwise.
	 */
	boolean rightSonLeaf();

	/**
	 * This method verify if this right son is a leaf;
	 * 
	 * @return <code>true</code> whether this right son is a leafe or
	 *         <code>false</code> in otherwise.
	 */
	boolean leftSonLeaf();

}
