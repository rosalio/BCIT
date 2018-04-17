
/**
 * Write a description of class Pay here.
 * 
 * @author Alex Dai
 * @version 09/20/2014
 */
public class Pay
{
    private static final double BASE_PAY_AMOUNT = 0.01;
    
    /**
     * Method: Calculate and display daily and total pay based on user input
     */
    public void calculatePay()
    {
        double payForTheNthDay = 0;
        double totalPayInCAD = 0;
        int numberOfDays = 0;
        InputReader inputReader = new InputReader();
            
        System.out.print("Please enter the number of days: ");
        numberOfDays = inputReader.readInt();
        
        if (numberOfDays > 0) {
            int nthDay = 1;
            while (nthDay <= numberOfDays) {
                payForTheNthDay = nthDay == 1 ? BASE_PAY_AMOUNT : 2 * payForTheNthDay;
                System.out.println("Day " + nthDay + " earning is: $ " + payForTheNthDay);
                totalPayInCAD += payForTheNthDay;
                nthDay++;
            }
            System.out.printf("Total earning for 5 days is: $ %.2f\n", totalPayInCAD);
        } else {
            System.out.println("Error: The number of days must be more than 0!");
        }       
    }
}
