import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Hi! Thank you for playing cave game");
		Player player = new Player();
		ResourceSheet playerSheet = new ResourceSheet(player);
		new Intro();
	}

}

