package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ResourceDisplay extends JFrame{
	
	/**
	 * The ResourceDisplay class creates a window displaying all of the player's resources.
	 * This is old and no longer has a use in the current build of the game. It's been kept in just because it took me so much work to make.
	 * If you'd like to see it in action, new ResourceDisplay(); will bring it up in its former glory.
	 * @Author: Elliot Miller
	 * @Verison 1.0
	 * @Since:2021-12-18
	 */
	

	static JLabel health = new JLabel();
	static JLabel sanity = new JLabel();
	static JLabel info = new JLabel();
	static JLabel energy = new JLabel();
	
	static Integer energyCount = Main.playerSheet.getEnergy();
	static Double healthCount = Main.playerSheet.getHealth();
	static Integer sanityCount = Main.playerSheet.getSanity();
	
	public ResourceDisplay() {
		this.setSize(250,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.setTitle("Resource Window");
		
		updateText();
		updateInfo();
		
		this.add(health);
		this.add(sanity);
		this.add(info);
		this.add(energy);
		
		this.setVisible(true);
	}
	
	public static void updateText() {
		healthCount = Main.playerSheet.getHealth();
		sanityCount = Main.playerSheet.getSanity();
		energyCount = Main.playerSheet.getEnergy();
		
		health.setText("Health: " + healthCount.toString());
		sanity.setText("Sanity: " + sanityCount.toString());
		energy.setText("Energy:" + energyCount.toString());
	}
	
	public static void updateInfo() {
		info.setText(Main.player.getname() + ", " + Main.player.getGender());
	}
	
	//this just updates the resource display when the player dies.
	public static void death() {
		info.setText(Main.player.getname() + ", " + Main.player.getGender() + " RIP");
	}
}
