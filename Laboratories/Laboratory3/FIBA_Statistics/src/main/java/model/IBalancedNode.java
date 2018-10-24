package model;

public interface IBalancedNode<P extends Number> extends INode<P> {

	/**
	 * This method returns the father of this node.
	 * @return node father of this node.
	 */
	INode<P> getFather();
	
	
	/**
	 * This method changes the father of this node
	 * @param newFather a new node that will be father of this.
	 */
	void setFather(INode<P> newFather);
	
	/**
	 * this method execute a left Rotation. in this kind of tree, all rotation is, in part, only to values.
	 */
	void leftRotation();
	
	/**
	 * this method execute a right Rotation. in this kind of tree, all rotation is, in part, only to values.
	 */
	void rightRotation();
	
	/**
	 * this method execute a left double Rotation. in this kind of tree, all rotation is, in part, only to values.
	 */
	
	void leftDoubleRotation();
	
	/**
	 * this method execute a right double Rotation. in this kind of tree, all rotation is, in part, only to values.
	 */
	void rightDoubleRotation();
}
