
/**
 * Write a description of class BookClub here.
 * 
 * @author  Alex Dai
 * @version 04/29/2014
 */
public class BookClub
{
    // instance variable
    private String clientName;
    private int numberOfPurchasedBooksPerMonth;
    private double bookPriceInCAD;
    private static int totalNumberOfPurchasedBooks = 0;
    
    // symbolic constant
    private static final int FIRST_LEVEL_BOOK_NUMBER = 1;
    private static final int SECOND_LEVEL_BOOK_NUMBER = 2;
    private static final int THIRD_LEVEL_BOOK_NUMBER = 3;
    private static final int FOURTH_LEVEL_BOOK_NUMBER = 4;
    private static final int FIRST_LEVEL_AWARD_POINTS = 5;
    private static final int SECOND_LEVEL_AWARD_POINTS = 15;
    private static final int THIRD_LEVEL_AWARD_POINTS = 30;
    private static final int FOURTH_LEVEL_AWARD_POINTS = 60;
    private static final int EXTRA_AWARD_BOOK_NUMBER = 10;
    private static final int EXTRA_AWARD_POINTS = 20;
    
    /**
     * Default constructor
     */
    public BookClub()
    {
        clientName = "";
        numberOfPurchasedBooksPerMonth = 0;
        bookPriceInCAD = 0.0;
    }

    /**
     * Non-default constructor
     * @param   name as a String
     * @param   bookNum as an int
     * @param   price as a double
     */
    public BookClub(String name, int bookNum, double price)
    {
        if (name != null) {
            clientName = name;
        }
        else {
            clientName = "";
        }
        
        if (bookNum > 0) {
            numberOfPurchasedBooksPerMonth = bookNum;
            totalNumberOfPurchasedBooks += numberOfPurchasedBooksPerMonth;
        }
        else {
            numberOfPurchasedBooksPerMonth = 0;
        }
        
        if (price > 0) {
            bookPriceInCAD = price;
        }
        else {
            bookPriceInCAD = 0;
        }
    }
    
    /**
     * Get client name
     * @return  clientName
     */
    public String getClientName()
    {
        return clientName;
    }
    
    /**
     * Get number of purchased books per month
     * @return  numberOfPurchasedBooksPerMonth
     */
    public int getNumOfPurchasedBooksPerMonth()
    {
        return numberOfPurchasedBooksPerMonth;
    }
    
    /**
     * Get book price in CAD
     * @return  bookPriceInCAD
     */
    public double getBookPriceInCAD()
    {
        return bookPriceInCAD;
    }
    
    /**
     * Set client name
     * @param   name as a String
     */
    public void setClientName(String name)
    {
        if (name != null) {
            clientName = name;
        }
    }
    
    /**
     * Set number of purchased books per month
     * @param   bookNum as an int
     */
    public void setNumOfPurchasedBooksPerMonth(int bookNum)
    {
        if (bookNum >= 0) {
            numberOfPurchasedBooksPerMonth = bookNum;
        }
    }
    
    /**
     * Set book price in CAD
     * @param   price as a double
     */
    public void setBookPriceInCAD(double price)
    {
        if (price >= 0) {
            bookPriceInCAD = price;
        }
    }
    
    /**
     * Get total number of purchased books
     * @return  totalNumberOfPurchasedBooks
     */
    public static int getTotalNumberOfPurchasedBooks()
    {
        return totalNumberOfPurchasedBooks;
    }
    
    
    /**
     * Method to calculate and return the number of points awarded
     * @return  pointsAwarded as an int
     */
    public int calculateBookPoints()
    {
        int pointsAwarded = 0;
        
        if (numberOfPurchasedBooksPerMonth == FIRST_LEVEL_BOOK_NUMBER) {
            pointsAwarded = FIRST_LEVEL_AWARD_POINTS;
        }
        else if (numberOfPurchasedBooksPerMonth == SECOND_LEVEL_BOOK_NUMBER) {
            pointsAwarded = SECOND_LEVEL_AWARD_POINTS;
        }
        else if (numberOfPurchasedBooksPerMonth == THIRD_LEVEL_BOOK_NUMBER) {
            pointsAwarded = THIRD_LEVEL_AWARD_POINTS;
        }
        else if (numberOfPurchasedBooksPerMonth >= FOURTH_LEVEL_BOOK_NUMBER) {
            pointsAwarded = FOURTH_LEVEL_AWARD_POINTS;
        }
        
        if (totalNumberOfPurchasedBooks >= EXTRA_AWARD_BOOK_NUMBER) {
            pointsAwarded += EXTRA_AWARD_POINTS;
        }
        
        return pointsAwarded;
    }
}
