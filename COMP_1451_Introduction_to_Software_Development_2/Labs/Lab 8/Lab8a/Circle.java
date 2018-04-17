import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Circle extends GeometricShape
{
    private int diameter;
    
    /**
     * Create a new circle at default position with default color.
     */
    public Circle(int xPosition, int yPosition, String color, boolean isVisible, int diameter)
    {
        super(xPosition, yPosition, color, isVisible);
        this.diameter = diameter;
    }
    
    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newDiameter)
    {
        erase();
        diameter = newDiameter;
        draw();
    }

    /*
     * Draw the circle with current specifications on screen.
     */
    public void draw()
    {
        if(getIsVisible()) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, getColor(), new Ellipse2D.Double(getXPosition(), getYPosition(), diameter, diameter));
            canvas.wait(10);
        }
    }
}
