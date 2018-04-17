
/**
 * Write a description of class locationMapper here.
 * 
 * @author Alex Dai
 * @version 12/04/2014
 */
public class LocationMapper
{
    /**
     * get location by position coordinates
     * @param pos
     * @return location
     */
    public Location getLocationByPos(String pos) throws InvalidMoveException
    {        
        //if (pos == null || pos.length() != 2 || pos.charAt(0) < '1' || pos.charAt(0) > '5' || pos.charAt(1) < 'a' || pos.charAt(1) > 'e') {
        if (pos == null || pos.length() != 2) {
            throw new InvalidMoveException("Invalid input format of source or destination.");
        }
        
        int row = pos.charAt(0) - '1';
        int col = pos.charAt(1) - 'a';
        
        return new Location(row, col);
    }
}
