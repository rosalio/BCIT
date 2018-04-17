

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalcEngineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalcEngineTest
{
    /**
     * Default constructor for test class CalcEngineTest
     */
    public CalcEngineTest()
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

    /**
     * Test plus method:
     * Calculation: 5 + 8
     * Expected: 13
     * Result: Pass
     */
    @Test
    public void testPlus()
    {
        CalcEngine calcEngi1 = new CalcEngine();
        calcEngi1.clear();
        calcEngi1.numberPressed(5);
        calcEngi1.plus();
        calcEngi1.numberPressed(8);
        calcEngi1.equals();
        assertEquals(13, calcEngi1.getDisplayValue());
    }

    /**
     * Test minus method：
     * Calculatoin: 9 - 3
     * Expected: 6
     * Result: Pass
     */
    @Test
    public void testMinus()
    {
        CalcEngine calcEngi1 = new CalcEngine();
        calcEngi1.clear();
        calcEngi1.numberPressed(9);
        calcEngi1.minus();
        calcEngi1.numberPressed(3);
        calcEngi1.equals();
        assertEquals(6, calcEngi1.getDisplayValue());
    }

    /**
     * Test plus method (multiple digits):
     * Calculation: 12 + 15
     * Expected: 27
     * Result: Pass
     */
    @Test
    public void testPlus2()
    {
        CalcEngine calcEngi1 = new CalcEngine();
        calcEngi1.clear();
        calcEngi1.numberPressed(12);
        calcEngi1.plus();
        calcEngi1.numberPressed(15);
        calcEngi1.equals();
        assertEquals(27, calcEngi1.getDisplayValue());
    }

    /**
     * Test minus method (multiple digits):
     * Calculation: 35 - 40
     * Expected: -5
     * Result: Pass
     */
    @Test
    public void testMinus2()
    {
        CalcEngine calcEngi1 = new CalcEngine();
        calcEngi1.clear();
        calcEngi1.numberPressed(35);
        calcEngi1.minus();
        calcEngi1.numberPressed(40);
        calcEngi1.equals();
        assertEquals(-5, calcEngi1.getDisplayValue());
    }

    /**
     * Test mixed calculation:
     * Calculation: 9 + 1 - 4
     * Expected: 6
     * Result: Pass
     */
    @Test
    public void testMix()
    {
        CalcEngine calcEngi1 = new CalcEngine();
        calcEngi1.numberPressed(9);
        calcEngi1.plus();
        calcEngi1.numberPressed(1);
        calcEngi1.minus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(6, calcEngi1.getDisplayValue());
    }

    /**
     * Test apply previous operator
     * step 1: press clear
     * step 2: press 3
     * step 3: press plus
     * step 4: press clear
     * step 5: press 5
     * step 6: press equals
     * Expected: 5
     * Displayed: 8
     * Result: Fail
     */
    @Test
    public void testOperator()
    {
        CalcEngine calcEngi2 = new CalcEngine();
        calcEngi2.clear();
        calcEngi2.numberPressed(3);
        calcEngi2.plus();
        calcEngi2.clear();
        calcEngi2.numberPressed(5);
        calcEngi2.equals();
        assertEquals(5, calcEngi2.getDisplayValue());
    }

    /**
     * Test equals
     * step 1: press clear
     * step 2: press 8
     * step 3: press equals
     * Expected: 8
     * Displayed: -8
     * Result: Fali
     */
    @Test
    public void testEquals()
    {
        CalcEngine calcEngi2 = new CalcEngine();
        calcEngi2.clear();
        calcEngi2.numberPressed(8);
        calcEngi2.equals();
        assertEquals(8, calcEngi2.getDisplayValue());
    }
}







