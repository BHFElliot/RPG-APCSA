package game;

public class Intro{
  public Intro() {
    backStory();  
  }
  private void backStory() {
	Main.clearConsole();
    Main.printSleep(1000, "You awake to the sound of water droplets pattering around you.");
    Main.printSleep(2000, "A breeze of cold air brings you to. You open your eyes only to find yourself completely enshrouded in darkness.");
    Main.printSleep(1250,"As you come to, you begin to remember how you got here.");
    System.out.println("Wasn't I...");
  }
  
  private static void awakenChoice() {
	  
  }
} 
