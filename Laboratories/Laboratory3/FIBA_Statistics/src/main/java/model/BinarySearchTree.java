package model;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class BinarySearchTree implements Serializable{

	/**
	 * This attribute represents the root node.
	 */
	private BTSNode<Float> root;
	
    /**
     * This attribute represents the size of this tree.
     */
    private int size;

    /**
     * This attribute represents the node that contains the maximun value for the tree.
     */
    private Node<Number> maxNode;

    /**
     * This attribute represents the node that contains the minimun value for the tree.
     */
    private Node<Number> minNode;


    /**
     * This method save its corresponding items in itself by a given player. In this case, will be save  the field goals percentage, three point percentage, free throw percentage, personal fouls and the name of that given player.
     * @param player Player
     */
    public void addPlayersItems(Player player) {
        // TODO implement here
    }

    /**
     * This method searchs for all items that meet the range criteria and returns an arraylist with all of this items. 
     * 
     * If there are  any item with that satisface this criteria that arraylist will be empty.
     * @param initialRange 
     * @param finalRange 
     * @param itemType 
     * @return
     */
    public ArrayList<Item<Number>> searchRange(Number initialRange, Number finalRange, int itemType) {
        // TODO implement here
        return null;
    }

    /**
     * This method searchs for all items that meet the criteria and returns an arraylist with all of this items. 
     * 
     * If there are  any item with that satisface this criteria that arraylist will be empty.
     * @param value 
     * @param ItemType 
     * @return
     */
    public ArrayList<Item<Number>> searchValue(Number value, int ItemType) {
        // TODO implement here
        return null;
    }

    /**
     * This method allows to modify a value on this tree by another given value. But, this need to especify which player has this change and what attribute will be changed
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
     * @param searchedPlayer 
     * @return
     */
    public boolean removePlayer(Player searchedPlayer) {
        // TODO implement here
        return false;
    }

    /**
     * This method evaluate if this tree is empty
     * @return
     */
    public boolean isEmpty() {
        // TODO implement here
        return false;
    }

    /**
     * This method returns
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