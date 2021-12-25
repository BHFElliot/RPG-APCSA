package game;

import javax.swing.JOptionPane;

public class Player {
	
	/**
	 * The Player class allows us to create a player object, as well as win the game, and die.
	 * 
	 * @Author: Elliot Miller
	 * @Version: 3.01
	 * @Since: 2021-12-15
	 */
	
	Scanner in = new Scanner(System.in);
	public String name;
	public char gender;
	public String genderString;
	
	public Player() {
		create();
	}
	
	public Player(String a, char b) {
		name = a;
		gender = b;
		confirm();
	}
	//below are the getters and setters for gender and name. These can only be invoked by special events.
	public char getGender() {
		return gender;
	}
	
	public void setGender(char sex) {
		gender = sex;
	}
	
	public String getname() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}
	
	//this monster of a method is basically a constructor
	private void create() {
		name = JOptionPane.showInputDialog("Input a character name please");
		String genders[] = {"Male", "Female", "Other"}; //these are the options for the gender selecting window.
		
		while(name == null || name.equals("")) {
			name = JOptionPane.showInputDialog("Input a character name please\nYou can't name your character nothing!");
		}
		
		int characterGender = Printers.optionDialog("Input the character's gender please.", "Character Creator", 2, genders);
				//JOptionPane.showOptionDialog (null, "Input the character's gender please.", "Character Creator", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, genders, 0);
		
		//the non null parameters are (in order): The message in the window, the window title, how many buttons there are, the symbol next to the question, and the words on the buttons.
		switch(characterGender) {
			case 0: gender = 'M';
			genderString = "Man";
			break;
			case 1: gender = 'F';
			genderString = "Lady";
			break;
			case 2: gender = 'O';
			genderString = "One";
			break;
		}
		confirm();
		
	}
	/*this is basically the same thing as the last window, although the main difference is that selecting no starts the whole process over again. 
	Forcing the player to hard reset if they want to change their character's name and gender is really annoying for the user.*/
	private void confirm() {
		if (Printers.optionDialog("You've selected: " + name + " with gender: " + gender + "\nIs this ok?", "confirmation", 2, null) == 0)
			System.out.println("good luck!");
		else
			create();
	}
	
	//this is pretty self-explanatory. If the player makes enough mistakes, just like real life, they die.
	public static void death() {
		System.out.println("You Died.");
		Main.playerSheet.setEnergy(0);
		Main.playerSheet.setHealth(0);
		Main.playerSheet.setEnergy(0);
		ResourceDisplay.death();
		System.exit(0);
	}
	
	public static void end() {
		Printers.printlnSleep(2000, "Thanks for playing spelunk!");
		Printers.printlnSleep(3000, "If this is your first win, I highly encourage you play again. There's a lot of stuff you haven't seen.");
		Printers.printlnSleep(2000, "Goodbye!");
		System.exit(0);
	}
	
}
