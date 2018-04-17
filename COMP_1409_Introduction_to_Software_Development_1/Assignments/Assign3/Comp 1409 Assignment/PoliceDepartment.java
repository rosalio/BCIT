
/**
 * Write a description of class PoliceDepartment here.
 * 
 * @author  Alex Dai
 * @version May 31 2014
 */

import java.util.ArrayList;
import java.util.Iterator;

public class PoliceDepartment
{
    private ArrayList<PoliceOfficer> listOfOfficers;
    private String location;

    /**
     * Default constructor for objects of class PoliceDepartment
     */
    public PoliceDepartment()
    {
        setDeptLocation("unknown");
        this.listOfOfficers = new ArrayList<PoliceOfficer>();
    }

    /**
     * Constructor for objects of class PoliceDepartment
     * 
     * @param   deptLocation
     */
    public PoliceDepartment(String deptLocation)
    {
        setDeptLocation(deptLocation);
        this.listOfOfficers = new ArrayList<PoliceOfficer>();
    }
    
    /**
     * Get department location
     *    
     * @return  location
     */
    public String getDeptLocation()
    {
        return  this.location;
    }
    
    /**
     * Set department location
     * 
     * @param   deptLocation
     */
    public void setDeptLocation(String deptLocation)
    {
        if(deptLocation != null && deptLocation != "") {
            this.location = deptLocation;
        }
        else {
            this.location = "unknown";
            System.out.println("The passed paramter cannot be null or an empty string.");
        }
    }
    
    /**
     * Add a new police officer object
     * 
     * @param newOfficer
     */
    public void addOfficer(PoliceOfficer newOfficer)
    {
        if(newOfficer != null) {
            listOfOfficers.add(newOfficer);
        }
    }
    
    /**
     * Search all the parking tickets issued by a police officer
     * @return  list of parking tickets
     */
    public ArrayList<ParkingTicket> getAllTicketsByOfficer(String officerName)
    {        
        if(officerName != null) {
            Iterator<PoliceOfficer> it = listOfOfficers.iterator();
            while(it.hasNext()) {
                PoliceOfficer officer = it.next();
                if(officer.getOfficerName().equals(officerName)) {
                    return officer.getIssuedParkingTickets();
                }
            }
        
        }
        return null;
    }
    
    /**
     * Calculate the total amount of fines of all the parking tickets issued by all the officers
     * @return  the total amount of fines
     */
    public double getTotalAmountOfFines()
    {
        double totalFines = 0;
        Iterator<PoliceOfficer> it = listOfOfficers.iterator();
        while(it.hasNext()) {
            totalFines += it.next().calSumOfFines();
        }
        return totalFines;
    }
    
    /**
     * Search and get the total number of parking tickets issued to a specific car by any officers
     * @return total number of parking tickets issued to a specific car by all officers
     */
    public int getTotalNumOfTickets(String license)
    {
        if(null == license) {
            return 0;
        }
        
        int totalNumOfTickets = 0;
        Iterator<PoliceOfficer> it1 = this.listOfOfficers.iterator();
        while(it1.hasNext()) {
            PoliceOfficer officer = it1.next();
            Iterator<ParkingTicket> it2 = officer.getIssuedParkingTickets().iterator();
            while(it2.hasNext()) {
                ParkingTicket ticket = it2.next();
                if(ticket.getLicenseNumber().equals(license)) {
                    totalNumOfTickets++;
                }
            }
        }
        
        return totalNumOfTickets;
    }
}
