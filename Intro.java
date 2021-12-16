package game;
/* this whole class is basically just getters and setters for the players resources. It's very likely that at least one of these
 * goes completely unutilized.
 * 
 * @Author: Elliot Miller
 * @Version: 1.0
 * @Since: 12-16-21
 */
public class Intro{
  public Intro() {
    backStory();  
  }
  private void backStory() {
	System.out.println("\n");
    Main.printSleep(1000, "You awake to the sound of water droplets pattering around you.");
    Main.printSleep(2000, "A breeze of cold air brings you to. You open your eyes only to find yourself completely enshrouded in darkness.");
    Main.printSleep(1250,"As you come to, you begin to remember how you got here.");
    System.out.println("Wasn't I...");
    awakenChoice();
  }
  
  private static void awakenChoice() {
	  switch(Main.optionDialog("Wasn't I...", null, 1, new String[]{"Going spleunking?","Taking a nap alone in a dark cave?"})) {
	  	case 0:
	  	case 1: Main.playerSheet.addSanity(-10);
	  }
  }
} 
