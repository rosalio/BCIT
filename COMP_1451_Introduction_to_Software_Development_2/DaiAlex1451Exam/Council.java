
/**
 * Write a description of class Council here.
 * 
 * @author Alex Dai
 * @version 12/05/2014
 */
public class Council extends Employee
{
    private static final double ANNUAL_SALARY = 30000;

    /**
     * Constructor for objects of class Council
     * @param lastName
     * @param firstName
     */
    public Council(String lastName, String firstName)
    {
        super(lastName, firstName);
    }

    /**
     * Calculate monthly pay
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
