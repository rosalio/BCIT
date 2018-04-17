
/**
 * Employee.
 * 
 * @author Colleen 
 * @version 2013.02.25
 */
public abstract class Employee
{

    private String name;

    /**
     * Constructor for objects of class Employee
     */
    public Employee(String name)
    {
        this.name = name;
    }
    
    /**
     * Gets name
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sets name.
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * @return name
     */
    public String toString()
    {
        return name;
    }
    
    public abstract double calculateMonthlyEarnings();
    
}
