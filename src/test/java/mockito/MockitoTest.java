package mockito;

import encryption.CeasarCypher;
import encryption.Decryptor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    @Mock
    CeasarCypher ceasarCypher;
    @Mock
    Decryptor decryptor;

    @Test
    public void mockEncryptionResultTest() {
        when(ceasarCypher.encrypt("Norbert")).thenReturn("NotEncryptedNorbert");
        String interval = "21";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        String encryptedInput = ceasarCypher.encrypt("Norbert");
        assertEquals("NotEncryptedNorbert", encryptedInput);
    }

    @Test
    public void mockEncryptionWithDecryptionResultTest() {
        when(ceasarCypher.encryptWithDecryptor("Norbert", "anyString", "anyString")).thenReturn("NotEncryptedNorbert");
        String interval = "2";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        String encryptedInput = ceasarCypher.encryptWithDecryptor("Norbert", "anyString", "anyString");
        assertEquals("NotEncryptedNorbert", encryptedInput);
    }

    @Test
    public void mockInputMismatchEvenIfIntervalIsCorrect() {
        doThrow(new InputMismatchException()).when(ceasarCypher).encryptWithDecryptor("Norbert", "anyString", "anyString");
        String interval = "2";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () -> ceasarCypher.encryptWithDecryptor("Norbert", "anyString", "anyString"));
    }

    @Test
    public void mockGetQuestionTest() {
        doReturn("This is mocked question").when(decryptor).getQuestion();
        assertEquals("This is mocked question", decryptor.getQuestion());
    }

    @Test
    public void mockGetEncryptedTest() {
        doReturn("This is mocked encrypted text").when(decryptor).getEncryptedText();
        assertEquals("This is mocked encrypted text", decryptor.getEncryptedText());
    }

    @Test
    public void mockAnswerTheQuestionTest() {
        doReturn("This is mocked decrypted text").when(decryptor).answerTheQuestion("answer");
        assertEquals("This is mocked decrypted text", decryptor.answerTheQuestion("answer"));
    }
}
