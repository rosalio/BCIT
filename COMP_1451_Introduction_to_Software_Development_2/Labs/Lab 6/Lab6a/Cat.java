
/**
 * Write a description of class Cat here.
 * 
 * @author Alex Dai
 * @version 10/24/2014
 */
public class Cat extends Animal
{
    private boolean canHunts;

    /**
     * Constructor for objects of class Cat
     * 
     * @param breed
     *          the breed
     * @param weightInKilos
     *          the weight in kilos
     * @param canHunts
     *          can hunts
     */
    public Cat(String breed, double weightInKilos, boolean canHunts)
    {
        super(breed, weightInKilos);
        setCanHunts(canHunts);
    }

    /**
     * Set hunts
     * 
     * @param canHunts
     *          can hunts
     */
    public void setCanHunts(boolean canHunts)
    {
        this.canHunts = canHunts;
    }
    
    
    public String toString()
    {
        String text = "This is";
        text += this.canHunts ? " a hunter!!\n" : " one lazy cat!\n";
        text += super.toString();
        
        return text;
    }
}
