package game;

import java.util.Scanner;


/** 
 * The Main class starts the game.
 * 
 * @Author: Elliot Miller
 * @Version: 1.0
 * @Since: 2021-12-15
 */
public class Main {

	static Scanner in = new Scanner(System.in);
	//player and statsheets
	public static Player player;
	public static ResourceSheet playerSheet;
	public static int readingSpeed;
	
	public static void main(String[] args) {
		player = characterCreate();
		playerSheet = new ResourceSheet(player);	
		//Start.backStory();
		Settlement.begin();
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
	
	//this is not in use anymore, but has been kept in case a major change is made in the game later on.
	public static void sanityExplanation() {
		Printers.messageWindow("Certain events and decisions can raise or lower your sanity.\nCertain events also require a sanity check to pass,"
				+ "\n meaning that if your sanity is too low you're locked out of a decision that a more mentally sound person would make.", null);
	}
}
