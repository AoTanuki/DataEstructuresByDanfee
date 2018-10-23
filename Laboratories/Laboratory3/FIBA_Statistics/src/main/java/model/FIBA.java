package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class FIBA {

	/**
	 * this constant is used to define that given file contains all player's
	 * attributes by commas.
	 */
	public static final char CSV_FILE = 'C';

	/**
	 * this constant is used to define that given file contains all player's
	 * attributes by spaces. 
	 */
	public static final char SEPARATE_BY_SPACES = 'C';

	/**
	 * This constant indicate the url of hashmap's .obj
	 */
	private static final String PLAYERS_ADDED_OBJECT_PATH = "./data/config/PlayersAdded.obj";
	
	/**
	 * This constant indicate the url of binary tree search's .obj
	 */
	private static final String BTS_OBJECT_PATH = "./data/config/BTS.obj";
	
	/**
	 * This constant indicate the url of avl tree's .obj
	 */
	private static final String AVL_OBJECT_PATH = "./data/config/AVL.obj";
	
	/**
	 * This constant indicate the URL of red black tree's .obj
	 */
	private static final String RBT_OBJECT_PATH = "./data/config/RBT.obj";
	
	/**
	 * This map contains all players added on the program.
	 */
	private HashMap<String, Integer> playersAdded;

	/**
	 * This is the binary search tree no balanced
	 */
	private BinarySearchTree BTSTree;

	/**
	 * This is the AVL tree
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
	public Player readInformation(int name, char gender, int age, int gamesPlayed, double minutesPlayed,
			double fgpercentage, double tpfpercentage, double ftpecerntage, int personalFouls, double piestimate,
			double orpercentage, double turnoverPercentage) {
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
	public ArrayList<Item<Number>> searchIntervalValues(boolean defaultSearch, Number initialValue, Number finalValue,
			int itemType) {
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
	 * This method initializes the classes with their corresponding .obj files
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	public void persistenceOn() throws FileNotFoundException, IOException, ClassNotFoundException {
		//TODO test it
		//initialize players added:
		ObjectInputStream hashMapReader = new ObjectInputStream(new FileInputStream(PLAYERS_ADDED_OBJECT_PATH));
		this.playersAdded = (HashMap<String,Integer>) hashMapReader.readObject();
		hashMapReader.close();
		//initialize bts tree:
		ObjectInputStream btsReader = new ObjectInputStream(new FileInputStream(BTS_OBJECT_PATH));
		this.BTSTree = (BinarySearchTree) btsReader.readObject();
		btsReader.close();
		//initialize avl tree:
		ObjectInputStream avlReader = new ObjectInputStream(new FileInputStream(AVL_OBJECT_PATH));
		this.AVlTree = (AVLTree) avlReader.readObject();
		avlReader.close();
		//initialize red black tree:
		ObjectInputStream rbReader = new ObjectInputStream(new FileInputStream(RBT_OBJECT_PATH));
		this.RBTree = (RedBlackTree) rbReader.readObject();
		rbReader.close();
	}

	/**
	 * this method save all data added in the program.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void persistenceOff() throws FileNotFoundException, IOException {
		//TODO test it
		// save all players added in the hashmap:
		ObjectOutputStream hashMapSaver = new ObjectOutputStream(new FileOutputStream(PLAYERS_ADDED_OBJECT_PATH));
		hashMapSaver.writeObject(this.playersAdded);
		hashMapSaver.close();
		//save bts tree
		ObjectOutputStream BTSSaver = new ObjectOutputStream(new FileOutputStream(BTS_OBJECT_PATH));
		BTSSaver.writeObject(this.BTSTree);
		BTSSaver.close();
		//save avl tree
		ObjectOutputStream AVLSaver = new ObjectOutputStream(new FileOutputStream(AVL_OBJECT_PATH));
		AVLSaver.writeObject(this.AVlTree);
		AVLSaver.close();
		//save rb tree
		ObjectOutputStream RBSaver = new ObjectOutputStream(new FileOutputStream(PLAYERS_ADDED_OBJECT_PATH));
		RBSaver.writeObject(this.RBTree);
		RBSaver.close();
	}

}