import java.util.Collections;

/**
 * Main that tests all the classes
 * Code written by Liwen Zhang
 */
public class Contacts {
    public static void main (String[] args) {
        Contact person1 = new Contact("Emily","Zhang", "4082343439","something@gmail.com","1287 blahblah ave san jose 13498","random contact entry that I just made up just now");
        System.out.println(person1); //toString

        Contact person2 = new Contact("Joe","Bob","9901238790","hellohello@gmail.com","39487 something lane los altos hills 39480", "other contact");
        System.out.println(person2); //toString

        ContactList listofpeople = new ContactList();
        listofpeople.addContact(person1);
        listofpeople.addContact(person2);

        System.out.println("person 1 " + person1);
        System.out.println("person 2 " + person2);

        System.out.println(person1.compareTo(person2));
        System.out.println(person2.compareTo(person1));

        System.out.println(person1.getFirstName());
        System.out.println(person1.getLastName());
        System.out.println(person1.getPhoneNumber());
        System.out.println(person1.getEmail());
        System.out.println(person1.getStreetAddress());
        System.out.println(person1.getNotes());

        listofpeople.printAllContacts();
        listofpeople.searchContactsByLastName("Zhang");
        listofpeople.searchContactsByLastName("Bob");
        listofpeople.saveListToDisk();
        listofpeople.retrieveListFromDisk();

    }
}

/*
contact
contact
person 1 contact
person 2 contact
0
0
first name
last name
phone number
email
street address
notes
 */