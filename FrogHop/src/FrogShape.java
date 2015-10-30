import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * A frog that moves around under user control
 *
 */
public class FrogShape implements MoveableShape {
	 int levelcounter;
	 private int x;
	 private int dx = 10;
     private int dy = 80;
	 private int y;
	 private int width = 25;
	 private int height = 25;
	 private BufferedImage image;
	 private Image finalImage;
	/**
	 * @param x value in the form  of an integer
	 * @param y value in the form of an integer
	 * @param a filename in the form a string
	 */
	public	FrogShape(int x, int y, String file)
	   {
	      this.x = x;
	      this.y = y;
	      
	      try { image = ImageIO.read(getClass().getResource(file)); } catch (IOException e){System.out.print("file error");
	    	  
	      }
	      finalImage =   image.getScaledInstance(width, height, 0);
	   
	      
	      
	   }
	public	FrogShape(int x, int y, BufferedImage file)
	   {
	      this.x = x;
	      this.y = y;
	      
	      image = file;
	      finalImage =   image.getScaledInstance(width, height, 0);
	   
	      
	      
	   }

	

	/* (non-Javadoc)
	 * @see MoveableShape#translate()
	 */
	@Override
	public void translate() {
		x += dx;
	    y += dy;
	     
		
	}
       
	/* (non-Javadoc)
	 * @see MoveableShape#getWidth()
	 */
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	/* (non-Javadoc)
	 * @see MoveableShape#getHeight()
	 */
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
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
	
	//"Magic numbers" below are the values necessary to prevent the frog from leaving the play area
	/**
	 * moves the frog left inside the frame
	 */
	public void LEFT(){
		if(x < width/2){
			x = width/2;}
			x = x - dx;
	}
	/**
	 * moves the frog right inside the frame
	 */
	public void RIGHT(){
		if(x > 370){
			x = 370;}
		x = x + dx;
	}
	
	/**
	 * Moves the frog up inside the frame
	 */
	public void UP(){
		if(y < 50){
			y = 200; 
			levelcounter++;
			System.out.println("You Have Reached Level: " + levelcounter);}
		else if (y >= 50)
		y = y - dy;
	}
	/**
	 * Moves the frog down inside the frame
	 */
	public void DOWN(){
		if(y > 100){
			y = 200;}
		else if (y <= 100)
		y = y + dy;
	}
	
	/**
	 * @return  a Rectangle for use in the MultiShape CollisionDetection method
	 */
	public Rectangle bounds(){
		return new Rectangle(x, y, width, height);
	}
	
	/**
	 * @param an integer
	 * Sets the X value.
	 */
	public void setX(int x){
		this.x = x;
	}
	/**
	 * @param an integer
	 * Sets the Y value.
	 */
	public void setY(int y){
		this.y = y;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

}
