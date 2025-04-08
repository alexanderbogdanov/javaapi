import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CookieTest {
    @Test
    public void testAuthCookie() {
        String url = "https://playground.learnqa.ru/api/get_auth_cookie";
        String login = "secret_login";
        String password = "secret_pass";
        Map<String, String> data = new HashMap<>();
        data.put("login", login);
        data.put("password", password);
        Response response = RestAssured
                .given()
                .body(data)
                .post(url)
                .andReturn();
        String authCookie = response.getCookie("auth_cookie");
        System.out.println("Auth cookie: " + authCookie
        );

        String url2 = "https://playground.learnqa.ru/api/check_auth_cookie";
        Response response2 = RestAssured
                .given()
                .cookie("auth_cookie", authCookie)
                .get(url2)
                .andReturn();
        String result = response2.asString();
        System.out.println("Result: " + result);

    }
}
