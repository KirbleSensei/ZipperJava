package week10.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Node_jUnitTest {

    @Test
    void testNodeConstructorWithGsm() {
        long gsm = 1234567890;
        Node node = new Node(gsm);
        assertEquals(gsm, node.GSM);
        assertNull(node.nameSurname);
        assertNull(node.email);
        assertNull(node.next);
        assertNull(node.previous);
    }

    @Test
    void testNodeConstructorWithAllParams() {
        long gsm = 1234567890;
        String name = "John Doe";
        String email = "john.doe@example.com";
        Node node = new Node(gsm, name, email);
        assertEquals(gsm, node.GSM);
        assertEquals(name, node.nameSurname);
        assertEquals(email, node.email);
        assertNull(node.next);
        assertNull(node.previous);
    }

    @Test
    void testDisplayNode() {
        long gsm = 1234567890;
        String name = "John Doe";
        String email = "john.doe@example.com";
        Node node = new Node(gsm, name, email);
        String expectedOutput = name + " " + gsm + " " + email + "\n";
        assertDoesNotThrow(() -> {
            // Redirect stdout to capture printed output
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
            node.displayNode();
            // Reset stdout
            System.setOut(System.out);
            assertEquals(expectedOutput, outputStream.toString());
        });
    }
}
