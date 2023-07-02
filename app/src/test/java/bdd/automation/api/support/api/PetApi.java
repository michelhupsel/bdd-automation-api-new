package bdd.automation.api.support.api;

import bdd.automation.api.support.domain.Pet;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {
    private static final String FIND_PETS_BY_STATUS = "/v3/pet/findByStatus?status={status}";
    private static final String PETS_BY_ID = "/v3/pet/{id}";

    public List<Pet> getPetsByStatus(String status) {
        return given().
                pathParam("status", status).
            when().
                get(FIND_PETS_BY_STATUS).
            then().
                extract().body().jsonPath().getList("", Pet.class);
    }

    public Response getPetsResponseByStatus(String status) {
        return given().
                pathParam("status", status).
                when().
                get(FIND_PETS_BY_STATUS);
    }


    public void deletePetsByStatus(String status) {
        List<Integer> petsId = given().
                pathParam("status", status).
            when().
                get(FIND_PETS_BY_STATUS).
            thenReturn().
                path("id");

        if (!petsId.isEmpty()) {
            for (Integer id : petsId) {
                given().pathParam("id", id).delete(PETS_BY_ID);
            }
        }

    }

}
