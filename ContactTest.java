package contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ContactTest {

    /*
     * Tests the creation of a valid contact.
     */
    @Test
    void testCreateContact() {
        Contact contact = new Contact(
                "1001",
                "Kadeem",
                "Abraham",
                "4415551234",
                "1 Front Street");

        assertEquals("1001", contact.getContactId());
        assertEquals("Kadeem", contact.getFirstName());
        assertEquals("Abraham", contact.getLastName());
        assertEquals("4415551234", contact.getPhone());
        assertEquals("1 Front Street", contact.getAddress());
    }

    /*
     * Tests a contact ID containing exactly 10 characters.
     */
    @Test
    void testContactIdAtMaximumLength() {
        Contact contact = new Contact(
                "1234567890",
                "Kadeem",
                "Abraham",
                "4415551234",
                "1 Front Street");

        assertEquals("1234567890", contact.getContactId());
    }

    /*
     * Tests that an ID longer than 10 characters is rejected.
     */
    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "Kadeem",
                    "Abraham",
                    "4415551234",
                    "1 Front Street");
        });
    }

    /*
     * Tests that a null contact ID is rejected.
     */
    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "Kadeem",
                    "Abraham",
                    "4415551234",
                    "1 Front Street");
        });
    }

    /*
     * Tests a first name containing exactly 10 characters.
     */
    @Test
    void testFirstNameAtMaximumLength() {
        Contact contact = new Contact(
                "1001",
                "ABCDEFGHIJ",
                "Abraham",
                "4415551234",
                "1 Front Street");

        assertEquals("ABCDEFGHIJ", contact.getFirstName());
    }

    /*
     * Tests that a first name longer than 10 characters is rejected.
     */
    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "ABCDEFGHIJK",
                    "Abraham",
                    "4415551234",
                    "1 Front Street");
        });
    }

    /*
     * Tests that a null first name is rejected.
     */
    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    null,
                    "Abraham",
                    "4415551234",
                    "1 Front Street");
        });
    }

    /*
     * Tests a last name containing exactly 10 characters.
     */
    @Test
    void testLastNameAtMaximumLength() {
        Contact contact = new Contact(
                "1001",
                "Kadeem",
                "ABCDEFGHIJ",
                "4415551234",
                "1 Front Street");

        assertEquals("ABCDEFGHIJ", contact.getLastName());
    }

    /*
     * Tests that a last name longer than 10 characters is rejected.
     */
    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Kadeem",
                    "ABCDEFGHIJK",
                    "4415551234",
                    "1 Front Street");
        });
    }

    /*
     * Tests that a null last name is rejected.
     */
    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Kadeem",
                    null,
                    "4415551234",
                    "1 Front Street");
        });
    }

    /*
     * Tests a valid phone number containing exactly 10 digits.
     */
    @Test
    void testValidPhone() {
        Contact contact = new Contact(
                "1001",
                "Kadeem",
                "Abraham",
                "0123456789",
                "1 Front Street");

        assertEquals("0123456789", contact.getPhone());
    }

    /*
     * Tests that a phone number shorter than 10 digits is rejected.
     */
    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Kadeem",
                    "Abraham",
                    "123456789",
                    "1 Front Street");
        });
    }

    /*
     * Tests that a phone number longer than 10 digits is rejected.
     */
    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Kadeem",
                    "Abraham",
                    "12345678901",
                    "1 Front Street");
        });
    }

    /*
     * Tests that a phone number containing letters is rejected.
     */
    @Test
    void testPhoneWithLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Kadeem",
                    "Abraham",
                    "441ABC1234",
                    "1 Front Street");
        });
    }

    /*
     * Tests that a null phone number is rejected.
     */
    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Kadeem",
                    "Abraham",
                    null,
                    "1 Front Street");
        });
    }

    /*
     * Tests an address containing exactly 30 characters.
     */
    @Test
    void testAddressAtMaximumLength() {
        String address = "123456789012345678901234567890";

        Contact contact = new Contact(
                "1001",
                "Kadeem",
                "Abraham",
                "4415551234",
                address);

        assertEquals(address, contact.getAddress());
    }

    /*
     * Tests that an address longer than 30 characters is rejected.
     */
    @Test
    void testAddressTooLong() {
        String address = "1234567890123456789012345678901";

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Kadeem",
                    "Abraham",
                    "4415551234",
                    address);
        });
    }

    /*
     * Tests that a null address is rejected.
     */
    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Kadeem",
                    "Abraham",
                    "4415551234",
                    null);
        });
    }

    /*
     * Tests the valid setter methods.
     */
    @Test
    void testUpdateContactFields() {
        Contact contact = createValidContact();

        contact.setFirstName("John");
        contact.setLastName("Smith");
        contact.setPhone("4415559999");
        contact.setAddress("2 Reid Street");

        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("4415559999", contact.getPhone());
        assertEquals("2 Reid Street", contact.getAddress());

        // The contact ID should remain unchanged.
        assertEquals("1001", contact.getContactId());
    }

    /*
     * Tests that setters reject invalid values.
     */
    @Test
    void testSettersRejectInvalidValues() {
        Contact contact = createValidContact();

        assertThrows(
                IllegalArgumentException.class,
                () -> contact.setFirstName(null));

        assertThrows(
                IllegalArgumentException.class,
                () -> contact.setLastName("ABCDEFGHIJK"));

        assertThrows(
                IllegalArgumentException.class,
                () -> contact.setPhone("12345"));

        assertThrows(
                IllegalArgumentException.class,
                () -> contact.setAddress(
                        "1234567890123456789012345678901"));
    }

    /*
     * Creates a valid contact that can be reused by the tests.
     */
    private Contact createValidContact() {
        return new Contact(
                "1001",
                "Kadeem",
                "Abraham",
                "4415551234",
                "1 Front Street");
    }
}