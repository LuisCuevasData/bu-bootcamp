import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void getName_returnsCorrectName() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void getPhone_returnsCorrectPhone() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void toString_containsName() {
        assertTrue(contact.toString().contains("Ada Lovelace"));
    }

    @Test
    void toString_containsPhone() {
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }

    @Test
    void beforeEach_createsFreshContactEachTest() {
        Contact other = new Contact("Alan Turing", "555-0001");
        assertNotEquals(contact.getName(), other.getName());
        assertNotEquals(contact.getPhone(), other.getPhone());
    }

@Test
void twoContactsWithSameName_areIndependentObjects() {
    Contact contact2 = new Contact("Ada Lovelace", "+1 999 999 9999");

    // Same name, but each object holds its own separate phone number
    assertEquals(contact.getName(), contact2.getName());
    assertNotEquals(contact.getPhone(), contact2.getPhone());

    // Confirm the original 'contact' from setUp() is untouched
    assertEquals("+1 617 555 0101", contact.getPhone());
    assertEquals("+1 999 999 9999", contact2.getPhone());
}

}