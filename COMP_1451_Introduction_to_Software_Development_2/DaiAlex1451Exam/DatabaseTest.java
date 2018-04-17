

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DatabaseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DatabaseTest
{
    private Database database1;
    
    /**
     * Default constructor for test class DatabaseTest
     */
    public DatabaseTest()
    {
        database1 = new Database("City of Port Nowhere");
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {

        Staff staff1 = new Staff("A", "B");
        Union union1 = new Union("C", "D", 35);
        Council council1 = new Council("E", "F");
        Volunteer voluntee1 = new Volunteer("G", "H", 500);
        database1.addPerson(staff1);
        database1.addPerson(union1);
        database1.addPerson(council1);
        database1.addPerson(voluntee1);
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
    public void testCalculateTotalPayment()
    {
        assertEquals(12526.7, database1.calculateTotalPayment(), 0.1);
    }
    
    @Test
    public void testCalculateTotalPaymentNegative()
    {
        Database database2 = new Database ("City of Port Nowhere 2");
        assertEquals(0, database2.calculateTotalPayment(), 0.1);
    }
    
    @Test
    public void testCalculateTotalHours()
    {
        assertEquals(500, database1.calculateTotalHours());
    }
    
    @Test public void testCalculateTotalHoursNegative()
    {
        Database database2 = new Database ("City of Port Nowhere 2");
        assertEquals(0, database2.calculateTotalHours());
    }
    
    @Test
    public void testGetEmpIdWhoEarnedMost()
    {
        assertEquals("E1000", database1.getEmpIdWhoEarnedMost());
    }
    
    @Test
    public void testGetEmpIdWhoEarnedMostNegative()
    {
        Database database2 = new Database ("City of Port Nowhere 2");
        assertEquals(null, database2.getEmpIdWhoEarnedMost());
    }
}

