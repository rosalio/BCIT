
/**
 * Write a description of class Cat here.
 * 
 * @author Alex Dai
 * @version May 27 2014
 */
public class Cat
{
    private String name;
    private int yearOfBirth;
    private double weightInKg;

    /**
     * Default constructor for objects of class Cat
     */
    public Cat()
    {
        setName("");
        setYearOfBirth(0);
        setWeight(0);
    }

    /**
     * Constructor for objects of class Cat
     * @param   newName  
     * @param   year
     * @param   weight
     */
    public Cat(String newName, int year, double weight)
    {
        setName(newName);
        setYearOfBirth(year);
        setWeight(weight);
    }
    
    /**
     * Set  name
     * @param   newName
     */
    public void setName(String newName)
    {
        if(newName != null) {
            this.name = newName;
        }
        else {
            System.out.println("Invalid input of name!");
        }
    }
    
    /**
     * Set year of birth
     * @param   year
     */
    public void setYearOfBirth(int year)
    {
        if(year >= 0) {
            this.yearOfBirth = year;
        }
        else {
            System.out.println("Invalid input of year of birth!");
        }
    }
       
    /**
     * Set weight in kgs
     * @param   weight
     */
    public void setWeight(double weight)
    {
        if(weight >= 0) {
            this.weightInKg = weight;
        }
        else {
            System.out.println("Invalid input of weight!");
        }        
    }
    
    /**
     * Get name
     * @return  name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Get year of birth
     * @return  yearOfBirth
     */
    public int getYearOfBirth()
    {
        return this.yearOfBirth;
    }
    
    /**
     * Get weight in kgs
     * @return  weightInKg
     */
    public double getWeight()
    {
        return this.weightInKg;
    }
    
}
