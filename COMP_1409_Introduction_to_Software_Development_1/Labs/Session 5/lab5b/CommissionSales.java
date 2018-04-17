
/**
 * class CommissionSales
 * 
 * @author Alex Dai
 * @version 05/08/2014
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
    public static final int ADVANCE_CASH_LIMIT = 1500;       
    
    // Attributes
    String salesPersonName;
    double salesAmountInCAD;
    double salesCommissionRate;
    boolean isInDebt;
    double cashAdvance;
    
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
     * @param   cashAdvanceInCAD
     */
    public CommissionSales(String personName, double amountInCAD, double cashAdvanceInCAD)
    {
        setSalesPersonName(personName);
        setSalesAmountInCAD(amountInCAD);
        setCashAdvance(cashAdvanceInCAD);
        calculateCommissionRate();
    }
    
    /**
     * Set cashInAdvance
     * @param   cashAdvanceInCAD
     */
    public void setCashAdvance(double cashAdvanceInCAD)
    {
        if(cashAdvanceInCAD >= 0 && cashAdvanceInCAD <= ADVANCE_CASH_LIMIT) {
            cashAdvance = cashAdvanceInCAD;
        }
        else {
            cashAdvance = 0;
        }
    }
    
    /**
     * Get sales person name
     * @return  salesPersonName
     */
    public String getSalesPersonName()
    {
        return salesPersonName;
    }
    
    /**
     * Get sales amount in CAD
     * @return  salesAmountInCAD
     */
    public double getSalesAmountInCAD()
    {
        return salesAmountInCAD;
    }
    
    /**
     * Get sales commission rate
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
     * @return net pay
     */
    public double calculatePay()
    {
        if(cashAdvance > 0) {
            isInDebt = true;
        }
        return salesAmountInCAD * salesCommissionRate - cashAdvance;
    }

    /**
     * Display details
     */
    public void displayDetails()
    {
        String rate;
        if(salesCommissionRate == RATE_A) {
            rate = "A";
        }
        else if(salesCommissionRate == RATE_B) {
            rate = "B";
        }
        else if(salesCommissionRate == RATE_C) {
            rate = "C";
        }
        else if(salesCommissionRate == RATE_D) {
            rate = "D";
        }
        else {
            rate = "E";
        }
        
        double netPay = calculatePay();
        if(isInDebt) {
            //System.out.println("Sales Person " + salesPersonName + " has a commission rate of " + rate + " and received cash advance amount $" + cashAdvance + ". His net earning is $" + netPay + ".");
            System.out.printf("Sales Person %s has a commission rate of %s and received cash advance amount $%.2f. His net earning is $%.2f.\n", salesPersonName, rate, cashAdvance, netPay);
        }
        else {
            //System.out.println("Sales Person " + salesPersonName + " has a commission rate of " + rate + ". His net earning is $" + netPay + ".");
            System.out.printf("Sales Person %s has a commission rate of %s. His net earning is $%.2f.\n", salesPersonName, rate, netPay);
        }
    }
}
