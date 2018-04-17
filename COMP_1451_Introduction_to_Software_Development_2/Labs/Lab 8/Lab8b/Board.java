
/**
 * Write a description of class Board here.
 * 
 * @author Alex Dai
 * @version 11/12/2014
 */

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private static final int GRID_ROW = 4;
    private static final int GRID_COLUMN = 4;
    
    private GamePiece[][] grid;

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        grid = new GamePiece[GRID_ROW][GRID_COLUMN];
    }
    
    /**
     * Populate the board with the same piece
     * @param piece
     */
    public void populateBoardWithPiece(GamePiece piece)
    {
        if (piece != null) {
            for (int row = 0; row < GRID_ROW; row++) {
                for (int col = 0; col < GRID_COLUMN; col++) {
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
            for (int col = 0; col < GRID_COLUMN; col++) {
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
     * Move the piece
     * @param from location
     * @param to location
     */
    public void movePiece(Location from, Location to)
    {
        if (!checkMovePiece(from, to)) {
            System.out.println("The move cannot be made!!!");
        } else {
            grid[to.getXPosition()][to.getYPosition()] = grid[from.getXPosition()][from.getYPosition()];
            grid[from.getXPosition()][from.getXPosition()] = null;
        }
    }

    /**
     * Check if the move is legal
     * @param from location
     * @param to location
     * @return true if is legal, false if not
     */
    public boolean checkMovePiece(Location from, Location to)
    {
        if (from.getXPosition() < 0 || from.getXPosition() >= GRID_ROW || from.getYPosition() < 0 || from.getYPosition() >= GRID_COLUMN) {
            System.out.println("Locaiton FROM is outside the boundary of the board!!!");
            return false;
        }
        
        if (to.getXPosition() < 0 || to.getXPosition() >= GRID_ROW || to.getYPosition() < 0 || to.getYPosition() >= GRID_COLUMN) {
            System.out.println("Locaiton TO is outside the boundary of the board!!!");
            return false;
        }
        
        if (grid[from.getXPosition()][from.getYPosition()] == null) {
            System.out.println("There is no piece in the FROM position!!!");
            return false;
        }
        
        if (!(grid[from.getXPosition()][from.getYPosition()].isLegalMove(from, to))) {
            System.out.println("The game piece at the FROM location reports that the move is not legal!!!");
            return false;
        }
        
        return true;
    }
}
