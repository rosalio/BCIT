
/**
 * Write a description of class Book here.
 * 
 * @author Alex Dai
 * @version May 28 2014
 */
public class Book
{
    private String title;
    private String author;
    private int yearPublished;
    private double bookPriceInCAD;

    /**
     * Default constructor for objects of class Book
     */
    public Book()
    {
        setTitle("");
        setAuthor("");
        setYearPublished(0);
        setPriceInCAD(0);
    }

    /**
     * Constructor for objects of class Book
     * 
     * @param   bookTitle
     * @param   bookAuthor
     * @param   publishYear
     * @param   bookPrice
     */
    public Book(String bookTitle, String bookAuthor, int publishYear, double bookPrice)
    {
        setTitle(bookTitle);
        setAuthor(bookAuthor);
        setYearPublished(publishYear);
        setPriceInCAD(bookPrice);
    }
    
    /**
     * Set the title of a book
     *
     * @param   bookTitle
     */
    public void setTitle(String bookTitle)
    {
        if(bookTitle != null) {
            this.title = bookTitle;
        }
    }
    
    /**
     * Set the author of a book
     * 
     * @param   bookAuthor
     */
    public void setAuthor(String bookAuthor)
    {
        if(bookAuthor != null) {
            this.author = bookAuthor;
        }
    }
    
    /**
     * Set the year in which the book was published
     * 
     * @param   publishYear
     */
    public void setYearPublished(int publishYear)
    {
        if(publishYear >= 0) {
            this.yearPublished = publishYear;
        }
    }
    
    /**
     * Set the price of a book in Canadian Dollars
     * 
     * @param   bookPrice
     */
    public void setPriceInCAD(double bookPrice)
    {
        if(bookPrice >= 0) {
            this.bookPriceInCAD = bookPrice;
        }
    }
    
    /**
     * Get the title of a book
     * 
     * @return  title
     */
    public String getTitle()
    {
        return this.title;
    }
    
    /**
     * Get the author of a book
     * 
     * @return  author
     */
    public String getAuthor()
    {
        return this.author;
    }
    
    /**
     * Get the year in which the book was published
     * 
     * @return yearPublished
     */
    public int getYearPublished()
    {
        return this.yearPublished;
    }
    
    /**
     * Get the book price in Canadian Dollars
     * 
     * @return  bookPriceInCAD
     */
    public double getPriceInCAD()
    {
        return this.bookPriceInCAD;
    }

    /**
     * Display the book's information
     */
    public void displayBookInfo()
    {
        System.out.println("----------Book Information----------");
        System.out.printf("Title: %s\nAuthor: %s\nPublish Year: %d\nPrice: CAD $%.2f\n", title, author, yearPublished, bookPriceInCAD);
        System.out.println("----------------End-----------------");
    }
}
