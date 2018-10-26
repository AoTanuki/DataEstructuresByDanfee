package model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 
 */
public class BinarySearchTree implements Serializable {

	/**
	 * This attribute represents the root node of field goals percentage
	 */
	private BTSNode<Double> rootFieldGoalsIndex;

	/**
	 * This attribute represents the root node of three points field percentage
	 */
	private BTSNode<Double> rootThreePointsIndex;

	/**
	 * This attribute represents the root node of free throw percentage
	 */
	private BTSNode<Double> rootFreeThrowPercentageIndex;

	/**
	 * This attribute represents the root node of personal
	 */
	private BTSNode<Integer> rootPersonalFoulIndex;

	/**
	 * This attribute represents the size of this tree.
	 */
	private int size;

	/**
	 * This attribute represents the node that contains the maximun value for the
	 * tree.
	 */
	private Node<Number> maxNode;

	/**
	 * This attribute represents the node that contains the minimun value for the
	 * tree.
	 */
	private Node<Number> minNode;

	/**
	 * This method save its corresponding items in itself by a given player. In this
	 * case, will be save the field goals percentage, three point percentage, free
	 * throw percentage, personal fouls and the name of that given player.
	 * 
	 * @param player Player
	 * @throws Exception
	 */
	public void addPlayersItems(Player player, int txtIndex) throws Exception {
		// TODO test it

		Item<Double> fieldGoalsItem = new Item<Double>(player.getFieldGoalsPercentage(), txtIndex);
		Item<Double> threePointItem = new Item<Double>(player.getThreePointsFieldPercentage(), txtIndex);
		Item<Double> freeThrowItem = new Item<Double>(player.getFreeThrowPercentage(), txtIndex);
		Item<Integer> personalFoulItem = new Item<Integer>(player.getPersonalFouls(), txtIndex);

		// 1)
		if (this.rootFieldGoalsIndex == null) {
			this.rootFieldGoalsIndex = new Node<>(fieldGoalsItem);
		} else {
			this.rootFieldGoalsIndex.insertABB(fieldGoalsItem);
		}

		// 2
		if (this.rootFreeThrowPercentageIndex == null) {
			this.rootFreeThrowPercentageIndex = new Node<>(freeThrowItem);
		} else {
			this.rootFreeThrowPercentageIndex.insertABB(freeThrowItem);
		}

		// 3
		if (this.rootPersonalFoulIndex == null) {
			this.rootPersonalFoulIndex = new Node<>(personalFoulItem);
		} else {
			this.rootPersonalFoulIndex.insertABB(personalFoulItem);
		}

		// 4
		if (this.rootThreePointsIndex == null) {
			this.rootThreePointsIndex = new Node<>(threePointItem);
		} else {
			this.rootThreePointsIndex.insertABB(threePointItem);
		}

	}

	/**
	 * This method searchs for all items that meet the range criteria and returns an
	 * arraylist with all of this items.
	 * 
	 * If there are any item with that satisface this criteria that arraylist will
	 * be empty.
	 * 
	 * @param initialRange
	 * @param finalRange
	 * @param itemType
	 * @return
	 */
	public ArrayList<Item<Number>> searchRange(Number initialRange, Number finalRange, int itemType) {
		// TODO test it
		ArrayList<Item<Number>> result = new ArrayList<>();

		switch (itemType) {
		case BTSNode.FIELD_GOALS_PERCENTAGE:

			result = this.rootFieldGoalsIndex.searchValueRange(initialRange,finalRange, BTSNode.FIELD_GOALS_PERCENTAGE);
			break;

		case BTSNode.THREE_POINT_FIELD_GOALS_PERCENTAGE:
			result = this.rootThreePointsIndex.searchValueRange(initialRange,finalRange, BTSNode.THREE_POINT_FIELD_GOALS_PERCENTAGE);
			break;

		case BTSNode.FREE_THROW_PERCENTAGE:
			result = this.rootFreeThrowPercentageIndex.searchValueRange(initialRange,finalRange, BTSNode.FREE_THROW_PERCENTAGE);
			break;

		case BTSNode.PERSONAL_FOULS:
			result = this.rootFreeThrowPercentageIndex.searchValueRange(initialRange,finalRange, BTSNode.PERSONAL_FOULS);
			break;
		}

		return result;

		
	}

	/**
	 * This method searchs for all items that meet the criteria and returns an
	 * arraylist with all of this items.
	 * 
	 * If there are any item with that satisface this criteria that arraylist will
	 * be empty.
	 * 
	 * @param value
	 * @param ItemType
	 * @return
	 */
	public ArrayList<Item<Number>> searchValue(Number value, int itemType) {
		// TODO test it
		ArrayList<Item<Number>> result = new ArrayList<>();

		switch (itemType) {
		case BTSNode.FIELD_GOALS_PERCENTAGE:

			result = this.rootFieldGoalsIndex.searchValue(value, BTSNode.FIELD_GOALS_PERCENTAGE);
			break;

		case BTSNode.THREE_POINT_FIELD_GOALS_PERCENTAGE:
			result = this.rootThreePointsIndex.searchValue(value, BTSNode.THREE_POINT_FIELD_GOALS_PERCENTAGE);
			break;

		case BTSNode.FREE_THROW_PERCENTAGE:
			result = this.rootFreeThrowPercentageIndex.searchValue(value, BTSNode.FREE_THROW_PERCENTAGE);
			break;

		case BTSNode.PERSONAL_FOULS:
			result = this.rootFreeThrowPercentageIndex.searchValue(value, BTSNode.PERSONAL_FOULS);
			break;
		}

		return result;
	}

	/**
	 * This method allows to modify a value on this tree by another given value.
	 * But, this need to especify which player has this change and what attribute
	 * will be changed
	 * 
	 * @param searchedPlayer
	 * @param newValue
	 * @param itemType
	 * @return
	 */
	public boolean modifyValue(Player searchedPlayer, String newValue, int itemType) {
		// TODO implement here
		return false;
	}

	/**
	 * This method remove the item of a player in all type of node.
	 * 
	 * @param searchedPlayer
	 * @return
	 */
	public void removePlayer(Player player, int txtIndex) throws EmptyTreeException, ItemDoesNotFoundException {
		// TODO test it
		Item<Double> fieldGoalsItem = new Item<Double>(player.getFieldGoalsPercentage(), txtIndex);
		Item<Double> threePointItem = new Item<Double>(player.getThreePointsFieldPercentage(), txtIndex);
		Item<Double> freeThrowItem = new Item<Double>(player.getFreeThrowPercentage(), txtIndex);
		Item<Integer> personalFoulItem = new Item<Integer>(player.getPersonalFouls(), txtIndex);

		// 1
		if (this.rootFieldGoalsIndex != null) {
			this.rootFieldGoalsIndex = this.rootFieldGoalsIndex.removeABB(fieldGoalsItem);
		} else {
			throw new EmptyTreeException("this tree is empty");
		}
		// 2
		if (this.rootThreePointsIndex != null) {
			this.rootThreePointsIndex = this.rootThreePointsIndex.removeABB(threePointItem);
		} else {
			throw new EmptyTreeException("this tree is empty");
		}

		// 3
		if (this.rootFreeThrowPercentageIndex != null) {
			this.rootFreeThrowPercentageIndex = this.rootFreeThrowPercentageIndex.removeABB(freeThrowItem);
		} else {
			throw new EmptyTreeException("this tree is empty");
		}

		// 4
		if (this.rootPersonalFoulIndex != null) {
			this.rootPersonalFoulIndex = this.rootPersonalFoulIndex.removeABB(personalFoulItem);
		} else {
			throw new EmptyTreeException("this tree is empty");
		}

	}

	/**
	 * This method evaluate if this tree is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		// TODO implement here
		return false;
	}

	/**
	 * This method returns
	 * 
	 * @return
	 */
	public Item<Number> getMaxValue() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public Item<Number> getMinValue() {
		// TODO implement here
		return null;
	}

}