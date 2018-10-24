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
	char getColor(int itemType);
	
	/**
	 * this method change the color of this node
	 */
	
	void setColor(char color);
	

	/**
	 * This method returns the uncle of this node.
	 * 
	 * @return node uncle of this node.
	 */
	INode<P> getUncle();

	/**
	 * This method changes the uncle of this node.
	 * 
	 * @param newUncle a new node.
	 */
	void setUncle(INode<P> newUncle);
	
	/**
	 * this method insert a node.
	 * @param node the node to be inserted.
	 * @return the new root of the of the tree or null whether did not appear any change.
	 */
	RedBlackNode<P> insert(RedBlackNode<P> node);
}
