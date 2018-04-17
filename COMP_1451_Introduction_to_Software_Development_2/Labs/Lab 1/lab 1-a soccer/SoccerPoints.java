
/**
 * Write a description of class SoccerPoints here.
 * 
 * @author Alex Dai
 * @version 09/19/2014
 */
public class SoccerPoints
{
    private static final int END_LOOP_FLAG = -1;
    private String teamName;
    private int totalPoints;
    
    /**
     * Constructor
     */
    public SoccerPoints()
    {
        this.totalPoints = 0;
        this.teamName = "";
    }
    
    /**
     * Constructor
     * @param teamname - name of the team
     */
    public SoccerPoints(String teamName)
    {
        this.totalPoints = 0;
        setTeamName(teamName);
    }
    
    /**
     * Get name of the team
     * @return team name
     */
    public String getTeamName()
    {
        return this.teamName;
    }
    
    /**
     * Get total points
     * @return total points
     */
    public int getTotalPoints()
    {
        return this.totalPoints;
    }
    
    /**
     * Set team name
     * @param teamName - name of the team
     */
    public void setTeamName(String teamName)
    {
        this.teamName = teamName != null && !teamName.equals("") ? teamName : "unknown";
    }
    
    /**
     * Method to calucate and display total points based on user input
     */
    public void calculateTotalPoints()
    {
        InputReader inputReader = new InputReader();
        int pointsInOneGame = 0;
                
        do {
            System.out.print("Please enter earned points of this game (-1 to end): ");
            pointsInOneGame = inputReader.readInt();
            if (pointsInOneGame >= 0) {
                this.totalPoints += pointsInOneGame;
            } else if (pointsInOneGame < 0 && pointsInOneGame != END_LOOP_FLAG) {
                System.out.println("Points must be positive numbers");
            }
        }
        while (pointsInOneGame != END_LOOP_FLAG);
        
        System.out.println("The team " + this.teamName + " has earned " + this.totalPoints + " points totally.");
    }
}
