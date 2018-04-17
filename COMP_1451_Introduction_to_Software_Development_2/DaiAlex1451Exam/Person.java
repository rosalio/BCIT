
/**
 * Abstract class Person - write a description of the class here
 * 
 * @author Alex Dai
 * @version 12/05/2014
 */
public class Person
{
    private static int id = 1000;
    
    private String lastName;
    private String firstName;
    private String identifier;
    
    /**
     * Constructor of Person class
     * @param lastName
     * @param firstName
     */
    public Person(String lastName, String firstName)
    {
        setLastName(lastName);
        setFirstName(firstName);

    }
    
    /**
     * Get the next available id
     * @return id
     */
    public int getNextId()
    {
        return id++;
    }
    
    /**
     * Get last name
     * @return lastName
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * Set last name
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    /**
     * Get first name
     * @return firstName
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Set first name
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    /**
     * Get identifier
     * @return identifier
     */
    public String getIdentifier()
    {
        return identifier;
    }
    
    /**
     * Set identifier
     * @param identifier
     */
    public void setIdentifier(String identifier)
    {
        this.identifier = identifier;
    }
    
    /**
     * toString method
     * @return output
     */
    public String toString()
    {
        String output = "Name: " + lastName + ", " + firstName + "\nID: " + identifier + "\n";
        return output;
    }
}
