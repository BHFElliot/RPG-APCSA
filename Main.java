

/* This class kickstarts the game.
 * 
 * @Author: Elliot Miller
 * @Version: 1.0
 * @Since: 12-15-21
 */
public class Main {

	static Scanner in = new Scanner(System.in);
	//player and statsheets
	public static Player player;
	public static ResourceSheet playerSheet;
	
	public static void main(String[] args) {
		player = characterCreate();
		playerSheet = new ResourceSheet(player);	
		new ResourceDisplay();
		Intro.backStory();
		//Settlement.begin();
	}
	
	//asks the player if they want to make a custom character.
	public static Player characterCreate() {
		Printers.messageWindow("Welcome to spelunk! This is a text-based choose your own adventure style game."
				+ "\nThe game's mechanics are very simple. Whenever you're presented with a choice, a window will pop up showing your options."
				+ "\nA resource window will also appear displaying your character's sanity, health, name, and gender.", null);
		
		if(Printers.optionDialog("Would you like an explanation\nof the sanity system?", null, 2, null) == 0) 
			sanityExplanation();
		
		switch (Printers.optionDialog("Would you like to create a character?\nDefault values will be assigned\nto your character if not.", null, 2, null)) {
		case 0: return new Player();
		case 1: return new Player("Explorer", 'M');
		}
		return null;
	}

	public static void sanityExplanation() {
		Printers.messageWindow("Certain events and decisions can raise or lower your sanity.\nCertain events also require a sanity check to pass,"
				+ "\n meaning that if your sanity is too low you're locked out of a decision that a more mentally sound person would make.", null);
	}
}
