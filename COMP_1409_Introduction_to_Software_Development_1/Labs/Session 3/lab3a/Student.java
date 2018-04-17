
/**
 * class Student
 * 
 * @author Alex Dai 
 * @version Apr 22 2014
 */
public class Student
{
    // instance variables
    private String studentName;
    private String studentID;
    private int testGrade;
    private double courseFees;
    private boolean isEligibleForADiscount;

    /**
     * Default constructor
     */
    public Student()
    {
        // initialise instance variables
        studentName = "";
        studentID = "";
        testGrade = 0;
        courseFees = 0.0;
        isEligibleForADiscount = false;
    }

    /**
     * Non-default constructor
     * 
     * @param   name as a String
     * @param   id as a String
     * @param   score as an int
     * @param   fees as a double
     */
    public Student(String name, String id, int score, double fees)
    {
        // initialise instance variables
        studentName = name;
        studentID = id;
        
        if (score > 0) {
            testGrade = score;
        }
        else {
            testGrade = 0;
        }
        
        if(fees > 0.0) {
            courseFees = fees;
        }
        else {
            courseFees = 0.0;
        }
        
        isEligibleForADiscount = false;
    }
    
    /**
     * @return  studentName  
     */
    public String getName()
    {
        return studentName;
    }
    
     /**
     * @return  studentID  
     */
    public String getID()
    {
        return studentID;
    }
    
     /**
     * @return  testGrade
     */
    public int getGrade()
    {
        return testGrade;
    }
    
     /**
     * @return  courseFees
     */
    public double getFees()
    {
        return courseFees;
    }
    
     /**
     * @return  isEligibleForADiscount
     */
    public boolean getDiscount()
    {
        return isEligibleForADiscount;
    }

    /**
     * set the name of a student
     * @param newName: student name to set
     */
    public void setName(String newName)
    {
        if(newName != null) {
            studentName = newName;
        }
    }
    
     /**
     * set the ID of a student
     * @param newID: student ID to set
     */
    public void setID(String newID)
    {
        if(newID != null) {
            studentID = newID;
        }
    }
    
     /**
     * set the test score of a student
     * @param score: test score to set
     */
    public void setScore(int score)
    {
        if(score >= 0) {
            testGrade = score;
        }
        else {
            System.out.println("Invalid test score!");
        }
    }
    
     /**
     * set the course fees of a student
     * @param fees: test fees to set
     */
    public void setFees(double fees)
    {
        if(fees >= 0.0) {
            courseFees = fees;
        }
        else {
            System.out.println("Invalid course fees!");
        }
    }
    
     /**
     * set the eligibility for a discount
     * @param isDiscount: eligibility for a discount to set
     */
    public void setDiscount(boolean isDiscount)
    {
        isEligibleForADiscount = isDiscount;
    }
    
    /**
     * method to check the course fees 
     */
    public void checkForDiscount()
    {
        if (courseFees > 700.0) {
            courseFees *= 0.85;
            isEligibleForADiscount = true;
        }
        else {
            System.out.println("The student is not eligible for a discount.");
            isEligibleForADiscount = false;
        }
    }
    
    /**
     * method to display the student details
     */
    public void displayStudentInfo()
    {
        System.out.println("Student name: " + studentName);
        System.out.println("Student ID: " + studentID);
        System.out.println("Test Score: " + testGrade);
        if(isEligibleForADiscount) {
            System.out.println("This student gets a discount of 15%");
        }
        else {
            System.out.println("This student does not get a discount");
        }
    }
}
