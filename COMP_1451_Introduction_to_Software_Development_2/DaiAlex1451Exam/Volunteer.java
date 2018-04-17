
/**
 * Write a description of class Volunteer here.
 * 
 * @author Alex Dai
 * @version 12/05/2014
 */
public class Volunteer extends Person
{
    private static final String prefixOfVolunteer = "V";
    private int monthlyHours;

    /**
     * Constructor for objects of class Volunteer
     * @param lastName
     * @param firstName
     * @param monthlyHours
     */
    public Volunteer(String lastName, String firstName, int monthlyHours)
    {
        super(lastName, firstName);
        super.setIdentifier(prefixOfVolunteer + super.getNextId());
        setMonthlyHours(monthlyHours);
    }

    /**
     * Report monthly hours
     * @return monthlyHours
     */
    public int reportMonthlyHours()
    {
        return monthlyHours;
    }
    
    /**
     * Set monthly hours
     * @param monthlyHours
     */
    public void setMonthlyHours(int monthlyHours)
    {
        this.monthlyHours = monthlyHours;
    }
    
    /**
     * toString method
     * @return output
     */
    public String toString()
    {
        String output = super.toString();
        output += "Monthly hours: " + reportMonthlyHours() + "\n";
        return output;
    }
    
}
