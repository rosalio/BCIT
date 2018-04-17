
/**
 * Write a description of class Play here.
 * 
 * @author Alex Dai
 * @version June 3rd 2014
 */
public class Play
{
    private InputReader iReader;
    private int x;

    /**
     * Constructor for objects of class Play
     */
    public Play()
    {
       iReader = new InputReader();
    }

    /**
     * Prompt the user for a number
     * Calculate and return the sum of numbers from 1 to that number inclusive
     * 
     * @return sum
     */
    public int numberSum()
    {
        int num = 1;
        System.out.print("Enter an integer: ");
        int last = iReader.readInt();
        int sum = 0;
        while(num <= last) {
            sum += num++;
        }
        
        return sum; 
    }
    
    /**
     * Prompt the user for a string
     * display the string as many times as the length of that string
     * first letter uppcase
     */
    public void stringPlay()
    {
        System.out.print("Enter a string: ");
        String str = iReader.readString();
        str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        
        int count = 0;
        while(count < str.length()) {
            System.out.print(str + " ");
            count++;
        }
        
    }
}
