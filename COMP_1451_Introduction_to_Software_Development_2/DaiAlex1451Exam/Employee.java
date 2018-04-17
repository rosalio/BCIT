
/**
 * Write a description of class Employee here.
 * 
 * @author Alex Dai
 * @version 12/05/2014
 */
public abstract class Employee extends Person implements EmpAction
{
    private static final String prefixOfEmp = "E";

    /**
     * Constructor for objects of class Employee
     * @param lastName
     * @param firstName
     */
    public Employee(String lastName, String firstName)
    {
        super(lastName, firstName);
        super.setIdentifier(prefixOfEmp + super.getNextId());
    }

    /**
     * Abstract method calculateMonthlyPay
     * @return monthly pay
     */
    public abstract double calculateMonthlyPay();
    
    /**
     * toString() method
     * @return output
     */
    public String toString()
    {
        return super.toString();
    }
}
