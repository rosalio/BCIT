

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SpamFilterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SpamFilterTest
{
    /**
     * Default constructor for test class SpamFilterTest
     */
    public SpamFilterTest()
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
    public void testAddNonStartPositive()
    {
        SpamFilter spamFilt1 = new SpamFilter();
        spamFilt1.addNonStart("Spam");
        MailItem mailItem1 = new MailItem("alex", "john", "SPAM mail", "test spam mail");
        assertEquals(true, spamFilt1.isSpam(mailItem1));
    }

    @Test
    public void testAddNonContainPositive()
    {
        SpamFilter spamFilt1 = new SpamFilter();
        spamFilt1.addNonContain("online pharmacy");
        MailItem mailItem1 = new MailItem("alex", "john", "test online Pharmacy is spam", "test");
        assertEquals(true, spamFilt1.isSpam(mailItem1));
    }
}



