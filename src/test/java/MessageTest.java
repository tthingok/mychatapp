import com.mycompany.chatapppoe.Message;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    @Test
    public void testSentMessagesArrayPopulated() {
        Message.populateTestData();
        assertEquals("Did you get the cake?", Message.sentMessages.get(0));
        assertEquals("It is dinner time !", Message.sentMessages.get(1));
    }
    @Test
    public void testLongestMessage() {
        Message.populateTestData();
        assertEquals("Where are you? You are late! I have asked you to be on time.", Message.getLongestMessage());
    }
    @Test
    public void testSearchByMessageID() {
        Message.populateTestData();
        assertEquals("It is dinner time !", Message.searchByID("0838884567"));
    }
    @Test
    public void testSearchByRecipient() {
        Message.populateTestData();
        String result = Message.searchByRecipient("+27838884567");
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(result.contains("Ok, I am leaving without you."));
    }
    @Test
    public void testDeleteByHash() {
        Message.populateTestData();
        String hash = Message.storedHashes.get(0);
        String result = Message.deleteByHash(hash);
        assertTrue(result.contains("successfully deleted"));
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time"));
    }
    @Test
    public void testDisplayReport() {
        Message.populateTestData();
        String report = Message.displayReport();
        assertTrue(report.contains("Message Hash"));
        assertTrue(report.contains("Recipient"));
        assertTrue(report.contains("Message"));
    }
}