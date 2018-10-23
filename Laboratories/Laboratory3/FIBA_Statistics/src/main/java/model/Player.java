package model;

public class Player {

	/**
	 * This constant indicates that user want to change the name of a player
	 */
	static final String CHAGE_NAME = "name";

	/**
	 * This constant indicates that user want to change the gender of a player
	 */
	static final String GENDER	= "gender";
	
	/**
	 * This constant indicates that user want to change the age of a player
	 */
	static final String AGE = "age";
	
	/**
	 * This constant indicates that user want to change the games played of a player
	 */
	static final String GAMES_PLAYED = "age";
	
	/**
	 * This constant indicates that user want to change the minutes played of a player
	 */
	static final String MINUTES_PLAYED = "age";
	
	/**
	 * This constant indicates that user want to change the field goals percentage of a player
	 */
	static final String FIELD_GOALS_PERCENTAGE = "age";
	
	/**
	 * This constant indicates that user want to change the free throw percentage of a player
	 */
	static final String FREE_THROW_PERCENTAGE = "age";
	
	/**
	 * This constant indicates that user want to change personal fouls of a player
	 */
	static final String PERSONAL_FOULS = "age";
	
	/**
	 * This constant indicates that user want to change the three throw percentage of a player
	 */
	static final String THREE_THROW_PERCENTAGE = "age";
	
	/**
	 * This constant indicates that user want to change the player impact estimate of a player
	 */
	static final String PLAYER_IMPACT_ESTIMATE = "age";
	
	/**
	 * This constant indicates that user want to change the offensive rebound percentage of a player
	 */
	static final String OFFENSIVE_REBOUND_PERCENTAGE = "age";
	
	/**
	 * This constant indicates that user want to change the turnover percentage	 of a player
	 */
	static final String TURNOVER_PERCENTAGE = "age";
	
	/**
	 * This attribute represents  the name of this player.
	 */
	private String name;
	
	/**
	 * This attribute represents the gender of this player.
	 */
	private char gender;
	
	/**
	 * This attribute represents the age of this player.
	 */
	private int age;
	
	/**
	 * This attribute represents how many games this player played.
	 */
	private int gamesPlayed;
	
	/**
	 * This attribute represents how many minutes this player played.
	 */
	private double minutesPlayed;
	
	/**
	 * This attribute represents the field goals percentage of this player.
	 */
	private double fieldGoalsPercentage;
	
	/**
	 * This attribute represents  the three points field Percentage of this player.
	 */
	private double threePointsFieldPercentage;
	
	/**
	 * This attribute represents the free throw percentage of this player.
	 */
	private double freeThrowPercentage;
	
	/**
	 * This attribute represents the personal fouls  of this player.
	 */
	private int personalFouls;
	
	/**
	 * This attribute represents the estimate impact of this player.
	 */
	private double playerImpactEstimate;
	
	/**
	 * This attribute represents the offensive rebound percentage of this player.
	 */
	private double offensiveReboundPercentage;
	
	/**
	 * This attribute represents the turnover percentage of this player.
	 */
	private double turnoverPercentage;

	public Player(String name, char gender, int age, int gamesPlayed, double minutesPlayed, double fieldGoalsPercentage,
			double threePointsFieldPercentage, double freeThrowPercentage, int personalFouls,
			double playerImpactEstimate, double offensiveReboundPercentage, double turnoverPercentage) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.gamesPlayed = gamesPlayed;
		this.minutesPlayed = minutesPlayed;
		this.fieldGoalsPercentage = fieldGoalsPercentage;
		this.threePointsFieldPercentage = threePointsFieldPercentage;
		this.freeThrowPercentage = freeThrowPercentage;
		this.personalFouls = personalFouls;
		this.playerImpactEstimate = playerImpactEstimate;
		this.offensiveReboundPercentage = offensiveReboundPercentage;
		this.turnoverPercentage = turnoverPercentage;
	}

	/**
	 * This method returns a String that contains the statistical data ordered by txt order.
	 */
	@Override
	public String toString() {
		return ""+name+" "+ gender+" "+age+" "+gamesPlayed+" "+minutesPlayed+" "+fieldGoalsPercentage+" "+threePointsFieldPercentage
				+" "+freeThrowPercentage+" "+personalFouls+" "+playerImpactEstimate+" "+offensiveReboundPercentage+" "+turnoverPercentage;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the gamesPlayed
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * @return the minutesPlayed
	 */
	public double getMinutesPlayed() {
		return minutesPlayed;
	}

	/**
	 * @return the fieldGoalsPercentage
	 */
	public double getFieldGoalsPercentage() {
		return fieldGoalsPercentage;
	}

	/**
	 * @return the threePointsFieldPercentage
	 */
	public double getThreePointsFieldPercentage() {
		return threePointsFieldPercentage;
	}

	/**
	 * @return the freeThrowPercentage
	 */
	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	/**
	 * @return the personalFouls
	 */
	public int getPersonalFouls() {
		return personalFouls;
	}

	/**
	 * @return the playerImpactEstimate
	 */
	public double getPlayerImpactEstimate() {
		return playerImpactEstimate;
	}

	/**
	 * @return the offensiveReboundPercentage
	 */
	public double getOffensiveReboundPercentage() {
		return offensiveReboundPercentage;
	}

	/**
	 * @return the turnoverPercentage
	 */
	public double getTurnoverPercentage() {
		return turnoverPercentage;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param gamesPlayed the gamesPlayed to set
	 */
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	/**
	 * @param minutesPlayed the minutesPlayed to set
	 */
	public void setMinutesPlayed(double minutesPlayed) {
		this.minutesPlayed = minutesPlayed;
	}

	/**
	 * @param fieldGoalsPercentage the fieldGoalsPercentage to set
	 */
	public void setFieldGoalsPercentage(double fieldGoalsPercentage) {
		this.fieldGoalsPercentage = fieldGoalsPercentage;
	}

	/**
	 * @param threePointsFieldPercentage the threePointsFieldPercentage to set
	 */
	public void setThreePointsFieldPercentage(double threePointsFieldPercentage) {
		this.threePointsFieldPercentage = threePointsFieldPercentage;
	}

	/**
	 * @param freeThrowPercentage the freeThrowPercentage to set
	 */
	public void setFreeThrowPercentage(double freeThrowPercentage) {
		this.freeThrowPercentage = freeThrowPercentage;
	}

	/**
	 * @param personalFouls the personalFouls to set
	 */
	public void setPersonalFouls(int personalFouls) {
		this.personalFouls = personalFouls;
	}

	/**
	 * @param playerImpactEstimate the playerImpactEstimate to set
	 */
	public void setPlayerImpactEstimate(double playerImpactEstimate) {
		this.playerImpactEstimate = playerImpactEstimate;
	}

	/**
	 * @param offensiveReboundPercentage the offensiveReboundPercentage to set
	 */
	public void setOffensiveReboundPercentage(double offensiveReboundPercentage) {
		this.offensiveReboundPercentage = offensiveReboundPercentage;
	}

	/**
	 * @param turnoverPercentage the turnoverPercentage to set
	 */
	public void setTurnoverPercentage(double turnoverPercentage) {
		this.turnoverPercentage = turnoverPercentage;
	}
	
	
	
	
}
