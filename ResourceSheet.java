package game;


public class ResourceSheet {
	
	/** 
	 * The ResourceSheet class contains getters and setters for the players resources. 
	 * This is no longer in use for the most part. This was made when the game was being taken in a different, more survival oriented direction.
	 * 
	 * @Author: Elliot Miller
	 * @Version: 1.0
	 * @Since: 2021-12-15
	 */	
	
	private double health;
	private int energy;
	private int sanity;
	private int level;
	private int experience = 0;
	private char playerPosition = 'S';
	//S = start, H = house/shack, T = town/village/settlement, C = caves
	public ResourceSheet(Player a) {
		health = 10;
		energy = 100;
		sanity = 100;
		level = 1;
	}

	public double getHealth() {
		return health;
	}
	
	public void addHealth(double a) {
		health += a;
		if (health > 10)
			health = 10;
	}
	
	public void setHealth(double a) {
		health = a;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void addEnergy(int a) {
		energy += a;
		if (energy > 100)
			energy = 100;
		else if (energy < 0)
			energy = 0;
		if (energy <= 0)
			Player.death();
	}
	
	public void setEnergy(int a) {
		energy = a;
	}
	
	public int getSanity() {
		return sanity;
	}
	
	public void addSanity(int a) {
		sanity += a;
		if (sanity > 100)
			sanity = 100;
		else if (sanity < 0)
			sanity = 0;
	}
	
	public void setSanity(int a) {
		sanity = a;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int a) {
		level = a;
	}
	
	public void addExperience(int a) {
		experience += a;
		if (experience >= 10 + (level - 1))
			level++;
	}
	
	public char getPlayerPosition() {
		return playerPosition;
	}
	
	public void setPlayerPosition(char a) {
		playerPosition = a;
	}

}
