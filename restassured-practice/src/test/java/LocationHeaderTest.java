import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class LocationHeaderTest {
    @Test
    public void testRedirectHeader() {
        String url = "https://playground.learnqa.ru/api/get_303";

        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .get(url)
                .then()
                .log().all()
                .extract()
                .response();

        String locationHeader = response.getHeader("Location");
        System.out.println("Location header: \n" + locationHeader
        );
    }
}
