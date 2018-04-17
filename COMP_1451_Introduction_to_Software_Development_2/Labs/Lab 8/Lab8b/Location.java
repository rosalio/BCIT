
/**
 * Write a description of class Location here.
 * 
 * @author Alex Dai
 * @version 11/12/2014
 */
public class Location
{
    private int xPosition;
    private int yPosition;

    /**
     * Constructor of class Location
     * @param xPosition
     * @param yPosition
     */
    public Location(int xPosition, int yPosition)
    {
        setXPosition(xPosition);
        setYPosition(yPosition);
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
}
