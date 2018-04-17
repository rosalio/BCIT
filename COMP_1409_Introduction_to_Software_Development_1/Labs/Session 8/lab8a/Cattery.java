
/**
 * Write a description of class Cattery here.
 * 
 * @author Alex Dai
 * @version May 27 2014
 */

import java.util.ArrayList;

public class Cattery
{
    private ArrayList<Cat> cats;
    private String businessName;

     /**
     * Constructor for objects of class Cattery
     * @param   name
     */
    public Cattery(String name)
    {
       this.cats = new ArrayList<Cat>();
       this.businessName = name == null ? "" : name;
    }
    
    /**
     * Add a new cat
     * @param   newCat
     */
    public void addCat(Cat newCat)
    {
        if(newCat != null) {
            cats.add(newCat);
        }
    }
    
    /**
     * Display the details of the cat with a given index
     * @param   index
     */
    public void displayCatInfo(int index)
    {
        if(index >= 0 && index < cats.size()) {
            Cat theCat = cats.get(index);
            System.out.printf("Cat Name: %s; Year of Birth: %d; Weight: %f KGs\n", theCat.getName(), theCat.getYearOfBirth(), theCat.getWeight());    
        }
        else {
            System.out.println("Cat not found!");    
        }
    }
    
    /**
     * Remove the cat with a given index
     * @param   index
     */
    public void removeCat(int index)
    {
        if(index >= 0 && index < cats.size()) {
            cats.remove(index);
        }
        else {
            System.out.println("Cat not found!");
        }
    }
    
    /**
     * Display the names of all the cats
     */
    public void displayNamesOfAll()
    {
        System.out.printf("The current guests in %s:\n", this.businessName);
        for(Cat cat : cats) {
            System.out.println(cat.getName());
        }
    }   
}
