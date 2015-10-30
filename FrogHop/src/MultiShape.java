import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;



/**
 * Creates a MultiShape component that displays a frog and a car on the screen.
 *
 */
public class MultiShape extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CarShape x;
	private FrogShape y;
	//Array of x's
	//Array of y's
	//array of 
	private Image image1;
	private Image image2;
	private Rectangle car;
	private Rectangle frog;
	
	/**
	 * @param a CarShape
	 * @param a FrogShape
	 * 
	 */
	public MultiShape(CarShape x, FrogShape y){
		this.x = x;
		this.y = y;
		image1 = x.getImage();
		image2 = y.getImage();
		this.setSize(500, 300);
	}
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	public Dimension getPreferredSize() {
        if (image1 == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(400, 500);
        }
    }
	
	/**
	 *
	 * Implements a KeyListener and moves the frog around the screen
	 * 
	 */
	public void listen(){
		this.addKeyListener(new KeyListener() {
	        public void keyPressed(KeyEvent e)
	        {
	          if (e.getKeyCode() == KeyEvent.VK_LEFT)
	          {
	        	  
	               y.LEFT();
	          }
	          else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	          {
	               y.RIGHT();
	          }
	          else if (e.getKeyCode() == KeyEvent.VK_UP)
	          {
	               y.UP();
	          }
	          else if (e.getKeyCode() == KeyEvent.VK_DOWN)
	          {
	               y.DOWN();
	          }
	        }

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
	      });
	}
	
	/**
	 * Uses bounding boxes to detect collision between two objects
	 */
	public void collisionDetection(){
		car = x.bounds();
		frog = y.bounds();
		if(car.intersects(frog)){
			System.out.println("Failure");
			y.levelcounter = 0;
			x.resetDX();
			y.setY(200);
			y.setX(175);
		
		}
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
	    super.paintComponents(g);

	    Graphics2D g2 = (Graphics2D) g;
	    Graphics2D g3 = (Graphics2D) g;
	    

	    g2.drawImage(image1, x.getX(), x.getY(), null);
	    g3.drawImage(image2, y.getX(), y.getY(), null);
	}
	

}
