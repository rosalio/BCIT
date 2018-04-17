
/**
 * Write a description of class InputReader here.
 * 
 * @author Alex Dai
 * @version 11/21/2014
 */

import java.util.Scanner;

public class InputReader
{
    private Scanner scanner;
    
    public InputReader()
    {
        scanner = new Scanner(System.in);
    }

    /**
     * This method returns the number typed by the user. If the number is
     * not an integer it throws a custom checked exception that will be
     * caught by the calling method.
     * @throws InputMismatchException, InvalidInputException
     */
    public int getNumber() throws InvalidInputException
    {
        int number = 0;
        try {
            number = scanner.nextInt();
        }
        // catch any non-integer input
        catch(java.util.InputMismatchException exc) {
            scanner.nextLine(); // clear the buffer
            throw new InvalidInputException("not a valid number!");
        }
        return number;
    }
}
