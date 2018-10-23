package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
	 * This constant indicate the URL of players data path.
	 */
	private static final String PLAYERS_DATA_SOURCE = "./data/playersSource/";
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
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	public FIBA() throws FileNotFoundException, ClassNotFoundException, IOException {
		persistenceOn();

	}

	/**
	 * this method allows read a file that contains players and add each player to
	 * the system.
	 * 
	 * @param textURL is the path to the file
	 * @param textType define what kind of file will be readed.
	 * @return return a string with the especify of success of the process.
	 * @throws IOException
	 * @throws PlayerAlredyAddedException this exception apears when a player is already added.
	 */
	public String readInformation(String textURL, char textType) throws IOException{
		// TODO test it
		
		String result = "All players has added correctly";
		
		BufferedReader bf = new BufferedReader(new FileReader(textURL));
		String message = bf.readLine();

		
		while (message != null && !message.isEmpty()) {
			String name = "";
			char gender = ' ';
			int age = 0;
			int gamesPlayed = 0;
			double minutesPlayed = 0;
			double fieldGoalsPercentage = 0;
			double threePointsFieldPercentage = 0;
			double freeThrowPercentage = 0;
			int personalFouls = 0;
			double playerImpactEstimate = 0;
			double offensiveReboundPercentage = 0;
			double turnoverPercentage = 0;

			// save all player's data readed on a line.

			// If the file has an csv extension do all normal with an array of string given
			// by split the message by commas.
			if (textType == CSV_FILE) {
				String[] playersData = message.split(",");

				name = playersData[0];
				gender = playersData[1].charAt(0);
				age = Integer.parseInt(playersData[2]);
				gamesPlayed = Integer.parseInt(playersData[3]);
				minutesPlayed = Double.parseDouble(playersData[4]);
				fieldGoalsPercentage = Double.parseDouble(playersData[5]);
				threePointsFieldPercentage = Double.parseDouble(playersData[6]);
				freeThrowPercentage = Double.parseDouble(playersData[7]);
				personalFouls = Integer.parseInt(playersData[8]);
				playerImpactEstimate = Double.parseDouble(playersData[9]);
				offensiveReboundPercentage = Double.parseDouble(playersData[10]);
				turnoverPercentage = Double.parseDouble(playersData[11]);

			}

			// save all data but String tokenizer. i dont know, maybe its more effecient.
			else if (textType == SEPARATE_BY_SPACES) {
				StringTokenizer toker = new StringTokenizer(message);
				name = toker.nextToken();
				gender = toker.nextToken().charAt(0);
				age = Integer.parseInt(toker.nextToken());
				gamesPlayed = Integer.parseInt(toker.nextToken());
				minutesPlayed = Double.parseDouble(toker.nextToken());
				fieldGoalsPercentage = Double.parseDouble(toker.nextToken());
				threePointsFieldPercentage = Double.parseDouble(toker.nextToken());
				freeThrowPercentage = Double.parseDouble(toker.nextToken());
				personalFouls = Integer.parseInt(toker.nextToken());
				playerImpactEstimate = Double.parseDouble(toker.nextToken());
				offensiveReboundPercentage = Double.parseDouble(toker.nextToken());
				turnoverPercentage = Double.parseDouble(toker.nextToken());
			}

			// Create a new player.
			Player player = new Player(name, gender, age, gamesPlayed, minutesPlayed, fieldGoalsPercentage,
					threePointsFieldPercentage, freeThrowPercentage, personalFouls, playerImpactEstimate,
					offensiveReboundPercentage, turnoverPercentage);

			// add this new player
			try {
				addPlayer(player);
			}catch (PlayerAlredyAddedException e){
				if(result.equals("All players has added correctly")) {
					result = e.getMessage();
				}else{
					result+= ", and "+e.getMessage();
				}
			}
			
			message = bf.readLine();
		}

		bf.close();
		return result;
	}

	/**
	 * 
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
	 * This method add a player in the system.
	 * 
	 * @param player the new player
	 * @throws PlayerAlredyAddedException
	 * @throws IOException
	 */
	public void addPlayer(Player player) throws PlayerAlredyAddedException, IOException {
		// TODO test it

		if (playersAdded.containsKey(player)) {
			throw new PlayerAlredyAddedException(
					"The player with the name: " + player.getName() + " is already in the system");
		} else {

			// add the player to the system
			playersAdded.put(player.getName(), playersAdded.size() - 1);
			// save player to be persistent.
			savePlayer(player, playersAdded.size() - 1);

			// save all index in the trees.
			this.RBTree.addPlayerItems(player);
			this.AVlTree.addPlayersItems(player);
			this.BTSTree.addPlayersItems(player);

			// TODO consider
			// save persistence
			persistenceOff();
		}
	}

	/**
	 * @return
	 */
	public boolean removePlayer() {
		// TODO implement here
		return false;
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
	 * this method search a player with her/his name.
	 * 
	 * @param name the name of that player
	 * @return the searched player
	 * @throws IOException
	 * @throws PlayerNotFoundException this exception appears when the player does
	 *                                 not appears in the players added.
	 */
	public Player searchPlayer(String name) throws IOException, PlayerNotFoundException {
		// TODO test it
		Player player = null;

		if (playersAdded.containsKey(name)) {
			player = getPlayer(playersAdded.get(name));
		} else {
			throw new PlayerNotFoundException("The player that is called: " + name + " does not found in our system");
		}

		return player;
	}

	/**
	 * @param txtIndex
	 * @return
	 * @throws IOException
	 */
	public Player getPlayer(int txtIndex) throws IOException {
		// TODO test it

		// read file with its corresponding index
		BufferedReader bf = new BufferedReader(new FileReader(PLAYERS_DATA_SOURCE + "player" + txtIndex + ".txt"));
		StringTokenizer toker = new StringTokenizer(bf.readLine());

		// cast all attribute
		String name = toker.nextToken();
		char gender = toker.nextToken().charAt(0);
		int age = Integer.parseInt(toker.nextToken());
		int gamesPlayed = Integer.parseInt(toker.nextToken());
		double minutesPlayed = Double.parseDouble(toker.nextToken());
		double fieldGoalsPercentage = Double.parseDouble(toker.nextToken());
		double threePointsFieldPercentage = Double.parseDouble(toker.nextToken());
		double freeThrowPercentage = Double.parseDouble(toker.nextToken());
		int personalFouls = Integer.parseInt(toker.nextToken());
		double playerImpactEstimate = Double.parseDouble(toker.nextToken());
		double offensiveReboundPercentage = Double.parseDouble(toker.nextToken());
		double turnoverPercentage = Double.parseDouble(toker.nextToken());

		// Create a new player.
		Player player = new Player(name, gender, age, gamesPlayed, minutesPlayed, fieldGoalsPercentage,
				threePointsFieldPercentage, freeThrowPercentage, personalFouls, playerImpactEstimate,
				offensiveReboundPercentage, turnoverPercentage);

		bf.close();
		return player;
	}

	/**
	 * This method create a new txt file with a new player
	 * 
	 * @param player   the new player to be added.
	 * @param txtIndex index of the new file.
	 * @throws IOException
	 */
	public void savePlayer(Player player, int txtIndex) throws IOException {
		// TODO test it

		// create a new file with that index
		BufferedWriter bf = new BufferedWriter(
				new FileWriter(PLAYERS_ADDED_OBJECT_PATH + "player" + txtIndex + ".txt"));
		bf.write(player.savePlayerReport());
		bf.close();
	}

	/**
	 * this method create a report with all players that are referenced in each
	 * items of the given array.
	 * 
	 * @param items an array with items that contains a value and a txt index.
	 * @return an array with the information of all players referenced in previous
	 *         items.
	 * @throws IOException
	 */
	public ArrayList<String> generateReport(ArrayList<Item<Number>> items) throws IOException {
		// TODO test it
		ArrayList<String> report = new ArrayList<>();

		for (int i = 0; i < items.size(); i++) {
			Player player = getPlayer(items.get(i).getTxtIndex());
			report.add(player.toString());
		}
		return report;
	}

	/**
	 * This method initializes the classes with their corresponding .obj files
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void persistenceOn() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO test it
		// initialize players added:
		ObjectInputStream hashMapReader = new ObjectInputStream(new FileInputStream(PLAYERS_ADDED_OBJECT_PATH));
		this.playersAdded = (HashMap<String, Integer>) hashMapReader.readObject();
		hashMapReader.close();
		// initialize bts tree:
		ObjectInputStream btsReader = new ObjectInputStream(new FileInputStream(BTS_OBJECT_PATH));
		this.BTSTree = (BinarySearchTree) btsReader.readObject();
		btsReader.close();
		// initialize avl tree:
		ObjectInputStream avlReader = new ObjectInputStream(new FileInputStream(AVL_OBJECT_PATH));
		this.AVlTree = (AVLTree) avlReader.readObject();
		avlReader.close();
		// initialize red black tree:
		ObjectInputStream rbReader = new ObjectInputStream(new FileInputStream(RBT_OBJECT_PATH));
		this.RBTree = (RedBlackTree) rbReader.readObject();
		rbReader.close();
	}

	/**
	 * this method save all data added in the program.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void persistenceOff() throws FileNotFoundException, IOException {
		// TODO test it
		// save all players added in the hashmap:
		ObjectOutputStream hashMapSaver = new ObjectOutputStream(new FileOutputStream(PLAYERS_ADDED_OBJECT_PATH));
		hashMapSaver.writeObject(this.playersAdded);
		hashMapSaver.close();
		// save bts tree
		ObjectOutputStream BTSSaver = new ObjectOutputStream(new FileOutputStream(BTS_OBJECT_PATH));
		BTSSaver.writeObject(this.BTSTree);
		BTSSaver.close();
		// save avl tree
		ObjectOutputStream AVLSaver = new ObjectOutputStream(new FileOutputStream(AVL_OBJECT_PATH));
		AVLSaver.writeObject(this.AVlTree);
		AVLSaver.close();
		// save rb tree
		ObjectOutputStream RBSaver = new ObjectOutputStream(new FileOutputStream(PLAYERS_ADDED_OBJECT_PATH));
		RBSaver.writeObject(this.RBTree);
		RBSaver.close();
	}

}