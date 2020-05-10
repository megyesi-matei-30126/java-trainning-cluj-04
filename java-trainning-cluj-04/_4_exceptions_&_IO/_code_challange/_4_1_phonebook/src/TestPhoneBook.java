import Exception.*;

import java.util.Scanner;

public class TestPhoneBook {
    public static void main(String[] args) {
        PhoneBookRegister phoneBook = new PhoneBookRegister();
        String persoName = "";
        String phoneNumber = "";
        Scanner scanner = new Scanner(System.in);
        boolean addPerson = true;
        boolean searchPerson = true;

        while (addPerson) {

                try {
                    phoneBook.addNewPerson();
                } catch (InvalidNumberException e) {
                    System.out.println("Number can't have character!");
                } catch (PersonAlreadyExistsException e) {
                    System.out.println("Person " + persoName + " alredy exists in book!");
                } catch (InvalidNameException e) {
                    System.out.println("Name can't contains digit!");
                } catch (NumberLengthException e) {
                    System.out.println("Number should have 10 digits!");
                }
            System.out.println("Add antoher person ?, y or n");
            String result = scanner.nextLine();
            if (!result.equals("y")) {
                addPerson = false;
            }
        }

        System.out.println(phoneBook.toString());

        while (searchPerson) {
            System.out.println("Person name?");
            persoName = scanner.nextLine();
            try {
                phoneBook.searchPerson(new Person(persoName));
            } catch (PersonNotFoundException e) {
                System.out.println("Person not found!");
            }
            System.out.println("Search another person? y or n");
            String result = scanner.nextLine();
            if (!result.equals("y")) {
                searchPerson = false;
            }
        }
    }
}
