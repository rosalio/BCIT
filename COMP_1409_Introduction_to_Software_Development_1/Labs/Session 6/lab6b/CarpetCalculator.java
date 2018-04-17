
/**
 * Write a description of class CarpetCalculator here.
 * 
 * @author Alex Dai
 * @version May 15 2014
 */
public class CarpetCalculator
{
    private double pricePerSquareFoot;
    private Room room;

    /**
     * Default constructor
     */
    public CarpetCalculator()
    {
        setPrice(0);
        setRoom(new Room());
    }

    /**
     * Non-default constructor
     * @param   price
     * @param   theRoom
     */
    public CarpetCalculator(double price, Room theRoom)
    {
        setPrice(price);
        setRoom(theRoom);
    }
    
    /**
     * Set price per square foot
     * @param   price
     */
    public void setPrice(double price)
    {
        if(price > 0) {
            pricePerSquareFoot = price;
        }
    }
    
    /**
     * Set the room
     * @param   theRoom
     */
    public void setRoom(Room theRoom)
    {
        if(null == theRoom) {
            room = new Room();
        }
        else {
            room = theRoom;
        }
    }
    
    /**
     * Get price per square foot
     * @return  pricePerSquareFoot
     */
    public double getPrice()
    {
        return pricePerSquareFoot;
    }
    
    /**
     * Get the room
     * @return room
     */
    public Room getRoom()
    {
        return room;
    }
    
    /**
     * Calculate and return the total cost of the carpet of the room
     * @return  total cost
     */
    public double calculateTotalCost()
    {
        return pricePerSquareFoot * room.calculateArea();
    }
    
    /**
     * Display related information
     */
    public void displayInfo()
    {
        System.out.printf("Room Length: %f feet\n", room.getLength());
        System.out.printf("Room Width: %f feet\n", room.getWidth());
        System.out.printf("Room Area: %f square feet\n", room.calculateArea());
        System.out.printf("Price Per Square Foot: %.2f CAD\n", pricePerSquareFoot);
        System.out.printf("Total Cost: %.2f CAD\n", calculateTotalCost());
        System.out.println();
    }
}
