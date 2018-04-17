
/**
 * Write a description of class BallPiece here.
 * 
 * @author Alex Dai
 * @version 11/29/2014
 */
public class BallPiece extends GamePiece
{   
    /**
     * Constructor for objects of class BallPiece
     * @param pieceString
     * @param owner
     */
    public BallPiece(String pieceString, Player owner)
    {
        super(pieceString, owner);
    }
    
    /**
     * Implementation of isLegalMove method
     * @param location a
     * @param location b
     * @return true if is legal move, false if not
     */
    public boolean isLegalMove(Location a, Location b)
    {
        if (a.getYPosition() != b.getYPosition() || Math.abs(a.getXPosition() - b.getXPosition()) != 1) {
            return false;
        }        
        return true;
    }
}
