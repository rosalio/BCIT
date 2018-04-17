
/**
 * Write a description of class PoliceOfficer here.
 * 
 * @author Alex Dai
 * @version 05/09/2014
 */

import java.util.ArrayList;

public class PoliceOfficer
{
    public static final double FINE_FIRST_HOUR = 25;
    public static final double FINE_ADDITIONAL_HOUR = 20;
    public static final int NUM_OF_MINS_IN_ONE_HOUR = 60;
    
    private String officerName;
    private String badgeNumber;
    private ParkedCar parkedCar;
    private ParkingMeter parkingMeter;
    private ArrayList<ParkingTicket> issuedParkingTickets;
        
    /**
     * Default constructor
     */
    public PoliceOfficer()
    {
        setOfficerName("");
        setBadgeNumber("");
        setParkedCar(new ParkedCar());
        setParkingMeter(new ParkingMeter());
        issuedParkingTickets = new ArrayList<ParkingTicket>();
    }

    /**
     * Non-default constructor
     * @param name
     * @param badge
     * @param car
     * @param meter
     */
    public PoliceOfficer(String name, String badge, ParkedCar car, ParkingMeter meter)
    {
       setOfficerName(name);
       setBadgeNumber(badge);
       setParkedCar(car);
       setParkingMeter(meter);
       issuedParkingTickets = new ArrayList<ParkingTicket>();
    }
    
    /**
     * Get issued parking tickets
     * @return  issuedParkingTickets
     */
    public ArrayList<ParkingTicket> getIssuedParkingTickets()
    {
        return issuedParkingTickets;
    }
    
    /**
     * Get office name
     * @return  officerName
     */
    public String getOfficerName()
    {
        return officerName;
    }
    
    /**
     * Get badge number
     * @return badgeNumber
     */
    public String getBadgeNumber()
    {
        return badgeNumber;
    }
    
    /**
     * Get parked car
     * @return parkedCar
     */
    public ParkedCar getParkedCar() 
    {
        return parkedCar;
    }
    
    /**
     * Get parking meter
     * @return parking meter
     */
    public ParkingMeter getParkingMeter()
    {
        return parkingMeter;
    }
    
    /**
     * Set officer name
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
     * Set badge number
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
     * Set parked car
     * @param car
     */
    public void setParkedCar(ParkedCar car)
    {
        if(car != null) {
            parkedCar = car;
        }
        else {
            parkedCar = new ParkedCar();
        }
    }
        
    /**
     * Set parking meter
     * @param meter
     */
    public void setParkingMeter(ParkingMeter meter)
    {
        if(meter != null) {
            parkingMeter = meter;
        }
        else {
            parkingMeter = new ParkingMeter();
        }
    }
    
    /**
     * Check if the parkedCar time has expired.
     * @return true if parking time is expired, or false if not expired
     */
    public boolean isParkingTimeExpired()
    {
        if(parkedCar != null && parkedCar.getMinsParked() > parkingMeter.getPurchasedMins()) {
            return true;
        }
        return false;
    }
    
    /**
     * Calculate the fine
     * @return fine in CAD
     */
    public double calculateFine()
    {
        int fineInCAD = 0;
        if(isParkingTimeExpired()) {    // if parking time is expired
            int overTimeInMins = parkedCar.getMinsParked() - parkingMeter.getPurchasedMins();
            fineInCAD += FINE_FIRST_HOUR;
            overTimeInMins -= NUM_OF_MINS_IN_ONE_HOUR;
            
            if(overTimeInMins > 0) {    // if parking time is expired for more than one hour
                // if overTimeInMins is with range [1, 60], the number of additional hours is 1
                // similarly, if with range [61, 120], the number of additional hours is 2
                // the number 1 below is NOT a magic number, it is just used in the math formula to get expected output
                int numOfAdditionalHours = (overTimeInMins - 1) / NUM_OF_MINS_IN_ONE_HOUR + 1;
                fineInCAD += FINE_ADDITIONAL_HOUR * numOfAdditionalHours;
            }
        }
        return fineInCAD;
    }
    
    /**
     * Issue a parking ticket
     * @return parking ticket created
     */
    public void issueTicket()
    {
        if(isParkingTimeExpired()) {
            ParkingTicket ticket = new ParkingTicket(officerName, badgeNumber, parkedCar.getLicenseNum(), parkedCar.getMake(), parkedCar.getModel(), calculateFine());
            ticket.displayTicket();        
            issuedParkingTickets.add(ticket);
        }
    }
    
    /**
     * Calculate the sum of fines of all the parking tickets
     * @return sumOfFines
     */
    public double calSumOfFines()
    {
        double sumOfFines = 0;
        for(ParkingTicket ticket : issuedParkingTickets) {
            sumOfFines += ticket.getAmountOfFineInCAD();
        }
        return sumOfFines;
    }
    
    /**
     * Count the number of tickets issued to a specific car
     * @return number of tickets
     */
    public int countNumOfTickets(String license)
    {
        int numOfTickets = 0;
        for(ParkingTicket ticket : issuedParkingTickets) {
            if(license.equals(ticket.getLicenseNumber())) {
                numOfTickets++;
            }
        }
        return numOfTickets;
    }    
}
