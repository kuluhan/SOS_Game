import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;

public class SOSCanvas extends JPanel
{
   // properties 
   SOS sos;
   // constructors
   public SOSCanvas(SOS sos)
   {
      this.sos = sos;
      this.setPreferredSize(new Dimension(400,400));
      repaint();
   }
   
   // methods
   public void paintComponent(Graphics g)
   {
      int x = getWidth();
      int y = getHeight();
      super.paintComponent(g);
      
      int xstart = 0;
      int ystart = 0;
      
      for(int i = 0; i <= sos.getDimension(); i++)
      {
         xstart = i * (x / sos.getDimension());
         g.drawLine(xstart, 0, xstart, y);
         ystart = i * (y / sos.getDimension());
         g.drawLine(0, ystart, x, ystart);
         for(int j = 0; j <= sos.getDimension(); j++)
         {
            if(i != sos.getDimension() && j != sos.getDimension())
            {
               g.drawString(""+sos.getCellContents(i,j),(int)((2*i+1)/(double)2*x/sos.getDimension()),(int)((2*j+1)/(double)2*x/sos.getDimension()));
            }
         }
         
      }
      
   }
}