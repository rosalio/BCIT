
/**
 * Write a description of class Item here.
 * 
 * @author Alex Dai
 * @version 11/14/2014
 */
public class Item
{
    private String title;

    /**
     * Constructor for objects of class Item
     */
    public Item(String title)
    {
        this.title = title;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * @return a String representing this item
     */
    public String toString()
    {
        return "title: " + title;
    }
}
