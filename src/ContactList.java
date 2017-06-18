import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * One object of class ContactList represents one list of contacts
 * Code written by Liwen Zhang
 */
public class ContactList implements Serializable {
    private ArrayList<Contact> listOfContacts = new ArrayList<>();

    /**
     * adds an object of class contact to the arraylist, parameter is newContact
     */
    public void addContact(Contact newContact) {
        listOfContacts.add(newContact);
    }
    /**
     * prints a string of all objects of class contact in the arraylist
     */
    public void printAllContacts() {

    }
    /**
     * searches the arraylist for any objects of class contact by last name
     * and prints out any matching object
     */
    public void searchContactsByLastName(String lastName) {

    }

    /**
     * saves the arraylist to the disk
     */
    public void saveListToDisk() {

    }
    /**
     * retrieves(returns) the arraylist from disk to listOfContacts
     */
    public void retrieveListFromDisk() {

    }

    /**
     * returns a String containing all the information related to an object of class ContactList
     */
    public String toString() {
        String printed = "";
        for(Contact contact: listOfContacts) {
            printed += contact.toString();
            printed += "\n";
        }
        return printed;
    }
}