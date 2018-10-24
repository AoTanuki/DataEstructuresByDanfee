package model;

import java.io.Serializable;
import java.util.HashMap;

public class Node<D extends Number> implements AVLNode<D>, RedBlackNode<D>, BTSNode<D>, Serializable {

	/**
	 * This attribute represents the father node of this one.
	 */
	private INode<D> father;

	/**
	 * This attribute represents the uncle node of this one.
	 */
	private INode<D> uncle;

	/**
	 * This attribute represents the left child node of this one.
	 */
	private INode<D> leftChild;

	/**
	 * This attribute represents the right child node of this one.
	 */
	private INode<D> rightChild;

	/**
	 * this map contains the items to make queries. into the hash map there are two
	 * or four items, depending which tree is using for, and their value is the item
	 * associate.
	 * 
	 * All constants defined in this class contains the index of the item into hash
	 * map.
	 * 
	 */
	private Item<D> entryData;

	/**
	 * this attribute define the balanced factor of this node. That is only visible
	 * to AVL node
	 */
	private int balancedFactor;

	/**
	 * this attribute define the color of this node 
	 */
	private char color;

	/**
	 * This constructor create a node with a non-leaf whithout father and leaf sons and with color as red
	 * This constructor shall only use to a Red black node.
	 * @param father
	 * @param uncle
	 * @param leftChild
	 * @param rightChild

	 */
	public Node(Item<D> item, char color) {
		this.father = null;
		this.uncle = null;
		this.leftChild = (RedBlackNode) new Node<>();
		this.rightChild = (RedBlackNode) new Node<>();
		this.color = color;
		this.entryData = item;
	}
	
	
	/**
	 * defect constructor of a red black node
	 * construct an Node without any information and colored as Black.
	 */
	public Node() {
		this.entryData = null;
		this.color = RedBlackNode.BLACK_NODE;
		this.father = null;
		this.uncle = null;
		this.leftChild = null;
		this.rightChild = null;
		
	}

	@Override
	public INode<D> getFather() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFather(INode<D> newFather) {
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
	public INode<D> getleftChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLeftChild(INode<D> node) {
		// TODO Auto-generated method stub

	}

	@Override
	public INode<D> getRightChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRightChild(INode<D> node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addItem(int itemType, Item<D> item) {
		// TODO test it

	}

	@Override
	public INode<D> getUncle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUncle(INode<D> newUncle) {
		// TODO Auto-generated method stub

	}

	@Override
	public char getColor(int itemType) {
		return this.color;
	}

	@Override
	public void setColor(char color) {
		this.color = color;
		
	}


	@Override
	public INode<D> insert(INode<D> node) {
		// TODO Auto-generated method stub
		
		
		return null;
	}


	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
