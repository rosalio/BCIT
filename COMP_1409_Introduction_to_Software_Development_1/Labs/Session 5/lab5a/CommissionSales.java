
/**
 * class CommissionSales
 * 
 * @author Alex Dai
 * @version 05/06/2014
 */
public class CommissionSales
{
    // Symbolic constants
    public static final double RATE_A = 0.05;
    public static final double RATE_B = 0.10;
    public static final double RATE_C = 0.12;
    public static final double RATE_D = 0.14;
    public static final double RATE_E= 0.16;
    public static final double AMOUNT_A = 10000;
    public static final double AMOUNT_B = 15000;
    public static final double AMOUNT_C = 18000 ;
    public static final double AMOUNT_D = 22000;
           
    // Attributes
    String salesPersonName;
    double salesAmountInCAD;
    double salesCommissionRate;
    
    /**
     * Default constructor
     */
    public CommissionSales()
    {
        setSalesPersonName("");
        setSalesAmountInCAD(0);
        calculateCommissionRate();
    }
    
    /**
     * Non-default constructor
     * @param   personName
     * @param   amountInCAD
     */
    public CommissionSales(String personName, double amountInCAD)
    {
        setSalesPersonName(personName);
        setSalesAmountInCAD(amountInCAD);
        calculateCommissionRate();
    }
    
    /**
     * @return  salesPersonName
     */
    public String getSalesPersonName()
    {
        return salesPersonName;
    }
    
    /**
     * @return  salesAmountInCAD
     */
    public double getSalesAmountInCAD()
    {
        return salesAmountInCAD;
    }
    
    /**
     * @return  salesCommissionRate
     */
    public double getSalesCommissionRate()
    {
        return salesCommissionRate;
    }
    
    /**
     * Set salesPersonName
     * @param   personName
     */
    public void setSalesPersonName(String personName)
    {
        if(personName != null) {
            salesPersonName = personName;
        }
        else {
            salesPersonName = "";
        }
    }
    
    /**
     * Set salesAmountInCAD
     * @param   amountInCAD
     */
    public void setSalesAmountInCAD(double amountInCAD)
    {
        if(amountInCAD >= 0) {
            salesAmountInCAD = amountInCAD;
        }
    }
    
    /**
     * Calculate commission rate
     */
    public void calculateCommissionRate()
    {
        if(salesAmountInCAD < AMOUNT_A) {
            salesCommissionRate = RATE_A;
        }
        else if(salesAmountInCAD < AMOUNT_B) {
            salesCommissionRate = RATE_B;
        }
        else if(salesAmountInCAD < AMOUNT_C) {
            salesCommissionRate = RATE_C;
        }
        else if(salesAmountInCAD < AMOUNT_D) {
            salesCommissionRate = RATE_D;
        }
        else {
            salesCommissionRate = RATE_E;
        }
    }
    
    /**
     * Calculate pay
     */
    public double calculatePay()
    {
        return salesAmountInCAD * salesCommissionRate;
    }

    /**
     * Display details
     */
    public void displayDetails()
    {
        System.out.println("Sales Person's Name: " + salesPersonName);
        System.out.println("Rate: " + salesCommissionRate);
        System.out.println("Pay: " + calculatePay());
    }
}
