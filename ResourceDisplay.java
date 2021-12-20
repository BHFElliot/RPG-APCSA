package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
/* This class creates a window displaying all of the player's resources.
 * @Author: Elliot Miller
 * @Verison 1.0
 * @Since:12-18-21
 */
public class ResourceDisplay extends JFrame{

	private static final long serialVersionUID = 1L;
	static JLabel health = new JLabel();
	static JLabel sanity = new JLabel();
	static JLabel info = new JLabel();
	static JLabel energy = new JLabel();
	
	static Integer energyCount = Main.playerSheet.getEnergy();
	static Integer healthCount = Main.playerSheet.getHealth();
	static Integer sanityCount = Main.playerSheet.getSanity();
	
	public ResourceDisplay() {
		this.setSize(250,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		
		health.setText("Health: " + healthCount.toString());
		health.setHorizontalAlignment(JLabel.LEFT);
		sanity.setText("Sanity: " + sanityCount.toString());
		info.setText(Main.player.getname() + ", " + Main.player.getGender());
		energy.setText("Energy:" + energyCount.toString());
		
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
