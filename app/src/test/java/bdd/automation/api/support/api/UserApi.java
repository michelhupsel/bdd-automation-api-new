package bdd.automation.api.support.api;

import bdd.automation.api.support.domain.User;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class UserApi {
    private static final String CREATE_USER_ENDPOINT = "/v3/user";
    private static final String USER_ENDPOINT = "/v3/user/{name}";

    public void crateUser(User user) {
        given().
                body(user).
                when().
                post(CREATE_USER_ENDPOINT).
                then().
                statusCode(HttpStatus.SC_OK);
    }

    public String getUsername(User user) {
        return given().
            pathParams("name", user.getUsername()).
        when().
            get(USER_ENDPOINT).
        thenReturn().
            path("username");

    }
}
