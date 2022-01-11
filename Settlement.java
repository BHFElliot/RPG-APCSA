package game;

public class Settlement {
	
	/**
	 *The Settlment class is gameplay and dialogue in the town.
	 * 
	 *@Author: Elliot Miller
	 *@Since: 2021/12/22
	 *@Version: 1.0
	 *
	 */
	
	public static boolean isHostile = Roll.silentRoll(1,2);
	public static boolean hasBeen = false;
	public static void begin() {
		hasBeen = true;
		Printers.printlnSleep(3000,"After what felt like an eternity of walking, you finally "
				+ "reach the end of the cramped tunnel you've been travelling through.");
		Printers.printlnSleep(2000, "On the other side, you spot a huge walled off area.");
		Printers.printlnSleep(3000, "There's an entrance with a guard sitting right beside it, reading a book.");
		Printers.printlnSleep(2000, "You approach the guard and ask how you can get into the town.");
		Printers.printlnSleep(1000, "The guard responds: \"Do you have a passport?\"");
		Printers.printlnSleep(2000, "You tell the guard you might have an id, and reach for your wallet.");
		if(Roll.silentRoll(1, 3))
			id();
		else
			noID();
	}
	
	public static void id() {
		Printers.printlnSleep(2000, "You find your id and hand it to the guard.");
		Printers.printlnSleep(2000, "The guard takes a look at your id and hands it back to you.");
		Printers.printlnSleep(2000, "\"Not sure where this is from, but it looks fine.\"");
		townSquare();
	}
	
	public static void noID() {
		Printers.printlnSleep(2500, "\"I must've lost my id when I fell down here, I'm just trying to get back home\"");
		Printers.printlnSleep(1000, "The guard scratches his chin and looks around.");
		Printers.printlnSleep(2000, "\"Alright, I'll let you in but tell NOBODY you don't have a passport. Got it?\"");
		Printers.printlnSleep(500, "You quickly nod.");
		townSquare();
	}
	
	public static void townSquare() {
		Printers.printlnSleep(3000, "He signals you through and you enter the town. You see townsfolk chatting and kids playing, all dressed "
				+ "in colonial garb.");
		Printers.printlnSleep(2000, "There are a couple shops and a little town hall in the center of the town.");
		Printers.printlnSleep(3000, "Your entrance doesn't go unnoticed for long. People slowly stop talking at start looking at you. After just a few "
				+ "minutes, the town goes completely silent.");
		
		switch(Printers.optionDialog("You feel obligated to say something.", 
		new String[] {"\"Does anyone know a way to get out of this cave?\"","\"Just passing through.\""})) {
		case 0: followChoice(); 
		break;
		case 1: Printers.printlnSleep(2500, "A look of disappointment washes over the townsfolk.");
		Caves.begin(false); 
		break;
		
		}
	}
	
	public static void followChoice() {
		Printers.printlnSleep(2000, "An older man emerges from the crowd and asks you to follow him.");
		if(isHostile)
			Printers.printlnSleep(2000, "You feel an immense pressure to agree.");
		if(Printers.optionDialog("Do you want to follow him?", new String[] {"Yeah, he seems nice.", "No, I don't trust him."}) == 0) {
			if(isHostile)
				hostileFollow();
			else
				passiveFollow();		
		} else {
			if(isHostile)
				hostileNoFollow();
			else {
				Printers.printlnSleep(2500, "A look of disappointment washes over the townsfolk.");
				Printers.printlnSleep(2000, "\"So be it.\" The old man says with a tinge of sorrow in his voice.");
				Printers.printlnSleep(2000, "The old man turns away from you and gestures towards the guard");
				Caves.begin(false);	
			}
		}
		
	}
	
	public static void passiveFollow() {
		Printers.printlnSleep(2000, "The old man's straight face turns to a hearty smile.");
		Printers.printlnSleep(2000, "\"Follow me into the town hall, young " + Main.player.genderString + ".");
		Printers.printlnSleep(3000, "The old man sits you down in a room full of photographs, documents, and all sorts of artifacts.");
		Printers.printlnSleep(2000, "He says: \"I'll lead you up to the surface, but I need you to do something for me as well.\"");
		Printers.printlnSleep(1000, "\"Every exit to this cave is sealed off.\"");
		Printers.printlnSleep(2000, "\"However, they open whenever a tour comes through.\"");
		Printers.printlnSleep(3000, "\"I need you to sneak into a tour and when you leave, go tell someone important that we're down here.\"");
		Printers.printlnSleep(2000, "\"You see, we've been down here for generations.\"");
		Printers.printlnSleep(3000, "\"Our town had a religious split. Most of the citizens were in one sect, while we were in the other\"");
		Printers.printlnSleep(3000, "\"Finally, after years of abuse and harassment, they drove us into these caves and sealed up all the exits.\"");
		Printers.printlnSleep(2000, "\"It's been well over a hundred years, but the townspeople on the surface have, for some reason, decided to keep us down here.");
		Printers.printlnSleep(2000, "\"We've grown so accustomed to the cave life that we have no real desire to leave.\"");
		Printers.printlnSleep(2000, "\"But, we understand that you probably have a family on the surface, so we'll show you the way out.\"");
		Caves.begin(false);
	}
	
	public static void hostileFollow() {
		Printers.printlnSleep(2000, "The old man's straight face turns to a hearty smile.");
		Printers.printlnSleep(2000, "\"Follow me into the town hall, young " + Main.player.genderString + ".");
		Printers.printlnSleep(3000, "The old man sits you down in a room full of photographs, documents, and all sorts of artifacts.");
		Printers.printlnSleep(2000, "\"You see, we've been down here for generations.\"");
		Printers.printlnSleep(3000, "\"Our town had a religious split. Most of the citizens were in one sect, while we were in the other\"");
		Printers.printlnSleep(3000, "\"Finally, after years of abuse and harassment, they drove us into these caves and sealed up all the exits.\"");
		Printers.printlnSleep(2000, "\"It's been well over a hundred years, but the townspeople on the surface have decided to keep us down here for whatever reason.\"");
		Printers.printlnSleep(3000, "\"Every decade or so, someone like you comes down here. Someone with knowledge of the outside world,");
		Printers.printlnSleep(2000, "Someone who might be able to help us get out of here.\"");
		Printers.printSleep(500, "\"Every ");
		Printers.printSleep(500, "single ");
		Printers.printSleep(500, "person ");
		Printers.printlnSleep(2000, "who comes down here ends up breaking their promise.\"");
		Printers.printlnSleep(3000, "\"We'll tell you how to get back to the surface, but you need to promise that you'll do whatever you can to get us out of here.\"");
		switch(Printers.optionDialog("What do you want to say?", new String[] {"\"I promise.","\"I can't promise anything."})) {
		case 0: Printers.printlnSleep(0, "\"Perfect. We'll show you the exit.\"");
		Caves.begin(true);
		break;
		case 1: howAreYouThisStupid();
		break;
		}
	}
	
	public static void hostileNoFollow() {
		Printers.printSleep(2500, "The cautious curiosity the townsfolk had towards you only a moment ago was all gone.");
		Printers.printlnSleep(1000," Now, all that's left is hostility");
		Printers.printlnSleep(2500,"You hear the guard move to block off the entrance and the old man retreats into the crowd.");
		Printers.printlnSleep(1500, "Before you know it, there's a crowd of people descending on you.");
		Player.death();
	}
	
	public static void howAreYouThisStupid() {
		Printers.printlnSleep(2000, "\"Huh. I'll give you this, you're the first person to actually tell the truth.\"");
		Printers.printlnSleep(500, "Still...");
		Printers.printlnSleep(0, null);
	}
	
}


