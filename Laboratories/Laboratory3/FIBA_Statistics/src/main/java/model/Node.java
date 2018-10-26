package model;

import java.io.Serializable;
import java.util.ArrayList;
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
	 * This constructor create a node with a non-leaf whithout father and leaf sons
	 * and with color as red This constructor shall only use to a Red black node.
	 * 
	 * @param father
	 * @param uncle
	 * @param leftChild
	 * @param rightChild
	 * 
	 */
	public Node(Item<D> item, char color) {
		this.father = null;
		this.leftChild = (RedBlackNode) new Node<>();
		this.rightChild = (RedBlackNode) new Node<>();
		this.color = color;
		this.entryData = item;
	}

	/**
	 * defect constructor of a red black node construct an Node without any
	 * information and colored as Black.
	 */
	public Node() {
		this.entryData = null;
		this.color = RedBlackNode.BLACK_NODE;
		this.father = null;
		this.leftChild = null;
		this.rightChild = null;

	}

	/**
	 * This constructor is using for avlnode y bts
	 */
	public Node(Item<D> item) {
		this.entryData = item;
		this.rightChild = null;
		this.leftChild = null;
	}

	@Override
	public INode<D> getFather() {
		return this.father;
	}

	@Override
	public void setFather(INode<D> newFather) {
		this.father = newFather;

	}

	@Override
	public void swampItems(RedBlackNode<D> node) {
		// TODO test it

		if (node.getItem() == null) {
			Item<D> aux = this.entryData;
			this.entryData = node.getItem();
			node.setItem(aux);
		} else {
			this.entryData = null;
			this.color = BLACK_NODE;
			this.rightChild = this.leftChild = null;
		}
	}

	@Override
	public void removeChilds() {

		this.rightChild = new Node<>();
		this.leftChild = new Node<>();
	}

	@Override
	public IBalancedNode<D> leftRotation() {
		if (this.rightSonLeaf()) {
			return this;
		}

		else {

			IBalancedNode<D> rigthChildAux = (IBalancedNode<D>) this.rightChild;
			setRightChild(rigthChildAux.getleftChild());
			rigthChildAux.setFather(this.father);
			rigthChildAux.setLeftChild(this);
			return rigthChildAux;
		}

	}

	@Override
	public IBalancedNode<D> rightRotation() {
		if (this.leftSonLeaf()) {

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
	public IBalancedNode<D> leftDoubleRotation() {
		// TODO Auto-generated method stub
		AVLNode<D> cast = (AVLNode<D>) this.leftChild;
		this.leftChild = cast.leftRotation();
		return rightRotation();

	}

	@Override
	public IBalancedNode<D> rightDoubleRotation() {
		AVLNode<D> cast = (AVLNode<D>) this.rightChild;
		this.rightChild = cast.rightRotation();
		return this.leftRotation();
	}

	@Override
	public INode<D> getleftChild() {
		return this.leftChild;
	}

	@Override
	public void setLeftChild(INode<D> node) {
		this.leftChild = node;

	}

	@Override
	public INode<D> getRightChild() {
		return this.rightChild;
	}

	@Override
	public void setRightChild(INode<D> node) {
		this.rightChild = node;
	}

	@Override
	public INode<D> getMaximun() {
		if (rightSonLeaf()) {
			return this;
		} else {
			return this.rightChild.getMaximun();
		}

	}

	@Override
	public INode<D> getMinimun() {
		if (leftSonLeaf()) {
			return this;
		} else {
			return this.leftChild.getMinimun();
		}
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
	public Item<D> getItem() {
		return this.entryData;
	}

	@Override
	public void setItem(Item<D> item) {
		this.entryData = item;

	}

	@Override
	public INode<D> getNodewithEqualsValues(Item<D> item) throws ItemDoesNotFoundException {
		// TODO test it
		if (item.compareTo(this.entryData) == 0) {
			return this;
		}

		else if (item.compareTo(this.entryData) < 0) {
			if (!leftSonLeaf()) {
				return this.leftChild.getNodewithEqualsValues(item);
			} else
				throw new ItemDoesNotFoundException("Item has not found");
		}

		else {
			if (!rightSonLeaf()) {
				return this.rightChild.getNodewithEqualsValues(item);
			} else
				throw new ItemDoesNotFoundException("Item has not found");
		}
	}

	@Override
	public INode<D> getNodeWithEqualsValuesAndSamePlayer(Item<D> item) throws ItemDoesNotFoundException {
		// TODO test it

		if (itemsHasSamePlayerAndValue(this.entryData, item)) {
			return this;
		} else if (item.compareTo(this.entryData) < 0) {
			if (!leftSonLeaf()) {
				return this.leftChild.getNodeWithEqualsValuesAndSamePlayer(item);
			} else
				throw new ItemDoesNotFoundException("Item has not found");

		} else {
			if (!rightSonLeaf()) {
				return this.rightChild.getNodeWithEqualsValuesAndSamePlayer(item);

			} else
				throw new ItemDoesNotFoundException("Item has not found");
		}
	}

	@Override
	public boolean itemsHasSamePlayerAndValue(Item<D> item1, Item<D> item2) {
		return item1.compareTo(item2) == 0 && item1.getTxtIndex() == item2.getTxtIndex();
	}

	@Override
	public RedBlackNode<D> getUncle() {
		// TODO test it
		IBalancedNode<D> fatherCast = (IBalancedNode<D>) this.father;
		if (this.father == null || fatherCast.getFather() == null) {
			return null;
		}

		else {

			RedBlackNode<D> grandFatherCast = (RedBlackNode<D>) fatherCast.getFather();
			RedBlackNode<D> fatherCastAgain = (RedBlackNode<D>) this.father;
			if (grandFatherCast.isRightChild(fatherCastAgain)) {
				return (RedBlackNode<D>) grandFatherCast.getleftChild();
			} else {
				return (RedBlackNode<D>) grandFatherCast.getRightChild();
			}
		}

	}

	@Override
	public boolean rightSonLeaf() {
		return this.rightChild.getItem() == null;
	}

	@Override
	public boolean leftSonLeaf() {
		return this.leftChild.getItem() == null;
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
	public void setBalanceFactor(int balance) {
		this.balancedFactor = balance;

	}

	@Override
	public int getBalanceFactor() {
		return this.balancedFactor;
	}

	@Override
	public boolean isLeaf() {
		return this.entryData == null;
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

		if (this.entryData.compareTo(node.getItem()) < 0) {

			if (this.rightSonLeaf()) {

				this.rightChild = node;
				node.setFather(this);
			} else {

				RedBlackNode<D> cast = (RedBlackNode<D>) this.rightChild;
				cast.normalInsertion(node);
			}
		}

		else {

			if (leftSonLeaf()) {

				this.leftChild = node;
				node.setFather(this);
			} else {

				RedBlackNode<D> cast = (RedBlackNode<D>) this.leftChild;
				cast.normalInsertion(node);
			}

		}

	}

	@Override
	public RedBlackNode<D> redBlackBalancerCase1(RedBlackNode<D> returnNode) {
		// TODO test it
		if (this.father == null) {

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
		if (fatherCast.getColor() == RedBlackNode.RED_NODE) {

			this.redBlackBalancerCase3(returnNode);
		} else {

			returnNode = null;
		}

	}

	@Override
	public void redBlackBalancerCase3(RedBlackNode<D> returnNode) {
		// TODO test it
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;
		RedBlackNode<D> uncle = this.getUncle();
		RedBlackNode<D> grandFather = (RedBlackNode<D>) fatherCast.getFather();

		returnNode = null;

		if (!uncle.isLeaf() && uncle.getColor() == RedBlackNode.RED_NODE) {

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
		RedBlackNode<D> grandFather = (RedBlackNode<D>) fatherCast.getFather();
		returnNode = null;

		if (fatherCast.isRightChild(this) && grandFather.isLeftChild(fatherCast)) {

			grandFather.setRightChild(fatherCast.leftRotation());
			RedBlackNode<D> leftChildCast = (RedBlackNode<D>) this.leftChild;
			leftChildCast.redBlackBalancerCase5(returnNode);
		} else if (fatherCast.isLeftChild(this) && grandFather.isRightChild(fatherCast)) {

			grandFather.setRightChild(fatherCast.rightRotation());
			RedBlackNode<D> rightChildCast = (RedBlackNode<D>) this.rightChild;
			rightChildCast.redBlackBalancerCase5(returnNode);
		} else {

			this.redBlackBalancerCase5(returnNode);
		}
	}

	@Override
	public void redBlackBalancerCase5(RedBlackNode<D> returnNode) {
		// TODO test it
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;
		RedBlackNode<D> grandFather = (RedBlackNode<D>) fatherCast.getFather();
		RedBlackNode<D> grandGrandFather = (RedBlackNode<D>) grandFather.getFather();
		fatherCast.setColor(BLACK_NODE);
		fatherCast.setColor(RED_NODE);

		if (fatherCast.isLeftChild(this) && grandFather.isLeftChild(fatherCast)) {

			if (grandFather.getFather() == null) {
				grandFather.rightRotation();
			} else if (grandGrandFather.isRightChild(grandFather)) {
				grandGrandFather.setRightChild(grandFather.rightRotation());
			} else {
				grandGrandFather.setLeftChild(grandFather.rightRotation());
			}
		}

		else {

			if (grandFather.getFather() == null) {
				grandFather.leftRotation();
			} else if (grandGrandFather.isRightChild(grandFather)) {
				grandGrandFather.setRightChild(grandFather.leftRotation());
			} else {
				grandGrandFather.setLeftChild(grandFather.leftRotation());
			}
		}

		returnNode = (RedBlackNode<D>) this.father;
	}

	@Override
	public RedBlackNode<D> removeRB() {
		// TODO test it
		RedBlackNode<D> newNode = !leftSonLeaf() ? (RedBlackNode<D>) this.leftChild.getMaximun()
				: (RedBlackNode<D>) this.getMinimun();

		this.swampItems(newNode);

		RedBlackNode<D> returnNode = (RedBlackNode<D>) new Node<>(null, BLACK_NODE);
		newNode.removeBalancer(returnNode);

		return returnNode;
	}

	@Override
	public void removeBalancer(RedBlackNode<D> returnNode) {
		// TODO test it

		RedBlackNode<D> child = !this.rightSonLeaf() ? (RedBlackNode<D>) this.rightChild
				: (RedBlackNode<D>) this.leftChild;

		char colorToRemove = this.color;
		char childColor = child.getColor();

		swampItems(child);
		this.removeChilds();

		if (childColor == RED_NODE) {
			returnNode = this;
		} else if (childColor == BLACK_NODE && colorToRemove == RED_NODE) {
			returnNode = this;
			this.setColor(BLACK_NODE);
		} else {
			removeBalancerCase1(returnNode);
		}
	}

	@Override
	public void removeBalancerCase1(RedBlackNode<D> returnNode) {
		// TODO test it

		if (this.father == null) {
			this.removeBalancerCase2(returnNode);
		} else {
			returnNode = null;
		}
	}

	@Override
	public void removeBalancerCase2(RedBlackNode<D> returnNode) {
		// TODO
		RedBlackNode<D> brother = this.getBrother();
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;

		if (brother.getColor() == RED_NODE) {

			fatherCast.setColor(RED_NODE);
			brother.setColor(BLACK_NODE);
			returnNode = brother;
			RedBlackNode<D> grandFather = (RedBlackNode<D>) fatherCast.getFather();

			if (fatherCast.isRightChild(this)) {

				if (grandFather != null) {

					if (grandFather.isRightChild(fatherCast)) {
						grandFather.setRightChild(fatherCast.rightRotation());
					} else {
						grandFather.setLeftChild(fatherCast.rightRotation());
					}
				} else {
					fatherCast.rightRotation();
				}
			}

			else {
				if (grandFather != null) {

					if (grandFather.isRightChild(fatherCast)) {
						grandFather.setRightChild(fatherCast.leftRotation());
					} else {
						grandFather.setLeftChild(fatherCast.leftRotation());
					}
				}

				else {
					fatherCast.leftRotation();
				}
			}
		}

		removeBalancerCase3(returnNode);
	}

	@Override
	public void removeBalancerCase3(RedBlackNode<D> returnNode) {
		// TODO test it

		RedBlackNode<D> brother = getBrother();
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;
		if (fatherCast.getColor() == BLACK_NODE && brother.getColor() == BLACK_NODE && brother.blackChilds()) {

			brother.setColor(RED_NODE);
			fatherCast.removeBalancerCase1(returnNode);
		} else {

			removeBalancerCase4(returnNode);
		}
	}

	@Override
	public void removeBalancerCase4(RedBlackNode<D> returnNode) {
		// TODO test it
		RedBlackNode<D> brother = getBrother();
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;

		if (fatherCast.getColor() == RED_NODE && brother.getColor() == BLACK_NODE && brother.blackChilds()) {

			brother.setColor(RED_NODE);
			fatherCast.setColor(BLACK_NODE);
		}

		else {
			removeBalancerCase5(returnNode);
		}
	}

	@Override
	public void removeBalancerCase5(RedBlackNode<D> returnNode) {
		// TODO test it
		RedBlackNode<D> brother = getBrother();
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;

		if (fatherCast.isLeftChild(this) && brother.getColor() == BLACK_NODE && !brother.leftChildBlack()
				&& brother.rightChildBlack()) {

			brother.setColor(RED_NODE);
			RedBlackNode<D> aux = (RedBlackNode<D>) brother.getleftChild();
			aux.setColor(BLACK_NODE);
			fatherCast.setLeftChild(brother.rightRotation());
		}

		else if (fatherCast.isRightChild(this) && brother.getColor() == BLACK_NODE && !brother.rightChildBlack()
				&& brother.leftChildBlack()) {

			brother.setColor(RED_NODE);
			RedBlackNode<D> aux = (RedBlackNode<D>) brother.getRightChild();
			aux.setColor(BLACK_NODE);
			fatherCast.setLeftChild(brother.leftRotation());
		}
		removeBalancerCase6(returnNode);
	}

	@Override
	public void removeBalancerCase6(RedBlackNode<D> returnNode) {
		// TODO test it
		RedBlackNode<D> brother = getBrother();
		RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;

		brother.setColor(fatherCast.getColor());
		fatherCast.setColor(BLACK_NODE);
		RedBlackNode<D> grandFather = (RedBlackNode<D>) fatherCast.getFather();

		returnNode = brother;

		if (fatherCast.isLeftChild(this)) {
			RedBlackNode<D> aux = (RedBlackNode<D>) brother.getRightChild();
			aux.setColor(BLACK_NODE);

			if (grandFather != null) {

				if (grandFather.isRightChild(fatherCast)) {
					grandFather.setRightChild(fatherCast.leftRotation());
				} else {
					grandFather.setLeftChild(fatherCast.leftRotation());
				}
			} else {
				fatherCast.leftRotation();
			}
		} else {
			RedBlackNode<D> aux = (RedBlackNode<D>) brother.getleftChild();
			aux.setColor(BLACK_NODE);
		}

		if (grandFather != null) {

			if (grandFather.isRightChild(fatherCast)) {
				grandFather.setRightChild(fatherCast.rightRotation());
			} else {
				grandFather.setLeftChild(fatherCast.rightRotation());
			}
		} else {
			fatherCast.rightRotation();
		}
	}

	@Override
	public RedBlackNode<D> getBrother() {
		if (this.father == null) {
			return null;
		} else {
			RedBlackNode<D> fatherCast = (RedBlackNode<D>) this.father;
			return fatherCast.isRightChild(this) ? (RedBlackNode<D>) fatherCast.getleftChild()
					: (RedBlackNode<D>) fatherCast.getRightChild();
		}

	}

	@Override
	public boolean blackChilds() {
		return leftChildBlack() && rightChildBlack();
	}

	@Override
	public boolean leftChildBlack() {
		RedBlackNode<D> leftChildCast = (RedBlackNode<D>) this.leftChild;
		return leftChildCast.getColor() == BLACK_NODE;
	}

	@Override
	public boolean rightChildBlack() {
		RedBlackNode<D> rightChildCast = (RedBlackNode<D>) this.rightChild;
		return rightChildCast.getColor() == BLACK_NODE;
	}

	@Override
	public AVLNode<D> insertAVL(Item<D> item) throws Exception {
		Result result = new Result(null, false);
		auxiliarInsertAVL(item, result);
		return result.result;
	}

	@Override
	public void auxiliarInsertAVL(Item<D> item, Result result) throws Exception {
		// TODO Auto-generated method stub
		int compareResult = this.entryData.compareTo(item);

		if (itemsHasSamePlayerAndValue(this.entryData, item)) {
			throw new Exception("Item cloned");
		}
		if (compareResult >= 0) {
			if (this.leftChild == null) {
				this.leftChild = new Node<>(item);
				result.result = this;

				if (this.rightChild == null) {
					this.balancedFactor = LEFT_BALANCE;
					result.hightDiference = true;
				} else {
					this.balancedFactor = BALANCE;
					result.hightDiference = false;
				}
			} else {
				AVLNode<D> leftChildCast = (AVLNode<D>) this.leftChild;
				leftChildCast.auxiliarInsertAVL(item, result);
				this.leftChild = result.result;

				if (result.hightDiference) {

					switch (this.balancedFactor) {
					case LEFT_BALANCE:
						result.hightDiference = false;
						result.result = AVLLeftBalance();
						break;

					case BALANCE:
						this.balancedFactor = BALANCE;
						result.result = this;
						break;

					case RIGHT_BALANCE:
						this.balancedFactor = BALANCE;
						result.hightDiference = false;
						result.result = this;
						break;
					}
				}

				else {
					result.result = this;
				}
			}
		}

		// right case:
		else {
			if (this.rightChild == null) {
				this.rightChild = new Node<>(item);
				result.result = this;

				if (this.leftChild == null) {
					this.balancedFactor = RIGHT_BALANCE;
					result.hightDiference = true;
				} else {
					balancedFactor = BALANCE;
					result.hightDiference = false;
				}
			} else {
				AVLNode<D> rightChildCast = (AVLNode<D>) this.rightChild;
				rightChildCast.auxiliarInsertAVL(item, result);
				this.rightChild = result.result;

				if (result.hightDiference) {

					switch (this.balancedFactor) {
					case LEFT_BALANCE:
						this.balancedFactor = BALANCE;
						result.hightDiference = false;
						result.result = this;
						break;

					case BALANCE:
						this.balancedFactor = BALANCE;
						result.result = this;
						break;

					case RIGHT_BALANCE:
						result.hightDiference = false;
						result.result = AVLRightBalance();
						break;
					}
				}

				else {
					result.result = this;
				}
			}
		}

	}

	public AVLNode<D> AVLRightBalance() {
		// TODO test it
		AVLNode<D> rightChildCast = (AVLNode<D>) this.rightChild;
		AVLNode<D> leftChildCast = (AVLNode<D>) this.leftChild;

		if (rightChildCast.getBalanceFactor() == RIGHT_BALANCE) {
			this.balancedFactor = BALANCE;
			rightChildCast.setBalanceFactor(BALANCE);
			return (AVLNode<D>) this.leftRotation();
		} else {

			AVLNode<D> cast = (AVLNode<D>) this.rightChild.getleftChild();
			switch (cast.getBalanceFactor()) {

			case LEFT_BALANCE:
				this.balancedFactor = BALANCE;
				rightChildCast.setBalanceFactor(RIGHT_BALANCE);
				break;
			case BALANCE:
				this.balancedFactor = BALANCE;
				rightChildCast.setBalanceFactor(BALANCE);
				break;
			case RIGHT_BALANCE:
				this.balancedFactor = LEFT_BALANCE;
				rightChildCast.setBalanceFactor(BALANCE);
				break;
			}
			cast.setBalanceFactor(BALANCE);
			return (AVLNode<D>) this.rightDoubleRotation();
		}
	}

	public AVLNode<D> AVLLeftBalance() {
		// TODO test it
		AVLNode<D> rightChildCast = (AVLNode<D>) this.rightChild;
		AVLNode<D> leftChildCast = (AVLNode<D>) this.leftChild;

		if (leftChildCast.getBalanceFactor() == BALANCE) {

			this.balancedFactor = BALANCE;
			leftChildCast.setBalanceFactor(BALANCE);

			return (AVLNode<D>) rightRotation();
		} else {
			AVLNode<D> cast = (AVLNode<D>) this.leftChild.getRightChild();
			switch (cast.getBalanceFactor()) {
			case LEFT_BALANCE:
				this.balancedFactor = RIGHT_BALANCE;
				leftChildCast.setBalanceFactor(BALANCE);
				break;

			case BALANCE:
				this.balancedFactor = BALANCE;
				leftChildCast.setBalanceFactor(BALANCE);
				break;

			case RIGHT_BALANCE:
				this.balancedFactor = BALANCE;
				leftChildCast.setBalanceFactor(LEFT_BALANCE);
				break;
			}
			cast.setBalanceFactor(BALANCE);
			return (AVLNode<D>) this.leftDoubleRotation();
		}

	}

	@Override
	public AVLNode<D> removeAVL(Item<D> item) throws ItemDoesNotFoundException {
		// TODO test it
		Result result = new Result(null, false);
		auxiliarRemoveAVL(item, result);

		return result.result;
	}

	public void auxiliarRemoveAVL(Item<D> item, Result result) throws ItemDoesNotFoundException {
		// TODO test it
		int compareResult = this.entryData.compareTo(item);
		AVLNode<D> rightChildCast = (AVLNode<D>) this.rightChild;
		AVLNode<D> leftChildCast = (AVLNode<D>) this.leftChild;

		if (compareResult == 0) {

			if (itemsHasSamePlayerAndValue(this.entryData, item)) {
				if (this.leftChild == null && this.rightChild == null) {
					result.hightDiference = true;
					result.result = this;
				} else if (this.leftChild == null) {
					result.result = (AVLNode<D>) this.rightChild;
					result.hightDiference = true;
				} else {
					AVLNode<D> reemplace = (AVLNode<D>) this.leftChild.getMaximun();
					item = reemplace.getItem();
					leftChildCast.auxiliarRemoveAVL(item, result);
					this.leftChild = result.result;

					if (result.hightDiference) {
						AVLRemoveRightBalance(result);
					} else {
						result.result = this;
					}
				}
			} else if (this.rightChild != null) {

				AVLNode<D> cast = (AVLNode<D>) this.rightChild;
				cast.auxiliarRemoveAVL(item, result);
			} else {
				throw new ItemDoesNotFoundException("this element has not founded in the tree");
			}

		} else if (compareResult > 0) {

			if (this.leftChild == null) {
				throw new ItemDoesNotFoundException("this element has not founded in the tree");
			}

			leftChildCast.auxiliarRemoveAVL(item, result);
			this.leftChild = result.result;

			if (result.hightDiference) {
				this.AVLRemoveRightBalance(result);
			} else {
				result.result = this;
			}
		} else {

			if (this.rightChild == null) {
				throw new ItemDoesNotFoundException("this element has not founded in the tree");
			}
			rightChildCast.auxiliarRemoveAVL(item, result);
			this.rightChild = result.result;

			if (result.hightDiference) {
				this.AVLRemoveLeftBalance(result);
			} else {
				result.result = this;
			}
		}
	}

	public void AVLRemoveLeftBalance(Result result) {
		// TODO test it
		AVLNode<D> rightChildCast = (AVLNode<D>) this.rightChild;
		AVLNode<D> leftChildCast = (AVLNode<D>) this.leftChild;

		switch (this.balancedFactor) {
		case LEFT_BALANCE:

			if (leftChildCast.getBalanceFactor() != RIGHT_BALANCE) {
				result.result = (AVLNode<D>) this.rightRotation();

				if (result.result.getBalanceFactor() == BALANCE) {
					result.result.setBalanceFactor(RIGHT_BALANCE);
					AVLNode<D> cast = (AVLNode<D>) result.result.getRightChild();
					cast.setBalanceFactor(LEFT_BALANCE);
					result.hightDiference = false;
				} else {
					result.result.setBalanceFactor(BALANCE);
					AVLNode<D> cast = (AVLNode<D>) result.result.getRightChild();
					cast.setBalanceFactor(BALANCE);
				}
			} else {
				result.result = (AVLNode<D>) this.leftDoubleRotation();
				if (result.result.getBalanceFactor() == LEFT_BALANCE) {
					AVLNode<D> cast = (AVLNode<D>) result.result.getRightChild();
					cast.setBalanceFactor(RIGHT_BALANCE);
				} else {
					AVLNode<D> cast = (AVLNode<D>) result.result.getRightChild();
					cast.setBalanceFactor(BALANCE);
				}

				if (result.result.getBalanceFactor() == RIGHT_BALANCE) {
					AVLNode<D> cast = (AVLNode<D>) result.result.getleftChild();
					cast.setBalanceFactor(LEFT_BALANCE);
				} else {
					AVLNode<D> cast = (AVLNode<D>) result.result.getleftChild();
					cast.setBalanceFactor(BALANCE);
				}
				result.result.setBalanceFactor(BALANCE);
			}
			break;

		case BALANCE:
			this.balancedFactor = LEFT_BALANCE;
			result.hightDiference = false;
			result.result = this;
			break;

		case RIGHT_BALANCE:
			this.balancedFactor = BALANCE;
			result.result = this;
			break;
		}

	}

	public void AVLRemoveRightBalance(Result result) {
		// TODO test it
		AVLNode<D> rightChildCast = (AVLNode<D>) this.rightChild;
		AVLNode<D> leftChildCast = (AVLNode<D>) this.leftChild;
		switch (this.balancedFactor) {
		case LEFT_BALANCE:
			this.balancedFactor = BALANCE;
			result.result = this;
			break;

		case BALANCE:
			this.balancedFactor = RIGHT_BALANCE;
			result.hightDiference = false;
			result.result = this;
			break;

		case RIGHT_BALANCE:
			if (rightChildCast.getBalanceFactor() != LEFT_BALANCE) {
				result.result = (AVLNode<D>) this.leftRotation();

				if (result.result.getBalanceFactor() == BALANCE) {
					result.result.setBalanceFactor(LEFT_BALANCE);
					AVLNode<D> cast = (AVLNode<D>) result.result.getleftChild();
					cast.setBalanceFactor(RIGHT_BALANCE);
					result.hightDiference = false;
				} else {
					result.result.setBalanceFactor(BALANCE);
					AVLNode<D> cast = (AVLNode<D>) result.result.getleftChild();
					cast.setBalanceFactor(BALANCE);
				}
			} else {
				result.result = (AVLNode<D>) this.rightDoubleRotation();
				if (result.result.getBalanceFactor() == RIGHT_BALANCE) {
					AVLNode<D> cast = (AVLNode<D>) result.result.getleftChild();
					cast.setBalanceFactor(LEFT_BALANCE);
				} else {
					AVLNode<D> cast = (AVLNode<D>) result.result.getleftChild();
					cast.setBalanceFactor(BALANCE);
				}
				if (result.result.getBalanceFactor() == LEFT_BALANCE) {
					AVLNode<D> cast = (AVLNode<D>) result.result.getRightChild();
					cast.setBalanceFactor(RIGHT_BALANCE);
				} else {
					AVLNode<D> cast = (AVLNode<D>) result.result.getRightChild();
					cast.setBalanceFactor(BALANCE);
				}
				result.result.setBalanceFactor(BALANCE);
			}
			break;
		}
	}

	/**
	 * Estructura para retornar la raíz del árbol AVL resultado de un proceso de
	 * modificación, con un indicador de si su altura ha sido modificada.
	 */
	public class Result {
		// -----------------------------------------------------------------
		// Atributos
		// -----------------------------------------------------------------

		/**
		 * Raíz del árbol de respuesta
		 */
		private AVLNode<D> result;

		/**
		 * Indicador de cambio de altura del árbol.
		 */
		private boolean hightDiference;

		// -----------------------------------------------------------------
		// Constructores
		// -----------------------------------------------------------------

		/**
		 * Método constructor de la clase Retorno<br>
		 * <b>post: </b> Se construyó en objeto retorno con los valores
		 * especificados<br>
		 * 
		 * @param result        Raíz del árbol de respuesta
		 * @param highDiference Indicador de cambio de altura del árbol
		 */
		private Result(AVLNode<D> result, boolean highDiference) {
			result = result;
			hightDiference = highDiference;
		}
	}

	@Override
	public ArrayList<Item<Number>> searchValueRange(Number initial, Number finalrange, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Item<Number>> searchValue(Number value, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertABB(Item<D> item) {
		// TODO
		int result = this.entryData.compareTo(item);

		if (result == 0) {
			if (itemsHasSamePlayerAndValue(this.entryData, item)) {
				if (this.rightChild == null) {
					this.rightChild = new Node<>(entryData);
				} else {
					BTSNode<D> cast = (BTSNode<D>) this.rightChild;
					cast.insertABB(item);

				}
			}
		} else if (result > 0) {
			if (this.leftChild == null) {
				this.leftChild = new Node<>(item);
			}else {
				BTSNode<D> cast = (BTSNode<D>) this.leftChild;
				cast.insertABB(item);
			}
		}else {
			
			if(this.rightChild== null) {
				this.rightChild = new Node<>(item);
			}else
			{
				BTSNode<D> cast = (BTSNode<D>) this.rightChild;
				cast.insertABB(item);
			}
		}

	}

	@Override
	public BTSNode<D> removeABB(Item<D> item) throws ItemDoesNotFoundException {
		// TODO test it
		
		int result = this.entryData.compareTo(item);
		
		if(result == 0) {
			if(itemsHasSamePlayerAndValue(this.entryData, item)) {
				if(this.leftChild== null) {
					return (BTSNode<D>) this.rightChild;
				}else if(this.rightChild== null) {
					return (BTSNode<D>) this.leftChild;
				}else {
					item = this.leftChild.getMaximun().getItem();
					BTSNode<D> cast = (BTSNode<D>) this.leftChild;
					this.leftChild = cast.removeABB(item);
				}
			}else {
				if(this.rightChild!= null) {
					BTSNode<D> cast = (BTSNode<D>) this.rightChild;
					cast.removeABB(item);
					return this;
				}else {
					throw new ItemDoesNotFoundException ("item has not found");
				}
			}
		}else if (result>0) {
			if(this.leftChild==null) {
				throw new ItemDoesNotFoundException();
			}else {
				BTSNode<D> cast = (BTSNode<D>) this.leftChild;
				this.leftChild = cast.removeABB(item);
				return this;
			}
		}
		else {
			if(this.rightChild== null) {
				throw new ItemDoesNotFoundException();
			}else {
				BTSNode<D> cast = (BTSNode<D>) this.rightChild;
				this.rightChild = cast.removeABB(item);
				return this;
			}
		}
		return null;
	}

}
