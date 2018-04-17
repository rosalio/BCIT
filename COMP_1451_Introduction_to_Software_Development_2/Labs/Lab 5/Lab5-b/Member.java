
/**
 * Write a description of class Member here.
 * 
 * @author Alex Dai
 * @version 10/20/2014
 */
public class Member
{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String bcitId;

    /**
     * Defaut constructor for objects of class Member
     */
    public Member()
    {
        setFirstName("");
        setLastName("");
        setEmailAddress("");
        setBcitId("");
    }
    
    /**
     * Constructor for objects of class Member
     * 
     * @param firstName
     *          the first name
     * @param lastName
     *          the last name
     * @param emailAddress
     *          the email address
     * @param bcitId
     *          the bcit id
     */
    public Member(String firstName, String lastName, String emailAddress, String bcitId)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(emailAddress);
        setBcitId(bcitId);
    }    
    
    /**
     * Get the first name
     * 
     * @return firstName
     */
    public String getFirstName()
    {
        return this.firstName;
    }
    
    /**
     * Get the last name
     * 
     * @return lastName
     */
    public String getLastName()
    {
        return this.lastName;
    }
    
    /**
     * Get the email address
     * 
     * @return emailAddress
     */
    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    /**
     * Get the bcit id
     * 
     * @return bcitId
     */
    public String getBcitId()
    {
        return this.bcitId;
    }
    
    /**
     * Set the first name
     * 
     * @param firstName
     *          the first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName != null ? firstName : this.firstName;
    }
    
    /**
     * Set the last name
     * 
     * @param lastName
     *          the last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName != null ? lastName : this.lastName;
    }
    
    /**
     * Set the email address
     * 
     * @param emailAddress
     *          the email address
     */
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress != null ? emailAddress : this.emailAddress;
    }
    
    /**
     * Set the bcit id
     * 
     * @param bcitId
     *          the bcit id
     */
    public void setBcitId(String bcitId)
    {
        this.bcitId = bcitId != null ? bcitId : this.bcitId;
    }
}
