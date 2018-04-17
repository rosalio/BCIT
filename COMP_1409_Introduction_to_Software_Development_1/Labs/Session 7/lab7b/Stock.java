
/**
 * Write a description of class Stock here.
 * 
 * @author Alex Dai 
 * @version May 21 2014
 */
public class Stock
{
    private String stockSymbol;
    private double sharePrice;

    /**
     * Default constructor
     */
    public Stock()
    {
        setStockSymbol("");
        setSharePrice(0);
    }

    /**
     * Non-default constructor
     * @param   symbol
     * @param   price
     */
    public Stock(String symbol, double price)
    {
        setStockSymbol(symbol);
        setSharePrice(price);
    }
    
    /**
     * Set stock symbol
     * @param   symbol
     */
    public void setStockSymbol(String symbol)
    {
        if(null == symbol) {
            this.stockSymbol = "";
            return ;
        }
        
        this.stockSymbol = symbol;
    }
    
    /**
     * Set share price
     * @param price
     */
    public void setSharePrice(double price)
    {
        this.sharePrice = price > 0 ? price : this.sharePrice;
    }
    
    /**
     * Get stock symbol
     * @return  stockSymbol
     */
    public String getStockSymbol()
    {
        return this.stockSymbol;
    }
    
    /**
     * Get share price
     * @return  sharePrice
     */
    public double getSharePrice()
    {
        return this.sharePrice;
    }
        
    /**
     * Display the stock's information
     */
    public void displayStockInfo()
    {
        System.out.println("---Stock Information---");
        System.out.printf("Stock Symbol: %s\n", this.stockSymbol);
        System.out.printf("Share Price: USD $%.2f\n", this.sharePrice);
        System.out.println("");
    }
}
