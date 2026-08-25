public class Contact {
    // Two private String fields
    private String name;
    private String phone;

    // Constructor that takes both fields
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // Override toString to return formatted string
    @Override
    public String toString() {
        return name + " | " + phone;
    }
}