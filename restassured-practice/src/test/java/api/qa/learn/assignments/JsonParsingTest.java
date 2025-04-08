package api.qa.learn.assignments;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class JsonParsingTest {
    @Test
    public void testPrintSecondMessage() {
        String url = "https://playground.learnqa.ru/api/get_json_homework";

        JsonPath jsonResponse = RestAssured
                .given()
                .get(url)
                .jsonPath();

        List<Map<String, String>> messages = jsonResponse.getList("messages");

        if (messages != null && messages.size() > 1) {
            System.out.println(messages.get(1).get("message"));
        }
    }
}
