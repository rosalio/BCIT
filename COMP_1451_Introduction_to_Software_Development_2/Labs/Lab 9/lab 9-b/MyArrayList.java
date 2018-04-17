
/**
 * Write a description of class MyArrayList here.
 * 
 * @author Alex Dai
 * @version 11/15/2014
 */

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList implements MyList 
{
    private Object[] theList;
    
    /**
     * Constructor for objects of class MyArrayList
     */
    public MyArrayList()
    {
        theList = new Object[0];
    }

    /**
     * Adds a new element at the end of the list.
     * @param the object to add
     * @return true if element successfully added, otherwise false
     */
    public boolean add(Object toAdd)
    {
        if (toAdd == null) {
            System.out.println("Cannot add null!");
            return false;
        }
        
        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(theList));
        temp.add(toAdd);
        theList = temp.toArray();
        
        return true;
    }
       
    /**
     * Gets the object at the specified index.
     * @param index value of object to get
     * @return object at that index
     */
    public Object get(int index)
    {
        return index >= 0 && index < theList.length ? theList[index] : null;
    }
    
    /**
     * Removes specified object from list.
     * @param index value of object to remove
     * @return the object removed
     */
    public Object remove(int index)
    {
        if (index < 0 || index >= theList.length) {
            System.out.println("index is out of range!");
            return null;
        }
        
        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(theList));
        Object toRemove = temp.remove(index);
        theList = temp.toArray();
        
        return toRemove;
    }
    
    /**
     * Returns size of the list
     * @return number of elements in the list
     */
    public int size()
    {
        return theList.length;
    }
    
    /**
     * @return true if the list has no elements, false otherwise
     */
    public boolean isEmpty()
    {
        return theList.length == 0;
    }
}
