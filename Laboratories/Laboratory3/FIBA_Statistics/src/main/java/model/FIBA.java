package model;


import java.util.*;

/**
 * 
 */
public class FIBA {

    
    /**
     * 
     */
    public static final char CSV_FILE = 'C';

    /**
     * 
     */
    public static final char SEPARATE_BY_SPACES = 'C';

    /**
     * This map contains all players added on the program.
     */
  	private HashMap<String, Integer> playersAdded;
  	
  	/**
  	 * This is the binary search tree no balanced
  	 */
  	private BinarySearchTree BTSTree;
  	
  	/**
  	 *This is the AVL tree 
  	 */
  	private AVLTree AVlTree;
  	
  	/**
  	 * This is the red black tree
  	 */
  	private RedBlackTree RBTree;
  	
  	
  	/**
     * Default constructor
     */
    public FIBA() {
    	
    }


    /**
     * @param textFile 
     * @param textType
     */
    public void readInformation(String textFile, char textType) {
        // TODO implement here
    }

    /**
     * @param name 
     * @param gender 
     * @param age 
     * @param gamesPlayed 
     * @param minutesPlayed 
     * @param fgpercentage 
     * @param tpfpercentage 
     * @param ftpecerntage 
     * @param personalFouls 
     * @param piestimate 
     * @param orpercentage 
     * @param turnoverPercentage 
     * @return
     */
    public Player readInformation(int name, char gender, int age, int gamesPlayed, double minutesPlayed, double fgpercentage, double tpfpercentage, double ftpecerntage, int personalFouls, double piestimate, double orpercentage, double turnoverPercentage) {
        // TODO implement here
        return null;
    }

    /**
     * @param player 
     * @return
     */
    public boolean addPlayer(Player player) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @return
     */
    public Player searchPlayer(String name) {
        // TODO implement here
        return null;
    }

    /**
     * @param playerName 
     * @param attributeToChange 
     * @param newValue
     */
    public void modifyPlayer(String playerName, String attributeToChange, Object newValue) {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean removePlayer() {
        // TODO implement here
        return false;
    }

    /**
     * @param defaultSearch 
     * @param initialValue 
     * @param finalValue 
     * @param itemType 
     * @return
     */
    public ArrayList<Item<Number>> searchIntervalValues(boolean defaultSearch, Number initialValue, Number finalValue, int itemType) {
        // TODO implement here
        return null;
    }

    /**
     * @param defaultSearch 
     * @param value 
     * @param itemType 
     * @return
     */
    public ArrayList<Item<Number>> searchValue(boolean defaultSearch, Number value, int itemType) {
        // TODO implement here
        return null;
    }

    /**
     * @param txtIndex 
     * @return
     */
    public Player getPlayer(int txtIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param items 
     * @return
     */
    public ArrayList<String> generateReport(ArrayList<Item<Number>> items) {
        // TODO implement here
        return null;
    }

    /**
     * @param File
     */
    public void readObjects(String File) {
        // TODO implement here
    }

    /**
     * @param File
     */
    public void writeObjects(String File) {
        // TODO implement here
    }

    /**
     * 
     */
    public void persistenceOn() {
        // TODO implement here
    }

    /**
     * 
     */
    public void persistenceOff() {
        // TODO implement here
    }

}