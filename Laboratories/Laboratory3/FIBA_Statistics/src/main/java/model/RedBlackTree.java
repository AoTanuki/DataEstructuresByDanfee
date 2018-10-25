package model;

import java.util.*;

/**
 * 
 */
public class RedBlackTree extends BinarySearchTree {

	/**
	 * This attribute represents the root node of field goals percentage
	 */
	private RedBlackNode<Double> rootFieldGoalsIndex;

	/**
	 * This attribute represents the root node of three points field percentage
	 */
	private RedBlackNode<Double> rootThreePointsIndex;

	/**
	 * Default constructor
	 */
	public RedBlackTree() {
		this.rootFieldGoalsIndex = null;
		this.rootThreePointsIndex = null;
	}

	/**
	 * This method save its corresponding items in itself by a given player. In this
	 * case, will be save free throw percentage and personal fouls of that given
	 * player.
	 * 
	 * @param Player
	 */
	@Override
	public void addPlayersItems(Player player, int txtIndex) {
		// TODO test it

		// star to add the first item.
		Item<Double> fieldGoalsPercentageItem = new Item<Double>(player.getFieldGoalsPercentage(), txtIndex);
		Item<Double> threePointsFieldItem = new Item<Double>(player.getThreePointsFieldPercentage(), txtIndex);

		RedBlackNode<Double> node = (RedBlackNode<Double>) new Node<>(fieldGoalsPercentageItem, RedBlackNode.RED_NODE);
		RedBlackNode<Double> r2 = null;
		// do a normal binary search tree insert but with the root of field goals
		// percentage
		if (this.rootFieldGoalsIndex == null) {

			this.rootFieldGoalsIndex = node;
			this.rootFieldGoalsIndex.setColor(RedBlackNode.BLACK_NODE);
		} else {
			r2 = this.rootFieldGoalsIndex.insert(node);
		}

		this.rootFieldGoalsIndex = r2 != null && r2.getFather() == null ? r2 : this.rootFieldGoalsIndex;

		// finally, do the same but with the root of three points field

		node = (RedBlackNode<Double>) new Node<>(threePointsFieldItem, RedBlackNode.RED_NODE);
		r2 = null;

		if (this.rootThreePointsIndex == null) {

			this.rootThreePointsIndex = node;
			this.rootThreePointsIndex.setColor(RedBlackNode.BLACK_NODE);
		} else {
			r2 = this.rootThreePointsIndex.insert(node);
		}

		this.rootThreePointsIndex = r2 != null && r2.getFather() == null ? r2 : this.rootFieldGoalsIndex;
	}

	/**
	 * this method remove a player's index asociate to this player.
	 * @param SearchedPlayer is the player that will be added
	 * @throws EmptyTreeException it appears when the tree is empty in any root.
	 * @throws ItemDoesNotFoundException  it appears when an item would'n founded.
	 */
	@Override
	public void removePlayer(Player searchedPlayer, int txtIndex) throws EmptyTreeException, ItemDoesNotFoundException {

		// TODO test it
		Item<Double> fieldGoalsPercentageItem = new Item<Double>(searchedPlayer.getFieldGoalsPercentage(), txtIndex);
		Item<Double> threePointsFieldItem = new Item<Double>(searchedPlayer.getThreePointsFieldPercentage(), txtIndex);

		// remove on both roots:
		if (this.rootFieldGoalsIndex == null) {
			throw new EmptyTreeException("The red black tree that contains field goals percentage index is empty");
		}
		
		if (this.rootFieldGoalsIndex.itemsHasSamePlayerAndValue(this.rootFieldGoalsIndex.getItem(), fieldGoalsPercentageItem)
				&& this.rootFieldGoalsIndex.rightSonLeaf() && this.rootFieldGoalsIndex.leftSonLeaf()) {
			
				this.rootFieldGoalsIndex = null;
			
		} 
		else {
			RedBlackNode<Double> cast = (RedBlackNode<Double>) this.rootFieldGoalsIndex.getNodeWithEqualsValuesAndSamePlayer(fieldGoalsPercentageItem);
			RedBlackNode<Double> r2 = cast.removeRB();
			this.rootFieldGoalsIndex = r2!=null && r2.getFather()==null? r2:this.rootFieldGoalsIndex;
		}
		
		//remove on the three points field root ---------------------------------------------------------------------------------------------------
		if (this.rootThreePointsIndex == null) {
			throw new EmptyTreeException("The red black tree that contains three point field goals percentage index is empty");
		}
		
		if (this.rootThreePointsIndex.itemsHasSamePlayerAndValue(this.rootThreePointsIndex.getItem(), threePointsFieldItem)
				&& this.rootThreePointsIndex.rightSonLeaf() && this.rootThreePointsIndex.leftSonLeaf()) {
			
				this.rootThreePointsIndex = null;
			
		} 
		else {
			RedBlackNode<Double> cast = (RedBlackNode<Double>) this.rootThreePointsIndex.getNodeWithEqualsValuesAndSamePlayer(threePointsFieldItem);
			RedBlackNode<Double> r2 = cast.removeRB();
			this.rootThreePointsIndex = r2!=null && r2.getFather()==null? r2:this.rootThreePointsIndex;
		}
		
	}

}