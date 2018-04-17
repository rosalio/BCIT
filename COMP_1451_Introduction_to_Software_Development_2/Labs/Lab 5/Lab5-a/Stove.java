
/**
 * Write a description of class Stove here.
 * 
 * @author Alex Dai
 * @version 10/17/2014
 */
public class Stove extends Appliance
{
    private int numberOfHeatingElements;

    /**
     * Default constructor for objects of class Stove
     */
    public Stove()
    {
        super();
        setNumberOfHeatingElements(0);
    }

    /**
     * Constructor for objects of class Stove
     *
     * @param brand
     *          the brand
     * @param serialNumber
     *          the serial number
     * @param interiorHeightInCentimeters
     *          the interior height in centimeters
     * @param interiorDepthInCentimeters
     *          the interior depth in centimeters
     * @param interiorWidthInCentimeters
     *          the interior width in centimeters
     * @param numberOfHeatingElements
     *          the number of heating elements
     */
    public Stove(String brand, String serialNumber, int interiorHeightInCentimeters, int interiorDepthInCentimeters, int interiorWidthInCentimeters, int numberOfHeatingElements)
    {
        super(brand, serialNumber, interiorHeightInCentimeters, interiorDepthInCentimeters, interiorWidthInCentimeters);
        setNumberOfHeatingElements(numberOfHeatingElements);
    }
    
    public int getNumberOfHeatingElements()
    {
        return this.numberOfHeatingElements;
    }
    
    public void setNumberOfHeatingElements(int numberOfHeatingElements)
    {
        this.numberOfHeatingElements = numberOfHeatingElements >= 0 ? numberOfHeatingElements : this.numberOfHeatingElements;
    }
}
