
/**
 * Write a description of class Database here.
 * 
 * @author Alex Dai
 * @version 12/05/2014
 */

import java.util.ArrayList;

public class Database
{
    private String title;
    private ArrayList<Person> personList;

    /**
     * Constructor for objects of class Database
     */
    public Database(String title)
    {
        this.title = title;
        personList = new ArrayList();
    }

    /**
     * Add a person to the list
     */
    public void addPerson(Person person)
    {
        if (person != null) {
            personList.add(person);
        }
    }
    
    /**
     * Display details of all people
     */
    public void displayPeopleDetails()
    {
        for (Person person : personList) {
            System.out.println(person);
        }
    }
    
    /**
     * Calculate and return the total paid to all employees per month
     */
    public double calculateTotalPayment() {
        double totalPayment = 0;
        for (Person person: personList) {
            if (person instanceof Employee) {
                totalPayment += ((Employee) person).calculateMonthlyPay();
            }
        }
        return totalPayment;
    }
    
    /**
     * Calculate and return the total volunteer hours per month
     */
    public int calculateTotalHours()
    {
        int totalHours = 0;
        for (Person person : personList) {
            if (person instanceof Volunteer) {
                totalHours += ((Volunteer) person).reportMonthlyHours();
            }
        }
        return totalHours;
    }
    
    /**
     * Locate the employee id of the employee who earned the most
     */
    public String getEmpIdWhoEarnedMost()
    {
        Person mostEarnedEmp = null;
        double mostEarnedMonthlyAmt = 0;
        
        for (Person person : personList) {
            if (person instanceof Employee) {
                if (((Employee) person).calculateMonthlyPay() > mostEarnedMonthlyAmt) {
                    mostEarnedEmp = person;
                    mostEarnedMonthlyAmt = ((Employee) person).calculateMonthlyPay();
                }
            }
        }
        
        if (mostEarnedEmp != null) {
            return mostEarnedEmp.getIdentifier();
        } else {
            return null;
        }
    }
}
