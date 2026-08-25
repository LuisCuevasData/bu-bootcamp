import java.util.*;

public class ContactManager {

    public static void main(String[] args) {
        // initialize the HashMap
        HashMap<String, Contact> contacts = new HashMap<>();

        // adding contacts 
        contacts.put("Peter Parker", new Contact("Peter Parker", "+1 617 555 0101"));
        contacts.put("Walter White", new Contact("Walter White", "+1 505 555 9876"));
        contacts.put("Gregory House", new Contact("Gregory House", "+1 800 555 1234"));
        contacts.put("Jesse Pinkman", new Contact("Jesse Pinkman", "+1 505 555 1111"));
        contacts.put("Shrek", new Contact("Shrek", "+1 555 555 0000"));
        contacts.put("Jovani Vazquez", new Contact("Jovani Vazquez", "+1 787 590 0001"));
        contacts.put("Burro", new Contact("Burro", "+1 904 513 2713"));
        contacts.put("Lightning McQueen", new Contact("Lightning McQueen", "+1 305 470 3192"));
        contacts.put("Bad Bunny", new Contact("Bad Bunny", "+1 787 590 4502"));
        contacts.put("Arthur Morgan", new Contact("Arthur Morgan", "+1 716 555 9815"));

        // looking up a contact
        System.out.println("=== Lookup Test ===");
        lookupContact(contacts, "Peter Parker");
        lookupContact(contacts, "Saul Goodman"); // testing a name that does not exist


        System.out.println(); 

        // printing sorted list
        printSortedContacts(contacts);

        // optional step
        System.out.println("\n=== Testing Removal ===");
        removeContact(contacts, "Shrek");
        printSortedContacts(contacts);
    }

    // helper method 
    public static void lookupContact(HashMap<String, Contact> contacts, String name) {
        Contact c = contacts.get(name);
        if (c == null) {
            System.out.println("Contact not found: " + name);
        } else {
            System.out.println(c.toString());
        }
    }

    // helper method 
    public static void printSortedContacts(HashMap<String, Contact> contacts) {
        System.out.println("=== All Contacts ===");
        
        // create an ArrayList from the HashMap's values
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        
        // sort it alphabetically by name using the lambda expression
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        // loop through the sorted list and print each contact
        for (Contact c : sorted) {
            System.out.println(c.toString());
        }
    }

    // helper method for optional step
    public static void removeContact(HashMap<String, Contact> contacts, String name) {
        contacts.remove(name);
        System.out.println("Removed contact: " + name + "\n");
    }
}