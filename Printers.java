package game;

import javax.swing.JOptionPane;

public class Printers {
	/**
	 * The printer class contains all methods necessary to printing story and events to the console and creating windows 
	 * with options for players.
	 * @Author: Elliot Miller
	 * @Version: 1.0
	 * @Since: 2021-12-17
	 */
	
	//these methods are just me not wanting to look at 1000 try catch statements every time I use Thread.sleep().
	//also It's easier to have print and sleep in the same method rather than doing two lines and all these methods
	//just print and then sleep.
	public static void sleep(int a) {
	    try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void printlnSleep(int sleepTimeMS, String text) {
		System.out.println(text);
		if(!Main.isDev) 
			sleep(sleepTimeMS+Main.readingSpeed);
		 
			
	}
	
	public static void printSleep(int sleepTimeMS, String text) {
		System.out.print(text);
		if(!Main.isDev) 
			sleep(sleepTimeMS+Main.readingSpeed);
		
	}

	//creates an option window.
	public static int optionDialog(String bodyText, String title, int options, String[]responses) {
		
		if(options == 1)	
			return JOptionPane.showOptionDialog(null, bodyText, title, JOptionPane.YES_NO_CANCEL_OPTION, 
			JOptionPane.PLAIN_MESSAGE, null, responses, 0);
		else if(options == 2)
			return JOptionPane.showOptionDialog(null, bodyText, title, JOptionPane.YES_NO_OPTION, 
			JOptionPane.PLAIN_MESSAGE, null, responses, 0);
		else 
			return JOptionPane.showOptionDialog(null, bodyText, title, JOptionPane.YES_OPTION, 
			JOptionPane.PLAIN_MESSAGE, null, responses, 0);
	}	
	//creates an option window with no title
	public static int optionDialog(String bodyText, int options, String[]responses) {
		
		if(options == 1)	
			return JOptionPane.showOptionDialog(null, bodyText, null, JOptionPane.YES_NO_CANCEL_OPTION, 
			JOptionPane.PLAIN_MESSAGE, null, responses, 0);
		else if(options == 2)
			return JOptionPane.showOptionDialog(null, bodyText, null, JOptionPane.YES_NO_OPTION, 
			JOptionPane.PLAIN_MESSAGE, null, responses, 0);
		else 
			return JOptionPane.showOptionDialog(null, bodyText, null, JOptionPane.YES_OPTION, 
			JOptionPane.PLAIN_MESSAGE, null, responses, 0);
	}	
	
	//creates a yes/no option window with no title
	public static int optionDialog(String bodyText, String[]responses) {
			return JOptionPane.showOptionDialog(null, bodyText, null, JOptionPane.YES_NO_OPTION, 
			JOptionPane.PLAIN_MESSAGE, null, responses, 0);
	}
	
	//creates a message window (holds information and has only one option)
	public static void messageWindow(String bodyText, String title) {
		JOptionPane.showMessageDialog(null, bodyText, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void ellipsis(int numDots) {
		for (int i = 0; i < numDots; i++)
			printSleep(750 - Main.readingSpeed,".");
	}
}
