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
    Printers.printAct(0);
	Printers.printlnSleep(2000, "You awake to the sound of water droplets pattering around you.");
    Printers.printlnSleep(3500, "A breeze of cold air wakes you up. You open your eyes only to find yourself completely enshrouded in darkness.");
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
  
  private static void flashlightChoice() {
	  switch(Printers.optionDialog("Should I turn my flashlight on?", 1, new String[]{"Of course! I can't get out of here without any light.","No way. Who knows what could be lurking down here?"})) {
	  	case 0: 
	  		Printers.printlnSleep(2000, "You go to turn on your phone, and...");
	  		//THIS HAS BEEN ALTERED, IT SHOULD BE 1 NOT 77
	  		if (new Random().nextInt(2) == 77) {
	  			Printers.printlnSleep(1000, "It's dead.");
	  			darkness();	
	  		}	
	  		else {
	  			CivPath.begin();
	  		}	
	  		break;
	  	case 1: 
	  		Main.playerSheet.addSanity(-5); 
	  		CivPath.begin();
	  }
  }
  
  //this is the backstory and allows the player to make a decision about what path they want to go down.
  public static void introPartOne(boolean a) {
	  if(a) {
		  Printers.printlnSleep(2000, "You begin to remember what happened before you woke up.");
		  Printers.printlnSleep(2500, "\"Of course! I must've slipped and fell when I was checking out that cave.\"");
		  Printers.printlnSleep(4000, "Thankfully, you still have your phone on you.");
		  Printers.printlnSleep(3000, "You reach into your bag and pull out your phone. "
		  							+ "Do you want to turn the flashlight on?");
		  flashlightChoice();
	  }
	  else {
		  Printers.printlnSleep(2000, "You begin to remember what happened before you woke up.");
		  Printers.printlnSleep(4000, "\"Of course! I must've been out for one of my solo cave walks when I got tired and took a nap in this crevace.\"");
		  Printers.printlnSleep(3000, "You feel around your pockets and find your phone. Do you try and use the flashlight feature to illuminate your surroundings?");
		  flashlightChoice();
	  }
	  
	 
  }
  
  public static void darkness() {
	  Printers.printlnSleep(3000, "You've seen enough horror movies to know no good can come from being alone in caves. This is probably for the best.");
	  Printers.printlnSleep(3000, "You stumble around the cave, feeling around for any sort of exit and trying your best to avoid any additional falls.");
	  Printers.printlnSleep(1500, "Suddenly, your finger strikes something...");
	  
	  
  }
  
  //Printers.printSleep(2000,""); this is what I'm using for copy and pasting. Hopefully it's been removed by the time I turn this in.
  


} 
