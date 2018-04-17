/**
 * A class to model a simple mail item. The item has sender and recipient
 * addresses and a message string.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailItem
{
    // The sender of the item.
    private String from;
    // The intended recipient.
    private String to;
    // The subject of the message.
    private String subject;
    // The text of the message.
    private String message;

    /**
     * Create a mail item from sender to the given recipient,
     * containing the given message.
     * @param from The sender of this item.
     * @param to The intended recipient of this item.
     * @param subject The subject of this item.
     * @param message The text of the message to be sent.
     */
    public MailItem(String from, String to, String subject, String message)
    {
        this.from = formatName(from);
        this.to = formatName(to);
        this.subject = subject;
        this.message = message;
    }

    /**
     * @return The sender of this message.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * @return The intended recipient of this message.
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return The subject of this message.
     */
    public String getSubject()
    {
        return subject;
    }
    
    /**
     * @return The text of the message.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @param name
     * @return the properly-formatted name.
     */ 
    public static String formatName(String name)
    {
        String first = "";
        String rest = "";
        if (name != null && name.length() > 0) {
            first = name.substring(0, 1).toUpperCase();
            if (name.length() > 1) {
                rest = name.substring(1).toLowerCase();
            }
        }
        return first + rest;
    }
    
    /**
     * Print this mail message to the text terminal.
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
