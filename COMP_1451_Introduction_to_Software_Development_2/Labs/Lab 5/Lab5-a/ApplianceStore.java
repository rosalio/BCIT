
/**
 * Write a description of class ApplianceStore here.
 * 
 * @author Alex Dai
 * @version 10/17/2014
 */

import java.util.ArrayList;

public class ApplianceStore
{
    private ArrayList<Appliance> applianceStore;

    /**
     * Constructor
     */
    public ApplianceStore()
    {
        applianceStore = new ArrayList<Appliance>();
    }
    
    /**
     * Add an appliance to the store
     * 
     * @param appliance
     *          the appliance
     */
    public void addAppliance(Appliance appliance)
    {
        if (appliance != null) {
            applianceStore.add(appliance);
        } else {
            System.out.println("Invalid input, failed null check!");
        }
    }
    
    /**
     * Count the number of appliances in the store
     * 
     * @return number of appliances
     */
    public int countAppliances()
    {
        return applianceStore.size();
    }
    
    /**
     * Display the brand and serial number of each appliance in the store
     */
    public void display()
    {
        int index = 1;
        for (Appliance appliance : applianceStore) {
            System.out.println(index++ + ": " + appliance.getBrand() + " --- " + appliance.getSerialNumber());            
        }
    }
}
