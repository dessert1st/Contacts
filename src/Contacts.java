import java.util.Scanner;

/**
 * Class "Contacts" controls the creation of a contact list.
 * Code written by Edward Miszkiewicz
 * Rev 2.0 (Task 4)
 * Date: 06/23/2017
 */
public class Contacts {

    private static ContactList listOfPeople  = new ContactList();

    /**
     * Method that prompts the user and reads in the required fields to create a single contact.
     * Written by edm.
     */
    private static Scanner input = new Scanner(System.in);
    public static void printMenu () {
        int inputOption = 0;
        //String inputOption = "";

        while (inputOption != 4){
            System.out.println("------------- MENU -------------");
            System.out.println("  *** Contact List Program ***");
            System.out.println();
            System.out.println("    1. Add new contact");
            System.out.println("    2. Print contact list");
            System.out.println("    3. Search by last name");
            System.out.println("    4. Save and exit");
            System.out.println("--------------------------------\n");
            System.out.print("Select from one of the above options: ");
            //System.out.println();
            inputOption = Integer.parseInt(input.nextLine());
            while (inputOption <=0 || inputOption >4){

                System.out.print("\nPlease enter valid input option: ");
                //inputOption = input.nextLine();
                inputOption = Integer.parseInt(input.nextLine());
            }

            switch (inputOption) {

                case 1:      //call add contact method
                    addPerson();
                    break;
                case 2:      //call print contact list method
                    System.out.println();
                    System.out.println("List of Contacts");
                    System.out.println("----------------");
                    System.out.print(listOfPeople);
                    break;
                case 3:      //call search by last name method
                    String searchName;
                    System.out.print("\nEnter last name to search by: ");
                    searchName = input.nextLine();
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
     * Method that prompts the user and reads in the required fields to create a single contact.
     * Written by edm.
     */
    public static Contact inputInfo () {

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
     * Method that collects the input and calls the add contact method in class Contact.
     * Written by edm.
     */
    private static void addPerson()
    {
        Contact person;
        person = inputInfo();

        if (person != null) {
            listOfPeople.addContact(person);
            System.out.println("Contact added");
            System.out.println("-------------");
            System.out.println(person); //implicit call to toString
        }
        else
            System.out.print("\nContact not added!\n\n");
    }

    /**
     * Main that calls the printMenu method.
     * Written by edm.
     */
    public static void main (String[] args) {

        listOfPeople.retrieveListFromDisk();
        printMenu();
        //System.out.println("List of Contacts");
        //System.out.println("----------------");
        //System.out.print(listOfPeople);
    }
}