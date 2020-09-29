import hashMap.Contact;
import hashMap.PhoneContacts;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PhoneContacts myContacts = new PhoneContacts();
        fillGroups(myContacts);
        fillContacts(myContacts);
        usersFillContacts(myContacts);

        System.out.println(myContacts);
        System.out.println("Hello World");
        System.out.println("Hello World");
        // xaxaxaxaxaxaxaxax
    }

    public static void fillGroups(PhoneContacts contacts) {
        contacts.addGroup("Семья");
        contacts.addGroup("Друзья");
        contacts.addGroup("Работа");
        contacts.addGroup("Учеба");
        contacts.addGroup("VIP");

        String groupName = null;
        while(true) {
            System.out.println("Пожалуйста, введите имя группы или end");
            groupName = scanner.nextLine();
            if (groupName.equals("end")) break;
            contacts.addGroup(groupName);
        }

    }

    public static void usersFillContacts(PhoneContacts contacts) {

        String groupNames = null;
        String contactName = null;
        String contactPhone = null;

        while(true) {
            System.out.println("Пожалуйста, введите имя контакта или end");
            contactName = scanner.nextLine();
            if (contactName.equals("end")) break;

            System.out.println("Пожалуйста, введите телефон контакта");
            contactPhone = scanner.nextLine();

            Contact targetContact = new Contact(contactName, contactPhone);

            System.out.println("Пожалуйста, введите имена групп для контакта через пробел");
            groupNames = scanner.nextLine();
            String[] groups = groupNames.split(" ");

            for(String group : groups) {
                contacts.addContactToGroup(
                        targetContact,
                        group
                );
            }
        }
    }

    public static void fillContacts(PhoneContacts contacts) {
        contacts.addContactToGroup(
                new Contact("Мама", "+7 999 999 99 99"),
                "Семья"
        );
        contacts.addContactToGroup(
                new Contact("Папа", "+7 888 999 99 99"),
                "Семья"
        );

        Contact brother = new Contact("Брат", "+7 777 999 99 99");
        contacts.addContactToGroup(
                brother,
                "Семья"
        );
        contacts.addContactToGroup(
                brother,
                "Друзья"
        );
        contacts.addContactToGroup(
                new Contact("Василий", "+7 666 999 99 99"),
                "Друзья"
        );
        contacts.addContactToGroup(
                new Contact("Учитель", "+7 555 999 99 99"),
                "Учеба"
        );
    }
}