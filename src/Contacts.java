import java.util.Scanner;

/**
 * Class "Contacts" controls the creation of a contact list.
 * Code written by Edward Miszkiewicz
 * Rev 1.2
 * Date: 06/19/2017, PM
 */
public class Contacts {

    /**
     * Method that prompts the user and reads in the required fields to create a single contact.
     * Written by edm.
     */
    public static Contact inputInfo () {

        Scanner input = new Scanner(System.in);

        String newFirstName = "";
        String newLastName = "";
        String newPhoneNumber = "";
        String newEmail = "";
        String newStreetAddress = "";
        String newNotes = "";

        System.out.print("Enter first name: ");
        newFirstName = input.nextLine();

        System.out.print("Enter last name: ");
        newLastName = input.nextLine();

        while (newLastName.equals("")) {

            System.out.print("Enter last name (required), or 99 to skip: ");
            newLastName = input.nextLine();
        }
        if (newLastName.equals("99")) {
            return null;
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

    /**
     * Main that calls the methods in class Contact and ContactList to create a list for two contacts.
     * Written by edm.
     */
    public static void main (String[] args) {
        ContactList listOfPeople = null;
        listOfPeople  = new ContactList();

        for (int count = 1; count <= 2; count++) {
            Contact person;
            person = inputInfo();

            if (person != null) {
                listOfPeople.addContact(person);
                System.out.println("Contact (" + count + ") added");
                System.out.println("-----------------");
                System.out.println(person); //implicit call to toString
            }
            else
                System.out.print("\nContact (" + count + ") not added!\n\n");
        }

        System.out.println("List of Contacts");
        System.out.println("----------------");
        System.out.print(listOfPeople);
    }
}

/*
------ Output (Run #1) ------

Enter first name: Edward
Enter last name:
Enter last name (required), or 99 to skip:
Enter last name (required), or 99 to skip:
Enter last name (required), or 99 to skip: 99

Contact (1) not added!

Enter first name: Andrew
Enter last name: Jackson
Enter street address: 23 Freedom Lane, Boston, MA 02110
Enter phone number: 514-267-1777
Enter email: AndJack@gmail.com
Enter notes: 7th president of the US.

Contact (2) added
-----------------
Name:    Andrew Jackson
Address: 23 Freedom Lane, Boston, MA 02110
Email:   AndJack@gmail.com
Phone:   514-267-1777
Notes:   7th president of the US.

List of Contacts
----------------
Name:    Andrew Jackson
Address: 23 Freedom Lane, Boston, MA 02110
Email:   AndJack@gmail.com
Phone:   514-267-1777
Notes:   7th president of the US.


Process finished with exit code 0
-----------------------------

------ Output (Run #2) ------

Enter first name: Edward
Enter last name:
Enter last name (required), or 99 to skip:
Enter last name (required), or 99 to skip:
Enter last name (required), or 99 to skip: Miszkiewicz
Enter street address: 4141 Thain Way, Palo Alto, CA 94306
Enter phone number: 650-269-4336
Enter email: havdessert1st@gmail.com
Enter notes: software slacker

Contact (1) added
-----------------
Name:    Edward Miszkiewicz
Address: 4141 Thain Way, Palo Alto, CA 94306
Email:   havdessert1st@gmail.com
Phone:   650-269-4336
Notes:   software slacker

Enter first name: Lisa
Enter last name: Penninger
Enter street address: 222 Haight St., San Francisco, CA 94111
Enter phone number: 650-338-2389
Enter email: summeroflove@gmail.com
Enter notes: software deva

Contact (2) added
-----------------
Name:    Lisa Penninger
Address: 222 Haight St., San Francisco, CA 94111
Email:   summeroflove@gmail.com
Phone:   650-338-2389
Notes:   software deva

List of Contacts
----------------
Name:    Edward Miszkiewicz
Address: 4141 Thain Way, Palo Alto, CA 94306
Email:   havdessert1st@gmail.com
Phone:   650-269-4336
Notes:   software slacker

Name:    Lisa Penninger
Address: 222 Haight St., San Francisco, CA 94111
Email:   summeroflove@gmail.com
Phone:   650-338-2389
Notes:   software deva


Process finished with exit code 0
-----------------------------

------ Output (Run #3) ------

Enter first name: George
Enter last name: Washington
Enter street address: 55 Liberty Ct., Boston, MA 02110
Enter phone number: 512-378-1777
Enter email: therealgeorge.w@gmail.com
Enter notes: Number 1.

Contact (1) added
-----------------
Name:    George Washington
Address: 55 Liberty Ct., Boston, MA 02110
Email:   therealgeorge.w@gmail.com
Phone:   512-378-1777
Notes:   Number 1.

Enter first name: Ben
Enter last name: Franklin
Enter street address: 279 Kite Rd, Philadelphia, PA, 02450
Enter phone number: 448-668-1777
Enter email: bigben@gmail.com
Enter notes: Likes kites.

Contact (2) added
-----------------
Name:    Ben Franklin
Address: 279 Kite Rd, Philadelphia, PA, 02450
Email:   bigben@gmail.com
Phone:   448-668-1777
Notes:   Likes kites.

List of Contacts
----------------
Name:    George Washington
Address: 55 Liberty Ct., Boston, MA 02110
Email:   therealgeorge.w@gmail.com
Phone:   512-378-1777
Notes:   Number 1.

Name:    Ben Franklin
Address: 279 Kite Rd, Philadelphia, PA, 02450
Email:   bigben@gmail.com
Phone:   448-668-1777
Notes:   Likes kites.


Process finished with exit code 0
-----------------------------
 */