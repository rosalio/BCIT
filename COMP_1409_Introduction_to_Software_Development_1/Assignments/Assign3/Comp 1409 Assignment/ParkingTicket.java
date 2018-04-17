
/**
 * Write a description of class ParkingTicket here.
 * 
 * @author Alex Dai
 * @version 05/09/2014
 */

public class ParkingTicket
{
    public final int INCREMENT_VALUE = 1;
    
    private static String ticketNumber = "V1000";   // the initial value, add one to get number of the first ticket
    private String officerName;
    private String badgeNumber;
    private String carLicenseNumber;
    private String carMaker;
    private String carModel;
    private double amountOfFineInCAD;
    

    /**
     * Default constructor
     */
    public ParkingTicket()
    {
        createTicketNumber();
        setOfficerName("");
        setBadgeNumber("");
        setLicenseNumber("");
        setCarMaker("");
        setCarModel("");
        setAmountOfFine(0);
    }
    
    /**
     * Non-Default constructor
     * @param name
     * @param badge
     * @param license
     * @param maker
     * @param model
     * @param fineInCAD
     */
    public ParkingTicket(String name, String badge, String license, String maker, String model, double fineInCAD)
    {
        createTicketNumber();
        setOfficerName(name);
        setBadgeNumber(badge);
        setLicenseNumber(license);
        setCarMaker(maker);
        setCarModel(model);
        setAmountOfFine(fineInCAD);
    }
    
    /**
     * Create the ticket number  
     */
    private void createTicketNumber()
    {
        // the ticket number is composed of non-digit part followed by digit part (must be satisfied)
        // for each new ticket, add one to the digit part
        int index = ticketNumber.length() - 1;  // index of the last character
        
        // find where the non-digit part ends
        while(index >= 0 && Character.isDigit(ticketNumber.charAt(index))) {
            index--;
        }
             
        String nonDigit = ticketNumber.substring(0, index + 1); // substring containing the non-digit part
        String digit = ticketNumber.substring(index + 1);   // substring containing the digit part
        int i = Integer.parseInt(digit) + INCREMENT_VALUE;  // add one
        ticketNumber = nonDigit + i;    // merge the two parts
    }
        
    /**
     * Set police officer's name
     * @param name
     */
    public void setOfficerName(String name)
    {
        if(name != null) {
            officerName = name;
        }
        else {
            officerName = "";
        }
    }
    
    /**
     * Set officer's badge number
     * @param badge
     */
    public void setBadgeNumber(String badge)
    {
        if(badge != null) {
            badgeNumber = badge;
        }
        else {
            badgeNumber = "";
        }
    }
    
    /**
     * Set car license number
     * @param license
     */
    public void setLicenseNumber(String license)
    {
        if(license != null) {
            carLicenseNumber = license;
        }
        else {
            carLicenseNumber = "";
        }
    }
    
    /**
     * Set car maker
     * @param maker
     */
    public void setCarMaker(String maker)
    {
        if(maker != null) {
            carMaker = maker;
        }
        else {
            carMaker = "";
        }
    }
    
    /**
     * Set car model
     * @param model
     */
    public void setCarModel(String model)
    {
        if(model != null) {
            carModel = model;
        }
        else {
            carModel = "";
        }
    }
    
    /**
     * Set amount of the fine
     * @param fineInCAD 
     */
    public void setAmountOfFine(double fineInCAD)
    {
        if(fineInCAD >= 0) {
            amountOfFineInCAD = fineInCAD;
        }
        else {
            amountOfFineInCAD = 0;
        }
    }
    
    /**
     * Get ticket number
     * @return ticketNumber;
     */
    public String getTicketNumber()
    {
        return ticketNumber;
    }
    
    /**
     * Get the name of the police officer who issued the ticket
     * @return officerName
     */
    public String getOfficerName()
    {
        return officerName;
    }
    
    /**
     * Get the police officer's badge number
     * @return badgeNumber
     */
    public String getBadgeNumber()
    {
        return badgeNumber;
    }
    
    /**
     * Get car license number
     * @return carLicenseNumber
     */
    public String getLicenseNumber()
    {
        return carLicenseNumber;
    }

    /**
     * Get car's maker
     * @return carMaker
     */
    public String getCarMaker()
    {
        return carMaker;
    }
    
    /**
     * Get car model
     * @return carModel
     */
    public String getCarModel()
    {
        return carModel;
    }
    
    /**
     * Get amount of the fine
     * @return amountOfFineInCAD
     */
    public double getAmountOfFineInCAD()
    {
        return amountOfFineInCAD;
    }

    /**
     * Display the details of the ticket
     */
    public void displayTicket()
    {
        System.out.println("------ Ticket Issued ------");
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Officer Name: " + officerName);
        System.out.println("Badge Number: " + badgeNumber);
        System.out.println("Car License Number: " + carLicenseNumber);
        System.out.println("Car Make: " + carMaker);
        System.out.println("Car Model: " + carModel);
        System.out.printf("Fine: CAD $%.2f\n", amountOfFineInCAD);
        System.out.println("------------ End ------------");
    }
}
