package model;

import java.io.Serializable;
import java.util.HashMap;

public class Node<D extends Number> implements AVLNode<D>, RedBlackNode<D>, BTSNode<D>,Serializable{

	/**
	 * This attribute represents the father node of this one.
	 */
	private Node<D> father;
	
	/**
	 * This attribute represents the uncle node of this one.
	 */
	private Node<D> uncle;

	/**
	 * This attribute represents the left child node of this one.
	 */
	private Node<D> leftChild;

	/**
	 * This attribute represents the right child node of this one.
	 */
	private Node<D> rightChild;

	/**
	 * this map contains the items to make queries. into the hash map there are two
	 * or four items, depending which tree is using for, and their value is the item
	 * associate.
	 * 
	 * All constants defined in this class contains the index of the item into
	 * hash map.
	 * 
	 */
	private HashMap<Integer, Item<D>> entryData;

	
	/**
	 * this attribute define the color of this node. That  is only visible to RB Node
	 */
	private char color;

	/**
	 *  this attribute define the balanced factor of this node. That  is only visible to AVL node
	 */
	private int balancedFactor;

	@Override
	public Node<D> getFather() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFather(Node<D> newFather) {
		// TODO Auto-generated method stub

	}

	@Override
	public void leftRotation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightRotation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leftDoubleRotation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightDoubleRotation() {
		// TODO Auto-generated method stub

	}

	@Override
	public Node<D> getleftChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLeftChild(Node<D> node) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node<D> getRightChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRightChild(Node<D> node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addItem(int itemType, Item<D> item) {
		// TODO Auto-generated method stub

	}

	@Override
	public char getColorFieldGoalsPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char getColorThreePointFieldGoals() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setColorFieldGoalsPercentage(char color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColorThreePointFieldGoals(char color) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node<D> getUncle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUncle(Node<D> newUncle) {
		// TODO Auto-generated method stub

	}

}
