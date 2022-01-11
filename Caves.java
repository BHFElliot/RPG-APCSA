package game;

public class Caves {
	/**
	 * The Caves class contains what happens to the player when they leave the town.
	 * 
	 * @author Elliot Miller
	 * @version 1.0
	 * @since 2021-12-21
	 */
	public static void begin() {
		Main.playerSheet.setPlayerPosition('C');
		Printers.printlnSleep(2000, "The guard grabs your arm and leads you to the front gate.");
		Printers.printlnSleep(3000, "Once you're there, the guard grunts and points to a new passageway all the way on the other side of the village.");
		Printers.printlnSleep(1500, "The guard moves to block you from reentering the village.");
		Printers.printlnSleep(2000, "You flick your phone flashlight back on and see a narrow passageway.");
		fall();		
	}
	
	public static void fall() {
		Printers.printlnSleep(3000, "You take on step in and immediately trip and start tumbling down a steep slope.");
		Printers.printlnSleep(3000, "Suddenly, you fly headfirst out of the tunnel and into a huge pool of water. ");
		Printers.printlnSleep(1500, "You swim to the surface and gasp for air.");
		Printers.printlnSleep(3500, "You poke your head out of the water and come face to face with a party of around 10 people,"
				+ "\nDressed in cargo shorts with cameras around their necks and fanny packs around their waists.");
		Printers.printlnSleep(2000, "They're all looking at you starry-eyed.");
		switch(Printers.optionDialog("What would you like to say?", new String[] {"Are you guys from the surface?", "I think I got seperated from the group."})) {
		case 0:
			Printers.printlnSleep(2000, "The group's confusion turns to terror as they bolt away, shutting off the lights behind them.");
			Printers.printlnSleep(3000, "You try to give chase but they're out of sight before you can get out of the water.");
			if(!feelAround())
				starve();
			Printers.printlnSleep(2000, "Suddenly, your finger flicks a switch on.");
			Printers.printlnSleep(2000, "The row of plastic lights turn back on.");
			switch(Printers.optionDialog("Where do you want to go?", new String[] {"I'll go the same way that group went.", "I'll go the other way."})){
			case 0: 
				Printers.ellipsis(3);
				Printers.printlnSleep(2000, "After an eternity of walking, you reach a metal door.");
				Printers.printlnSleep(3000, "You bang on the door, but nobody answers.");
				Printers.printlnSleep(2000, "You bang even harder and yell, until you finally get a response:");
				Printers.printlnSleep(1500, "\"Go back to your town, we don't want you here!\"");
				Printers.printlnSleep(2000, "You try to say something, but they just repeating that phrase over and over.");
				Printers.printlnSleep(1000, "They turn off the lights again.");
				Printers.printlnSleep(2000, "You feel around your pockets for your food but all you can find is your phone, destroyed by the fall.");
				starve();
				break;
			case 1:
				Printers.printlnSleep(2000, "After an eternity of walking, you reach a metal door.");
				Printers.printlnSleep(3000, "You bang on the door, but nobody answers.");
				Printers.printlnSleep(2000, "After a short wait, you push the door open yourself.");
				Printers.printlnSleep(2000, "The sun is overwhelming, although in a good way.");
				Printers.printlnSleep(2000, "You made it.");
				Player.end();
				break;
			}
		case 1:
			Printers.printlnSleep(3000, "\"You could've gotten lost, or even died!\" Shouts the tour guide. She apologizes to the other guests and"
					+ " shouts for you to come rejoin the group.");
			Printers.printlnSleep(2000, "You follow the group all the way to the exit, and you finally reach the exit door.");
			Printers.printlnSleep(2000, "The tour guide pushes the door open.");
			Printers.printlnSleep(2000, "The sun is overwhelming, although in a good way.");
			Printers.printlnSleep(2000, "You made it.");
			Player.end();
			break;
			
		}
		
	}
	
	public static boolean feelAround() {
	int numAttempts = 1;
		
		while(!Roll.silentRoll(1, 20) || numAttempts > 11) {
			Printers.printSleep(2000,"You've been looking for " + numAttempts * 10 + " minutes, but you haven't found anything yet.");
			numAttempts++;
		}
		
		if (numAttempts > 11) {
			Printers.printlnSleep(1000, "You give up.");
			return false;
		}
		return true;
	}
	
	public static void starve() {
		Printers.printlnSleep(3000, "Alone, quiet, and in complete darkness, you realize it's your time to go.");
		Printers.printlnSleep(4000, "With no food, a destroyed phone, and no idea where you are, the chances that someone else comes along to help "
				+ "you are pretty slim.");
		Player.death();
	}
}

