
/**
 * Write a description of class Instructor here.
 * 
 * @author Alex Dai
 * @version 10/19/2014
 */
public class Instructor extends Member
{
    private double hourlyWage;

    /**
     * Default constructor for objects of class Instructor
     */
    public Instructor()
    {
        super();
        setHourlyWage(0);
    }

    /**
     * Constructor for objects of class Instructor
     * 
     * @param firstName
     *          the first name
     * @param lastName
     *          the last name
     * @param emailAddress
     *          the email address
     * @param bcitId
     *          the bcit id
     * @param hourlyWage
     *          the hourly wage
     */
    public Instructor(String firstName, String lastName, String emailAddress, String bcitId, double hourlyWage)
    {
        super(firstName, lastName, emailAddress, bcitId);
        setHourlyWage(hourlyWage);
    }    
    
    /**
     * Get hourly wage
     * 
     * @return hourlyWage
     */
    public double getHourlyWage()
    {
        return this.hourlyWage;
    }
    
    /**
     * Set hourly wage
     * 
     * @param hourlyWage
     *          the hourly wage
     */
    public void setHourlyWage(double hourlyWage)
    {
        this.hourlyWage = hourlyWage > 0 ? hourlyWage : this.hourlyWage;
    }
}
