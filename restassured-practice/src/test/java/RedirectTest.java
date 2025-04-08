import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RedirectTest {
    @Test
    public void testStatusCode() {
        String url = "https://playground.learnqa.ru/api/get_303";

        Response response = RestAssured
                .given()
                .redirects()
                .follow(true)
                .when()
                .get(url)
                .then()
                .log().all()
                .extract()
                .response();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
    }
}

