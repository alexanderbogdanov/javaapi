import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HeadersTest {
    @Test
    public void testStatusCode() {
        Map<String, String> headers = new HashMap<>();
        headers.put("testHeader1", "testValue1");
        headers.put("testHeader2", "testValue2");
        String url = "https://playground.learnqa.ru/api/show_all_headers";

        Response response = RestAssured
                .given()
                .headers(headers)
                .get(url)
                .then()
                .log().all()
                .extract()
                .response();

        Headers responseHeaders = response.getHeaders();
        System.out.println("Headers: \n" + responseHeaders
        );
    }
}
