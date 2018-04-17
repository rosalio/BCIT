
/**
 * class RetailItem
 * 
 * @author Alex Dai 
 * @version Apr 15 2014
 */
public class RetailItem
{
    // declare fields
    private String itemDescription;
    private double itemPrice;
    private boolean isOnDemand;
    private int numberOfUnitsInStock;
    
    /**
     * Default constructor
     */
    public RetailItem()
    {
        // initialize fields
        itemDescription = "";
        itemPrice = 0.0;
        isOnDemand = false;
        numberOfUnitsInStock = 0;
    }

    /**
     * Non-default constructor
     * 
     * @param descriptionInEnglish
     * @param priceInCAD
     * @param onDemand
     * @param stockNum
     */
    public RetailItem(String descriptionInEnglish, double priceInCAD, boolean onDemand, int stockNum)
    {
        // initialize fields
        itemDescription = descriptionInEnglish;
        itemPrice = priceInCAD;
        isOnDemand = onDemand;
        numberOfUnitsInStock = stockNum;
    }
    
    /**
     * @return itemDescription as a String
     */
    public String getDescription()
    {
        return itemDescription;
    }
    
    /** 
     * @return itemPrice as a double
     */
    public double getPrice()
    {
        return itemPrice;
    }
    
    /**
     * @return isOnDemand as a boolean
     */
    public boolean getOnDemand()
    {
        return isOnDemand;
    }
    
    /**
     * @return numberOfUnitsInStock as an int
     */
    public int getStockNumber()
    {
        return numberOfUnitsInStock;
    }
}
