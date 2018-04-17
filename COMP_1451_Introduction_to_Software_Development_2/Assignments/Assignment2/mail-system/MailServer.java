import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.SortedSet;

/**
 * A simple model of a mail server. The server is able to receive
 * mail items for storage, and deliver them to clients on demand.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailServer
{
    // Storage for the arbitrary number of mail items to be stored
    // on the server.
    private HashMap<String, ArrayList<MailItem> > items;
    private SpamFilter spamFilter;

    /**
     * Construct a mail server.
     */
    public MailServer()
    {
        items = new HashMap<String, ArrayList<MailItem> >();
        spamFilter = new SpamFilter();
        addWordsToSpamFilter();
    }
    
    /**
     * Add word to spam filter
     */
    public void addWordsToSpamFilter()
    {
        spamFilter.addNonStart("spam");
        
        spamFilter.addNonContain("online pharmacy");
        spamFilter.addNonContain("cheap viagra");
        spamFilter.addNonContain("generic viagra");
        spamFilter.addNonContain("fake watches");
        spamFilter.addNonContain("replica watches");
    }
    
    /**
     * Return how many mail items are waiting for a user.
     * @param who The user to check for.
     * @return How many items are waiting.
     */
    public int howManyMailItems(String who)
    {
        if (who == null) {
            System.out.println("Parameter is null!!!");
            return -1;
        }
      
        who = MailItem.formatName(who);
        ArrayList mailbox = items.get(who);
        if (mailbox != null) {
            return mailbox.size();
        }
        
        System.out.println("User not found!!!");
        return -2;
    }

    /**
     * Return the next mail item for a user or null if there
     * are none.
     * @param who The user requesting their next item.
     * @return The user's next item.
     */
    public MailItem getNextMailItem(String who)
    {
        if (who == null) {
            System.out.println("Parameter is null!!!");
            return null;
        }
        
        who = MailItem.formatName(who);
        if (items.get(who) != null) {
            Iterator<MailItem> it = items.get(who).iterator();
            if (it.hasNext()) {
                MailItem item = it.next();
                it.remove();
                return item;
            }
        }
        
        System.out.println("User not found!!!");
        return null;
    }

    /**
     * Add the given mail item to the message list.
     * @param item The mail item to be stored on the server.
     */
    public void post(MailItem item)
    {
        if (item != null) {
            if (spamFilter.isSpam(item)) {
                System.out.println("This is a spam mail!!!");
            } else {
                if (items.get(item.getTo()) != null) {
                    items.get(item.getTo()).add(item);
                } else {
                    ArrayList<MailItem> newMailbox = new ArrayList<MailItem>();
                    newMailbox.add(item);
                    items.put(item.getTo(), newMailbox);
                }
            }
        } else {
            System.out.println("Parameter is null!!!");
        }
    }
    
    /**
     * Sort the recipients alphabetically by name and print the mails
     */
    public void printMessagesSortedByRecipient() {
        SortedSet<String> sortedUsers = new TreeSet<String>(items.keySet());
        
        Iterator<String> it = sortedUsers.iterator();
        while (it.hasNext()) {
            String userName = (String)(it.next());
            System.out.println(userName);
            
            ArrayList<MailItem> mails = items.get(userName);
            if (mails == null || mails.size() == 0) {
                System.out.println("No mail.");
                continue;
            }
            
            for (MailItem aMail : mails) {
                aMail.print();
            }
        } 
    }
}
