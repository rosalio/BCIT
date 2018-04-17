
/**
 * Write a description of class StockPurchase here.
 * 
 * @author Alex Dai
 * @version May 21 2014
 */
public class StockPurchase
{
    private Stock stock;
    private int numberOfShares;

    /**
     * Default constructor
     */
    public StockPurchase()
    {
        setStock(new Stock());
        setNumberOfShares(0);
    }

    /**
     * Non-default constructor
     * @param   newStock
     * @param   number
     */
    public StockPurchase(Stock newStock, int number)
    {
        setStock(newStock);
        setNumberOfShares(number);
    }
    
    /**
     * Set stock
     * @param   newStock
     */
    public void setStock(Stock newStock)
    {
        this.stock = null == newStock ? new Stock() : newStock;
    }
    
    /**
     * Set number of shares
     * @param   number
     */
    public void setNumberOfShares(int number)
    {
        this.numberOfShares = number > 0 ? number : this.numberOfShares;
    }
        
    /**
     * Get stock
     * @return  stock
     */
    public Stock getStock()
    {
        return this.stock;
    }
    
    /**
     * Get number of shares
     * @return  numberOfShares
     */
    public int getNumberOfShares()
    {
        return this.numberOfShares;
    }
    
    /**
     * Calculate the cost of buying stock shares
     * @return  total cost of buying the numberOfShares shares
     */
    public double getTotalCost()
    {
        return this.stock.getSharePrice() * this.numberOfShares;
    }
    
    /**
     * Display the details of stock and the cost of buying the numberOfShares shares. 
     */
    public void displayDetails()
    {
        this.stock.displayStockInfo();
        System.out.printf("Number of shares: %d\n", this.numberOfShares);
        System.out.printf("Total cost: USD $%.2f\n", this.getTotalCost());
        System.out.println("------End------");
    }
}
