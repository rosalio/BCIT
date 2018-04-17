
/**
 * Write a description of class InvalidInputException here.
 * 
 * @author Alex Dai
 * @version 11/21/2014
 */
public class InvalidInputException extends Exception
{
    /**
     * Constructor for objects of class InvalidInputException
     */
    public InvalidInputException(String message)
    {
        super(message);
        System.out.println(message);
    }
}
