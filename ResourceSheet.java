package game;

/* this whole class is basically just getters and setters for the players resources. It's very likely that at least one of these
 * goes completely unutilized.
 * 
 * @Author: Elliot Miller
 * @Version: 1.0
 * @Since: 12-15-21
 */
public class ResourceSheet {
	
	private int health;
	private int energy;
	private int sanity;
	private int level;
	private int experience = 0;
	private String playerPosition = "Start";
	
	public ResourceSheet(Player a) {
		health = 10;
		energy = 100;
		sanity = 100;
		level = 1;
	}

	public int getHealth() {
		return health;
	}
	
	public void addHealth(int a) {
		health += a;
		if (health > 10)
			health = 10;
		ResourceDisplay.updateText();
	}
	
	public void setHealth(int a) {
		health = a;
		ResourceDisplay.updateText();
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
		ResourceDisplay.updateText();
		if (energy <= 0)
			Player.death();
	}
	
	public void setEnergy(int a) {
		energy = a;
		ResourceDisplay.updateText();
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
		ResourceDisplay.updateText();
	}
	
	public void setSanity(int a) {
		sanity = a;
		ResourceDisplay.updateText();
	}
	
	public int getExperience() {
		return experience;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int a) {
		level = a;
		ResourceDisplay.updateText();
	}
	
	public void addExperience(int a) {
		experience += a;
		if (experience >= 10 + (level - 1))
			level++;
		ResourceDisplay.updateText();
	}
	
	public String getPlayerPosition() {
		return playerPosition;
	}
	
	public void setPlayerPosition(String a) {
		playerPosition = a;
	}

}

