/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

import java.util.HashMap;
import java.util.ArrayList;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new ArrayList<Item>();
    }

    /**
     * Define the exits of this room. 
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }  
    
    /**
     * Get the room given direction
     * @param direction
     * @return the room
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);   
    }
    
    /**
     * Return a description of the room’s exits,
     * for example, "Exits: north west".
     * @return A description of the available exits.
     */
    public String getExitString()
    {
        String exitString = "Exits:";
        for (String exit : exits.keySet()) {
            exitString += " " + exit;
        }
        return exitString;
    }

    /**
     * Return a long description of this room, of the form:
     * You are in the kitchen.
     * Exits: north west
     * @return A description of the room, including exits.
     */
     public String getLongDescription()
     {
         return "You are " + description + ".\n" + getExitString();
     }
        
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Put a item into the item collection
     * @param item
     */
    public void putInRoom(Item item)
    {
        if (item != null) {
            items.add(item);
        }
    }

    /**
     * Iterate over the items in the room
     * @return A string containing a description of each item
     */
    public String getRoomItems()
    {
        String outputStr = "This room contains:";
        for (Item item : items) {
            outputStr += " " + item.toString() + ",";
        }
        return outputStr;
    }
}
