import java.util.*;

public class PhoneBook {

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "John", "111");
        addContact(phoneBook, "Alan", "222");
        addContact(phoneBook, "John", "333");
        addContact(phoneBook, "Nik", "4444");

        printPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, ArrayList<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public static void printPhoneBook(HashMap<String, ArrayList<String>> phoneBook) {
        HashMap<Integer, ArrayList<String>> sortedPhoneBook = new HashMap<>();

        for (String name : phoneBook.keySet()) {
            int numOfPhoneNumbers = phoneBook.get(name).size();

            if (sortedPhoneBook.containsKey(numOfPhoneNumbers)) {
                sortedPhoneBook.get(numOfPhoneNumbers).add(name);
            } else {
                ArrayList<String> names = new ArrayList<>();
                names.add(name);
                sortedPhoneBook.put(numOfPhoneNumbers, names);
            }
        }

        List<Integer> sortedKeys = new ArrayList<>(sortedPhoneBook.keySet());
        Collections.sort(sortedKeys, Collections.reverseOrder());

        for (int key : sortedKeys) {
            ArrayList<String> names = sortedPhoneBook.get(key);
            for (String name : names) {
                System.out.println(name + ": " + key + " phone number(s)");
            }
        }
    }
}
