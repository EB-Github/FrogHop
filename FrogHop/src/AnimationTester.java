import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;


/**
 * @author Eli Brown
 *
 */
public class AnimationTester
{
   public static void main(String[] args) throws IOException
   {
      JFrame frame = new JFrame("Frog");
      
      final CarShape car
            = new CarShape(0, 100, "car.png");
     
      
      final FrogShape frog
      = new FrogShape(175, 200, "frog.png");

      MultiShape gamePanel =  new MultiShape(car, frog);
     
      
      
      JPanel outerPanel = new JPanel(new BorderLayout());
      JPanel topPanel = new JPanel(new BorderLayout());
      JLabel label = new JLabel();
      label.setFont(new Font("SansSerif", Font.BOLD, 20));
      label.setHorizontalAlignment(SwingConstants.CENTER);
     
      
      topPanel.add(label, BorderLayout.NORTH);
      topPanel.add(gamePanel, BorderLayout.CENTER);
      outerPanel.add(topPanel, BorderLayout.BEFORE_FIRST_LINE);
      
      frame.add(outerPanel);
      frame.setPreferredSize(new Dimension(400, 300));
      frame.setVisible(true);
      frame.pack();
      frame.setResizable(false);
      
     
      gamePanel.setFocusable(true);
      gamePanel.requestFocus();
      final int DELAY = 40;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               car.translate();
               gamePanel.collisionDetection();
               label.setText("Score: " + frog.levelcounter);
               label.repaint();
               gamePanel.repaint();               
               
            }
         });
      t.start();
      gamePanel.listen();

      
   }
   
}
