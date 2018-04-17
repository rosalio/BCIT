
/**
 * class Employee
 * 
 * @author Alex Dai 
 * @version Apr 15 2014
 */
public class Employee
{
    // instance variables
    private String employeeName;
    private int employeeAgeInYears;
    private String employeeAddress;
    private int numberOfYearsEmployed;
    private double annualPay;
    private boolean isFullTime;

    /**
     * Default constructor
     */
    public Employee()
    {
        employeeName = "";
        employeeAgeInYears = 0;
        employeeAddress = "";
        numberOfYearsEmployed = 0;
        annualPay = 0.0;
        isFullTime = false;
    }

    /**
     * Non-default constructor
     * @param name
     * @param ageInYears
     * @param address
     * @param yearsEmployed
     * @param incomeYearly
     * @param fullTime;
     */
    public Employee(String name, int ageInYears, String address, int yearsEmployed, double incomeYearly, boolean fullTime)
    {
        employeeName = name;
        employeeAgeInYears = ageInYears;
        employeeAddress = address;
        numberOfYearsEmployed = yearsEmployed;
        annualPay = incomeYearly;
        isFullTime = fullTime;
    }
    
    /**
     * @return  employeeName
     */
    public String getName()
    {
        return employeeName;
    }
    
    /**
     * @return  employeeAgeInYears
     */
    public int getAge()
    {
        return employeeAgeInYears;
    }
    
    /**
     * @return  employeeAddress
     */
    public String getAddress()
    {
        return employeeAddress;
    }
    
    /**
     * @return  numberOfYearsEmployed
     */
    public int getYearsEmployed()
    {
        return numberOfYearsEmployed;
    }
    
    /**
     * @return  annualPay
     */
    public double getPayment()
    {
       return annualPay;
    }
    
    /**
     * @return  isFullTime
     */
    public boolean getIsFullTime()
    {
        return isFullTime;
    }
    
}
