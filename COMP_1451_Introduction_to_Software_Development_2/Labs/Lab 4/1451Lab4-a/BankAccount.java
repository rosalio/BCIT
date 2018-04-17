
/**
 * BankAccount class models a simple bank account - Each account
 * has a unique account number, as well as a customer name and current balance -
 * This bank does not allow for an overdraft 
 * COMP 1451 lab 3
 * 
 * @author Colleen Penrowley 
 * @version October 2007 modified January 2008, July 2008
 */
public class BankAccount
{

    /** percentage to be added to balance each time applied -- currently set to one percent */
    public static final double INTEREST_RATE = 0.01; 
    /** starting point for account numbers -- currently set to 100 */
    public static final int FIRST_ACCOUNT_NUMBER = 100; 
    /* number of the first account created */
    private static int accountCounter = FIRST_ACCOUNT_NUMBER;   
    
    private double currentBalance;            // current balance in the account
    private int accountNumber;                // unique account number
    private String customerName;              // customer whose account this is

    
    /**
     * Constructor for objects of class BankAccount - This constructor sets the balance to zero
     * by default.
     */
    public BankAccount(String customerName)
    {
        this.customerName = customerName;
        currentBalance = 0.0;
        assignAccountNumber();
    }
        
    /**
     * Constructor for objects of class BankAccount - This constructor sets the balance to zero
     * if the amount passed in is not a positive value.
     */
    public BankAccount(String customerName, double initialBalance)
    {
        this.customerName = customerName;
        if (initialBalance > 0) {
            currentBalance = initialBalance;
        }
        else {
            currentBalance = 0.0;
        }
        assignAccountNumber();
    }
 
    /**
     * Assigns the first available account number and updates
     * the account counter for the next number
     */
    private void assignAccountNumber()
    {
        accountNumber = accountCounter;                    // get the first available number
        accountCounter++;                                  // for the next account
    }
    
    
    /**
     * Returns the balance in the account
     * 
     * @return  double current balance in the account
     */
    public double getBalance()
    {
        return currentBalance;
    }
    
    /**
     * Deposits the specified amount to the account - If the value 
     * passed in is not a positive amount, the balance will not change.
     * 
     * @param double amount to be deposited to the account
     */
    public void deposit(double amountToDeposit)
    {
        if (amountToDeposit > 0) {
            currentBalance += amountToDeposit;
        }
    }
 
    /**
     * Withdraws the specified amount from the account - Tests the 
     * parameter for validity - Account balance cannot be negative.
     * 
     * @param double amount to withdraw from the account
     */
    public void withdraw(double amountToWithdraw) 
    {
        if (amountToWithdraw <= currentBalance) {
           currentBalance -= amountToWithdraw;   
        }
    }

    /**
     * Returns the unique identifier for this account
     * 
     * @return int unique identifier for this account
     */
    public int getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * Returns the customer name
     * 
     * @return String customer name of this account
     */
    public String getCustomerName()
    {
        return customerName;
    }

    
    /**
     * Adds interest to the account balance, based on current 
     * interest rate - Each time the method is invoked, the percentage
     * is calculated and added to the account balance.
     */
    public void applyInterest()
    {
        currentBalance += (currentBalance * INTEREST_RATE);
    }

     
    /**
     * Provides account info as a returned String.
     * 
     * @return account details: customer name, account number, current balance
     */
    public String toString()
    {
        return "Name: " + customerName + " Account #: " + accountNumber + " Balance: " + currentBalance;
    }
    
    /**
     * STATIC method to reset the account counter for the purpose of testing.
     * This method should be invoked at the beginning of the setup method in the test class.
     */
    public static void resetAccountCounter()
    {
        accountCounter = FIRST_ACCOUNT_NUMBER;
    }
}
