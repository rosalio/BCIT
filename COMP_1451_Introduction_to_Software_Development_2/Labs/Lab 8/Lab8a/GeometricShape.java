
/**
 * Write a description of class GeometricShape here.
 * 
 * @author Alex Dai
 * @version 11/07/2014
 */
public abstract class GeometricShape
{
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Constructor of class GeometricShape
     * @param xPosition
     * @param yPosition
     * @param color
     */
    public GeometricShape(int xPosition, int yPosition, String color, boolean isVisible)
    {
        setXPosition(xPosition);
        setYPosition(yPosition);
        setColor(color);
        setIsVisible(isVisible);
    }
    
    /**
     * Set x position
     * @param xPosition
     */
    public void setXPosition(int xPosition)
    {
        this.xPosition = xPosition;
    }

    /**
     * Set y position
     * @param yPosition
     */
    public void setYPosition(int yPosition)
    {
        this.yPosition = yPosition;
    }
    
    /**
     * Set color
     * @param color
     */
    public void setColor(String color)
    {
        this.color = color;
    }
    
    /**
     * Set is visible
     * @param isVisible
     */
    public void setIsVisible(boolean isVisible)
    {
        this.isVisible = isVisible;
    }
    
    /**
     * Get x position
     * @return xPosition
     */
    public int getXPosition()
    {
        return xPosition;
    }
    
    /**
     * Get y position
     * @return yPosition
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    /**
     * Get color
     * @return color
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     * Get is visible
     * @return isVisible
     */
    public boolean getIsVisible()
    {
        return isVisible;
    }
    
    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
            
    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
        /**
     * Move the circle a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the circle horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the circle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the circle vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }
    
    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }
    
    /*
     * Erase the circle on screen.
     */
    public void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    /**
     * Abstract draw() method
     */
    abstract public void draw();
}
