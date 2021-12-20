package game;

/* This class contains the dialog for one of the 4 planned paths. I'd reccomend playing before looking around here,
 * there most likely won't be anything special.
 * 
 * @Author: Elliot Miller
 * @Version: 1.0
 * @Since: 12-18-21
 */
public class CivPath {
	
	public static void begin() {
		Printers.printlnSleep(1500, "A beam of light emits from the back of your phone.");
		Printers.printlnSleep(3000, "However, before you can really start looking for a way out,"
								+ " a dim light seeps out of a tunnel that was completely dark moments ago.");
		approachChoice();
		
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
		String[] increasingSeverity = {"No. I'm not gonna see what that is.","I don't care. I'd rather wait than go over there.", 
				"These are nothing compared to what could be down there.", "I'd rather be a little hungry now than meet whatever's down there.",
				"I'm strong. I'm not gonna give up.", "Maybe I'll just go to sleep for a minute."};
		int counter = 0;
		while(Printers.optionDialog("Would you like to approach the light now?", 1, new String[]{"I guess I have no other choice.", increasingSeverity[counter]}) != 0) {
			for(int i = 0; i < 4; i++)
				Printers.printSleep(750, ".");
			
			switch(Main.playerSheet.getEnergy()) {
			case 100: Printers.printlnSleep(1250," You're getting hungry."); 
			Main.playerSheet.addEnergy(-20);
			break;
			case 80: Printers.printlnSleep(1250," It's been a long time since you've last eaten."); 
			Main.playerSheet.addEnergy(-20); 
			break;
			case 60: Printers.printlnSleep(1250," The hunger pangs are setting in."); 
			Main.playerSheet.addEnergy(-20); 
			break;
			case 40: Printers.printlnSleep(1250," It's been a long time since you've last eaten."); 
			Main.playerSheet.addEnergy(-20); 
			break;
			case 20: Printers.printlnSleep(2000," You're getting cold and it's getting harder and harder to fight the urge to sleep."); 
			Main.playerSheet.addEnergy(-19); 
			break;
			case 1: Printers.printlnSleep(200," Goodnight."); 
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
	}
}
