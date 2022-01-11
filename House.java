package game;


public class House {
	
	/** 
	 * The House class contains the dialog that gets the player to go to the village and also the dialog for 
	 * when the player comes back from the village.
	 * 
	 * @Author: Elliot Miller
	 * @Version: 1.0
	 * @Since: 2021-12-18
	 */
	
	public static void begin() {
		Printers.printlnSleep(1500, "You turn on the flashlight, and a beam of light streams out from the back.");
		Printers.printlnSleep(3000, "After a few minutes of looking for an exit, a dim light in the distance flickers on.");
		approachChoice();
		
	}
	
	public static void directionChoice() {
		if(Main.playerSheet.getPlayerPosition()=='H') {
			switch(Printers.optionDialog("Where would you like to go?", new String[] {"I'm gonna head back to where I woke up.", "I'm gonna go towards town."})) {
			case 0: Printers.ellipsis(4);
			Main.playerSheet.setPlayerPosition('S'); 
			Printers.printlnSleep(1000,"There's nothing here.");
			directionChoice();
			break;
			case 1: Printers.ellipsis(4);
			Main.playerSheet.setPlayerPosition('T');
			Settlement.begin();
			break;

			}
		}
		else {
			switch(Printers.optionDialog("Where would you like to go?", new String[] {"I'm gonna stay here a little longer.", "I'm gonna go back towards the shack."})) {
			case 0: Printers.ellipsis(4);
			Printers.printlnSleep(1000,"There's still nothing here.");
			directionChoice();
			break;
			case 1: Printers.ellipsis(4);
			Main.playerSheet.setPlayerPosition('H'); 
			Printers.printlnSleep(2000, "The woman looks at you funny for going in the wrong direction.");
			directionChoice();
			break;

			}
		}
	}
	
	public static void approachChoice() {
		switch(Printers.optionDialog("Would you like to approach the light?", 1, 
				new String[]{"I have to! This might be my only chance out of here.", "I'm not entirely sure what that is, but I don't trust it."})) {
		case 0: approach(); 
		break;
		case 1: Printers.printlnSleep(2000, "You spend some more time looking around, but the only exit you can see is that tunnel."); 
		wasteAway(); 
		break;
		}
	}
	
	//this method kills the player if they don't want to play along.
	public static void wasteAway() {
		String[] increasingSeverity = {"No. I'm not gonna see what that is.","I don't care. I'd rather wait than go over there.", "I can wait.",
				"These are nothing compared to what could be down there.", "I'd rather be a little hungry now than meet whatever's down there.",
				"I'm strong. I'm not gonna give up.", "Maybe I'll just go to sleep for a minute."};
		int counter = 0;
		while(Printers.optionDialog("Would you like to approach the light now?", 1, new String[]{"I guess I have no other choice.", increasingSeverity[counter]}) != 0) {
			Printers.ellipsis(3);
			
			switch(Main.playerSheet.getEnergy()) {
			case 100: 
				Printers.printlnSleep(1250," You're getting hungry."); 
				Main.playerSheet.addEnergy(-20);
				Main.playerSheet.addSanity(-5);
			break;
			
			case 80: 
				Printers.printlnSleep(1250," It's been a long time since you've last eaten."); 
				Main.playerSheet.addEnergy(-20);
				Main.playerSheet.addSanity(-5);
			break;
			
			case 60:
				Printers.printlnSleep(1250," Hunger pangs are setting in."); 
				Main.playerSheet.addEnergy(-20); 
				Main.playerSheet.addSanity(-5);
			break;
			
			case 40: 
				Printers.printlnSleep(1250," It's been a very long time since you've last eaten."); 
				Main.playerSheet.addEnergy(-20); 
				Main.playerSheet.addSanity(-5);
			break;
			
			case 20: 
				Printers.printlnSleep(2000," You're getting cold and it's getting harder and harder to fight the urge to sleep."); 
				Main.playerSheet.addEnergy(-19); 
				Main.playerSheet.addSanity(-5);
			break;
			
			case 1: 
				Printers.printlnSleep(2000," Goodnight."); 
				Main.playerSheet.addEnergy(-2); 
				Player.death();
				break;
			}
			counter++;
		}
		
		approach();
	}

	public static void approach() {
		Printers.printlnSleep(1250, "You turn to the light and begin walking towards it.");
		Printers.printlnSleep(3500,"After travelling down a seemingly endless passage of twists and turns, you find a "
				+ "tiny shack hugging the cave wall.");
		Printers.printlnSleep(3500, "On the porch of the shack, a woman is sitting and reading with the help of a little "
				+ "porchlight hanging over her head.");
		Printers.printSleep(2000, "The woman puts down her book and looks to her left,");
		Printers.printlnSleep(2000," then back to her right, locking eyes with you.");
		Printers.printlnSleep(2000, "She visibly jumps, but after a moment calls for you to come over to her.");
		Printers.printlnSleep(2000, "You sit down in the chair next to her. ");
		Printers.printlnSleep(2000, "She's tall, thin as a rail, and deathly pale.");
		Printers.printlnSleep(1250, "She turns to you and says:");
		dialogue();
	}
 	
	public static void dialogue() {
		if(Main.playerSheet.getEnergy() < 20) 
			Printers.printlnSleep(2000, "\"Good god, you look awful. Come in, you need to eat!\"");
		else if(Main.playerSheet.getEnergy() < 40) 
			Printers.printlnSleep(2000, "\"Come in and eat, you clearly need some food.\"");
		else if(Main.playerSheet.getEnergy() < 60) 
			Printers.printlnSleep(2000, "\"Come in for dinner.\"");
		else if (Main.playerSheet.getEnergy() < 100)
			Printers.printlnSleep(2000, "\"I've got some food here if you'd like any.\"");
		Main.playerSheet.addEnergy(20);
		//Printers.sleep(5000);
		//if you can get sound working just chill for a bit with some porch lamp noises and possibly eating sounds 
		//(might be gross tho)
		
		Printers.printlnSleep(1000, "\"So, are you heading into town?\"");	
		switch(Printers.optionDialog("What would you like to say?", new String[] {"Town?", "I'm trying to get out of this cave."})) {
		case 0: Printers.printlnSleep(3000,"\"There's a settlement a couple thousand feet up that way. The direction you came from is"
				+ " a dead end, I'm not entirely sure how you got there.\""); break;
		case 1: 
			Printers.printlnSleep(3000, "\"The surface? It's possible. There's a town up that way that might be able "
				+ "to give you some directions.\"");
		}
		Printers.printlnSleep(2000, "Before you get up, she hands you an oil lamp.\n\"You'll need this.\" She says.");
		Main.playerSheet.setPlayerPosition('H');
		directionChoice();
	}

}
