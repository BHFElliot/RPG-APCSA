package game;

import javax.swing.JOptionPane;
/* This contains all methods necessary to printing story and events to the console and creating windows 
 * with options for players.
 * @Author: Elliot Miller
 * @Version: 1.0
 * @Since: 12-17-21
 */
public class Printers {
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