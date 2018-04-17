
/**
 * class: Driver
 * 
 * @author Alex Dai 
 * @version Apr 22 2014
 */
public class Driver
{
    // instance variables
    private String name;
    private String driverLicense;
    private int speedInKperHour;
    private String driverStanding;

    /**
     * Default constructor
     */
    public Driver()
    {
        name = "";
        driverLicense = "";
        speedInKperHour = 0;
        driverStanding = "";
    }

    /**
     * Non-default constructor
     * 
     * @param   driverName as a String
     * @param   license as a String
     * @param   speed as an int
     */
    public Driver(String driverName, String license, int speed)
    {
        if (driverName != null) {
            name = driverName;
        }
        else {
            name = "";
        }
            
        if ( license != null) {
            driverLicense = license;
        }
        else {
            driverLicense = "";
        }
        
        if (speed > 0) {
            speedInKperHour = speed;
        }
        else {
            speedInKperHour = 0;
        }
        
        driverStanding = "";
    }
    
    /**
     * get driver name
     * @return  name 
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * get driver license
     * @return  driverLicense 
     */
    public String getLicense()
    {
        return driverLicense;
    }
    
    /**
     * get speed in km per hour
     * @return  speedInKperHour 
     */
    public int getSpeed()
    {
        return speedInKperHour;
    }
    
    /**
     * get driver standing
     * @return  driverStanding 
     */
    public String getStanding()
    {
        return driverStanding;
    }
    
    /**
     * set driver name
     * @param   driverName
     */
    public void setName(String driverName)
    {
        if (driverName != null) {
            name = driverName;
        }
    }
    
    /**
     * set driver license
     * @param   license
     */
    public void setLicense(String license)
    {
        if (license != null) {
            driverLicense = license;
        }
    }
    
    /**
     * set speed in km per hour
     * @param speed
     */
    public void setSpeed(int speed)
    {
        if (speed >= 0) {
            speedInKperHour = speed;
        }
    }
    
    /**
     * set driver standing
     */
    public void setStanding()
    {
        if (speedInKperHour <= 60) {
            driverStanding = "no ticket";
        }
        else if (speedInKperHour <= 80) {
            driverStanding = "small ticket";
        }
        else {
            driverStanding = "big ticket";
        }
    }
    
    /**
     * method to display the driver's details
     */
    public void displayDriverInfo()
    {
        System.out.println("Driver name: " + name);
        System.out.println("Driver License: " + driverLicense);
        System.out.println("Speed: " + speedInKperHour + " K/H");
        System.out.println("Driver Standing: " + driverStanding);
    }
}
