package model;

public interface RedBlackNode<P extends Number> extends IBalancedNode<P> {

	/**
	 * This constant contains the index that reference field goals percentage item
	 * in the hashmap.
	 */
	static final int FIELD_GOALS_PERCENTAGE = 1;

	/**
	 * This constant contains the index that reference tree point field goals
	 * percentage item in the hashmap.
	 * 
	 */
	static final int THREE_POINT_FIELD_GOALS_PERCENTAGE = 2;

	/**
	 * This constant define that this node is a Red node.
	 * 
	 */
	static final char RED_NODE = 'R';

	/**
	 * This constant define that this node is a Black node.
	 */
	static final char BLACK_NODE = 'B';

	/**
	 * this method returns the color of this node depending the given item. For
	 * example, if you want to know what color has a red black node but with
	 * attribute field goals percentage
	 */
	char getColor();

	/**
	 * this method change the color of this node
	 */

	void setColor(char color);

	/**
	 * This method returns the uncle of this node.
	 * 
	 * @return node uncle of this node.
	 */
	RedBlackNode<P> getUncle();


	/**
	 * this method insert a node.
	 * 
	 * @param node the node to be inserted.
	 * @return the new root of the of the tree or null whether did not appear any
	 *         change.
	 */
	RedBlackNode<P> insert(RedBlackNode<P> node);

	/**
	 * This method create a new node and insert into this tree as a normal bts.
	 * Also, this method balanced this tree.
	 * 
	 * @param node new node to insert.
	 */
	void normalInsertion(RedBlackNode<P> node);

	/**
	 * this is the first case of insertion. this case start with balance a new node
	 * inserted in a tree.
	 */
	RedBlackNode<P> redBlackBalancerCase1(RedBlackNode<P> returnNode);

	/**
	 * this is the second case of insertion.
	 */
	void redBlackBalancerCase2(RedBlackNode<P> returnNode);

	/**
	 * This is the thirt case of insertion.
	 */
	void redBlackBalancerCase3(RedBlackNode<P> returnNode);

	/**
	 * This is the fourth case of insertion.
	 */
	// TODO
	void redBlackBalancerCase4(RedBlackNode<P> returnNode);

	/**
	 * this is the fifth case of insertion.
	 */
	// TODO
	void redBlackBalancerCase5(RedBlackNode<P> returnNode);

	
	/**
	 * This method remove this node by the tree
	 */
	RedBlackNode<P> removeRB();
	
	/**
	* Verify if the given node is  right child of this node
	* @param nodo Node to be compare.
	* @return <code>true</code>if given node is right child of <code>this</code> or <code>false</code> in otherwise.
	*/
	boolean isRightChild (RedBlackNode<P> node);
	
	/**
	* Verify if the given node is left child of this node
	* @param nodo Node to be compare.
	* @return <code>true</code>if given node is left child of <code>this</code> or <code>false</code> in otherwise.
	*/
	boolean isLeftChild (RedBlackNode<P> node);
	
	/**
	* Verify if this node is a leaf.
	* @return <code>true</code> if this node is a leaf or <code>false</code> in otherwise.
	*/
	public boolean isLeaf( );
	
	/**
	 * This method change the information of two nodes.
	 */
	void swampItems(RedBlackNode<P> node);
	
	/**
	 * this method keeps all properties in the tree when a node is removed.
	 */
	void removeBalancer(RedBlackNode<P> returnNode);
	
	/**
	 * this is the 1 case of remove balancer
	 */
	void removeBalancerCase1(RedBlackNode<P> returnNode);
	
	/**
	 * this is the 2 case of remove balancer
	 */
	void removeBalancerCase2(RedBlackNode<P> returnNode);

	/**
	 * this is the 3 case of remove balancer
	 */
	void removeBalancerCase3(RedBlackNode<P> returnNode);
	
	/**
	 * this is the 4 case of remove balancer
	 */
	void removeBalancerCase4(RedBlackNode<P> returnNode);
	
	/**
	 * this is the 5 case of remove balancer
	 */
	void removeBalancerCase5(RedBlackNode<P> returnNode);
	
	/**
	 * this is the 6 case of remove balancer
	 */
	void removeBalancerCase6(RedBlackNode<P> returnNode);

	/**
	 * This methods change both childs by leaf
	 */
	void removeChilds();
	
	/**
	 * this method returns the brother of this node
	 */
	RedBlackNode<P> getBrother();
	
	/**
	 *  This method verify if childs of this node are black
	 */
	boolean blackChilds();
	
	/**
	 * This method veryfy if left child is black
	 */
	boolean leftChildBlack();
	
	/**
	 * This method veryfy if right child is black
	 */
	boolean rightChildBlack();
}
