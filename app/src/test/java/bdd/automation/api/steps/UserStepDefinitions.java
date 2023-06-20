package bdd.automation.api.steps;

import bdd.automation.api.support.api.UserApi;
import bdd.automation.api.support.domain.User;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserStepDefinitions {

    private static final String CREATE_USER_ENDPOINT = "/v3/user";
    private static final String USER_ENDPOINT = "/v3/user/{name}";

    private UserApi userApi;
    private User expectedUser;

    public UserStepDefinitions() {
        userApi = new UserApi();
    }

    @Quando("crio um usuario")
    public void crioUmUsuario() {
        expectedUser = User.builder().build();
        userApi.crateUser(expectedUser);
    }

    @Entao("o usuario e salvo no sistema")
    public void oUsuarioESalvoNoSistema() {
        String actualUsername = userApi.getUsername(expectedUser);

        assertThat(actualUsername, is(expectedUser.getUsername()));
    }


}
