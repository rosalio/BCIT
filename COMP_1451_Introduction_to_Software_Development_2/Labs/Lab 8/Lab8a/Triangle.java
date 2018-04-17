import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Triangle extends GeometricShape
{
    private int height;
    private int width;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle(int xPosition, int yPosition, String color, boolean isVisible, int height, int width)
    {
        super(xPosition, yPosition, color, isVisible);
        this.height = height;
        this.width = width;
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newHeight, int newWidth)
    {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }

    /*
     * Draw the triangle with current specifications on screen.
     */
    public void draw()
    {
        if(getIsVisible()) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { getXPosition(), getXPosition() + (width/2), getXPosition() - (width/2) };
            int[] ypoints = { getYPosition(), getYPosition() + height, getYPosition() + height };
            canvas.draw(this, getColor(), new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }
}
