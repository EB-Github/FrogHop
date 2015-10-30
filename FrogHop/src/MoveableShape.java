import java.awt.*;

/**
   A shape that can be moved around.
*/
public interface MoveableShape
{
   /**
      Draws the shape to be moved.
      @param g2 the graphical context
   */
  
void draw(Graphics2D g2);
   /**
      Moves the shape by a given amount.
      @param dx the amount to translate in x-direction
      @param dy the amount to translate in y-direction
   */
void translate();
   
   /**
 * @return the width as an integer
 */
int getWidth();
   /**
 * @return the height as an integer
 */
int getHeight();
   /**
 * @return the image as an Image
 */
Image getImage();
   /**
 * @return the x value of the object as an integer
 */
int getX();
   /**
 * @return the y value of the object as an integer
 */
int getY();
}
