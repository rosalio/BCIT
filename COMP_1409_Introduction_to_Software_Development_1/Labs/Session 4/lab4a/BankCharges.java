
/**
 * class: BankCharges
 * 
 * @author Alex Dai 
 * @version 04/29/2014
 */
public class BankCharges
{
    // Symbolic constants
    public static final double FIRST_CHEQUES_CHARGE = 0.10;
    public static final double SECOND_CHEQUES_CHARGE = 0.08;
    public static final double THIRD_CHEQUES_CHARGE = 0.06;
    public static final double FOURTH_CHEQUES_CHARGE = 0.04;
    public static final int BANK_CHARGE = 10;
    public static final int BANK_LOW_BALANCE_CHARGE = 15;
    public static final int FIRST_CHEQUES_LIMIT = 20;
    public static final int SECOND_CHEQUES_LIMIT = 40;
    public static final int THIRD_CHEQUES_LIMIT = 60;
    public static final double LOW_BALANCE_LIMIT = 400.00;
       
    // Instant variables
    private String clientName;
    private double endingBalance;
    private int numberOfCheques;

    /**
     * Default constructor
     */
    public BankCharges()
    {
        clientName = "";
        endingBalance = 0.0;
        numberOfCheques = 0;
    }
    
    /**
     * Non-default constructor
     * @param   name as a String
     * @param   balance as a double
     * @param   numCheques as an int
     */
    public BankCharges(String name, double balance, int numCheques)
    {
        if (name != null) {
            clientName = name;
        }
        else {
            clientName = "";
        }
        
        if (balance > 0.0) {
            endingBalance = balance;
        }
        else {
            endingBalance = 0.0;
        }
        
        if (numCheques > 0) {
            numberOfCheques = numCheques;
        }
        else {
            numberOfCheques = 0;
        }
    }

    /**
     * Get client name
     * @return  clientName 
     */
    public String getClientName()
    {
        return clientName;
    }
    
    /**
     * Get ending balance
     * @return  endingBalance
     */
    public double getBalance()
    {
        return endingBalance;
    }
    
    /**
     * Get number of cheques
     * @return  numberOfCheques
     */
    public int getNumOfCheques()
    {
        return numberOfCheques;
    }
    
    /**
     * Set client name
     * @param   name as a String
     */
    public void setClientName(String name)
    {
        if (name != null) {
            clientName = name;
        }
    }
    
    /**
     * Set ending balance
     * @param   balance as a double
     */
    public void setBalance(double balance)
    {
        if (balance >= 0.0) {
            endingBalance = balance;
        }
    }
    
    /**
     * Set number of cheques
     * @param   numCheques as an int
     */
    public void setNumOfCheques(int numCheques)
    {
        if (numCheques >= 0) {
            numberOfCheques = numCheques;
        }
    }
    
    /**
     * Method to return the service fees of the bank
     * @return  bankServiceFees
     */
    public double calculateBankServiceFees()
    {
        double bankServiceFees = BANK_CHARGE;
             
        if (endingBalance < LOW_BALANCE_LIMIT) {
            bankServiceFees += BANK_LOW_BALANCE_CHARGE;
        }

          if (numberOfCheques < FIRST_CHEQUES_LIMIT) {
            bankServiceFees += (numberOfCheques * FIRST_CHEQUES_CHARGE);
        }
        else if (numberOfCheques < SECOND_CHEQUES_LIMIT) {
            bankServiceFees += (numberOfCheques * SECOND_CHEQUES_CHARGE);
        }
        else if (numberOfCheques < THIRD_CHEQUES_LIMIT) {
            bankServiceFees += (numberOfCheques * THIRD_CHEQUES_CHARGE);
        }
        else {
            bankServiceFees += (numberOfCheques * FOURTH_CHEQUES_CHARGE);
        }
        
        endingBalance -= bankServiceFees;
        
        return bankServiceFees;
    }
}
