import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SOSGUIPanel extends JPanel
{
   // properties
   JPanel panel;
   JLabel label1;
   JLabel label2;
   String player1;
   String player2;
   JRadioButton button1;
   JRadioButton button2;
   int score1;
   int score2;
   SOSCanvas canvas;
   
   // constructors
   public SOSGUIPanel(SOS sos, String name1, String name2)
   {
      player1 = name1;
      player2 = name2;
      score1 = 0;
      score2 = 0;
      button1 = new JRadioButton("s");
      button2 = new JRadioButton("o");
      button1.setActionCommand("s");
      button2.setActionCommand("o");
      
      ButtonGroup letterSelection = new ButtonGroup();
      letterSelection.add(button1);
      letterSelection.add(button2);
      letterSelection.clearSelection();
      button1.setSelected(true);
      
      label1 = new JLabel(player1 + ": " + sos.getPlayerScore1());
      label2 = new JLabel(player2 + ": " + sos.getPlayerScore2());
      panel = new JPanel();
      panel.add(label1);
      panel.add(button1);
      panel.add(button2);
      panel.add(label2);
      label1.setBackground(Color.green);
      label1.setOpaque(true);
      label2.setOpaque(true);
      label2.setBackground(Color.white);
      canvas = new SOSCanvas(sos);
      add(canvas, BorderLayout.NORTH);
      add(panel, BorderLayout.PAGE_END);

      canvas.addMouseListener(new MouseAdapter(){
         public void mouseClicked(MouseEvent e)
         {
               int row = (e.getX() / (canvas.getWidth() / sos.getDimension())) + 1;
               int col = (e.getY() / (canvas.getHeight() / sos.getDimension())) + 1;
//               int index1 = ((canvas.getWidth() / sos.getDimension()) * (row - 1) + (canvas.getWidth() / sos.getDimension()) * row) / 2;
//               int index2 = ((canvas.getHeight() / sos.getDimension()) * (col - 1) + (canvas.getHeight() / sos.getDimension()) * col) / 2;
               String letterSelected =  letterSelection.getSelection().getActionCommand();
               int result = sos.play(letterSelected.charAt(0),row,col);
               label1.setText(player1 + ": " + sos.getPlayerScore1());
               label2.setText(player2 + ": " + sos.getPlayerScore2());
               
               if(sos.getTurn()==1)
               {
                  label1.setBackground(Color.green);
                  label2.setBackground(Color.white);
               }
               else
               {
                  label1.setBackground(Color.white);
                  label2.setBackground(Color.green);
               }
               canvas.repaint();
               
               if(sos.isGameOver())
               {
                  int s1 = sos.getPlayerScore1();
                  int s2 = sos.getPlayerScore2();
                  String s = "";
                  if(s1>s2)
                     s += player1 + " is the winner";
                  else if(s1<s2)
                     s += player2 + " is the winner";
                  else
                     s += "Its a tie";
                  JOptionPane.showMessageDialog(null,s);
               }
            
            
         }
      });
      
   }
   
}