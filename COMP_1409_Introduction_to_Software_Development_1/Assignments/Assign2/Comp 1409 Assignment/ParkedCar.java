
/**
 * Implementation of ParkedCar class
 * 
 * @author Alex Dai 
 * @version 04/23/2014
 */
public class ParkedCar
{
    // instant variables
    private String carMake;
    private String carModel;
    private String carColor;
    private String carLicenseNum;
    private int numOfMinsParked;
    private String ownerName;

    /**
     * Default constructor
     */
    public ParkedCar()
    {
        carMake = "";
        carModel = "";
        carColor = "";
        carLicenseNum = "";
        numOfMinsParked = 0;
        ownerName = "";
    }

    /**
     * Non-default constructor
     * 
     * @param   make as a String
     * @param   model as a String
     * @param   color as a String
     * @param   licenseNum as a String
     * @param   minsParked as an int
     * @param   owner as a String
     */
    public ParkedCar(String make, String model, String color, String licenseNum, int minsParked, String owner)
    {
        if (make != null) {
            carMake = make;
        }
        else {
            carMake = "";
        }
        
        if (model != null) {
            carModel = model;
        }
        else {
            carModel = "";
        }   
        
        if (color != null) {
            carColor = color;
        }
        else {
            carColor = "";
        }
        
        if (licenseNum != null) {
            carLicenseNum = licenseNum;
        }
        else {
            carLicenseNum = "";
        }
        
        if (minsParked < 0) {
            numOfMinsParked = 0;
        }
        else {
            numOfMinsParked = minsParked;
        }
        
        if (owner != null) {
            ownerName = owner;
        }
        else {
            ownerName = "";
        }
    }
        
    /**
     * get car make
     * @return carMake
     */
    public String getMake()
    {
        return carMake;
    }
    
    /**
     * get car model
     * @return carModel
     */
    public String getModel()
    {
        return carModel;
    }
    
    /**
     * get car color
     * @return carColor
     */
    public String getColor()
    {
        return carColor;
    }
    
    /**
     * get car license number
     * @return carLicenseNum
     */
    public String getLicenseNum()
    {
        return carLicenseNum;
    }
    
    /**
     * get number of minutes parked
     * @return numOfMinsParked
     */
    public int getMinsParked()
    {
        return numOfMinsParked;
    }
    
    /**
     * get owner name
     * @return ownerName
     */
    public String getOwnerName()
    {
        return ownerName;
    }
    
    /**
     * set car make
     * @param make
     */
    public void setMake(String make)
    {
        if (make != null) {
            carMake = make;
        }
        else {
            System.out.println("Invalid input parameter! The car make cannot be \"null\".");
        }
    }
    
    /**
     * set car model
     * @param model
     */
    public void setModel(String model)
    {
        if (model != null) {
            carModel = model;
        }
        else {
            System.out.println("Invalid input parameter! The car model cannot be \"null\".");
        }
    }    
    
    /**
     * set car color
     * @param color
     */
    public void setColor(String color)
    {
        if (color != null) {
            carColor = color;
        }
        else {
            System.out.println("Invalid input parameter! The car color cannot be \"null\".");
        }
    }
    
    /**
     * set car license number
     * @param licenseNum
     */
    public void setLicenseNum(String licenseNum)
    {
        if (licenseNum != null) {
            carLicenseNum = licenseNum;
        }
        else {
            System.out.println("Invalid input parameter! The car license number cannot be \"null\".");
        }
    }
    
    /**
     * set number of minutes parked
     * @param minsParked
     */
    public void setMinsParked(int minsParked)
    {
        if (minsParked > 0) {
            numOfMinsParked = minsParked;
        }
        else {
            System.out.println("Invalid input parameter! The number of minutes parked should be a positive value.");
        }
    }
    
    /**
     * set car owner name
     * @param owner
     */
    public void setOwnerName(String owner)
    {
        if (owner != null) {
            ownerName = owner;
        }
        else {
            System.out.println("Invalid input parameter! The owner name cannot be \"null\".");
        }
    }
    
    
    /**
     * Method to display the details of the car on screen 
     */
    public void displayCarInfo()
    {
        System.out.println("Make: " + carMake);
        System.out.println("Model: " + carModel);
        System.out.println("Color: " + carColor);
        System.out.println("License Number: " + carLicenseNum);
        System.out.println("Time Parked: " + numOfMinsParked + " minutes");
        System.out.println("Owner Name: " + ownerName);
    }
}
