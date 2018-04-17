
/**
 * Write a description of class Staff here.
 * 
 * @author Alex dai
 * @version 12/05/2014
 */
public class Staff extends Employee
{
    private static final double ANNUAL_SALARY = 80000;
        
    /**
     * Constructor for objects of class Staff
     * @param lastName
     * @param firstName
     */
    public Staff(String lastName, String firstName)
    {
       super(lastName, firstName);
    }

    /**
     * Calculate Monthly pay
     * @return monthly pay
     */
    public double calculateMonthlyPay()
    {
        return ANNUAL_SALARY / 12;
    }
    
    /**
     * toString method
     * @return output
     */
    public String toString()
    {
        String output = super.toString();
        output += "Monthly Pay: " + calculateMonthlyPay() + "\n";
        return output;
    }
}
