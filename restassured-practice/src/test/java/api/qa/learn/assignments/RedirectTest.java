package api.qa.learn.assignments;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RedirectTest {
    @Test
    public void testPrintRedirectAddress() {
        String url = "https://playground.learnqa.ru/api/long_redirect";

        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .get(url);

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        String locationHeader = response.getHeader("Location");
        if (locationHeader != null) {
            System.out.println("Redirect to: " + locationHeader);
        } else {
            System.out.println("No Location header found");
        }

        assertTrue(
                statusCode >= 300 && statusCode < 400,
                "Expected a redirect (3xx) status code, got: " + statusCode
        );
    }
}

