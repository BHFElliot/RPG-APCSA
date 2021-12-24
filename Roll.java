package game;

import java.util.Random;


public class Roll {

	/*This class prints the info a player would need to know about any roll (the chance and what they're rolling for)
	 * and also does the calculations
	 * @Author: Elliot Miller
	 * @Since: 12-22-21
	 * @Version: 1.0
	 */
	
	public static boolean roll(double chance, int total, String action) {

		double probability = (chance/total) * 100;
		double roundedProbability = probability - (probability % 1) / 10;
		Printers.printlnSleep(2000, "You want to " + action + " with a " + roundedProbability + "% chance of success.");
		Printers.printSleep(1000, "And");
		Printers.ellipsis(3);
		System.out.println(); 
		if (new Random().nextInt(total)+1 <= chance) {
			Printers.printlnSleep(1000, "Success!");
			return true;
		}
		Printers.printlnSleep(1000, "Failure.");
		return false;
	}
	
	public static boolean silentRoll(int chance, int total) {
		return new Random().nextInt(total)+1 <= chance; 
	}	
	
	public static int test(int chance, int total) {
		int success = 0;
		for(int i = 0; i < 100; i++)
			System.out.println(new Random().nextInt(total));
		for(int i = 0; i < 100; i++)
			if(new Random().nextInt(total)+1 <= chance)
				success++;
		return success;
	}
	
}
