
/**
 * Write a description of class SpamFilter here.
 * 
 * @author Alex Dai
 * @version 11/06/2014
 */

import java.util.ArrayList;

public class SpamFilter
{
    private ArrayList<String> nonStart;
    private ArrayList<String> nonContain;
    
    /**
     * Constructor of class SpamFilter
     */
    public SpamFilter()
    {
        nonStart = new ArrayList<String>();
        nonContain = new ArrayList<String>();
        
    }
    
    /**
     * Add word starts in the subject, and would be treated as spam
     * @param word
     */
    public void addNonStart(String word)
    {
        if (word != null) {
            nonStart.add(word.toLowerCase());
        }
    }
    
    /**
     * Add word contains in the subject, and would be treated as spam
     */
    public void addNonContain(String word)
    {
        if (word != null) {
            nonContain.add(word.toLowerCase());
        }
    }
    
    /**
     * Determine if the mail is a spam
     * @param item the mail item
     * @return true if is spam; false if not spam
     */
    public boolean isSpam(MailItem item)
    {
        if(item == null) {
            System.out.println("Mail item is null!");
            return true; // no mail item, do not post
        }
        
        String subject = item.getSubject().toLowerCase();
        
        // check if subject starts with the words
        for (String str : nonStart) {
            if (subject.length() >= str.length() && subject.startsWith(str)) {
                return true;
            }
        }
        
        // check if subject contains the words
        for (String str : nonContain) {
            if (subject.length() >= str.length() && subject.contains(str)) {
                return true;
            }
        }
        
        return false;
    }
}
