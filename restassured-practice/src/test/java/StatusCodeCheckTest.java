import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class StatusCodeCheckTest {
    @Test
    public void testStatusCode() {
        String url = "https://playground.learnqa.ru/api/get_500";
        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put("param1", "value1");
        jsonBody.put("param2", "value2");

        Response response = RestAssured
                .given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .post(url)
                .then()
                .log().all()
                .extract()
                .response();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
    }
}
