package collections;

import java.util.HashMap;

public class PhoneBook {

    HashMap<String, String> contacts = new HashMap<>();

    public void addContact(String name, String phone) {
        contacts.put(name, phone);
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }

    public void findContact(String name) {

        if (contacts.containsKey(name)) {
            System.out.println(name + ": " + contacts.get(name));
        }
    }

    public void printContacts() {

        for (String name : contacts.keySet()) {
            System.out.println(name + " → " + contacts.get(name));
        }
    }
}