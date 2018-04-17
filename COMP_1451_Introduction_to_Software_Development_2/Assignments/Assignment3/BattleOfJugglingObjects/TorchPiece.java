
/**
 * Write a description of class TorchPiece here.
 * 
 * @author Alex Dai
 * @version 11/29/2014
 */
public class TorchPiece extends GamePiece
{   
    /**
     * Constructor for objects of class TorchPiece
     * @param pieceString
     * @param owner
     */
    public TorchPiece(String pieceString, Player owner)
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
        if (a.getXPosition() != b.getXPosition() && a.getYPosition() != b.getYPosition()) {
            return false;
        }
        
        return true;
    }
}
