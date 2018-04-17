
/**
 * Write a description of class GamePiece here.
 * 
 * @author Alex Dai
 * @version 11/22/2014
 */
public class GamePiece
{
    private String pieceString;

    /**
     * Constructor for objects of class GamePiece
     */
    public GamePiece(String pieceString)
    {
        this.pieceString = pieceString;
    }

    /**
     * Get piece string
     * @return pieceString
     */
    public String getPieceString()
    {
        return pieceString;
    }
    
    /**
     * Set piece string
     * @param pieceString
     */
    public void setPieceString(String pieceString)
    {
        this.pieceString = pieceString;
    }

    /**
     * Method isLegalMove
     * @param location a
     * @param location b
     * @return true if is legal move, false if not
     */
    public boolean isLegalMove(Location a, Location b)
    {
        return b.getXPosition() - a.getXPosition() > 0 || b.getYPosition() - a.getXPosition() > 0;
    }
}
