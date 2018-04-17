
/**
 * CommissionEmployee.
 * 
 * @author Colleen 
 * @version 2013.02.25
 */
public class CommissionEmployee extends Employee
{
    public static final double COMMISSION_RATE = 0.10; //10%
    private double monthlySales;

    /**
     * Constructor for objects of class CommissionEmployee
     */
    public CommissionEmployee(String name, double monthlySales)
    {
        super(name);
        setMonthlySales(monthlySales);
    }

    /**
     * Gets monthly sales.
     * @return monthly sales
     */
    public double getMonthlySales()
    {
        return monthlySales;
    }
    
    /**
     * Sets monthly sales.
     * @param salesThisMonth
     */
    public void setMonthlySales(double salesThisMonth)
    {
        if(salesThisMonth >= 0.0){
            monthlySales = salesThisMonth;
        }
    }
    
    /**
     * @return name and sales
     */
    public String toString()
    {
        return super.toString() + " sold $" + monthlySales  
            + " and earned " + calculateMonthlyEarnings();
    }
    
    /**
     * Calculates monthly earnings.
     * @return monthly earnings
     */
    public double calculateMonthlyEarnings()
    {
        return monthlySales * COMMISSION_RATE;
    }

    

}
