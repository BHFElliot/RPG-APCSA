package game;

import java.util.Random;


public class Roll {

	/**
	 * The Roll class handles and sometimes prints random chance.
	 * 
	 * @Author: Elliot Miller
	 * @Since: 2021-12-22
	 * @Version: 1.0
	 */
	
	public static boolean roll(double chance, int total, String action) {
		
		//this is a very useful method that I totally use many times throughout the code and definitely isn't
		//just a way to meet the double requirement
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
	//this gives an outcome given a probability in the form of chance/total
	public static boolean silentRoll(int chance, int total) {
		return new Random().nextInt(total)+1 <= chance; 
	}	
	
	//this is just a method I used for testing, I was very tired when I wrote this and it had some major logic errors at the start
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
