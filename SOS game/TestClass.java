import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;
public class TestClass
{
   public static void main(String[] args)
   {
      JFrame f = new JFrame();
      JFrame mainFrame = new JFrame();
      mainFrame.setLayout(new BorderLayout());
      mainFrame.add(new SOSGUIPanel(new SOS(5),"user1","user2"),BorderLayout.WEST); 
      mainFrame.add(new SOSGUIPanel(new SOS(3),"user1","user2"),BorderLayout.EAST);
      mainFrame.pack();
      mainFrame.setVisible(true);

   }
}