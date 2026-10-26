package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts;

    /*
     * Creates an empty in-memory contact service.
     */
    public ContactService() {
        contacts = new HashMap<String, Contact>();
    }

    /*
     * Adds a contact if its ID is unique.
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException(
                    "Contact cannot be null.");
        }

        String contactId = contact.getContactId();

        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "A contact with this ID already exists.");
        }

        contacts.put(contactId, contact);
    }

    /*
     * Deletes a contact using its ID.
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "Contact ID was not found.");
        }

        contacts.remove(contactId);
    }

    /*
     * Updates a contact's first name using its ID.
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    /*
     * Updates a contact's last name using its ID.
     */
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    /*
     * Updates a contact's phone number using its ID.
     */
    public void updatePhone(String contactId, String phone) {
        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    /*
     * Updates a contact's address using its ID.
     */
    public void updateAddress(String contactId, String address) {
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    /*
     * Finds and returns a contact using its ID.
     */
    public Contact getContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "Contact ID was not found.");
        }

        return contacts.get(contactId);
    }

    /*
     * Returns the number of contacts currently stored.
     */
    public int getContactCount() {
        return contacts.size();
    }
}