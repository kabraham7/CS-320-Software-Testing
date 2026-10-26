package contact;

public class Contact {

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /*
     * Creates a contact after validating all required fields.
     */
    public Contact(String contactId, String firstName, String lastName,
            String phone, String address) {

        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException(
                    "Contact ID cannot be null or longer than 10 characters.");
        }

        this.contactId = contactId;

        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                    "First name cannot be null or longer than 10 characters.");
        }

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                    "Last name cannot be null or longer than 10 characters.");
        }

        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("[0-9]{10}")) {
            throw new IllegalArgumentException(
                    "Phone number must contain exactly 10 digits.");
        }

        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                    "Address cannot be null or longer than 30 characters.");
        }

        this.address = address;
    }
}
