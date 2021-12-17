package game;

import java.util.Scanner;

import javax.swing.JOptionPane;
/* This is program allows us to create a player object.
 * 
 * @Author: Elliot Miller
 * @Version: 3.01
 * @Since: 12-15-21
 */
public class Player {
	
	Scanner in = new Scanner(System.in);
	private String name;
	private char gender;
	
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
			break;
			case 1: gender = 'F';
			break;
			case 2: gender = 'O';
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
}
