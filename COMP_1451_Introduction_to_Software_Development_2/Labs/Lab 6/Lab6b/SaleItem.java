
/**
 * Write a description of class SaleItem here.
 * 
 * @author Alex Dai
 * @version 10/28/2014
 */
public class SaleItem extends Item
{
    private double costInCAD;

    /**
     * Construtor of class SaleItem
     */
    public SaleItem(String description, double weightInKilos, double costInCAD)
    {
        super(description, weightInKilos, true);
        setCostInCAD(costInCAD);
    }
    
    /**
     * Set cost in CAD
     * 
     * @param costInCAD
     */
    public void setCostInCAD(double costInCAD)
    {
        if (costInCAD >= 0) {
            this.costInCAD = costInCAD;
        }
    }
    
    /**
     * toString method
     */
    public String toString()
    {
        return super.toString() + " $" + this.costInCAD; 
    }
}
