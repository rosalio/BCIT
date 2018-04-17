import java.util.Random;

/**
 * Grid - holds a two-dimensional array of String objects to use in a game.
 * 
 * @author Alex Dai
 * @version 09/28/2014
 */

import java.util.HashMap;

public class Grid
{
    // suggested Grid constants
    public static final int ROWS = 5;           // number of rows
    public static final int COLUMNS = 5;        // number of columns
    public static final String HIDDEN = "$";   // default string to display
  
    // suggested Grid instance variables
    private String[][] grid;                // the grid itself, a 2-D array of String
    private Random random;                  // random number generator
    
    /**
     * The Grid constructor creates a new grid using public constants ROWS and COLUMNS. 
     * Constructor also creates a new random number generator. 
     */
    public Grid()
    {
        this.grid = new String[ROWS][COLUMNS];
        this.random = new Random();
        
        // Fill the grid with default string
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                grid[row][col] = new String(HIDDEN);
            }
        }
    }
    
    /**
     * Get the grid
     * 
     * @return grid 
     */
    public String[][] getGrid() {
        return this.grid;
    }
    
    /**
     * Set the grid
     * 
     * @param grid
     *          the grid
     */
    public void setGrid(String[][] grid) {
        this.grid = grid;
    }
    
    /**
     * Get the random number generator
     * 
     * @return random
     */
    public Random getRandom() {
        return this.random;
    }
    
    /**
     * Set the random number generator
     * 
     * @param random
     *          the random number generator
     */
    public void setRandom(Random random) {
        this.random = random;
    }
    
    /**
     * Displays a grid
     */
    public void showGrid()
    {   
        System.out.println();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print(this.grid[row][col] + " ");
            }
            System.out.println();
        }
    }
    
    /** 
     * Generates random coordinates, puts them into a new CoordinatePair,
     * returns CoordinatePair
     * @return a randomly-generated pair of coordinates within the bounds of the
     * grid
     */   
    private CoordinatePair getRandomCoordinates()
    {
        // create a new coordinate pair object
        CoordinatePair coords = new CoordinatePair();  
        
        // code to get random numbers
        coords.setRow(this.random.nextInt(Integer.MAX_VALUE) % ROWS);
        coords.setColumn(this.random.nextInt(Integer.MAX_VALUE) % COLUMNS);
        
        // return the object
        return coords;                                 
    }
    
    /**
     * Invokes getRandomCoordinates() to put a specific value into a specified
     * number of grid positions.
     * @param the number of randomly-generated coordinates to set
     * @param the target value to set
     */
    public void setRandomCoordinatesInGrid(int coordsToSet, String valueToSet)
    {
        HashMap<CoordinatePair, String> coordsMap = new HashMap<CoordinatePair, String>();
        int counter = 0;
        
        while (counter < coordsToSet) {
            CoordinatePair coords = getRandomCoordinates();
            boolean duplicate = false;
            
            for (CoordinatePair pair : coordsMap.keySet()) {
                if (pair.getRow() == coords.getRow() && pair.getColumn() == coords.getColumn()) {
                    duplicate = true;
                    break;
                }
            }
            
            if (!duplicate) {
                coordsMap.put(coords, valueToSet);
                counter++;
            }
        }
        
        for (CoordinatePair pair : coordsMap.keySet()) {
            this.grid[pair.getRow()][pair.getColumn()] = new String(valueToSet);
        }
    }
}
