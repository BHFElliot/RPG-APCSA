import javax.Swing.JFrame;
import javax.Swing.JLabel;

public class ResourceWindow extends JFrame{
  public ResourceWindow() {
    this.setSize(500,500);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel sanity = new JLabel("Sanity");
    
    this.setVisible(true);
  }
}
