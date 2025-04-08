import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstRestAssuredTest {
    @Test
    public void testRestAssured() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "John");
        Response response = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/hello")
                .andReturn();
        var sk = response.getStatusCode();
        var body = response.getBody().asString();
        var message = response.jsonPath().getString("answer");
        System.out.println("Status code: " + sk);
        System.out.println("Response body: " + body);
        System.out.println("Message: " + message);

        JsonPath jsonResponse = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();

        String answer = jsonResponse.get("answer");
        System.out.println("Answer: " + answer);
    }
}
