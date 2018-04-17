

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MailServerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MailServerTest
{
    /**
     * Default constructor for test class MailServerTest
     */
    public MailServerTest()
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
    public void testHowManyMailItemsPositive()
    {
        MailServer mailServ1 = new MailServer();
        MailClient mailClie1 = new MailClient(mailServ1, "alex");
        mailClie1.sendMailItem("john", "test1", "test");
        mailClie1.sendMailItem("john", "test2", "test2");
        assertEquals(2, mailServ1.howManyMailItems("JOHN"));
    }

    @Test
    public void testGetNextMailItemNegative()
    {
        MailServer mailServ1 = new MailServer();
        assertEquals(null, mailServ1.getNextMailItem("alex"));
    }

    @Test
    public void testPostPositive()
    {
        MailServer mailServ1 = new MailServer();
        MailClient mailClie1 = new MailClient(mailServ1, "alex");
        MailClient mailClie2 = new MailClient(mailServ1, "john");
        mailClie1.sendMailItem("john", "test", "test");
        assertEquals(1, mailServ1.howManyMailItems("john"));
    }
}



