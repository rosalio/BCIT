
/**
 * Write a description of class Refrigerator here.
 * 
 * @author Alex Dai
 * @version 10/17/2014
 */
public class Refrigerator extends Appliance
{
    private double maxDegreesInCentigrade;
    
    /**
     * Default constructor for objects of class Refrigerator
     */
    public Refrigerator()
    {
        super();
        setMaxDegreesInCentigrade(0);
    }

    /**
     * Constructor for objects of class Refrigerator
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
     * @param maxDegreesInCentigrade
     *          the maximum degrees in centigrade
     */
    public Refrigerator(String brand, String serialNumber, int interiorHeightInCentimeters, int interiorDepthInCentimeters, int interiorWidthInCentimeters, double maxDegreesInCentigrade)
    {
        super(brand, serialNumber, interiorHeightInCentimeters, interiorDepthInCentimeters, interiorWidthInCentimeters);
        setMaxDegreesInCentigrade(maxDegreesInCentigrade);
    }
    
    /**
     * Get the maximum degrees in centigrade
     * 
     * @return maxDegreesInCentigrade
     */
    public double getMaxDegreesInCentigrade()
    {
        return this.maxDegreesInCentigrade;
    }
    
    /**
     * Set the maximum degrees in centigrade
     * 
     * @param maxDegreesInCentigrade
     *             the maximum degees in centigrade
     */
    public void setMaxDegreesInCentigrade(double maxDegreesInCentigrade)
    {
        this.maxDegreesInCentigrade = maxDegreesInCentigrade;
    }
    
        /**
     * Calculate the capacity in cubic centimeters
     * 
     * @return capacity
     */
    public int calculateCapacity()
    {
        return getInteriorHeightInCentimeters() * getInteriorDepthInCentimeters() * getInteriorWidthInCentimeters();
    }
}
