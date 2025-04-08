import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class PostRequestTest {
    @Test
    public void testPostRequest() {
        String url = "https://playground.learnqa.ru/api/check_type";
        String jsonBody = "{ \"param1\": \"value1\", \"param2\": \"value2\" }";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .post(url)
                .andReturn();

        response.print();
    }
}
