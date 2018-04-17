
/**
 * Abstract class GamePiece - write a description of the class here
 * 
 * @author Alex Dai
 * @version 11/12/2014
 */
public abstract class GamePiece
{
    private String pieceString;
    
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
     * abstract method isLegalMove
     * @param location a
     * @param location b
     * @return true if is legal move, false if not
     */
    public abstract boolean isLegalMove(Location a, Location b);
}
