import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

/**
   A car that moves back and forth in a lane
*/
public class CarShape implements MoveableShape
{
	private BufferedImage image = null;
	private Image finalImage;
	private int x;
	private int y;
	private int width = 100;
	private int height = 50;
	private double dx = width/10;
	private int dy;
	
   /**
 * @param x value in the form of an integer
 * @param y value in the form of an integer
 * @param filename in the form of a string
 */
public CarShape(int x, int y, String filename)
   {
      this.x = x;
      this.y = y;
      
      try { image = ImageIO.read(getClass().getResource(filename)); } catch (IOException e){System.out.print("file error");
    	  
      }
      finalImage =   image.getScaledInstance(width, height, 0);
   
      
      
   }
public CarShape(int x, int y, BufferedImage file)
{
   this.x = x;
   this.y = y;
   
   image = file;
   finalImage =   image.getScaledInstance(width, height, 0);

   
   
}
   

   /* (non-Javadoc)
 * @see MoveableShape#translate()
 */
public void translate()
   {
     x += dx;
     y += dy;
     
     //prevents the car from leaving the window
     if (x - 1 < 0) {
        dx = -dx;
         x = 1; 
      } 
      else if (x + width > 400) {
         dx = -dx-0.01;
         x = 400 - width;
      }
     
      
      
   }

   /* (non-Javadoc)
 * @see MoveableShape#draw(java.awt.Graphics2D)
 */
public void draw(Graphics2D g2)
   {
      
      
      
      g2.drawImage(finalImage, x, y, null);
    
   }
   /**
    * Returns a bounding box for the object
 * @return Rectangle
 */
public Rectangle bounds(){
	   return new Rectangle(x, y, width, height);
   }
   /* (non-Javadoc)
 * @see MoveableShape#getWidth()
 */
public int getWidth(){
	   return width;
   }
   /* (non-Javadoc)
 * @see MoveableShape#getHeight()
 */
public int getHeight(){
	   return height;
   }
  
   
   public static void main(String[] args){
	   
   }

/* (non-Javadoc)
 * @see MoveableShape#getImage()
 */
@Override
public Image getImage() {
	// TODO Auto-generated method stub
	return finalImage;
}

/* (non-Javadoc)
 * @see MoveableShape#getX()
 */
@Override
public int getX() {
	// TODO Auto-generated method stub
	return x;
}

/* (non-Javadoc)
 * @see MoveableShape#getY()
 */
@Override
public int getY() {
	// TODO Auto-generated method stub
	return y;
}
/**
 * resets the initial speed of the car
 */
public void resetDX(){
	dx = width/10;
	}
}
