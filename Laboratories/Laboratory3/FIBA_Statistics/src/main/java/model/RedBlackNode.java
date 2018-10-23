package model;

public interface RedBlackNode<P extends Number> extends IBalancedNode<P> {

	/**
	 * This constant contains the index that reference  field goals percentage item in the hashmap.
	 */
	static final int FIELD_GOALS_PERCENTAGE = 1;
	
	/**
	 * This constant contains the index that reference  tree point field goals percentage item in the hashmap.
 
	 */
	static final int THREE_POINT_FIELD_GOALS_PERCENTAGE = 2;
	
	/**
	 * This constant define that this node is a Red node.

	 */
	static final char RED_NODE = 'R';
	
	/**
	 * This constant define that this node is a Black node.
	 */
	static final char BLACK_NODE = 'B';
	
	/**
	 * this method return the color of this node but, the color that represents the index of field goals percentage
	 * @return the color that represent the part of the node of field goals percentage
	 */
	char getColorFieldGoalsPercentage();
	
	/**
	 * this method return the color of this node but, the color that represents the index of three point field goals percentage
	 * @return the color that represent the part of the node of three point field goals percentage
	 */
	char getColorThreePointFieldGoals();
	
	/**
	 *  this method change the color of this node, but, the color that represents the index of field goals percentage
	 * @param color a new color represented by the constants added in RedBlackNode interface
	 */
	void setColorFieldGoalsPercentage(char color);
	
	
	/**
	 *  this method change the color of this node, but, the color that represents the index of three point field goals percentage
	 * @param color a new color represented by the constants added in RedBlackNode interface
	 */
	void setColorThreePointFieldGoals(char color);
	
	/**
	 * This method returns the uncle of this node.
	 * @return node uncle of this node.
	 */
	Node<P> getUncle();
	
	/**
	 * This method changes the uncle of this node.
	 * @param newUncle a new node.
	 */
	void setUncle(Node<P> newUncle);
}
