
/**
 * HourlyEmployee
 * 
 * @author Colleen 
 * @version 2013.02.25
 */
public class HourlyEmployee extends Employee
{
    public static final double PAY_PER_HOUR = 25.00;
    private double hoursWorkedThisMonth;

    /**
     * Constructor for objects of class HourlyEmployee
     */
    public HourlyEmployee(String name, double hoursWorked)
    {
        super(name);
        setHoursWorkedThisMonth(hoursWorked);
    }

    /**
     * Gets hours worked
     * @return hours worked
     */
    public double getHoursWorkedThisMonth()
    {
        return hoursWorkedThisMonth;
    }
    
    /**
     * Sets hours worked for the month
     * @param hoursWorked
     */
    public void setHoursWorkedThisMonth(double hoursWorked)
    {
        if(hoursWorked >= 0.0) {
            hoursWorkedThisMonth = hoursWorked;
        }
    }
    
    /**
     * @return name and hours worked
     */
    public String toString()
    {
        return super.toString() + " worked " + hoursWorkedThisMonth 
            + " hours and earned " + calculateMonthlyEarnings();
    }
    
    /**
     * Calculates monthly earnings.
     * @return monthly earnings
     */
    public double calculateMonthlyEarnings()
    {
        return hoursWorkedThisMonth * PAY_PER_HOUR;
    }
}
