
/**
 * Write a description of class InvalidMoveException here.
 * 
 * @author Alex Dai
 * @version 12/04/2014
 */
public class InvalidMoveException extends Exception
{
    /**
     * Constructor for objects of class InvalidMoveException
     * @param message
     */
    public InvalidMoveException(String message)
    {
        super(message);
        System.out.println(message);
    }

}
