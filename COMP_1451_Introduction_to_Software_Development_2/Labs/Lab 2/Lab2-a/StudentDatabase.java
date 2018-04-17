
/**
 * Write a description of class StudentDatabase here.
 * 
 * @author Alex Dai
 * @version 09/26/2014
 */
import java.util.HashMap;

public class StudentDatabase
{
    public static final int NUM_QUIZZES = 10;
    public static final int MIN_GRADE = 0;
    public static final int MAX_GRADE = 100;
    
    private HashMap<String, int[]> quizMarks;
    
    /**
     * Constructor for objects of class StudentDatabase
     */
    public StudentDatabase()
    {
        quizMarks = new HashMap<String, int[]>();
    }
    
    /**
     * @param name
     *           student name
     * @return the properly-formatted name.
     */ 
    private String formatName(String name)
    {
        String first = "";
        String rest = "";
        if (name != null && name.length() > 0) {
            first = name.substring(0, 1).toUpperCase();
            if (name.length() > 1) {
                rest = name.substring(1).toLowerCase();
            }
        }
        return first + rest;
    }

    /** Add a student to the database and create a new array to hold
     * that student's quiz marks ( NUM_QUIZZES quizzes). These marks
     * will by default be set to MIN_GRADE.
     * 
     * @param studentName
     *               student name
     */
    public void addStudent(String studentName)
    {
        if (studentName != null) {
            int[] marks = new int[NUM_QUIZZES];
            for(int i = 0; i < NUM_QUIZZES; i++) {
                marks[i] = MIN_GRADE;
            }
            quizMarks.put(formatName(studentName), marks);
        }
    }
    /**
     * @param student
     *             student name
     * @return the array of quiz marks for this student.
     */
    public int[] getQuizzes(String student)
    {
        if (student != null) {
            return quizMarks.get(formatName(student));
        }
        return null;
    }
    
    /**
     * Change the mark for the specified student. This method
     * ensures the student exists in the database. It also ensures the
     * quiz to be changed is valid, and the mark is within the range
     * MIN_GRADE to MAX_GRADE. If anything is not valid it displays an
     * appropriate error message.
     * 
     * @param stduentName
     *              student name
     * @param whichQuiz
     *              which quiz
     * @param newMark
     *              new mark  
     */
     public void changeQuizMark(String studentName, int whichQuiz, int newMark)
     {
         if (studentName == null) {
             System.out.println("Sorry, the input student name is null.");
             return ;
         }
         
         if (!quizMarks.containsKey(formatName(studentName))){
             System.out.println("Sorry, cannot find the student name in database.");
             return ;
         }
         
         if (whichQuiz < 1 || whichQuiz > NUM_QUIZZES) {
             System.out.println("Sorry, the quiz does not exist.");
             return ;
         }
         
         if (newMark < MIN_GRADE || newMark > MAX_GRADE) {
             System.out.println("Sorry, the new mark is out of range.");
             return ;
         }
         
         int[] marks = quizMarks.get(formatName(studentName));
         marks[whichQuiz - 1] = newMark;

         System.out.println("Student name successfully changed.");
     }
        
     /**
      * Display the quiz marks for all students in the database.
      */
     public void showQuizMarks()
    {
        System.out.println("Display the quiz marks for all students");
        for (String name : quizMarks.keySet()) {
            int[] marks = quizMarks.get(name);
            System.out.println("Quiz marks for: " + name);
            for(int i = 0; i < NUM_QUIZZES; i++) {
                System.out.print(marks[i] + " ");
            }
            System.out.println();
        }
    }
}
