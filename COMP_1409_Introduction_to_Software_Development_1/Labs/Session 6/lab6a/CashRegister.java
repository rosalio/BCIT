
/**
 * Write a description of class CashRegister here.
 * 
 * @author Alex Dai 
 * @version May 13 2014
 */
public class CashRegister
{
    public static final double TAX_RATE = 0.06;
    
    private RetailItem item;
    private int quantitySold;

    /**
     * Default constructor
     */
    public CashRegister()
    {
        setItem(new RetailItem());
        setQuantitySold(0);
    }

    /**
     * Non-default constructor 
     * @param   theItem
     * @param   quantity
     */
    public CashRegister(RetailItem theItem, int quantity)
    {
        setItem(theItem);
        setQuantitySold(quantity);
    }
    
    /**
     * Set the retail item
     * @param   theItem
     */
    public void setItem(RetailItem theItem)
    {
        if(null == theItem) {
            item = new RetailItem();
        }
        else {
            item = theItem;
        }
    }
    
    /**
     * Set the quantity of retail items sold
     * @param   quantity
     */
    public void setQuantitySold(int quantity)
    {
        if(quantity >= 0) {
            quantitySold = quantity;
        }
    }
    
    /**
     * Get the retail item
     * @return  item
     */
    public RetailItem getItem()
    {
        return item;
    }
    
    /**
     * Get the quantity of retail items sold
     * @return  quantitySold
     */
    public int getQuantitySold()
    {
        return quantitySold;
    }
    
    /**
     * Calculate and return the subtotal cost
     * @return  subtotal cost
     */
    public double calculateSubtotal()
    {
        return quantitySold * item.getPrice();
    }
    
    /**
     * Calculate and return the total price (sub total price plus sales tax)
     * @return  total cost
     */
    public double calculateTotal()
    {
        return calculateSubtotal() * (1 + TAX_RATE);
    }
    
    /**
     * display the sales receipt
     */
    public void printSalesReceipt()
    {
        System.out.printf("Unit price: $%.2f\n", item.getPrice());
        System.out.printf("Quantity: %d\n", quantitySold);
        System.out.printf("Subtotal: $%.2f\n", calculateSubtotal());
        System.out.printf("Sales tax: $%.2f\n", item.getPrice() * TAX_RATE * quantitySold);
        System.out.printf("Total: $%.2f\n", calculateTotal());
    }
}
