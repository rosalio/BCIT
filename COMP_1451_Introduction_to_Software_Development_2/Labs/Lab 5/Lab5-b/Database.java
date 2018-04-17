
/**
 * Write a description of class Database here.
 * 
 * @author Alex Dai
 * @version 10/19/2014
 */

import java.util.ArrayList;

public class Database
{
    private ArrayList<Member> members;

    /**
     * Constructor for objects of class Database
     */
    public Database()
    {
        members = new ArrayList<Member>();
    }

    /**
     * Add member to the database
     * 
     * @param member
     *          the member
     */
    public void addMember(Member member)
    {
        if (member != null) {
            members.add(member);
        } else {
            System.out.println("The input cannot be null");
        }
    }
    
    /**
     * Display the names and emails of everyone in the database
     */
    public void displayMember()
    {
        for (Member member : members) {
            System.out.println(member.getFirstName() + " " + member.getLastName() + " : " + member.getEmailAddress());
        }
    }
}
