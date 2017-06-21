import java.io.Serializable;

/**
 * One object of this class represents one contact entry
 * Author: N.T
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
     * Author: N.T
     */
    public Contact(String newFirstName, String newLastName, String newPhoneNummber, String newEmail, String newStreetAddress, String newNotes) {

        this.firstName      = newFirstName;
        this.lastName       = newLastName;
        this.email          = newEmail;
        this.phoneNumber    = newPhoneNummber;
        this.streetAddress  = newStreetAddress;
        this.notes          = newNotes;

    }
    /**
     * returns the firstName of the contact
     */
    public String getFirstName() {

        return firstName;
    }

    /**
     * returns the last name of the contact
     */
    public String getLastName() {

        return lastName;
    }

    /**
     * returns the phone # of the contact
     */
    public String getPhoneNumber() {

        return phoneNumber;
    }

    /**
     * returns the email address of the contact
     */
    public String getEmail() {

        return email;
    }

    /**
     * returns the street address of the contact
     */
    public String getStreetAddress()
    {

        return streetAddress;
    }

    /**
     * returns the notes of the contact
     */
    public String getNotes() {

        return notes;
    }

    /**
     * returns a String containing all the information related to one contact
     * Author: N.T
     */
    public String toString() {

        String result = "";

        result += "Name:    " + firstName + " " + lastName + "\n";
        result += "Address: " + streetAddress + "\n";
        result += "Email:   " + email + "\n";
        result += "Phone:   " + phoneNumber + "\n";
        result += "Notes:   " + notes + "\n";

        return result;
    }

    /**
     * defines what it means for one object of class Contact to be bigger than another object of class Contact
     * compares two objects of class Contact and returns an integer based on whether one is greater, equal to, or less than the other
     * Author: N.T
     */
    public int compareTo(Contact contact) {

        if(this.lastName.compareToIgnoreCase(contact.lastName)==0)
            return this.firstName.compareToIgnoreCase(contact.firstName);
        else return this.lastName.compareToIgnoreCase(contact.lastName);

    }
}