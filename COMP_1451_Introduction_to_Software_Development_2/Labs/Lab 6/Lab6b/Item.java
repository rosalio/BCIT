
/**
 * Write a description of class Item here.
 * 
 * @author Alex Dai
 * @version 10/28/2014
 */
public class Item
{
    private String description;
    private double weightInKilos;
    private boolean canBePickedUp;

    /**
     * Constructor of class Item
     * 
     * @param description
     * @param weightInKilos
     * @param canBePickedUp
     */
    public Item(String description, double weightInKilos, boolean canBePickedUp)
    {
        setDescription(description);
        setWeightInKilos(weightInKilos);
        setCanBePickedUp(canBePickedUp);
    }
    
    /**
     * Set description
     * 
     * @param description
     */
    public void setDescription(String description)
    {
        if (description != null) {
            this.description = description;
        }
    }
    
    
    /**
     * Set weight in kilos
     * 
     * @param weightInKilos
     */
    public void setWeightInKilos(double weightInKilos)
    {
        if (weightInKilos >= 0) {
            this.weightInKilos = weightInKilos;
        }
    }
    
    /**
     * Set can be picked up
     * 
     * @param canBePickedUp
     */
    public void setCanBePickedUp(boolean canBePickedUp)
    {
        this.canBePickedUp = canBePickedUp;
    }
    
    /**
     * toString method
     */
    public String toString()
    {
        return this.description;
    }   
}
