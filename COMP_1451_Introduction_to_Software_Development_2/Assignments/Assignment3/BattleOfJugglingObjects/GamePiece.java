
/**
 * Abstract class GamePiece - write a description of the class here
 * 
 * @author Alex Dai
 * @version 11/29/2014
 */
public abstract class GamePiece
{
    private String pieceString;
    private Player owner;

    /**
     * Constructor for objects of class GamePiece
     * @param pieceString: string to represent the piece
     * @param owner: which player does the piece belong to
     */
    public GamePiece(String pieceString, Player owner)
    {
        this.pieceString = pieceString;
        this.owner = owner;
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
     * Get owner
     * @return owner
     */
    public Player getOwner()
    {
        return owner;
    }
    
    /**
     * Set owner
     * @param owner
     */
    public void setOwner(Player owner)
    {
        this.owner = owner;
    }
    
    /**
     * Method isLegalMove
     * @param location a
     * @param location b
     * @return true if is legal move, false if not
     */
    public abstract boolean isLegalMove(Location a, Location b);
}
