
/**
 * Write a description of class Game here.
 * 
 * @author Alex Dai
 * @version 12/03/2014
 */

import java.util.ArrayList;

public class Game
{
    private Board gameBoard;
    private Player playerOne;
    private Player playerTwo;
    private LocationMapper locationMapper;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        gameBoard = new Board();
        locationMapper = new LocationMapper();
        playerOne = new Player("Player 1");
        playerTwo = new Player("Player 2");
    }

    /**
     * play method
     */
    public void play()
    {
        showRules();
        gameBoard.initBoard(playerOne, playerTwo);
        
        while (!gameBoard.isGameOver(playerOne) && !gameBoard.isGameOver(playerTwo))
        {
            boolean playerOneMoved = false; 
            boolean playerTwoMoved = false;
            
            while (!gameBoard.isGameOver(playerOne) && !playerOneMoved){
                try {
                    gameBoard.displayBoard();
                    ArrayList<String> playerOneMove = playerOne.enterMove();
                    gameBoard.movePiece(playerOne, locationMapper.getLocationByPos(playerOneMove.get(0)), locationMapper.getLocationByPos(playerOneMove.get(1)));
                    playerOneMoved = true;
                } catch (InvalidMoveException e) {               
                }
            }
            
            while (!gameBoard.isGameOver(playerTwo) && !playerTwoMoved){
                try {
                    gameBoard.displayBoard();
                    ArrayList<String> playerTwoMove = playerTwo.enterMove();
                    gameBoard.movePiece(playerTwo, locationMapper.getLocationByPos(playerTwoMove.get(0)), locationMapper.getLocationByPos(playerTwoMove.get(1)));
                    playerTwoMoved = true;
                } catch (InvalidMoveException e) {               
                }
            }
        }
        
        if (gameBoard.isGameOver(playerOne)) {
            gameBoard.displayBoard();
            System.out.println(playerTwo.getName() + " won!");
        } else if (gameBoard.isGameOver(playerTwo)) {
            gameBoard.displayBoard();
            System.out.println(playerOne.getName() + " won!");
        } else {
            System.out.println("Quit the game.");
        }
    }
    
    /**
     * Description of how to play
     */
    public void showRules()
    {
        System.out.println("Battle of the Jugging Object Rules:");
        System.out.println("1. The pieces belonging to player One are shown as uppercase letters, \"T\" for torches and \"O\" for balls.");
        System.out.println("2. The pieces belonging to player Two are shown as lowercase letters, \"t\" for torches and \"o\" for balls.");
        System.out.println("3. Empty locations are shown as *.");
        System.out.println("4. The player who \"captures\" all the opponent’s pieces is the winner.");
        System.out.println("5. The players type their moves, specifying the source and destination of a move, e.g. \"2b 3b\" to move the ball at location 2b to empty location 3b.");
        System.out.println("6. Ball - A ball can move either up or down, but not sideways. It can move only one space per turn.");
        System.out.println("7. Torch - A torch can move up or down, and also side-to-side. A torch can move any number of spaces, but only one direction per turn.");
        System.out.println("\nGame start.");
    }
}
