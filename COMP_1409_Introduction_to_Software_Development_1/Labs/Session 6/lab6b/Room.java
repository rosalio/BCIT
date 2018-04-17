
/**
 * Write a description of class Room here.
 * 
 * @author Alex Dai
 * @version May 15 2014
 */
public class Room
{
    private double lengthInFeet;
    private double widthInFeet;

    /**
     * Default constructor
     */
    public Room()
    {
        setLength(0);
        setWidth(0);
    }

    /**
     * Non-default constructor
     * @param   length
     * @param   width
     */
    public Room(double length, double width)
    {
        setLength(length);
        setWidth(width);
    }
    
    /**
     * Set length of the room
     * @param   length
     */
    public void setLength(double length)
    {
        if(length > 0) {
            lengthInFeet = length;
        }
    }
    
    /**
     * Set width of the room
     * @param   width
     */
    public void setWidth(double width)
    {
        if(width > 0) {
            widthInFeet = width;
        }
    }
    
    /**
     * Get length of the room
     * @return  lengthInFeet
     */
    public double getLength()
    {
        return lengthInFeet;
    }
    
    /**
     * Get width of the room
     * @return  widthInFeet
     */
    public double getWidth()
    {
        return widthInFeet;
    }
    
    /**
     * Calcuate and return the room area in square feet
     * @return  the room area in square feet
     */
    public double calculateArea()
    {
        return lengthInFeet * widthInFeet;
    }    
}
