
/**
 * Write a description of class Course here.
 * 
 * @author Alex Dai
 * @version 06/24/2014
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Course
{
    public static final double TOP_STUDENT_POINTS= 450;
    
    private String courseName;
    private String instructorName;
    private ArrayList<Student> studentList;

    /**
     * Default constructor for objects of class Course
     */
    public Course()
    {
        setCourseName("Unknown");
        setInstructorName("Unknown");
        studentList = new ArrayList<Student>();
    }

    /**
     * Constructor for objects of class Course
     * @param course
     * @param instructor
     */
    public Course(String course, String instructor)
    {
        setCourseName(course);
        setInstructorName(instructor);
        studentList = new ArrayList<Student>();
    }   
    
    /**
     * Set course name
     * @param course
     */
    public void setCourseName(String course)
    {
        if(course != null) {
            this.courseName = course;
        }
    }
    
    /**
     * Set instructor name
     * @param instructor
     */
    public void setInstructorName(String instructor)
    {
        if(instructor != null) {
            this.instructorName = instructor;
        }
    }
    
    /**
     * Set student list
     * @param stuList
     */
    public void setStudentList(ArrayList<Student> stuList)
    {
        if(stuList != null) {
            this.studentList = stuList;
        }
    }
    
    /**
     * Get course name
     * @return courseName
     */
    public String getCourseName()
    {
        return this.courseName;
    }

    /**
     * Get instructor name
     * @return instructorName
     */
    public String getInstructorName()
    {
        return this.instructorName;
    }

    /**
     * Get student list
     * @return studentList
     */
    public ArrayList<Student> getStudentList()
    {
        return this.studentList;
    }
    
    /**
     * Add a student to the course
     * @param student
     */
    public void addStudent(Student student)
    {
        if(student != null) {
            this.studentList.add(student);
        }
    }
    
    /**
     * Remove from the course all students with points less than the parameter
     */
    public void removeStudents(double points)
    {
        Iterator<Student> it =  studentList.iterator();
        while(it.hasNext()) {
            Student student = it.next();
            if(student.getAccumulatedPoints() < points) {
                it.remove();
            }
        }
    }
    
    /**
     * Print course details
     */
    public void printCourseDetails()
    {
        System.out.println("Course Name: " + this.courseName);
        System.out.println("Instructor Name: " + this.instructorName);
        for(Student stu : studentList) {
            stu.printStudentInfo();
        }
    }
 
    /**
     * Print the names of top students
     */
    public void printTopStudents()
    {
        int index = 0;
        while(index < studentList.size()) {
            Student stu = studentList.get(index);
            if(stu.getAccumulatedPoints() >= TOP_STUDENT_POINTS) {
                System.out.println(stu.getFirstName() + " " + stu.getLastName());
            }
            index++;
        }
        
    }
    
    /**
     * Locate the student with the highest number of points
     * @return studentFullName
     */
    public String getFullNameOfTopStudent()
    {
        int index = 0;
        double highestPoints = 0;
        Student topStudent = studentList.get(0);
        while(index < studentList.size()) {
            Student stu = studentList.get(index);
            if(stu.getAccumulatedPoints() > highestPoints) {
                highestPoints = stu.getAccumulatedPoints();
                topStudent = stu;
            }
            index++;
        }
        
        return topStudent.getFirstName() + " " + topStudent.getLastName();
    }
    
    /**
     * Calculate the average points
     * @return averagePoints
     */
    public double calculateAveragePoints()
    {
        if(studentList.size() == 0)
            return 0;
        
        double totalPoints = 0;
        for(Student stu : studentList) {
            totalPoints += stu.getAccumulatedPoints();
        }
        
        return totalPoints / studentList.size();
    }
}
