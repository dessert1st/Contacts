import java.io.Serializable;

/**
 * One object of this class represents one contact entry
 * Code written by Liwen Zhang
 */
public class Contact implements Comparable<Contact>, Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String streetAddress;
    private String notes;


    /**
     * constructor that sets the firstName of the contact to newFirstName
     */
    public Contact(String newFirstName, String newLastName, String newPhoneNummber, String newEmail, String newStreetAddress, String newNotes) {

    }
    /**
     * returns the firstName of the contact
     */
    public String getFirstName() {
        return "first name";
    }

    /**
     * returns the last name of the contact
     */
    public String getLastName() {
        return "last name";
    }

    /**
     * returns the phone # of the contact
     */
    public String getPhoneNumber() {
        return "phone number";
    }

    /**
     * returns the email address of the contact
     */
    public String getEmail() {
        return "email";
    }

    /**
     * returns the street address of the contact
     */
    public String getStreetAddress() {
        return "street address";
    }

    /**
     * returns the notes of the contact
     */
    public String getNotes() {
        return "notes";
    }

    /**
     * returns a String containing all the information related to one contact
     */
    public String toString() {
        return "contact";
    }

    /**
     * defines what it means for one object of class Contact to be bigger than another object of class Contact
     * compares two objects of class Contact and returns an integer based on whether one is greater, equal to, or less than the other
     */
    public int compareTo(Contact contact) {
        return 0;
    }
}