import javax.Swing.JFrame;
import javax.Swing.JLabel;

/* This class displays the resources of the player.
*
*@Author:Elliot Miller
*@Version:1.0
*@Since:12-17-21
*/
public class ResourceWindow extends JFrame{
  public ResourceWindow() {
    this.setSize(500,500);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());
    
    JLabel info = new JLabel();
    switch(Main.player.Gender) {
			case 'M': info.setText(Player.name + ", male");
			break;
			case 'F': info.setText(Player.name + ", female);
			break;
			case 'O': info.setText(Player.name + ", nonbinary");
			break;
      default: info.setText("Error: Unexpected Gender");
    }
    this.add(info)
    
    JLabel sanity = new JLabel();
    sanity.setText("Sanity\n" + Main.playerSheet.sanity);
    this.add(sanity);
    
    JLabel health = new JLabel();
    health.setText("Health\n" + Main.playerSheet.health);
    this.add(health);
    
    
    this.setVisible(true);
  }
                             
    public void newValues() {
      sanity.setText("Sanity\n" + Main.playerSheet.sanity);
      health.setText("Health\n" + Main.playerSheet.health);
    }
}
