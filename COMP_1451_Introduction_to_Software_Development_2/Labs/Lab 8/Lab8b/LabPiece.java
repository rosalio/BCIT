
/**
 * Write a description of class LabPiece here.
 * 
 * @author Alex Dai
 * @version 11/12/2014
 */
public class LabPiece extends GamePiece
{   
    /**
     * Implementation of isLegalMove method
     * @param location a
     * @param location b
     * @return true if is legal move, false if not
     */
    public boolean isLegalMove(Location a, Location b)
    {
        return b.getXPosition() - a.getXPosition() > 0 || b.getYPosition() - a.getXPosition() > 0;
    }
}
