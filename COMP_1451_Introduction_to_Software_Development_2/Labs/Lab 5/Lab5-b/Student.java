
/**
 * Write a description of class Student here.
 * 
 * @author Alex Dai
 * @version 10/19/2014
 */

import java.util.HashMap;
import java.util.Collection;

public class Student extends Member
{
    private static final double GRADE_MIN = 0;
    private static final double GRADE_MAX = 100;
    private static final double GRADE_NO_COURSE = -1;
    
    private HashMap<String, Double> courseList;
    
    /**
     * Default constructor for objects of class Student
     */
    public Student()
    {
        super();
        setCourseList(new HashMap<String, Double>());
    }

    /**
     * Constructor for objects of class Student
     * 
     * @param courseList
     *          the course list
     */
    public Student(String firstName, String lastName, String emailAddress, String bcitId, HashMap<String, Double> courseList)
    {
        super(firstName, lastName, emailAddress, bcitId);
        setCourseList(courseList);
    }

    /**
     * Get the course list
     * 
     * @return courseList
     */
    public HashMap<String, Double> getCourseList()
    {
        return this.courseList;
    }
    
    /**
     * Set the course list
     * 
     * @param courseList
     *          the course list
     */
    public void setCourseList(HashMap<String, Double> courseList)
    {
        this.courseList = courseList != null ? courseList : new HashMap<String, Double>();
    }

    /**
     * Put a new course into the student's course collection
     * 
     * @param courseName
     *          the course name
     * @param grade
     *          the course grade
     */
    public void addCourse(String courseName, double grade)
    {
        if (courseName != null && grade >= GRADE_MIN && grade <= GRADE_MAX) {
            this.courseList.put(courseName, new Double(grade));
        } else {
            System.out.println("Invalid input arguments");
        }
    }
    
    /**
     * Calculate and return the student's average grade
     * 
     * @return the average grade
     */
    public double calcAverage()
    {
        if (this.courseList.isEmpty()) {
            System.out.println("No course");
            return GRADE_NO_COURSE;
        }
        
        int numOfCourses = this.courseList.size();
        double sumOfGrades = 0;
        
        Collection<Double> grades = this.courseList.values();
        for (Double aGrade : grades) {
            sumOfGrades += aGrade.doubleValue();
        }
        
        return sumOfGrades / numOfCourses;
    }
}
