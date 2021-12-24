package game;

public class Settlement {
	
	/*This is the gameplay in the (first?) settlement
	 * 
	 *@Author: Elliot Miller
	 *@Since: 12/22/21
	 *@Version: 1.0
	 *
	 */
	
	public static boolean isHostile = Roll.silentRoll(1,2);
	
	public static void begin() {
		Printers.printlnSleep(3000,"After what felt like an eternity of walking, you finally "
				+ "reach the end of the cramped tunnel you've been travelling through");
		Printers.printlnSleep(2000, "On the other side, you spot a huge walled off area.");
		Printers.printlnSleep(3000, "There's an entrance with a guard sitting right beside it, reading a book.");
		switch (Printers.optionDialog("How do you want to get in?", new String[] {"Go talk to the guard.", "hop the fence."})) {
		case 0: guard();
		case 1: fenceHop();
		}
	}
	
	public static void guard() {
		Printers.printlnSleep(2000, "You approach the guard and ask how you can get into the town.");
		Printers.printlnSleep(1000, "The guard responds: \"Do you have a passport?\"");
		Printers.printlnSleep(2000, "You tell the guard you might have an id, and reach for your wallet.");
		if(Roll.roll(1, 3, "find your wallet"))
			id();
		else
			noID();
	}
	
	public static void id() {
		Printers.printlnSleep(2000, "The guard takes a look at your id and hands it back to you.");
		Printers.printlnSleep(2000, "\"Looks fine.\"");
		townSquare();
	}
	
	public static void noID() {
		Printers.printlnSleep(2500, "\"I must've lost my id when I fell down here, I'm just trying to get back home\"");
		Printers.printlnSleep(1000, "The guard scratches his chin and looks around.");
		Printers.printlnSleep(2000, "\"Alright, I'll let you in but tell NOBODY you don't have a passport. Got it?\"");
		Printers.printlnSleep(500, "You quickly nod.");
		townSquare();
	}
	
	public static void fenceHop() {
		
	}
	
	public static void townSquare() {
		Printers.printlnSleep(3000, "He signals you through and you enter the town. You see kids playing in the street and adults talking.");
		Printers.printlnSleep(2000, "There are a couple shops and a little town hall in the center of the town.");
		Printers.printlnSleep(3000, "Your entrance doesn't go unnoticed for long. People slowly stop talking at start looking at you. After just a few "
				+ "minutes, the town goes completely silent.");
		switch(Printers.optionDialog("You feel obligated to say something.", 
		new String[] {"\"Does anyone know a way to get out of this cave?\"","\"Just passing through.\""})) {
		case 0: followChoice(); break;
		case 1: passingThrough(); break;
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
			else
				passiveNoFollow();		
		}
		
	}
	
	public static void passiveFollow() {
		
	}
	
	public static void hostileFollow() {
		
	}
	
	public static void hostileNoFollow() {
		Printers.printSleep(2500, "The cautious curiosity the townsfolk had towards you only a moment ago was all gone.");
		Printers.printlnSleep(1000," Now, all that's left is hostility");
		Printers.printlnSleep(2500,"You hear the guard move to block off the entrance and the old man retreats into the crowd.");
		Printers.printlnSleep(1500, "Before you know it, there's a crowd of people descending on you.");
		Player.death();
	}
	
	public static void passiveNoFollow() {
		Printers.printlnSleep(2500, "A look of dissapointment washes over the townsfolk.");
		Printers.printlnSleep(2000, "\"So be it.\" The old man says with a tinge of sorrow in his voice.");
		Printers.printlnSleep(2000,"The old man turns away from you and gestures towards the guard");
		Printers.printlnSleep(2000,"The guard grabs your arm and leads you to the front gate.");
	}
	
	public static void passingThrough() {
		
	}
	
}

