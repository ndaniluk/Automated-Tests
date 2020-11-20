import encryption.CeasarCypher;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class CeasarCypherTest {

    @Test
    void encryptWithCorrectInterval() {
        String interval = "21";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        CeasarCypher ceasarCypher = new CeasarCypher();
        String encryptedInput = ceasarCypher.encrypt("Norbert");
        assertEquals("Ijmwzmo", encryptedInput);
    }

    @Test
    void encryptWithIncorrectIntervalAndThrowException() {
        String interval = "ObviouslyIncorrectInteger";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        CeasarCypher ceasarCypher = new CeasarCypher();
        assertThrows(InputMismatchException.class, () -> ceasarCypher.encrypt("Norbert"));
    }

    @Test
    void encryptWithNotSupportedCharactersInInput(){
        String interval = "3";
        InputStream in = new ByteArrayInputStream(interval.getBytes());
        System.setIn(in);

        CeasarCypher ceasarCypher = new CeasarCypher();
        String encryptedInput = ceasarCypher.encrypt("1337");
        assertNull(encryptedInput);
    }
}
