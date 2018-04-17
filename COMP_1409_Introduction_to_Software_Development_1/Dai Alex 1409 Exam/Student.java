
/**
 * Write a description of class Student here.
 * 
 * @author Alex Dai
 * @version 06/24/2014
 */
public class Student
{
    public static final double MIN_ACCUMULATED_POINTS  = 0;
    public static final double MAX_ACCUMULATED_POINTS = 500;
    
    private String firstName;
    private String lastName;
    private String studentID;
    private double accumulatedPoints;
    
    /**
     * Default constructor for objects of class Student
     */
    public Student()
    {
        setFirstName("");
        setLastName("");
        setStudentID("");
        setAccumulatedPoints(0);
    }

    /**
     * Constructor for objects of class Student
     * @param fName
     * @param lName
     * @param stuID
     */
    public Student(String fName, String lName, String stuID)
    {
        setFirstName(fName);
        setLastName(lName);
        setStudentID(stuID);
        setAccumulatedPoints(0);
    }
    
    /**
     * Set student first name
     * @param fName
     */
    public void setFirstName(String fName)
    {
        this.firstName = fName == null ? "" : fName;
    }
    
    /**
     * Set student last name
     * @param lName
     */
    public void setLastName(String lName)
    {
        this.lastName = lName == null ? "" : lName;
    }
    
    /**
     * Set student ID
     * @param stuID
     */
    public void setStudentID(String stuID)
    {
        this.studentID = stuID == null ? "" : stuID;
    }
    
    /**
     * Set student accumulated points
     * @param points
     */
    public void setAccumulatedPoints(double points)
    {
        if(points >= MIN_ACCUMULATED_POINTS && points <= MAX_ACCUMULATED_POINTS) {
            this.accumulatedPoints = points;
        }
    }
    
    /**
     * Get student first name
     * @return firstName
     */
    public String getFirstName()
    {
        return this.firstName;
    }
   
    /**
     * Get stuent last name
     * @return lastName
     */
    public String getLastName()
    {
        return this.lastName;
    }
    
    /**
     * Get student ID
     * @return studentID
     */
    public String getStudentID()
    {
        return this.studentID;
    }
    
    /**
     * Get student accumulated points
     * @return accumulatedPoints
     */
    public double getAccumulatedPoints()
    {
        return this.accumulatedPoints;
    }
    
    /**
     * Increase the student's accumulated points
     * @param amountToIncrease
     */
    public void increaseAccumulatedPoints(double amountToIncrease)
    {
        if(amountToIncrease < 0) {
            System.out.println("Invalid input! The points must never decrease!");
            return ;
        }
           
        if(this.accumulatedPoints + amountToIncrease > MAX_ACCUMULATED_POINTS) {
            System.out.println("Invalid input! It might cause the points to go above the maximum points!");
            return ;
        }
        this.accumulatedPoints += amountToIncrease;
    }
    
    /**
     * Print the student details on the screen
     */
    public void printStudentInfo()
    {
        System.out.printf("First Name: %s\n", this.firstName);
        System.out.printf("Last Name: %s\n", this.lastName);
        System.out.printf("Student ID: %s\n", this.studentID);
        System.out.printf("Accumulated Points: %f\n", this.accumulatedPoints);
    }
}
