
/**
 * Write a description of class Play here.
 * 
 * @author Alex Dai
 * @version June 3rd 2014
 */

import java.util.Random;

public class Play
{
    private InputReader iReader;

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
    
    /**
     * Guess the number which is between 1 to 10 inclusive
     */
    public void guessTheNumber()
    {
        Random random = new Random();
        int num = random.nextInt(10) + 1;
        int numOfGuesses = 0;
        
        do {
            numOfGuesses++;
            System.out.print("What do you think the number is?\nPlease input an integer: ");
            int numGuessed = iReader.readInt();
            
            System.out.println("Number Of Guesses: " + numOfGuesses);
            if(numGuessed == num) {
                System.out.println("Congratulations! You got the right number!");
                break;
            }
            else if(numGuessed > num){
                System.out.println("Too cold");
            }
            else {
                System.out.println("Too hot");
            }
        }
        while(true);
    }
}
