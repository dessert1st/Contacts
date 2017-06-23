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
     * returns the last name of the contact
     */
    public String getLastName() {

        return lastName;
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
     * Compares two objects of class Contact with last names, if they are equal,compares them with first names.
     * compareToIgnoreCase() returns the value 0 if the argument is lexicographically equal to the object calling this method;
     * a value less than 0 if the argument is lexicographically greater than the object calling this method;
     * and a value greater than 0 if the argument lexicographically less than the object calling this method.
     * Author: N.T
     */
    public int compareTo(Contact contact) {

        if(this.lastName.compareToIgnoreCase(contact.lastName)==0)
            return this.firstName.compareToIgnoreCase(contact.firstName);
        else return this.lastName.compareToIgnoreCase(contact.lastName);

    }
}