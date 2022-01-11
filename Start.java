package game;

public class Start{
 /**
  *  The Start class contains the game's intro.
  * 
  * @Author: Elliot Miller
  * @Version: 1.0
  * @Since: 2021-12-16
  */ 
  public static void backStory() {
	System.out.println("\n");
	Printers.printlnSleep(2000, "You awake to the sound of water droplets pattering around you.");
    Printers.printlnSleep(3500, "A gust of cold air wakes you up. You open your eyes only to find yourself completely enshrouded in darkness.");
    Printers.printlnSleep(2250,"As you come to, you begin to remember how you got here.");

    awakenChoice();
  }
  //all of the players choices.
  private static void awakenChoice() {
	  switch(Printers.optionDialog("Wasn't I...", null, 1, new String[]{"Going spleunking?","Taking a nap alone in a dark cave?"})) {
	  	case 0: introPartOne(true); break;
	  	case 1: Main.playerSheet.addSanity(-10); introPartOne(false); break;
	  }
  }
  
  //this is the backstory and allows the player to make a decision about what path they want to go down.
  public static void introPartOne(boolean a) {
	  if(a) {
		  Printers.printlnSleep(2500, "\"Of course! I must've slipped and fell when I was checking out that cave.\"");
		  Printers.printlnSleep(4000, "Thankfully, you still have your phone on you.");
	  } else {
		  Printers.printlnSleep(4000, "\"Of course! I must've been out for one of my solo cave walks when I got tired and took a nap in this crevace.\"");
		  Printers.printlnSleep(3000, "You feel around your pockets and find your phone.");
	  }
	  House.begin();
  }
  
}


