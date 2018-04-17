
/**
 * Write a description of class Dog here.
 * 
 * @author Alex Dai
 * @version 10/24/2014
 */
public class Dog extends Animal
{
    private boolean likesWalk;

    /**
     * Constructor for objects of class Dog
     * 
     * @param breed
     *          the breed
     * @param weightInKilos
     *          weight in kilos
     * @param likesWalk
     *          likes walk
     */
    public Dog(String breed, double weightInKilos, boolean likesWalk)
    {
        super(breed, weightInKilos);
        setLikesWalk(likesWalk);
    }

    /**
     * Set likes to walk
     * 
     * @param likesWalk
     *          likes walk
     */
    public void setLikesWalk(boolean likesWalk)
    {
        this.likesWalk = likesWalk;
    }
    
    /**
     * toString() method
     */
    public String toString()
    {
        String text = super.toString();
        text += this.likesWalk ? "This dog likes to walk.\n" : "This is a lazy dog!\n";
        
        return text;
    }
}
