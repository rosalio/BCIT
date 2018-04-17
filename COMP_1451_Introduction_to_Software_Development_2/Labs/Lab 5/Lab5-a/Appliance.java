
/**
 * Write a description of class Appliance here.
 * 
 * @author Alex Dai
 * @version 10/17/2014
 */
public class Appliance
{
    private String brand;
    private String serialNumber;
    private int interiorHeightInCentimeters;
    private int interiorDepthInCentimeters;
    private int interiorWidthInCentimeters;

    /**
     * Default constructor for objects of class Appliance
     */
    public Appliance()
    {
        setBrand("");
        setSerialNumber("");
        setInteriorHeightInCentimeters(0);
        setInteriorDepthInCentimeters(0);
        setInteriorWidthInCentimeters(0);
    }
    
    /**
     * Constructor for objects of class Appliance
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
     */
    public Appliance(String brand, String serialNumber, int interiorHeightInCentimeters, int interiorDepthInCentimeters, int interiorWidthInCentimeters)
    {
        setBrand(brand);
        setSerialNumber(serialNumber);
        setInteriorHeightInCentimeters(interiorHeightInCentimeters);
        setInteriorDepthInCentimeters(interiorDepthInCentimeters);
        setInteriorWidthInCentimeters(interiorWidthInCentimeters);
    }
    
    /**
     * Get the brand
     * 
     * @return brand
     */
    public String getBrand()
    {
        return this.brand;
    }
    
    /**
     * Get the serial number
     * 
     * @return serialNumber
     */
    public String getSerialNumber()
    {
        return this.serialNumber;
    }
    
    /**
     * Get the interior height in centimeters
     * 
     * @return interiorHeightInCentimeters
     */
    public int getInteriorHeightInCentimeters()
    {
        return this.interiorHeightInCentimeters;
    }
    
    /**
     * Get the interior depth in centimeters
     * 
     * @return interiorDepthInCentimeters
     */
    public int getInteriorDepthInCentimeters()
    {
        return this.interiorDepthInCentimeters;
    }
    
    /**
     * Get the interior width in centimeters
     * 
     * @return interiorWidthInCentimeters
     */
    public int getInteriorWidthInCentimeters()
    {
        return this.interiorWidthInCentimeters;
    }
    
    /**
     * Set the brand
     * 
     * @param brand
     *              the brand
     */
    public void setBrand(String brand)
    {
        this.brand = brand != null ? brand : "";
    }
    
    /**
     * Set the serial number
     * 
     * @param serialNumber
     *              the serial number
     */
    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber != null ? serialNumber : "";
    }
    
    /**
     * Set the interior height in centimeters
     * 
     * @param
     *              the interior height in centimeters
     */
    public void setInteriorHeightInCentimeters(int interiorHeightInCentimeters)
    {
        this.interiorHeightInCentimeters = interiorHeightInCentimeters > 0 ? interiorHeightInCentimeters : this.interiorHeightInCentimeters;
    }
    
    /**
     * Set the interior depth in centimeters
     * 
     * @param
     *              the interior depth in centimeters
     */
    public void setInteriorDepthInCentimeters(int interiorDepthInCentimeters)
    {
        this.interiorDepthInCentimeters = interiorDepthInCentimeters > 0 ? interiorDepthInCentimeters : this.interiorDepthInCentimeters;
    }
    
    /**
     * Set the interior width in centimeters
     * 
     * @param
     *              the interior width in centimeters
     */
    public void setInteriorWidthInCentimeters(int interiorWidthInCentimeters)
    {
        this.interiorWidthInCentimeters = interiorWidthInCentimeters > 0 ? interiorWidthInCentimeters : this.interiorWidthInCentimeters;
    }
}
