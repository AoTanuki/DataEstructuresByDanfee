package model;

import java.io.Serializable;
import java.util.HashMap;

public class Node<D extends Number> implements AVLNode<D>, RedBlackNode<D>, BTSNode<D>, Serializable {

	/**
	 * This attribute represents the father node of this one.
	 */
	private INode<D> father;

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
	public IBalancedNode<D> leftRotation() {
		if(this.rightSonLeaf()) {
			return this;
		}
		
		else {
			
			RedBlackNode<D> rigthChildAux = (RedBlackNode<D>) this.rightChild;
			setRightChild(rigthChildAux.getleftChild());
			rigthChildAux.setFather(this.father);
			rigthChildAux.setLeftChild(this);
			return rigthChildAux;
		}

	}

	@Override
	public IBalancedNode<D> rightRotation() {
		if(this.leftSonLeaf()) {
			
			return this;
		}
		
		else {
			
			RedBlackNode<D> leftChildAuxiliar = (RedBlackNode<D>) this.leftChild;
			this.setLeftChild(leftChildAuxiliar.getRightChild());
			leftChildAuxiliar.setFather(this.father);
			leftChildAuxiliar.setRightChild(this);
			return leftChildAuxiliar;
		}

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
	public char getColor() {
		return this.color;
	}

	@Override
	public void setColor(char color) {
		this.color = color;
		
	}


	@Override
	public BTSNode<D> insert(BTSNode<D> node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AVLNode<D> insert(AVLNode<D> node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Item<D> getItem() {
		return this.entryData;
	}


	@Override
	public void setItem(Item<D> item) {
		this.entryData = item;
		
	}


	@Override
	public RedBlackNode<D> getNodewithEqualsValues(Item<D> item) throws ItemDoesNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public RedBlackNode<D> getNodeWithEqualsValuesAndSamePlayer(Item<D> item) throws ItemDoesNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean itemsHasSamePlayerAndValue(Item<D> item1, Item<D> item2) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public RedBlackNode<D> getUncle() {
		// TODO test it
		IBalancedNode<D> fatherCast = (IBalancedNode<D>) this.father;
		if(this.father==null || fatherCast.getFather()== null) {
			return null;
		}
		
		else {
			
			RedBlackNode<D> grandFatherCast = (RedBlackNode<D>) fatherCast.getFather();
			RedBlackNode<D> fatherCastAgain = (RedBlackNode<D>) this.father;
			if(grandFatherCast.isRightChild(fatherCastAgain)) {
				return (RedBlackNode<D>) grandFatherCast.getleftChild();
			} else {
				return (RedBlackNode<D>) grandFatherCast.getRightChild();
			}
		}
		
	}


	@Override
	public boolean rightSonLeaf() {
		return this.rightChild.getItem()== null;
	}


	@Override
	public boolean leftSonLeaf() {
		return this.leftChild.getItem()== null;
	}


	@Override
	public RedBlackNode<D> removeRB() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public RedBlackNode<D> insert(RedBlackNode<D> node) {
		// TODO test it
		this.normalInsertion(node);
		RedBlackNode<D> r = null;
		node.redBlackBalancerCase1(r);
		return r;
	}


	@Override
	public void normalInsertion(RedBlackNode<D> node) {
		// TODO test it
		
		if(this.entryData.compareTo(node.getItem())<0) {
			
			if(this.rightSonLeaf()) {
				
				this.rightChild = node;
				node.setFather(this);
			}else {
				
				RedBlackNode<D> cast = (RedBlackNode<D>) this.rightChild;
				cast.normalInsertion(node);
			}
		}
		
		else {
			
			if(leftSonLeaf()) {
				
				this.leftChild = node;
				node.setFather(this);
			}else {
				
				RedBlackNode<D> cast = (RedBlackNode<D>) this.leftChild;
				cast.normalInsertion(node);
			}
			
		}
		
	}


	@Override
	public RedBlackNode<D> redBlackBalancerCase1(RedBlackNode<D> returnNode) {
		// TODO test it
		if(this.father==null) {
			
			this.color = RedBlackNode.BLACK_NODE;
			returnNode = this;
		}
		
		else {
			redBlackBalancerCase2(returnNode);
		}
		
		return returnNode;
	}


	@Override
	public void redBlackBalancerCase2(RedBlackNode<D> returnNode) {
		// TODO test it
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;
		if(fatherCast.getColor()== RedBlackNode.RED_NODE) {
			
			this.redBlackBalancerCase3(returnNode);
		}else {
			
			returnNode = null;
		}
		
	}


	@Override
	public void redBlackBalancerCase3(RedBlackNode<D> returnNode) {
		// TODO test it
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;
		RedBlackNode<D> uncle = this.getUncle();
		RedBlackNode<D> grandFather =  (RedBlackNode<D>) fatherCast.getFather();
		
		returnNode = null;
		
		if(!uncle.isLeaf() && uncle.getColor()== RedBlackNode.RED_NODE) {
			
			fatherCast.setColor(BLACK_NODE);
			uncle.setColor(BLACK_NODE);
			grandFather.setColor(RED_NODE);
			grandFather.redBlackBalancerCase1(returnNode);
		}
		
		else {
			this.redBlackBalancerCase4(returnNode);
		}
	}


	@Override
	public void redBlackBalancerCase4(RedBlackNode<D> returnNode) {
		// TODO test it
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;
		RedBlackNode<D> grandFather =  (RedBlackNode<D>) fatherCast.getFather();
		returnNode = null;
		
		if(fatherCast.isRightChild(this) && grandFather.isLeftChild(fatherCast)) {
			
			grandFather.setRightChild(fatherCast.leftRotation());
			RedBlackNode<D> leftChildCast = (RedBlackNode<D>) this.leftChild;
			leftChildCast.redBlackBalancerCase5(returnNode);
		}
		else if(fatherCast.isLeftChild(this) && grandFather.isRightChild(fatherCast)) {
			
			grandFather.setRightChild(fatherCast.rightRotation());
			RedBlackNode<D> rightChildCast = (RedBlackNode<D>) this.rightChild;
			rightChildCast.redBlackBalancerCase5(returnNode);
		}else {
			
			this.redBlackBalancerCase5(returnNode);
		}
	}


	@Override
	public void redBlackBalancerCase5(RedBlackNode<D> returnNode) {
		// TODO test it
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;
		RedBlackNode<D> grandFather =  (RedBlackNode<D>) fatherCast.getFather();
		RedBlackNode<D> grandGrandFather = (RedBlackNode<D>) grandFather.getFather();
		fatherCast.setColor(BLACK_NODE);
		fatherCast.setColor(RED_NODE);
		
		if(fatherCast.isLeftChild(this) && grandFather.isLeftChild(fatherCast)) {
			
			if(grandFather.getFather() == null) {
				grandFather.rightRotation();
			}else if (grandGrandFather.isRightChild(grandFather)) {
				grandGrandFather.setRightChild(grandFather.rightRotation());
			}else {
				grandGrandFather.setLeftChild(grandFather.rightRotation());
			}
		}
		
		else {
			
			if(grandFather.getFather() == null) {
				grandFather.leftRotation();
			}else if(grandGrandFather.isRightChild(grandFather)) {
				grandGrandFather.setRightChild(grandFather.leftRotation());
			}else {
				grandGrandFather.setLeftChild(grandFather.leftRotation());
			}
		}
		
		returnNode = (RedBlackNode<D>) this.father;
	}


	@Override
	public boolean isRightChild(RedBlackNode<D> node) {
		return this.rightChild == node;
	}


	@Override
	public boolean isLeftChild(RedBlackNode<D> node) {
		return this.leftChild == node;
	}


	@Override
	public boolean isLeaf() {
		return this.entryData== null;
	}

}
