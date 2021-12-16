public class ResourceSheet {
	
	private int health;
	private int energy;
	private int sanity;
	private int level;
	private int experience = 0;
	
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
	}
	
	public void setHealth(int a) {
		health = a;
	}
	
	public int getEnergy() {
		return health;
	}
	
	public void addEnergy(int a) {
		energy += a;
		if (energy > 100)
			energy = 100;
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

}