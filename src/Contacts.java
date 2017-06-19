import java.util.Collections;
import java.util.Scanner;

/**
 * Main that calls the methods in class Contact and ContactList to create a list for two contacts.
 * Code written by Edward Miszkiewicz
 * Rev 1.0
 * Date: 06/19/2017
 */

public class Contacts {

    /**
     * Method that prompts the user and reads in the required fields for a single contact:
     * first name, last name, address, phone number, email and note.
     * Written by Edm.
     */
    public static Contact inputInfo () {

        Scanner input = new Scanner(System.in);

        String newFirstName;
        String newLastName;
        String newPhoneNumber;
        String newEmail;
        String newStreetAddress;
        String newNotes;

        System.out.print("Enter first name: ");
        newFirstName = input.nextLine();

        System.out.print("Enter last name: ");
        newLastName = input.nextLine();

        while (newLastName.equals("")) {
            System.out.print("Last name field is required!");
            System.out.println();
            System.out.print("Enter last name: ");
            newLastName = input.nextLine();
        }

        System.out.print("Enter street address: ");
        newStreetAddress = input.nextLine();

        System.out.print("Enter phone number: ");
        newPhoneNumber = input.nextLine();

        System.out.print("Enter email: ");
        newEmail = input.nextLine();


        System.out.print("Enter notes: ");
        newNotes = input.nextLine();

        System.out.println();

        Contact person = new Contact(newFirstName, newLastName, newPhoneNumber, newEmail, newStreetAddress, newNotes);

        return person;
    }

    public static void main (String[] args) {

        Contact person1;
        person1 = inputInfo();

        Contact person2;
        person2 = inputInfo();

        ContactList listofpeople = new ContactList();
        listofpeople.addContact(person1);
        listofpeople.addContact(person2);

        System.out.println("Contact (1)");
        System.out.println("-----------");
        System.out.println(person1); //implicit call to toString
        //System.out.println();

        System.out.println("Contact (2)");
        System.out.println("-----------");
        System.out.println(person2); //implicit call to toString

    }
}

/*
------ OUTPUT ------

Enter first name: Edward
Enter last name:
Last name field is required!
Enter last name:
Last name field is required!
Enter last name: Miszkiewicz
Enter street address: 4141 Thain Way, Palo Alto, CA, 94306
Enter phone number: 650-269-4336
Enter email: havdessert1st@gmail.com
Enter notes: software slacker

Enter first name: Lisa
Enter last name:
Last name field is required!
Enter last name: Penninger
Enter street address: 12345 Disneyland Lane, Los Angeles, CA 92208
Enter phone number: 650-799-3916
Enter email: lpenninger@alum.calberkeley.org
Enter notes: software deva

Contact (1)
-----------
Name:    Edward Miszkiewicz
Address: 4141 Thain Way, Palo Alto, CA, 94306
Email:   havdessert1st@gmail.com
Phone:   650-269-4336
Notes:   software slacker

Contact (2)
-----------
Name:    Lisa Penninger
Address: 12345 Disneyland Lane, Los Angeles, CA 92208
Email:   lpenninger@alum.calberkeley.org
Phone:   650-799-3916
Notes:   software deva


Process finished with exit code 0

--------------------
 */