
/**
 * Write a description of class DriverExam here.
 * 
 * @author Alex Dai
 * @version Jun 17 2014
 */
public class DriverExam
{
    public static final char[] ANSWERS = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D', 'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'};
    public static final int NUM_OF_QUESTIONS = 20;
    public static final int PASS_SCORE = 15;
    private char[] driverAnswers;
    private InputReader input;
    
    /**
     * Default constructor for objects of class DriverExam
     */
    public DriverExam()
    {
        driverAnswers = new char[NUM_OF_QUESTIONS];
        input = new InputReader();
    }

    /**
     * Prompt the studdents to type the answers to each question in turn
     * Validate the answers and put it into the array if valid
     * If the students types and invalid answers, he/she will be prompted to try again
     */
    public void promptStuentAnswers()
    {
        for(int index = 0; index < NUM_OF_QUESTIONS; index++) {
            char ch;
            do {
                System.out.print("Please enter your answer: ");
                ch = input.readChar();
            } while(ch < 'A' || ch > 'D');
            driverAnswers[index] = ch;
            System.out.printf("Question %d is done.\n", index + 1);
        }   
    }
    
    /**
     * Calculate and return the total number of correct answers
     * @return total number of correct answers
     */
    public int getTotalCorrectAnswers()
    {
        int numOfCorrectAnswers = 0;
        for(int i = 0; i < NUM_OF_QUESTIONS; i++) {
            numOfCorrectAnswers = driverAnswers[i] == ANSWERS[i] ? numOfCorrectAnswers + 1 : numOfCorrectAnswers;           
        }
        return numOfCorrectAnswers;
    }
    
    /**
     * Calculate and return the total number of incorrect answers
     * @return total number of incorrect answers
     */
    public int getTotalIncorrectAnswers()
    {
        return NUM_OF_QUESTIONS - getTotalCorrectAnswers();
    }
    
    /**
     * @return true if the student passes the exam, false if not
     */
    public boolean isPassed()
    {
        return getTotalCorrectAnswers() >= PASS_SCORE;
    }
}
