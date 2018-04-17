
/**
 * Write a description of class EmailInfo here.
 * 
 * @author Alex Dai
 * @version 09/28/2014
 */

import java.util.HashMap;
import java.util.Set;

public class EmailInfo
{
    private HashMap<String, String> addressBook;

    /**
     * Constructor for objects of class EmailInfo
     */
    public EmailInfo()
    {
        addressBook = new HashMap<String, String>();
    }

    /**
     * Format the name
     * 
     * @param name
     *            the name 
     * @return the properly-formatted name.
     */
    private String formatName(String name)
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
     
    /** Add a friend to the address book. The friend's name must be
     * formatted before being stored.
     * 
     * @param name
     *            the name
     * @param email
     *            the email
     */
    public void addFriend(String name, String email)
    {
        if (name != null && email != null) {
            addressBook.put(formatName(name), email);
            System.out.println("Successfully added " + name + " with email address " + email);
        } else {
            System.out.println("Input parameters contain null objects. Please validate.");
        }
    }

    /**
     * Remove a friend from the address book. The name passed in
     * can be in upper case, lower case, or mixed. The friend and
     * his/her email will be removed from the address book.
     * 
     * @param name
     *            the name
     */
    public void removeFriend(String name)
    {
        if (name == null) {
            System.out.println("Null input.");
            return ;
        }
        
        String formattedName = formatName(name);
        if (addressBook.containsKey(formattedName)) {
            addressBook.remove(formattedName);
            System.out.println("Successfully removed " + formattedName);
        } else {
            System.out.println("Cannot find " + formattedName + " in address book");
        }
    }

    /** Return an email address based on friend’s name. The name
     * passed in can be in upper case, lower case, or mixed. The
     * friend's email address will be returned.
     * 
     * @param name
     *            the name
     * @return email address based on name
     */
    public String getAddress(String name)
    {
        if (name == null) {
            return null;
        }
        return addressBook.get(formatName(name));
    }
    
    /**
     * Find and display friends based on their email address. There
     * might be more than one friend using the same email.
     * 
     * @param email
     *             the email
     */
    public void findFriends(String email)
    {
        if (email == null) {
            System.out.println("Null input.");
            return ;
        }
        
        Set<String> allNames = addressBook.keySet();
        System.out.println("Strarting looking for names with email " + email);
        for (String name : allNames) {
            if (addressBook.get(name).equals(email)) {
                System.out.println("Name found: " + name);
            }
        }
        System.out.println("Ending");
    }
    
    /**
     * List all friends and their email addresses
     */
    public void listAll()
    {
        Set<String> allNames = addressBook.keySet();
        System.out.println("List all names and email addresses: ");
        for (String name : allNames) {
            System.out.println(name + " : " + addressBook.get(name));
        }
    }
}
