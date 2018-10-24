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
}
