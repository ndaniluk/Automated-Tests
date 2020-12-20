package json;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import com.auth0.jwt.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

//CLaim set used in this JWT
//{
//    "iss": "Norbert Daniluk",
//    "iat": 1608470341,
//    "exp": 1640006341,
//    "aud": "daniluk.dev",
//    "sub": "norbert@daniluk.dev",
//    "GivenName": "Norbert",
//    "Surname": "Daniluk",
//    "Email": "norbert@daniluk.dev",
//    "Role": "Dev"
//}

public class JwtTest {
    JWT jwt;
    DecodedJWT decodedJwt;

    public JwtTest() {
        this.jwt = new JWT();
        this.decodedJwt = jwt.decodeJwt(
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJOb3JiZXJ0IERhbmlsdWsiL" +
                        "CJpYXQiOjE2MDg0NzAzNDEsImV4cCI6MTY0MDAwNjM0MSwiYXVkIjoiZGFuaWx1ay5kZXYiLCJzdWIiOiJ" +
                        "ub3JiZXJ0QGRhbmlsdWsuZGV2IiwiR2l2ZW5OYW1lIjoiTm9yYmVydCIsIlN1cm5hbWUiOiJEYW5pbHVrI" +
                        "iwiRW1haWwiOiJub3JiZXJ0QGRhbmlsdWsuZGV2IiwiUm9sZSI6IkRldiJ9.t_53IU7sC6DQHkRGGAWARz8" +
                        "W0EEXzOnB0eFoLb286io"
        );
    }

    @Test
    void isDecodedNameCorrect() {
        Claim givenName = decodedJwt.getClaim("GivenName");
        assertEquals("Norbert", givenName.asString());
    }

    @Test
    void isDecodedAlgorithmCorrect() {
        assertEquals("HS256", decodedJwt.getAlgorithm());
    }

    @Test
    void isDecodedIssueDateCorrect() {
        Date date = decodedJwt.getIssuedAt();
        assertEquals("Sun Dec 20 14:19:01 CET 2020", date.toString());
    }
}
