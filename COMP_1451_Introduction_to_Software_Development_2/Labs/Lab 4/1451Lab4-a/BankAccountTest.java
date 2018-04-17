

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BankAccountTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BankAccountTest
{
    /**
     * Default constructor for test class BankAccountTest
     */
    public BankAccountTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        BankAccount.resetAccountCounter();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetAccountNumber1()
    {
        BankAccount bankAcco1 = new BankAccount("Alex", 1000);
        assertEquals(100, bankAcco1.getAccountNumber());
    }

    @Test
    public void testGetAccountNumber2()
    {
        BankAccount bankAcco1 = new BankAccount("Bob");
        assertEquals(100, bankAcco1.getAccountNumber());
    }

    @Test
    public void testGetCustomerName()
    {
        BankAccount bankAcco1 = new BankAccount("Alex", 1500);
        assertEquals("Alex", bankAcco1.getCustomerName());
    }

    @Test
    public void testGetCustomerNameNegative()
    {
        BankAccount bankAcco1 = new BankAccount(null, 2500);
        assertEquals(null, bankAcco1.getCustomerName());
    }

    @Test
    public void testGetBalance()
    {
        BankAccount bankAcco1 = new BankAccount("Alex", 3000);
        assertEquals(3000, bankAcco1.getBalance(), 0.1);
    }

    @Test
    public void testGetBalanceNegative()
    {
        BankAccount bankAcco1 = new BankAccount("Bob", -500);
        assertEquals(0, bankAcco1.getBalance(), 0.1);
    }

    @Test
    public void testApplyInterest()
    {
        BankAccount bankAcco1 = new BankAccount("Alex", 1000);
        bankAcco1.applyInterest();
        assertEquals(1010, bankAcco1.getBalance(), 0.1);
    }

    @Test
    public void testApplyInterestNegative()
    {
        BankAccount bankAcco1 = new BankAccount("Bob", -100);
        bankAcco1.applyInterest();
        assertEquals(0, bankAcco1.getBalance(), 0.1);
    }

    @Test
    public void testDeposit()
    {
        BankAccount bankAcco1 = new BankAccount("Alex");
        bankAcco1.deposit(1000);
        assertEquals(1000, bankAcco1.getBalance(), 0.1);
    }

    @Test
    public void testDepositNegative()
    {
        BankAccount bankAcco1 = new BankAccount("Bob", -100);
        bankAcco1.deposit(-100);
        assertEquals(0, bankAcco1.getBalance(), 0.1);
    }

    @Test
    public void testWithDraw()
    {
        BankAccount bankAcco1 = new BankAccount("Alex", 2000);
        bankAcco1.withdraw(1000);
        assertEquals(1000, bankAcco1.getBalance(), 0.1);
    }

    @Test
    public void testWithDrawNegative()
    {
        BankAccount bankAcco1 = new BankAccount("Bob");
        bankAcco1.withdraw(-100);
        assertEquals(0, bankAcco1.getBalance(), 0.1);
    }

    @Test
    public void testToString()
    {
        BankAccount bankAcco1 = new BankAccount("Alex", 1000);
        assertEquals("Name: Alex Account #: 100 Balance: 1000.0", bankAcco1.toString());
    }

    @Test
    public void testToStringNegative()
    {
        BankAccount bankAcco1 = new BankAccount(null, -100);
        assertEquals(null, bankAcco1.toString());
    }
}














