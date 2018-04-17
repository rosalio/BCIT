import java.util.ArrayList;

/**
 * Company.
 * 
 * @author Colleen
 * @version 2013.02.25
 */
public class Company
{
    private ArrayList<Employee> employees;

    /**
     * Constructor for objects of class Company
     */
    public Company()
    {
        employees = new ArrayList<Employee>();
    }

    /**
     * Adds an employee.
     * @param anEmployee
     */
    public void addEmployee(Employee anEmployee)
    {
        if(anEmployee != null){
            employees.add(anEmployee);
        }        
    }
    
    /**
     * Shows all employees and their earnings.
     */
    public void showEmployees()
    {
        for(Employee emp : employees){
            System.out.println(emp);
        }
    }
    
    /**
     * Sums total wages paid for the month.
     * @return total wages paid
     */
    public double sumWagesPaidThisMonth()
    {
        double totalWages = 0.0;
        for(Employee emp : employees){
            totalWages += emp.calculateMonthlyEarnings();
        }
        return totalWages;
    }

}
