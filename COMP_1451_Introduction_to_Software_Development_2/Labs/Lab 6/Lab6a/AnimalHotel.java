
/**
 * Write a description of class AnimalHotel here.
 * 
 * @author Alex Dai
 * @version 10/24/2014
 */

import java.util.ArrayList;

public class AnimalHotel
{
    private ArrayList<Animal> listOfGuests;

    /**
     * Constructor for objects of class AnimalHotel
     */
    public AnimalHotel()
    {
        listOfGuests = new ArrayList<Animal>();
    }

    /**
     * Add a guest
     * 
     * @param guest
     *          the guest
     */
    public void addGuest(Animal guest)
    {
        if (guest != null) {
            listOfGuests.add(guest);
        }
    }
    
    /**
     * Display info
     */
    public void displayGuestsInfo()
    {
        if (listOfGuests.isEmpty()) {
            System.out.println("There is no guest.");
        } else {
            for (Animal guest : listOfGuests){
                System.out.println(guest);     
            }
        }
    }    
}
