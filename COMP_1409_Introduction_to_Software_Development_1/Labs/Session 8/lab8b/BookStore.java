
/**
 * Write a description of class BookStore here.
 * 
 * @author Alex Dai
 * @version May 28 2014
 */

import java.util.ArrayList;

public class BookStore
{
    public final String DEFAULT_BUSINESS_NAME = "Book Store";
    
    private String businessName;
    private ArrayList<Book> bookList;
    
    /**
     * Default constructor for objects of class BookStore
     */
    public BookStore()
    {
        this.businessName = DEFAULT_BUSINESS_NAME;
        this.bookList = new ArrayList<Book>();
    }

    /**
     * Constructor for objects of class BookStore
     * 
     * @param   newBusinessName 
     */
    public BookStore(String newBusinessName)
    {
        this.businessName = newBusinessName == null ? "" : newBusinessName;
        this.bookList = new ArrayList<Book>();
    }
    
    /**
     * Get the business name
     * 
     * @return  businessName
     */
    public String getBusinessName()
    {
        return this.businessName;
    }
    
    /**
     * Get the book list
     * 
     * @return  bookList
     */
    public ArrayList<Book> getBookList()
    {
        return this.bookList;
    }
    
    /**
     * Set the business name
     * 
     * @param newBusinessName
     */
    public void setBusinessName(String newBusinessName)
    {
        if(newBusinessName != null) {
            this.businessName = newBusinessName;
        }
    }
    
    /**
     * Set the book list
     * 
     * @param newBookList
     */
    public void setBookList(ArrayList<Book> newBookList) {
        if(newBookList != null) {
            this.bookList = newBookList;
        }
    }
    
    /**
     * Add a new book to the collection
     * 
     * @param   book
     */
    public void addBook(Book book)
    {
        if(book != null) {
            bookList.add(book);
        }
    }
    
    /**
     * Display the details of a book with a specific index
     * 
     * @param   index
     */
    public void showBookDetails(int index)
    {
        if(index >= 0 && index < bookList.size()) {
            bookList.get(index).displayBookInfo();
        }
        else {
            System.out.println("Book not found!");
        }
    }
    
    /**
     * Search a book by its title and display the details if found
     * Assumption: multiple books may have the same name
     *
     * @param   titleToSearch
     */
    public void searchBook(String titleToSearch)
    {
        boolean isFound = false;
        if(titleToSearch != null) {
            for(Book book : bookList) {
                if(titleToSearch.equalsIgnoreCase(book.getTitle())) {
                    isFound = true;
                    book.displayBookInfo();
                }
            }
        }
        
        if(!isFound) {
            System.out.println("Book not found!");  // book is not found
        }
    }
    
    /**
     * Display the details of all the books
     */
    public void displayDetailsOfAll()
    {
        System.out.printf("********************List of books in %s********************\n", businessName);
        int count = 1;
        for(Book book : bookList) {
            System.out.printf("Book No. %d:\n", count++);
            book.displayBookInfo();            
        }
        System.out.println("*******************************************************");
    }
}
