package game;

import java.util.Random;

/* This class contains the game's intro, which is the main branching point for the different paths.
 * 
 * @Author: Elliot Miller
 * @Version: 1.0
 * @Since: 12-16-21
 */ 
public class Intro{

  public static void backStory() {
	System.out.println("\n");
    Printers.printSleep(2000, "You awake to the sound of water droplets pattering around you.");
    Printers.printSleep(3500, "A breeze of cold air brings you to. You open your eyes only to find yourself completely enshrouded in darkness.");
    Printers.printSleep(2250,"As you come to, you begin to remember how you got here.");

    awakenChoice();
  }
  
  //this is the backstory and allows the player to make a VERY important decision about what path they want to go down.
  private static void introPartOne(boolean a) {
	  if(a) {
		  Printers.printSleep(2000, "You begin to remember what happened before you woke up.");
		  Printers.printSleep(2500, "\"Of course! I must've slipped and fell when I was checking out that cave.\"");
		  Printers.printSleep(4000, "Thankfully, you still have your backpack on you, "
		  							+ "containing your phone, a day's worth of food and water, and a compass.");
		  Printers.printSleep(3000, "You reach into your bag and pull out your phone. "
		  							+ "Do you want to turn the flashlight on?");
		  flashlightChoice();
	  }
	  else {
		  Printers.printSleep(2000, "You begin to remember what happened before you woke up.");
		  Printers.printSleep(4000, "\"Of course! I must've been out for one of my solo cave walks when I got tired and took a nap in this crevace.\"");
		  Printers.printSleep(3000, "You feel around your pockets and find your phone. Do you try and use the flashlight feature to illuminate your surroundings?");
		  flashlightChoice();
	  }
	  
	 
  }
  
  private static void darkness() {
	  Printers.printSleep(3000, "You've seen enough horror movies to know no good can come from being alone in caves. This is probably for the best.");
	  Printers.printSleep(3000, "You stumble around the cave, feeling around for any sort of exit and trying your best to avoid any additional falls.");
	  Printers.printSleep(1500, "Suddenly, your finger strikes something...");
	  
	  
  }
  
  //Printers.printSleep(2000,""); this is what I'm using for copy and pasting. Hopefully it's been removed by the time I turn this in.
  
  //all of the players choices. There are going to be a lot of these.
  private static void awakenChoice() {
	  switch(Printers.optionDialog("Wasn't I...", null, 1, new String[]{"Going spleunking?","Taking a nap alone in a dark cave?"})) {
	  	case 0: introPartOne(true); break;
	  	case 1: Main.playerSheet.addSanity(-10); introPartOne(false); break;
	  }
  }
  
  private static void flashlightChoice() {
	  switch(Printers.optionDialog("Should I turn my flashlight on?", null, 1, new String[]{"Of course! I can't get out of here without any light.","No way. Who knows what could be lurking down here?"})) {
	  	case 0: 
	  		Printers.printSleep(2000, "You go to turn on your phone, and...");
	  		if (new Random().nextInt(2) == 1) {
	  			Printers.printSleep(1000, "It's dead.");
	  			darkness();
	  		}	
	  		else {
	  			lightEvents();
	  		}	
	  		break;
	  	case 1: 
	  		Main.playerSheet.addSanity(-5); 
	  		lightEvents();
	  }
  }
  
  //random events, should be mostly out of the player's control
  private static void lightEvents() {
	  if (new Random().nextInt(2) == 1)
		  CivPath.begin();
	  else
		  BioPath.begin();
  }
} 
