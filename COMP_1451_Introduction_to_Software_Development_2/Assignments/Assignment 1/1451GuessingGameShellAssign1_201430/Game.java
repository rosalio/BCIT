
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    // suggested Game constants
    public static final String TARGET = "T";          
    public static final String HIT = "*";             
    public static final String MISS = "-";           
    public static final int NUMBER_OF_TARGETS = 6; // number of targets hidden in the game    
    public static final int NUMBER_OF_TRIES   = 10; // number of tries the user is given
    
    // suggested instance variables
    private Grid targetGrid;                       // the grid that holds the targets
    private Grid displayGrid;                      // the grid that displays hits and misses
    private InputReader reader;                    // input reader to get user coordinate choices

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        this.targetGrid = new Grid();
        this.displayGrid = new Grid();
        this.reader = new InputReader();
        targetGrid.setRandomCoordinatesInGrid(NUMBER_OF_TARGETS, TARGET);
    }
    
    /**
     * Get the targetGrid
     * 
     * @return targetGrid
     */
    public Grid getTargetGrid() {
        return this.targetGrid;
    }
    
    /**
     * Set the targetGrid
     * 
     * @param targetGrid
     *              the target grid
     */
    public void setTargetGrid(Grid targetGrid) {
        this.targetGrid = targetGrid;
    }
    
    /**
     * Get the displayGrid
     * 
     * @return displayGrid
     */
    public Grid getDisplayGrid() {
        return this.displayGrid;
    }
    
    /**
     * Set the displayGrid
     * 
     * @param displayGrid
     *              the display grid
     */
    public void setDisplayGrid(Grid displayGrid) {
        this.displayGrid = displayGrid;
    }    
    
    /**
     * Get the input reader
     * 
     * @return reader
     */
    public InputReader getInputReader() {
        return this.reader;
    }
    
    /**
     * Set the input reader
     * 
     * @param reader
     *          the input reader
     */
    public void setInputReader(InputReader reader) {
        this.reader = reader;
    }
    
    /**
     * Play the game - this method contains the game logic
     */
    public void playGame()
    {
        showInstructions();
        
        int count = 1;
        int numOfHit = 0;
        while (count <= NUMBER_OF_TRIES) {
            System.out.println("Try number " + count);
            System.out.println("Coordinates start from zero.");
            System.out.print("Type your choice of coordinates (row column) with a space between >");
            CoordinatePair pair = reader.getCoordinates();
            
            if (pair.getRow() >= Grid.ROWS || pair.getColumn() >= Grid.COLUMNS) {
                System.out.println("Not a valid coordinate, please re-enter");
                continue;
            }
            
            if (targetGrid.getGrid()[pair.getRow()][pair.getColumn()].equals(TARGET)) {
                displayGrid.getGrid()[pair.getRow()][pair.getColumn()] = HIT;
                numOfHit++;
            } else {
                displayGrid.getGrid()[pair.getRow()][pair.getColumn()] = MISS;
            }
            
            displayGrid.showGrid();
            System.out.println();
            if (numOfHit == NUMBER_OF_TARGETS) {
                break;
            }
            count++;
        }
        
        System.out.println();
        if (numOfHit == NUMBER_OF_TARGETS) {
            System.out.println("Congratulations! You hit " + numOfHit + " targets out of " + NUMBER_OF_TARGETS);
        } else {
            System.out.println("Sorry, you only hit " + numOfHit + " targets out of " + NUMBER_OF_TARGETS);
        }
        targetGrid.showGrid();
    }
    
    /**
     * Provides instructions to the user
     */
    private void showInstructions()
    {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("You will be shown a grid with " + NUMBER_OF_TARGETS + " hidden targets.");
        System.out.println("You will be given " + NUMBER_OF_TRIES + " chances to 'hit' a target.");
        System.out.println("When prompted, type the coordinates to 'hit'.");
        System.out.println("The grid will display * for a successful hit and - for a miss.");
        displayGrid.showGrid();
        System.out.println();
    }
}
