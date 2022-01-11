package game;

/** 
 * The Main class starts the game.
 * 
 * @Author: Elliot Miller
 * @Version: 1.0
 * @Since: 2021-12-15
 */
public class Main {

	//player and statsheets
	public static Player player;
	public static ResourceSheet playerSheet;
	public static int readingSpeed;
	public static boolean isDev;
	
	public static void main(String[] args) {
		isDev = true;
		player = characterCreate();
		playerSheet = new ResourceSheet(player);	
		Start.backStory();
	}
	
	//asks the player if they want to make a custom character.
	public static Player characterCreate() {
		Printers.messageWindow("Welcome to spelunk! This is a text-based choose your own adventure style game."
				+ "\nThe game's mechanics are very simple. Whenever you're presented with a choice, a window will pop up showing your options.", null);
		
		switch(Printers.optionDialog("How fast of a reader are you?", 1, new String[] {"Fast", "Medium", "Slow"})) {
		case 0: 
			readingSpeed = 2000;
			break;
		case 1: 
			readingSpeed = 1500;
			break;
		case 2:
			readingSpeed = 1000;
			break;
		}
		
		switch (Printers.optionDialog("Would you like to create a character?\nDefault values will be assigned\nto your character if not.", 2, null)) {
		case 0: return new Player();
		case 1: return new Player("Explorer", 'M');
		}
		return null;
	}
}
