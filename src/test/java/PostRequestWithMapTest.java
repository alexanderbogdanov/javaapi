import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PostRequestWithMapTest {
    @Test
    public void testPostRequestWithMap() {
        String url = "https://playground.learnqa.ru/api/check_type";
        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put("param1", "value1");
        jsonBody.put("param2", "value2");

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .post(url)
                .andReturn();

        response.print();
    }
}
