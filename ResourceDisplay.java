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
	static Integer healthCount = Main.playerSheet.getHealth();
	static Integer sanityCount = Main.playerSheet.getSanity();
	
	public ResourceDisplay() {
		this.setSize(250,75);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		
		health.setText("Health: " + healthCount.toString());
		health.setHorizontalAlignment(JLabel.LEFT);
		sanity.setText("Sanity: " + sanityCount.toString());
		info.setText(Main.player.getname() + ", " + Main.player.getGender());
		
		this.add(health);
		this.add(sanity);
		this.add(info);
		
		this.setVisible(true);
	}
	
	public static void updateText() {
		healthCount = Main.playerSheet.getHealth();
		sanityCount = Main.playerSheet.getSanity();
		
		health.setText("Health: " + healthCount.toString());
		sanity.setText("Sanity: " + sanityCount.toString());
	}
	
	public static void updateInfo() {
		info.setText(Main.player.getname() + ", " + Main.player.getGender());
	}
}
