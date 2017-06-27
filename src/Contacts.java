import java.util.Scanner;

/**
 * Class "Contacts" controls the creation of a contact list.
 * Code written by Edward Miszkiewicz
 * Rev 2.1 (Task 4)
 * Date: 06/27/2017
 */
public class Contacts {

    private static ContactList listOfPeople  = new ContactList();

    private static Scanner input = new Scanner(System.in);

    /**
     * Method that prints the menu, checks for valid user input, and calls
     * either the add, print, search, or save method.
     * Author: edm
     */
    public static void printMenu () {
        int inputOption = 0;

        while (inputOption != 4)
        {
            do
            {
                System.out.println("------------- MENU -------------");
                System.out.println("  *** Contact List Program ***");
                System.out.println();
                System.out.println("    1. Add new contact");
                System.out.println("    2. Print contact list");
                System.out.println("    3. Search by last name");
                System.out.println("    4. Save and exit");
                System.out.println("--------------------------------");
                System.out.print("Select from one of the above options: ");

                try
                {
                    inputOption = Integer.parseInt(input.nextLine());
                }
                catch (Exception e)
                {
                    inputOption = 0;
                }

                if (inputOption <= 0 || inputOption > 4)
                {
                    System.out.print("\nPlease enter a valid option!\n");
                    System.out.println();
                }
            }
            while (inputOption <= 0 || inputOption > 4);

            switch (inputOption)
            {
                case 1:  //call add contact method
                    addPerson();
                    break;
                case 2:  //call print contact list method
                    System.out.println();
                    System.out.print("(" + listOfPeople.count() + ") Contact(s) Found!\n");
                    System.out.print("---------------------\n");
                    if (listOfPeople.count() == 0)
                    {
                        System.out.println();
                    }
                    listOfPeople.printAllContacts();
                    break;
                case 3:  //call search by last name method
                    String searchName;
                    System.out.print("\nEnter last name to search by: ");
                    searchName = input.nextLine();
                    System.out.println();
                    listOfPeople.searchContactsByLastName(searchName);
                    break;
                case 4:  //call save method and exit program
                    listOfPeople.saveListToDisk();
                    System.out.print("\nContacts list saved!");
                    System.out.println();
                    System.out.print("\nGood-bye!");
            }
        }
    }

    /**
     * Method that prompts the user and reads in the required fields to create a contact.
     * Author: edm
     */
    public static Contact inputInfo ()
    {
        Scanner input = new Scanner(System.in);

        String newFirstName;
        String newLastName = "";
        String newPhoneNumber;
        String newEmail;
        String newStreetAddress;
        String newNotes;

        System.out.println();
        System.out.print("Enter first name: ");
        newFirstName = input.nextLine();

        System.out.print("Enter last name: ");
        newLastName = input.nextLine();

        if (newLastName.equals(""))
        {
            return null;
        }

        System.out.print("Enter address: ");
        newStreetAddress = input.nextLine();

        System.out.print("Enter email: ");
        newEmail = input.nextLine();

        System.out.print("Enter phone number: ");
        newPhoneNumber = input.nextLine();

        System.out.print("Enter notes: ");
        newNotes = input.nextLine();

        System.out.println();

        Contact person = new Contact(newFirstName, newLastName, newPhoneNumber, newEmail, newStreetAddress, newNotes);

        return person;
    }

    /**
     * Method that collects the input and calls the add contact method in class Contact.
     * Author: edm
     */
    private static void addPerson()
    {
        Contact person;
        person = inputInfo();

        if (person != null)
        {
            listOfPeople.addContact(person);
            System.out.println("Contact Added!");
            System.out.println("--------------");
            System.out.println(person); //implicit call to toString
        }
        else
            System.out.print("\nYou must enter a last name, contact not saved!\n\n");
    }

    /**
     * Main that calls the printMenu method.
     * Author: edm
     */
    public static void main (String[] args)
    {
        listOfPeople.retrieveListFromDisk();
        printMenu();
    }
}
/*
******* OUTPUT - 1st Run *******
------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 5

Please enter a valid option!

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: X

Please enter a valid option!

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 2

(0) Contact(s) Found!
---------------------

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 3

Enter last name to search by: Student

(0) Contact(s) Found!
---------------------

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 4

Contacts list saved!

Good-bye!
********************************

******* OUTPUT - 2nd Run *******
------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 1

Enter first name: John
Enter last name:

You must enter a last name, contact not saved!

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 1

Enter first name: John
Enter last name: Student
Enter address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Enter email: john.student@fhda.edu
Enter phone number: 650-732-0110
Enter notes: New computer science major at Foothill.

Contact Added!
--------------
Name:    John Student
Address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Email:   john.student@fhda.edu
Phone:   650-732-0110
Notes:   New computer science major at Foothill.

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 1

Enter first name: Jenny
Enter last name: Scientist
Enter address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Enter email: jenny.scientist@fhda.edu
Enter phone number: 408-422-8150
Enter notes: Second year physics major at Foothill.

Contact Added!
--------------
Name:    Jenny Scientist
Address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Email:   jenny.scientist@fhda.edu
Phone:   408-422-8150
Notes:   Second year physics major at Foothill.

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 2

(2) Contact(s) Found!
---------------------
Name:    Jenny Scientist
Address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Email:   jenny.scientist@fhda.edu
Phone:   408-422-8150
Notes:   Second year physics major at Foothill.

Name:    John Student
Address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Email:   john.student@fhda.edu
Phone:   650-732-0110
Notes:   New computer science major at Foothill.

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 3

Enter last name to search by: Schwarzenegger

(0) Contact(s) Found!
---------------------

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 3

Enter last name to search by: Student

(1) Contact(s) Found!
---------------------
Name:    John Student
Address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Email:   john.student@fhda.edu
Phone:   650-732-0110
Notes:   New computer science major at Foothill.

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 4

Contacts list saved!

Good-bye!
********************************

******* OUTPUT - 3rd Run *******
------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 2

(2) Contact(s) Found!
---------------------
Name:    Jenny Scientist
Address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Email:   jenny.scientist@fhda.edu
Phone:   408-422-8150
Notes:   Second year physics major at Foothill.

Name:    John Student
Address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Email:   john.student@fhda.edu
Phone:   650-732-0110
Notes:   New computer science major at Foothill.

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 4

Contacts list saved!

Good-bye!
********************************

******* OUTPUT - 4th Run *******
------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 1

Enter first name: Paul
Enter last name: Bunyan
Enter address:
Enter email: p.bunyan@gmail.com
Enter phone number:
Enter notes: don't know his street address or phone number

Contact Added!
--------------
Name:    Paul Bunyan
Address:
Email:   p.bunyan@gmail.com
Phone:
Notes:   don't know his street address or phone number

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 1

Enter first name:
Enter last name: Dundee
Enter address: 199 George Street, Sydney, New South Wales 2000, Australia
Enter email:
Enter phone number:
Enter notes: don't have much info on this contact

Contact Added!
--------------
Name:     Dundee
Address: 199 George Street, Sydney, New South Wales 2000, Australia
Email:
Phone:
Notes:   don't have much info on this contact

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 2

(4) Contact(s) Found!
---------------------
Name:    Paul Bunyan
Address:
Email:   p.bunyan@gmail.com
Phone:
Notes:   don't know his street address or phone number

Name:     Dundee
Address: 199 George Street, Sydney, New South Wales 2000, Australia
Email:
Phone:
Notes:   don't have much info on this contact

Name:    Jenny Scientist
Address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Email:   jenny.scientist@fhda.edu
Phone:   408-422-8150
Notes:   Second year physics major at Foothill.

Name:    John Student
Address: 12345 El Monte Rd, Los Altos Hills, CA, 94022
Email:   john.student@fhda.edu
Phone:   650-732-0110
Notes:   New computer science major at Foothill.

------------- MENU -------------
  *** Contact List Program ***

    1. Add new contact
    2. Print contact list
    3. Search by last name
    4. Save and exit
--------------------------------
Select from one of the above options: 4

Contacts list saved!

Good-bye!
********************************

 */