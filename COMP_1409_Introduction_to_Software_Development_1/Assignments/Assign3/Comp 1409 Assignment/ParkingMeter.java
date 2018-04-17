
/**
 * Implementation of class ParkingMeter.
 * 
 * @author Alex Dai
 * @version 04/23/2014
 */
public class ParkingMeter
{
    // instance variables - replace the example below with your own
    private static final int MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES = 180;
    private int numOfPurchasedMins;
    private String meterType;
    private String meterLocation;
    private double pricePerMinInCAD;
    private boolean hasCamera;

    /**
     * Default constructor
     */
    public ParkingMeter()
    {
        numOfPurchasedMins = 0;
        meterType = "";
        meterLocation = "";
        pricePerMinInCAD = 0.0;
        hasCamera = false;
    }

    /**
     * Non-default constructor
     * 
     * @param   minsPurchased as an int
     * @param   type as a String
     * @param   location as a String
     * @param   price as a double
     * @param   camera as a boolean
     */
    public ParkingMeter(int minsPurchased, String type, String location, double price, boolean camera)
    {
        if (minsPurchased > MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES) {
            numOfPurchasedMins = MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES;
        }
        else if (minsPurchased < 0) {
            numOfPurchasedMins = 0;
        }
        else {
            numOfPurchasedMins = minsPurchased;
        }
        
        if (type != null) {
            meterType = type;
        }
        else {
            meterType = "";
        }
        
        if (location != null) {
            meterLocation = location;
        }
        else {
            meterLocation = "";
        }
        
        if (price >= 0.0) {
            pricePerMinInCAD = price;
        }
        else {
            pricePerMinInCAD = 0.0;
        }
        
        hasCamera = camera;    
    }
    
    /**
     * get number of purchased minutes
     * @return  numOfPurchasedMins 
     */
    public int getPurchasedMins()
    {
        return numOfPurchasedMins;
    }
    
    /**
     * get meter type
     * @return  meterType
     */
    public String getType()
    {
        return meterType;
    }
    
    /**
     * get meter location
     * @return  meterLocation
     */
    public String getLocation()
    {
        return meterLocation;
    }
    
    /**
     * get price of one minute in CAD
     * @return  pricePerMin
     */
    public double getPrice()
    {
        return pricePerMinInCAD;
    }
    
    /**
     * get if there is a camera
     * @return hasCamera
     */
    public boolean getCamera()
    {
        return hasCamera;

    }
    
    /**
     * set number of purchased minutes
     * @param   minsPurchased
     */
    public void setPurchasedMins(int minsPurchased)
    {
        if (minsPurchased > MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES) {
            numOfPurchasedMins = MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES;
            System.out.println("The input parameter is too big. The maximum number of purchased minutes allowed is " + MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES + ".");
        }
        else if (minsPurchased < 0) {
            System.out.println("Invalid input parameter! The number of purchased minutes should be positive.");
        }
        else {
            numOfPurchasedMins = minsPurchased;
        }
    }
    
    /**
     * set meter type
     * @param   type
     */
    public void setType(String type)
    {
        if (type != null) {
            meterType = type;
        }
        else {
            System.out.println("Invalid input parameter! The meter type cannot be \"null\".");
        }
    }
    
    /**
     * set meter location
     * @param   location
     */
    public void setLocation(String location)
    {
        if (location != null) {
            meterLocation = location;
        }
        else {
            System.out.println("Invalid input parameter! The meter location cannot be \"null\".");
        }
        
    }
    
    /**
     * set price per minute in CAD
     * @param   price
     */
    public void setPrice(double price)
    {
        if( price < 0.0) {
            System.out.println("Invalid input parameter! The price of one minute cannot be negative.");
        }
        else {
            pricePerMinInCAD = price;
        }
    }
    
    /**
     * set if there is a camera
     * @param   camera
     */
    public void setCamera(boolean camera)
    {
        hasCamera = camera;
    }
    
    /**
     * Method to display the details of the parking meter on screen
     */
    public void displayMeterInfo()
    {
        System.out.println("Number of Purchased Minutes: " + numOfPurchasedMins + " minutes");
        System.out.println("Meter Type: " + meterType);
        System.out.println("Meter Location: " + meterLocation);
        System.out.println("Price of One Minute: " + pricePerMinInCAD + " CAD");
        System.out.println("Camera Included: " + hasCamera);
    }
}