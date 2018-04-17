import java.util.ArrayList;

/**
 * The Library class provides storage for several different kinds of library items.
 * 
 * @author Colleen Penrowley
 * @version comp 1451 Spring 2006, revised Summer 2008
 */
public class Library
{
    private ArrayList<Item> itemList;

    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        itemList = new ArrayList<Item>();
    }

    /**
     * Show details of all the items in the library
     */
    public void showAllItems()
    {
        for (Item item : itemList) {
            System.out.println(item);
        }
    }

    /**
     * Add an item to the library
     */
    public void addItem(Item item)
    {
        itemList.add(item);
    }
    
    /** Calculates and returns the average playing time of all items
     * in the library that have a playing time
     */
    public double averagePlayingTimes()
    {
        double totalPlayingTime = 0;
        int totalPlayableNumber = 0;
        
        for (Item item : itemList) {
            if (item instanceof Playable) {
                totalPlayableNumber++;
                totalPlayingTime += ((Playable)item).specifyPlayingTime();
            }
        }
                
        if(totalPlayableNumber != 0) {
            return totalPlayingTime / totalPlayableNumber;
        } else {
            System.out.println("No playable items!!!");
            return -1;
        }
    }
}
