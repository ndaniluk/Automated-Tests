package encryption;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class DecryptorTest {

    @Test
    void decryptWithCorrectValues() {
        String interval = "21";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        CeasarCypher ceasarCypher = new CeasarCypher();
        String input = "Norbert";
        String answer = "Brutus";
        ceasarCypher.encryptWithDecryptor(input, "Who killed Ceasar?", answer);
        Decryptor decryptor = ceasarCypher.getEnteredMessages().get(0);
        assertEquals(input, decryptor.answerTheQuestion(answer));
    }

    @Test
    void decryptWithIncorrectValues(){
        String interval = "21";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        CeasarCypher ceasarCypher = new CeasarCypher();
        String input = "Norbert";
        String answer = "Brutus";
        ceasarCypher.encryptWithDecryptor(input, "Who killed Ceasar?", answer);
        Decryptor decryptor = ceasarCypher.getEnteredMessages().get(0);
        assertNull(decryptor.answerTheQuestion("answer"));
    }

    @Test
    void isQuestionCorrectlyAssigned(){
        String interval = "21";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        CeasarCypher ceasarCypher = new CeasarCypher();
        String question = "Who killed Ceasar?";
        ceasarCypher.encryptWithDecryptor("Norbert", question, "Brutus");
        Decryptor decryptor = ceasarCypher.getEnteredMessages().get(0);
        assertEquals(question, decryptor.getQuestion());
    }

    @Test
    void isEncryptedTextCorrectlyAssigned() {
        String interval = "21";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        CeasarCypher ceasarCypher = new CeasarCypher();
        String encryptedInput = ceasarCypher.encryptWithDecryptor("Norbert", "Who killed Ceasar?", "Brutus");
        Decryptor decryptor = ceasarCypher.getEnteredMessages().get(0);
        assertEquals(encryptedInput, decryptor.getEncryptedText());
    }

    @Test
     void isQuestionNullWhenUsingEncryptOnly() {
         String interval = "21";
         InputStream in = new ByteArrayInputStream(interval.getBytes());
         System.setIn(in);

         CeasarCypher ceasarCypher = new CeasarCypher();
         ceasarCypher.encrypt("Norbert");
         Decryptor decryptor = ceasarCypher.getEnteredMessages().get(0);
         assertNull(decryptor.getQuestion());
     }

    @Test
    void isEncryptedMessageValidWhenUsingEncryptOnly() {
        String interval = "21";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        CeasarCypher ceasarCypher = new CeasarCypher();
        String encryptedInput = ceasarCypher.encrypt("Norbert");
        Decryptor decryptor = ceasarCypher.getEnteredMessages().get(0);
        assertEquals(encryptedInput, decryptor.getEncryptedText());
    }

    @Test
    void isDecryptedTextNullIfQuestionNotSpecified() {
        String interval = "21";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);
        String answer = "answer";
        CeasarCypher ceasarCypher = new CeasarCypher();
        ceasarCypher.encryptWithDecryptor("Norbert", null, answer);
        Decryptor decryptor = ceasarCypher.getEnteredMessages().get(0);
        assertNull(decryptor.answerTheQuestion(answer));
    }
}