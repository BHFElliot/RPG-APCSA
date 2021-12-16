import java.util.Scanner;

import javax.swing.JOptionPane;

public class Player {
	
	Scanner in = new Scanner(System.in);
	private String name;
	private char gender;
	
	public Player() {
		create();
	}
	
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
	
	private void create() {
		name = JOptionPane.showInputDialog("Input a character name please");
		String genders[] = {"Male", "Female", "Other"};
		while(name == null ||name.equals("")) {
			System.out.println("You can't name your character nothing!");
			name = JOptionPane.showInputDialog("Input a character name please");
		}
		
		int characterGender = JOptionPane.showOptionDialog (null, "Input the character's gender please.", "Character Creator", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, genders, 0);
		
		switch(characterGender) {
			case 0: gender = 'M';
			break;
			case 1: gender = 'F';
			break;
			case 2: gender = 'O';
			break;
		}
		
		if (JOptionPane.showOptionDialog (null, "You've selected:\n" + name + " with gender: " + gender, "Character Creator", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, 0) == 0)
			System.out.println("good luck!");
		else
			create();
	}