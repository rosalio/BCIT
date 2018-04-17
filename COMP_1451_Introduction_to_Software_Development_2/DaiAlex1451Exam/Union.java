
/**
 * Write a description of class Union here.
 * 
 * @author Alex Dai
 * @version 12/05/2014
 */
public class Union extends Employee
{
    // Assumption: there are 30 days in a month
    private static final int WEEKS_IN_A_MONTH = 30 / 7;
    private static final int STANDARD_WEEKLY_HOURS = 35;
    private static final double REGULAR_HOURLY_RATE = 24;
    private static final double OVERTIME_HOURLY_RATE = 48;
    
    private int hoursPerWeek;

    /**
     * Constructor for objects of class Union
     * @param lastName
     * @param firstName
     * @param hoursPerWeek
     */
    public Union(String lastName, String firstName, int hoursPerWeek)
    {
        super(lastName, firstName);
        setHoursPerWeek(hoursPerWeek);
    }

    /**
     * Get hours per week
     * @return hoursPerWeek
     */
    public int getHoursPerWeek()
    {
        return hoursPerWeek;
    }
    
    /**
     * Set hoursPerWeek
     * @param hoursPerWeek
     */
    public void setHoursPerWeek(int hoursPerWeek)
    {
        this.hoursPerWeek = hoursPerWeek;
    }
    
    /**
     * Calculate Monthly pay
     * @return monthly pay
     */
    public double calculateMonthlyPay()
    {
        double weeklyPayment = 0;
        if (hoursPerWeek <= STANDARD_WEEKLY_HOURS) {
            weeklyPayment =  hoursPerWeek * REGULAR_HOURLY_RATE;
        } else {
            weeklyPayment = STANDARD_WEEKLY_HOURS * REGULAR_HOURLY_RATE + (hoursPerWeek - STANDARD_WEEKLY_HOURS) * OVERTIME_HOURLY_RATE;
        }
       
        double monthlyPayment = WEEKS_IN_A_MONTH * weeklyPayment;
        
        return monthlyPayment;
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
