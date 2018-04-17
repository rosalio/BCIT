
/**
 * Write a description of class Board here.
 * 
 * @author Alex Dai
 * @version 11/22/2014
 */
public class Board
{
    private static final int GRID_ROW = 4;
    private static final int GRID_COL = 4;
    
    private GamePiece[][] grid;

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        grid = new GamePiece[GRID_ROW][GRID_COL];
    }

    /**
     * Populate the board with the same piece
     * @param piece
     */
    public void populateBoardWithPiece(GamePiece piece)
    {
        if (piece != null) {
            for (int row = 0; row < GRID_ROW; row++) {
                for (int col = 0; col < GRID_COL; col++) {
                    grid[row][col] = piece;
                }
            }
        } else {
            System.out.println("Parameter null");
        }
    }
    
    /**
     * Display the board
     */
    public void displayBoard()
    {
        System.out.println();
        for (int row = 0; row < GRID_ROW; row++) {
            for (int col = 0; col < GRID_COL; col++) {
                if (grid[row][col] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(grid[row][col].getPieceString() + " ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Move the piece; throw exception if the move is not valid
     * @param from location
     * @param to location
     */
    public void movePiece(Location from, Location to) throws InvalidMoveException
    {   
        if (from.getXPosition() < 0 || from.getXPosition() >= GRID_ROW || from.getYPosition() < 0 || from.getYPosition() >= GRID_COL) {
            throw new InvalidMoveException("Locaiton FROM is outside the boundary of the board!!!");
        } else if (to.getXPosition() < 0 || to.getXPosition() >= GRID_ROW || to.getYPosition() < 0 || to.getYPosition() >= GRID_COL) {
            throw new InvalidMoveException("Locaiton TO is outside the boundary of the board!!!");
        } else if (grid[from.getXPosition()][from.getYPosition()] == null) {
            throw new InvalidMoveException("There is no piece in the FROM position!!!");
        } else if (!(grid[from.getXPosition()][from.getYPosition()].isLegalMove(from, to))) {
            throw new InvalidMoveException("The game piece at the FROM location reports that the move is not legal!!!");
        } else {
            grid[to.getXPosition()][to.getYPosition()] = grid[from.getXPosition()][from.getYPosition()];
            grid[from.getXPosition()][from.getXPosition()] = null;
        }
    }
}
