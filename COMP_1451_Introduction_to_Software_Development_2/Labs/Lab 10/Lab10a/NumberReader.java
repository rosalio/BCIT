
/**
 * Write a description of class NumberReader here.
 * 
 * @author Alex Dai
 * @version 11/21/2014
 */
public class NumberReader
{
    private InputReader inputReader;

    /**
     * Constructor for objects of class NumberReader
     */
    public NumberReader()
    {
        inputReader = new InputReader();
    }
    
    /**
     * Calculate and display the sum of all non-zero whole number inputs 
     */
    public void calculateSum()
    {
        int sum = 0;
        int num = -1;
        
        while (num != 0)
        {
            try {
                System.out.print("Please input a number: ");
                num = inputReader.getNumber();
                sum += num;
            } catch (InvalidInputException e) {
            }
        }
        
       System.out.println("The sum of the input numbers is " + sum);  
    }
}
