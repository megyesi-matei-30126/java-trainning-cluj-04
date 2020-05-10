import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Exception.*;

public class PhoneBookRegister implements Serializable {
    private Map<Person, PhoneNumber> phoneBook;

    public PhoneBookRegister() {
        this.phoneBook = new HashMap<>();
    }

    public void addNewPerson() throws InvalidNumberException, PersonAlreadyExistsException, InvalidNameException, NumberLengthException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        String personName = scanner.nextLine();
        for (int i = 0; i < personName.length(); i++) {
            if (Character.isDigit(personName.charAt(i))) {
                throw new InvalidNameException("Name can't contains digit!");
            }
        }

        if (this.phoneBook.containsKey(new Person(personName))) {
            throw new PersonAlreadyExistsException("Person " + personName + " alredy exists in book!");
        }

        System.out.println("Phone number: ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.length() != 10) {
            throw new NumberLengthException("Number should have 10 digits!");
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (Character.isLetter(phoneNumber.charAt(i))) {
                throw new InvalidNumberException("Number can't have character!");
            }
        }

        this.phoneBook.put(new Person(personName), new PhoneNumber(phoneNumber));
    }

    public void searchPerson(Person personSearch) throws PersonNotFoundException {
        if (this.phoneBook.containsKey(personSearch)) {
            PhoneNumber number = this.phoneBook.get(personSearch);
            System.out.println(personSearch.getName() + " number phone: " + number.getPhoneNumber());
        } else {
            throw new PersonNotFoundException("Person not found!");
        }
    }

    @Override
    public String toString() {
        return "PhoneBookRegister{" +
                "phoneBook=" + phoneBook +
                '}';
    }
}
