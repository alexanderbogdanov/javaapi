package api.qa.learn.assignments;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class LongRedirectTest {
    @Test
    public void testPrintFinalAddressAfterAllRedirects() {
        String url = "https://playground.learnqa.ru/api/long_redirect";
        String currentUrl = url;
        int redirectCount = 0;

        while (true) {
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .get(currentUrl);

            int statusCode = response.getStatusCode();
            String locationHeader = response.getHeader("Location");

            System.out.println("Request to: " + currentUrl);
            System.out.println("Status Code: " + statusCode);
            if (locationHeader != null) {
                System.out.println("Redirects to: " + locationHeader);
                System.out.println("__________________________________________");
            }

            if (statusCode >= 300 && statusCode < 400 && locationHeader != null) {
                currentUrl = locationHeader;
                redirectCount++;
            } else {
                break;
            }
        }

        System.out.println("Final URL after " + redirectCount + " redirects: " + currentUrl);
    }
}

