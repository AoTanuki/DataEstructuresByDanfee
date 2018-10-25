package model;
import java.util.*;

/**
 * 
 */
public class AVLTree extends BinarySearchTree {

	/**
	 * This attribute represents the root node of free throw percentage
	 */
	private AVLNode<Double> rootFreeThrowPercentageIndex;

	/**
	 * This attribute represents the root node of personal
	 */
	private AVLNode<Integer> rootPersonalFoulIndex;
	
	/**
	 * This attribute represents the Weight of this tree.
	 */
	private int weight;
	
    /**
     * Default constructor
     */
    public AVLTree() {
    	
    	this.rootFreeThrowPercentageIndex = null;
    	this.rootPersonalFoulIndex = null;
    	this.weight = 0;
    }

    /**
     * This method save its corresponding items in itself by a given player. In this case, will be save  the field goals percentage and three point percentage of that given player.
     * @param player
     * @throws Exception 
     */
    @Override
    public void addPlayersItems(Player player,int txtIndex) throws Exception {
        // TODO test it
    	Item<Double> freeThrowItem =new Item<Double>(player.getFreeThrowPercentage(), txtIndex);
    	Item<Integer> personalFoulsItem = new Item<Integer>(player.getPersonalFouls(), txtIndex);
    	
    	//insert free throw percentage item:
    	if(this.rootFreeThrowPercentageIndex==null) {
    		this.rootFreeThrowPercentageIndex = new Node<>(freeThrowItem);
    	}
    	
    	else {
    		this.rootFreeThrowPercentageIndex = this.rootFreeThrowPercentageIndex.insertAVL(freeThrowItem);
    	}
    	
    	//Insert personal fouls item:
    	if(this.rootPersonalFoulIndex == null) {
    		this.rootPersonalFoulIndex = new Node<>(personalFoulsItem);
    	}else {
    		this.rootPersonalFoulIndex = this.rootPersonalFoulIndex.insertAVL(personalFoulsItem);
    	}
    	this.weight++;
    }



    /**
     * @param SearchedPlayer
     * @throws ItemDoesNotFoundException 
     */
    @Override
    public void removePlayer(Player searchedPlayer, int txtIndex) throws ItemDoesNotFoundException {
    	Item<Double> freeThrowItem =new Item<Double>(searchedPlayer.getFreeThrowPercentage(), txtIndex);
    	Item<Integer> personalFoulsItem = new Item<Integer>(searchedPlayer.getPersonalFouls(), txtIndex);
    	
    	//remove freeThrow percentage:
    	if(this.rootFreeThrowPercentageIndex==null) {
    		this.rootFreeThrowPercentageIndex = this.rootFreeThrowPercentageIndex.removeAVL(freeThrowItem);
    	}else {
    		throw new ItemDoesNotFoundException("A item has not found");
    	}
    	
    	//remove personal fouls:
    	if(this.rootPersonalFoulIndex ==null) {
    		this.rootPersonalFoulIndex = this.rootPersonalFoulIndex.removeAVL(personalFoulsItem);
    	}else {
    		throw new ItemDoesNotFoundException("A item has not founded");
    	}
    }

}