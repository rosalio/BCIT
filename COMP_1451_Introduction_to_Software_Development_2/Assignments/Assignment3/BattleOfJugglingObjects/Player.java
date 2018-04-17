
/**
 * Write a description of class Player here.
 * 
 * @author Alex Dai
 * @version 12/01/2014
 */

import java.util.ArrayList;

public class Player
{
    private String name;
    private InputReader reader;

    /**
     * Constructor for objects of class Player
     * @param name
     */
    public Player(String name)
    {
        this.name = name;
        reader = new InputReader();
    }

    /**
     * Get name
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set name
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * User input source and destination locations
     * @return list of position coordinates
     */
    public ArrayList<String> enterMove()
    {
        ArrayList<String> srcDst = new ArrayList();
        System.out.print(name + " enter your move: > ");
        String src = reader.readNext();
        
        if(src != null ) {
            srcDst.add(src);
        }
        
        String dst = reader.readNext();
        if(dst != null) {
            srcDst.add(dst);
        }
        return srcDst;
    }
    
}
