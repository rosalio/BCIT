
/**
 * AudioBook class maintains information about a book presented in audio format:
 * title, author, publisher, playing time, sound quality
 * 
 * @author Colleen Penrowley 
 * @version comp 1451 Spring 2006
 */
public class AudioBook extends Item implements Playable
{
	private double playingTime;
	private String author;
	private String publisher;

	/**
	 * Constructor for objects of class AudioBook
	 */
	public AudioBook(String title, String author, String publisher, double playingTime)
	{
		super(title);
		this.author = author;
		this.publisher = publisher;
		this.playingTime = playingTime;
	}
	
	/**
	 * @return the book author
	 */
	public String getAuthor()
	{
	    return author;
	}
	
	/**
	 * @treturn the book publisher
	 */
	public String getPublisher()
	{
	    return publisher;
	}
	
	/**
	 * @return the book's playing time
	 */
	public double specifyPlayingTime()
	{
	    return playingTime;
	}

	/**
	 * @return a String representing this book
	 */
	public String toString()
	{
	    return super.toString() + "\n author: " + author + "\n publisher: " + publisher + "\n time: " + playingTime ;
	}
}
