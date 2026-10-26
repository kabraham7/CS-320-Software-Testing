package contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService contactService;
    private Contact contact;

    /*
     * Creates fresh objects before every test.
     */
    @BeforeEach
    void setUp() {
        contactService = new ContactService();

        contact = new Contact(
                "1001",
                "Kadeem",
                "Abraham",
                "4415551234",
                "1 Front Street");
    }

    /*
     * Tests adding a contact.
     */
    @Test
    void testAddContact() {
        contactService.addContact(contact);

        assertEquals(1, contactService.getContactCount());
        assertEquals(contact, contactService.getContact("1001"));
    }

    /*
     * Tests adding more than one contact.
     */
    @Test
    void testAddMultipleContacts() {
        Contact secondContact = new Contact(
                "1002",
                "John",
                "Smith",
                "4415555678",
                "2 Reid Street");

        contactService.addContact(contact);
        contactService.addContact(secondContact);

        assertEquals(2, contactService.getContactCount());
        assertEquals(contact, contactService.getContact("1001"));
        assertEquals(secondContact, contactService.getContact("1002"));
    }

    /*
     * Tests that duplicate contact IDs are rejected.
     */
    @Test
    void testAddDuplicateContactId() {
        Contact duplicateContact = new Contact(
                "1001",
                "John",
                "Smith",
                "4415555678",
                "2 Reid Street");

        contactService.addContact(contact);

        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.addContact(duplicateContact));

        assertEquals(1, contactService.getContactCount());
    }

    /*
     * Tests that a null contact cannot be added.
     */
    @Test
    void testAddNullContact() {
        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.addContact(null));
    }

    /*
     * Tests deleting a contact by its ID.
     */
    @Test
    void testDeleteContact() {
        contactService.addContact(contact);
        contactService.deleteContact("1001");

        assertEquals(0, contactService.getContactCount());

        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.getContact("1001"));
    }

    /*
     * Tests deleting an ID that does not exist.
     */
    @Test
    void testDeleteMissingContact() {
        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.deleteContact("9999"));
    }

    /*
     * Tests updating a contact's first name.
     */
    @Test
    void testUpdateFirstName() {
        contactService.addContact(contact);
        contactService.updateFirstName("1001", "John");

        assertEquals(
                "John",
                contactService.getContact("1001").getFirstName());
    }

    /*
     * Tests updating a contact's last name.
     */
    @Test
    void testUpdateLastName() {
        contactService.addContact(contact);
        contactService.updateLastName("1001", "Smith");

        assertEquals(
                "Smith",
                contactService.getContact("1001").getLastName());
    }

    /*
     * Tests updating a contact's phone number.
     */
    @Test
    void testUpdatePhone() {
        contactService.addContact(contact);
        contactService.updatePhone("1001", "4415559999");

        assertEquals(
                "4415559999",
                contactService.getContact("1001").getPhone());
    }

    /*
     * Tests updating a contact's address.
     */
    @Test
    void testUpdateAddress() {
        contactService.addContact(contact);
        contactService.updateAddress("1001", "2 Reid Street");

        assertEquals(
                "2 Reid Street",
                contactService.getContact("1001").getAddress());
    }

    /*
     * Confirms that updates do not change the contact ID.
     */
    @Test
    void testContactIdDoesNotChangeAfterUpdates() {
        contactService.addContact(contact);

        contactService.updateFirstName("1001", "John");
        contactService.updateLastName("1001", "Smith");
        contactService.updatePhone("1001", "4415559999");
        contactService.updateAddress("1001", "2 Reid Street");

        assertEquals(
                "1001",
                contactService.getContact("1001").getContactId());
    }

    /*
     * Tests updating an ID that does not exist.
     */
    @Test
    void testUpdateMissingContact() {
        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.updateFirstName(
                        "9999", "John"));
    }

    /*
     * Tests that an invalid first-name update is rejected.
     */
    @Test
    void testUpdateInvalidFirstName() {
        contactService.addContact(contact);

        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.updateFirstName(
                        "1001", "ABCDEFGHIJK"));
    }

    /*
     * Tests that an invalid last-name update is rejected.
     */
    @Test
    void testUpdateInvalidLastName() {
        contactService.addContact(contact);

        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.updateLastName(
                        "1001", null));
    }

    /*
     * Tests that an invalid phone update is rejected.
     */
    @Test
    void testUpdateInvalidPhone() {
        contactService.addContact(contact);

        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.updatePhone(
                        "1001", "12345"));
    }

    /*
     * Tests that an invalid address update is rejected.
     */
    @Test
    void testUpdateInvalidAddress() {
        contactService.addContact(contact);

        String address =
                "1234567890123456789012345678901";

        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.updateAddress(
                        "1001", address));
    }
}