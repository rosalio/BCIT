import java.awt.*;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Square extends GeometricShape
{
    private int size;

    /**
     * Create a new square at default position with default color.
     */
    public Square(int xPosition, int yPosition, String color, boolean isVisible, int size)
    {
        super(xPosition, yPosition, color, isVisible);
        this.size = size;
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newSize)
    {
        erase();
        size = newSize;
        draw();
    }

    /*
     * Draw the square with current specifications on screen.
     */
    public void draw()
    {
        if(getIsVisible()) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, getColor(), new Rectangle(getXPosition(), getYPosition(), size, size));
            canvas.wait(10);
        }
    }
}
