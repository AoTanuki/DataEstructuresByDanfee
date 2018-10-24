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

import com.sun.javafx.geom.transform.TransformHelper;

public class FIBA {

	/**
	 * This method indicate what is the lastest index added. and is a value added in
	 * my players added hash map. just to confort jues jues jues.
	 */
	private static String LASTEST_INDEX_ADDED = "memory";

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
	 * This constant indicate the URL of available index queue .obj
	 */
	private static final String QUEUE_OBJECT_PATH = "./data/config/availableIndexs.obj";

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
	 * this queue indicates what txt index are available to reuse.
	 */
	private Queue<Integer> availableIndexs;

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
	 * @param textURL  is the path to the file
	 * @param textType define what kind of file will be readed.
	 * @return return a string with the especify of success of the process.
	 * @throws IOException
	 * @throws PlayerAlredyAddedException this exception apears when a player is
	 *                                    already added.
	 */
	public String readInformation(String textURL, char textType) throws IOException {
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
			} catch (PlayerAlredyAddedException e) {
				if (result.equals("All players has added correctly")) {
					result = e.getMessage();
				} else {
					result += ", and " + e.getMessage();
				}
			}

			message = bf.readLine();
		}

		bf.close();
		return result;
	}

	/**
	 * this method reads all information of a just one new player and added to the
	 * system.
	 * 
	 * @param name               is the name of the player.
	 * @param gender             is the gender of the player .
	 * @param age                is the age of the player.
	 * @param gamesPlayed        is how games this player has played.
	 * @param minutesPlayed      is how minutes this player has played.
	 * @param fgpercentage       is the field goals percentage of this player.
	 * @param tpfpercentage      is the three points field percentage of this
	 *                           player.
	 * @param ftpecerntage       is the free throw percentage of this player.
	 * @param personalFouls      is how many personal fouls this player has.
	 * @param piestimate         is the player impact estimate of this player.
	 * @param orpercentage       is the offensive rebound percentage of this player.
	 * @param turnoverPercentage is the turnover percentage of this player.
	 * @return return a string with the especify of success of the process.
	 * @throws IOException
	 */
	public String readInformation(String name, char gender, int age, int gamesPlayed, double minutesPlayed,
			double fgpercentage, double tpfpercentage, double ftpecerntage, int personalFouls, double piestimate,
			double orpercentage, double turnoverPercentage) {
		// TODO test it
		String result = "All players has added correctly";

		Player player = new Player(name, gender, age, gamesPlayed, minutesPlayed, fgpercentage, tpfpercentage,
				ftpecerntage, personalFouls, piestimate, orpercentage, turnoverPercentage);

		try {
			addPlayer(player);
		} catch (PlayerAlredyAddedException e) {
			result = e.getMessage();
		} catch (IOException e) {
			result = "the operation has been interrumpted by an unknown error";
			e.printStackTrace();
		}
		return result;
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

			// get new index to txt file
			int newIndex = 0;
			// if there are availables indexs the system will use this.
			if (!this.availableIndexs.isEmpty()) {
				newIndex = this.availableIndexs.poll();
			}
			// else use a new index
			else {

				if (playersAdded.containsKey(LASTEST_INDEX_ADDED)) {
					newIndex = playersAdded.get(LASTEST_INDEX_ADDED);
					playersAdded.put(LASTEST_INDEX_ADDED, playersAdded.get(LASTEST_INDEX_ADDED) + 1);
				} else {
					playersAdded.put(LASTEST_INDEX_ADDED, 0);
				}
			}

			// add the player to the system
			playersAdded.put(player.getName(), newIndex);
			// save player to be persistent.
			savePlayer(player, newIndex);

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
	 * this method remove a player on the system.
	 * 
	 * @param the name of the playar that would be removed.
	 * @return the result of the process.
	 */
	public String removePlayer(String name) {
		// TODO implement here
		String result = "the player " + name + " has been eliminate correctly";

		// exception

		// verify if the player is already added
		if (playersAdded.containsKey(name)) {
			// get the player
			Player player = null;
			try {
				player = getPlayer(playersAdded.get(name));
			} catch (IOException e) {
				result = " has appears an uknown error";
				e.printStackTrace();
			}
			// save index of this player
			this.availableIndexs.add(playersAdded.get(name));
			// remove its reference in the players added.
			this.playersAdded.remove(name);

			// TODO correct this method to support all exception in all tree remove's
			// finally, remove for all trees.
			this.AVlTree.removePlayer(player);
			this.BTSTree.removePlayer(player);
			this.RBTree.removePlayer(player);

		} else {
			result = "the player " + name + " does not finded in our system";
		}
		return result;
	}

	/**
	 * This methodo change a attribute of a given player
	 * 
	 * @param playerName        the name of the player that this method will change
	 * @param attributeToChange the attribute that will change. Player class
	 *                          contains all constant that refer which attribute.
	 * @param newValue          this is the new value for that atribute.
	 */
	public String modifyPlayerAttribute(String playerName, String attributeToChange, String newValue) {
		// TODO test it

		String result = "Done";
		// if the player is added so we proced to evaluate what is the attribute to
		// change
		if (playersAdded.containsKey(playerName)) {

			// To do that change we follow the next algorithm:
			// 1) get that player by her/his file
			Player player = null;
			try {
				player = getPlayer(playersAdded.get(playerName));
			} catch (IOException e) {
				result = "an IOException impeded to done that change";
				e.printStackTrace();
			}
			// 2) change that attribute:

			switch (attributeToChange) {
			case Player.CHANGE_NAME:
				player.setName(newValue);
				break;
			case Player.CHANGE_GENDER:

				player.setGender(newValue.charAt(0));
				break;
			case Player.CHANGE_AGE:
				player.setAge(Integer.parseInt(newValue));
				break;
			case Player.CHANGE_GAMES_PLAYED:
				player.setGamesPlayed(Integer.parseInt(newValue));
				break;
			case Player.CHANGE_MINUTES_PLAYED:
				player.setMinutesPlayed(Double.parseDouble(newValue));
				break;
			case Player.CHANGE_FIELD_GOALS_PERCENTAGE:
				player.setFieldGoalsPercentage(Double.parseDouble(newValue));
				break;
			case Player.CHANGE_THREE_THROW_PERCENTAGE:
				player.setThreePointsFieldPercentage(Double.parseDouble(newValue));
				break;
			case Player.CHANGE_FREE_THROW_PERCENTAGE:
				player.setFreeThrowPercentage(Double.parseDouble(newValue));
				break;
			case Player.CHANGE_PERSONAL_FOULS:
				player.setPersonalFouls(Integer.parseInt(newValue));
				break;
			case Player.CHANGE_PLAYER_IMPACT_ESTIMATE:
				player.setPlayerImpactEstimate(Double.parseDouble(newValue));
				break;
			case Player.CHANGE_OFFENSIVE_REBOUND_PERCENTAGE:
				player.setOffensiveReboundPercentage(Double.parseDouble(newValue));
				break;
			case Player.CHANGE_TURNOVER_PERCENTAGE:
				player.setTurnoverPercentage(Double.parseDouble(newValue));
				break;
			}

			// if the attribute to change is a stadistic index, we will follow this change
			// in the trees. Depending, of course, what tree contains that.

			// if attributes to chage are the field goals percentage or three throw
			// percentage. Then, we continue to use the modify in the red black tree and
			// bts.
			if (attributeToChange.equals(Player.CHANGE_FIELD_GOALS_PERCENTAGE)
					|| attributeToChange.equals(Player.CHANGE_THREE_THROW_PERCENTAGE)) {

				switch (attributeToChange) {
				case Player.CHANGE_FIELD_GOALS_PERCENTAGE:

					this.RBTree.modifyValue(player, newValue, RedBlackNode.FIELD_GOALS_PERCENTAGE);
					this.BTSTree.modifyValue(player, newValue, BTSNode.FIELD_GOALS_PERCENTAGE);
					break;

				case Player.CHANGE_THREE_THROW_PERCENTAGE:

					this.RBTree.modifyValue(player, newValue, RedBlackNode.THREE_POINT_FIELD_GOALS_PERCENTAGE);
					this.BTSTree.modifyValue(player, newValue, BTSNode.THREE_POINT_FIELD_GOALS_PERCENTAGE);
					break;
				}
			}

			// Otherwise, if the attribute are free throw percentage or personal fouls we
			// will modify AVL tree, and, again, bts tree.
			else if (attributeToChange.equals(Player.CHANGE_FREE_THROW_PERCENTAGE)
					|| attributeToChange.equals(Player.CHANGE_PERSONAL_FOULS)) {

				switch (attributeToChange) {
				case Player.CHANGE_FREE_THROW_PERCENTAGE:

					this.AVlTree.modifyValue(player, newValue, AVLNode.FREE_THROW_PERCENTAGE);
					this.BTSTree.modifyValue(player, newValue, BTSNode.FREE_THROW_PERCENTAGE);
					break;

				case Player.CHANGE_PERSONAL_FOULS:

					this.AVlTree.modifyValue(player, newValue, AVLNode.PERSONAL_FOULS);
					this.BTSTree.modifyValue(player, newValue, BTSNode.PERSONAL_FOULS);
					break;
				}

			}
			// Whether at this point all has been alright: We, finally, continue saving this
			// change in her/his corresponding txt file.
			try {
				savePlayer(player, playersAdded.get(playerName));
			} catch (IOException e) {
				result = "an IOException impeded to done that change";
				e.printStackTrace();
			}

		}
		// Otherwise, result will indicate that the process did not can possible.
		else {
			result = "Player does not are added";
		}

		return result;
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
		// initialize queue with availabe indexs
		ObjectInputStream queueReader = new ObjectInputStream(new FileInputStream(QUEUE_OBJECT_PATH));
		this.availableIndexs = (Queue<Integer>) queueReader.readObject();
		queueReader.close();

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
		// save available indexs
		ObjectOutputStream queueSaver = new ObjectOutputStream(new FileOutputStream(QUEUE_OBJECT_PATH));
		queueSaver.writeObject(this.availableIndexs);
		queueSaver.close();
	}

}