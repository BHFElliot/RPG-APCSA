package game;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		Player player = characterCreate();
		ResourceSheet playerSheet = new ResourceSheet(player);	
		new Intro();
	}
	
	//asks the player if they want to make a custom character.
	public static Player characterCreate() {
		switch (optionDialog("Hi! Thank you for playing spelunk. \nWhen presented with a choice, a window will pop up allowing you to choose what you'd like to do."
				+ "\nWould you like to create a character? Default values will be assigned to your character if not.", "Welcome!", 2, null)) {
		case 0: return new Player();
		case 1: return new Player("Explorer", 'M');
		}
		return null;
	}
	
	//these methods are just me not wanting to look at 1000 try catch statements every time I use Thread.sleep().
	public static void sleep(int a) {
	    try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void printSleep(int a, String b) {
		System.out.println(b);
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//prints a bunch of times lol
	public static void clearConsole() {
		for(int i = 0; i < 10; i++) {
			System.out.println();
		}
	}

	//creates an option window.
	public static int optionDialog(String bodyText, String title, int option, String[]responses) {
		
		if(option == 1)	
			return JOptionPane.showOptionDialog(null, bodyText, title, JOptionPane.YES_NO_CANCEL_OPTION, 
			JOptionPane.PLAIN_MESSAGE, null, responses, 0);
		else if(option == 2)
			return JOptionPane.showOptionDialog(null, bodyText, title, JOptionPane.YES_NO_OPTION, 
			JOptionPane.PLAIN_MESSAGE, null, responses, 0);
		else 
			return JOptionPane.showOptionDialog(null, bodyText, title, JOptionPane.YES_OPTION, 
			JOptionPane.PLAIN_MESSAGE, null, responses, 0);
	}	
	
}
