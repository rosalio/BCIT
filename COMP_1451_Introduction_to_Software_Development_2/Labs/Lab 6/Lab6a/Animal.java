
/**
 * Write a description of class Animal here.
 * 
 * @author Alex Dai
 * @version 10/24/2014
 */
public class Animal
{
    private String breed;
    private double weightInKilos;
    
    /**
     * Constructor for objects of class Animal
     * 
     * @param breed
     *          the breed
     * @param weightInKilos
     *          the weight in kilos
     */
    public Animal(String breed, double weightInKilos)
    {
        setBreed(breed);
        setWeightInKilos(weightInKilos);
    }
    
    /**
     * Set breed
     * 
     * @param breed
     *          the breed
     */
    public void setBreed(String breed)
    {
        if (breed != null) {
            this.breed = breed;
        }
    }
    
    /**
     * Set weight in kilos
     * 
     * @param weightInKilos
     *          the weight in kilos
     */
    public void setWeightInKilos(double weightInKilos)
    {
        if (weightInKilos >= 0) {
            this.weightInKilos = weightInKilos;
        }
    }

    /**
     * toString() method
     */
    public String toString()
    {
        return "This is a " + this.breed + " weighing " + this.weightInKilos + " kilos.\n";
    }
}
