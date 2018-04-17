
/**
 * Write a description of class Board here.
 * 
 * @author Alex Dai
 * @version 11/29/2014
 */
public class Board
{
    public static final int GRID_ROW = 5;
    public static final int GRID_COL = 5;
    private static final String TORCH_PLAYER_ONE = "T";
    private static final String BALL_PLAYER_ONE = "O";
    private static final String TORCH_PLAYER_TWO = "t";
    private static final String BALL_PLAYER_TWO = "o";
    
    private GamePiece[][] grid;

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        grid = new GamePiece[GRID_ROW][GRID_COL];
    }

    /**
     * Initialize the board with pieces at default locations
     * @param playerOne
     * @param playerTwo
     */
    public void initBoard(Player playerOne, Player playerTwo)
    {
        for (int col = 1; col <= 3; col++) {
            grid[0][col] = new TorchPiece(TORCH_PLAYER_ONE, playerOne);
            grid[1][col] = new BallPiece(BALL_PLAYER_ONE, playerOne);
            grid[3][col] = new BallPiece(BALL_PLAYER_TWO, playerTwo);
            grid[4][col] = new TorchPiece(TORCH_PLAYER_TWO, playerTwo);
        }
    }
    
    /**
     * Determine if one player lose the game
     * @param player
     */
    public boolean isGameOver(Player player)
    {
        if (player == null) {
            return false;
        }
        
        for (int row = 0; row < GRID_ROW; row++) {
            for (int col = 0; col < GRID_COL; col++) {
                if (grid[row][col] != null && grid[row][col].getOwner() == player) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Display the board
     */
    public void displayBoard()
    {
        int rowNum = 1;
        System.out.println();
        System.out.println("  a b c d e");
        for (int row = 0; row < GRID_ROW; row++) {
            System.out.print(rowNum++ + " ");
            for (int col = 0; col < GRID_COL; col++) {
                if (grid[row][col] == null) {
                    System.out.print("* ");
                } else {
                    System.out.print(grid[row][col].getPieceString() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Move the piece; throw exception if the move is not valid
     * @param player
     * @param from location
     * @param to location
     */
    public void movePiece(Player player, Location from, Location to) throws InvalidMoveException
    {   
        if (from.getXPosition() < 0 || from.getXPosition() >= GRID_ROW || from.getYPosition() < 0 || from.getYPosition() >= GRID_COL) {
            throw new InvalidMoveException("Invalid input for source location.");
        } else if (to.getXPosition() < 0 || to.getXPosition() >= GRID_ROW || to.getYPosition() < 0 || to.getYPosition() >= GRID_COL) {
            throw new InvalidMoveException("Invalid input for destination location.");
        } else if (grid[from.getXPosition()][from.getYPosition()] == null) {
            throw new InvalidMoveException("No piece at the source location.");
        } else if(grid[from.getXPosition()][from.getYPosition()].getOwner() != player) {
            throw new InvalidMoveException("That's not your piece.");
        } else if (from.getXPosition() == to.getXPosition() && from.getYPosition() == to.getYPosition()) {
            throw new InvalidMoveException("Invalid move, source and destination cannot be the same.");
        } else if (!(grid[from.getXPosition()][from.getYPosition()].isLegalMove(from, to))) {
            throw new InvalidMoveException("Invalid move for this piece.");
        } else if (!isPathClear(from, to)) {
            throw new InvalidMoveException("Path is not clear.");
        } else if (grid[to.getXPosition()][to.getYPosition()] != null && grid[to.getXPosition()][to.getYPosition()].getOwner() == player) {
            throw new InvalidMoveException("You can't capture your own piece.");
        } else {
            grid[to.getXPosition()][to.getYPosition()] = grid[from.getXPosition()][from.getYPosition()];
            grid[from.getXPosition()][from.getYPosition()] = null;
        }
    }
    
    /**
     * Determine if path is clear
     * @param from location
     * @param to location
     * @return true if path is clear, false if not
     */
    public boolean isPathClear(Location from, Location to)
    {
        if (from.getXPosition() == to.getXPosition()) {
            if (from.getYPosition() > to.getYPosition()) {
                Location temp = from;
                from = to;
                to = temp;
            }
            
            for (int col = from.getYPosition() + 1; col <= to.getYPosition() - 1; col++) {
                if (grid[from.getXPosition()][col] != null) {
                    return false;
                }
            }
        } else if (from.getYPosition() == to.getYPosition()) {
            if (from.getXPosition() > to.getXPosition()) {
                Location temp = from;
                from = to;
                to = temp;
            }
            
            for (int row = from.getXPosition() + 1; row <= to.getXPosition() - 1; row++) {
                if (grid[row][from.getYPosition()] != null) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
