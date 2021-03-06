import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * One object of class ContactList represents one list of contacts
 * Code written by Liwen Zhang
 */
public class ContactList{
    private ArrayList<Contact> listOfContacts = new ArrayList<>();

    /**
     * adds an object of class contact to the arraylist, parameter is newContact
     * written by L.Z.
     */
    public void addContact(Contact newContact) {
        listOfContacts.add(newContact);
    }

    /**
     * prints a string of all objects of class contact in the arraylist alphabetically by last name
     * written by L.Z.
     */
    public void printAllContacts() {
        Collections.sort(listOfContacts);
        System.out.print(this.toString());
    }

    /**
     * searches the arraylist for any objects of class contact by last name
     * and prints out any matching objects as well as number of contacts found
     * written by L.Z.
     */
    public void searchContactsByLastName(String lastName) {
        int count = 0;
        String found = "";
        for (Contact contact: listOfContacts) {
            if(lastName.equals(contact.getLastName())) {
                count++;
                found = found + contact.toString() + "\n";
            }
        }
        System.out.println("(" + count + ") Contact(s) Found!");
        System.out.println("---------------------");

        if (found.equals("")) {
            System.out.println();
        }
        else{
            System.out.print(found);
        }
    }

    /**
     * saves the arraylist to the disk
     * Author N.T
     */
    public void saveListToDisk() {

        if (this.listOfContacts.size() > 0) {
            String absoluteFilePath = getFilePath();
            try {
                FileOutputStream fileOut = new FileOutputStream(absoluteFilePath);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(listOfContacts);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                System.out.println("Error saving the contact list");
            }
        }
    }

    /**
     * retrieves the arraylist from disk to listOfContacts
     * Author N.T
     */
    public void retrieveListFromDisk() {

        String absoluteFilePath = getFilePath();
        File f = new File(absoluteFilePath);
        if(f.exists() && !f.isDirectory()) {
            try {
                FileInputStream fileIn = new FileInputStream(absoluteFilePath);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                this.listOfContacts = (ArrayList) in.readObject();
                in.close();
                fileIn.close();
            }catch(IOException i) {
                System.out.println("Error in reading data");
            }catch(ClassNotFoundException c) {
                System.out.println("Error in reading data");
            }
        }
    }

    /**
     * returns the number of contacts in ContactList
     * Author: edm
     */
    public int count() {
        return listOfContacts.size();
    }

    /**
     * returns file path for saving and retrieving data
     * Author: N.T
     */
    private String getFilePath(){

        String filename = "ContactList.ser";
        String workingDirectory = System.getProperty("user.dir");
        return  workingDirectory + File.separator + filename;
    }

    /**
     * returns a String containing all the information related to an object of class ContactList
     * written by L.Z.
     */
    public String toString() {
        String printed = "";
        for(Contact contact: listOfContacts) {
            printed = printed + contact.toString() + "\n";
        }
        return printed;
    }
}