
/**
 * Write a description of class Major here.
 * 
 * @author Alex Dai
 * @version 12/05/2014
 */
public class Major extends Employee
{
    private static final double ANNUAL_SALARY = 60000;

    /**
     * Constructor for objects of class Major
     * @param firstName
     * @param lastName
     */
    public Major(String lastName, String firstName)
    {
        super(lastName, firstName);
    }

    /**
     * caluclate monthly pay
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
