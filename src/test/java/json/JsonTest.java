package json;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    @Test
    void isLengthCorrect() {
        JSONObject json = new JSONObject();
        json.append("name", "Morbert");
        assertEquals(1, json.length());
    }
}
