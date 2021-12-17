package game;

import java.util.Scanner;

import javax.swing.JOptionPane;
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
		Intro.backStory();
	}
	
	//asks the player if they want to make a custom character.
	public static Player characterCreate() {
		switch (Printers.optionDialog("Hi! Thank you for playing spelunk. \nWhen presented with a choice, a window will pop up allowing you to choose what you'd like to do."
				+ "\nWould you like to create a character? Default values will be assigned to your character if not.", "Welcome!", 2, null)) {
		case 0: return new Player();
		case 1: return new Player("Explorer", 'M');
		}
		return null;
	}
	

	
}
