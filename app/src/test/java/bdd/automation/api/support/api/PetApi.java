package bdd.automation.api.support.api;

import bdd.automation.api.support.domain.Pet;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {
    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus?status={status}";
    private static final String FIND_PET_BY_ID_ENDPOINT = "/v3/pet/{id}";
    private static final String CREATE_PETS_ENDPOINT = "/v3/pet";

    public List<Pet> getPetsByStatus(String status) {
        return given().
                pathParam("status", status).
            when().
                get(FIND_PETS_BY_STATUS_ENDPOINT).
            then().
                extract().body().jsonPath().getList("", Pet.class);
    }

    public Response getPetsResponseByStatus(String status) {
        return given().
                pathParam("status", status).
                when().
                get(FIND_PETS_BY_STATUS_ENDPOINT);
    }


    public void deletePetsByStatus(String status) {
        List<Integer> petsId = given().
                pathParam("status", status).
            when().
                get(FIND_PETS_BY_STATUS_ENDPOINT).
            thenReturn().
                path("id");

        if (!petsId.isEmpty()) {
            for (Integer id : petsId) {
                given().pathParam("id", id).delete(FIND_PET_BY_ID_ENDPOINT);
            }
        }

    }

    public Pet createPet(Pet pet){
        return given().
                body(pet).
            when().
                post(CREATE_PETS_ENDPOINT).
            then().
                statusCode(HttpStatus.SC_OK).
                extract().body().as(Pet.class);
    }

    public void deleteExtraPets(String status){
        List<Integer> petsId = given().
                pathParam("status",status).
            when().
                get(FIND_PETS_BY_STATUS_ENDPOINT).
            thenReturn().
                path("id");

        List<Integer> petsToKeep = Arrays.asList(1,2,3,7,8,9,10);

        for (int petId : petsId){
            if(!petsToKeep.contains(petId)){
                given().
                    pathParam("id", petId).
                    delete(FIND_PET_BY_ID_ENDPOINT).
                then().
                    statusCode(HttpStatus.SC_OK);

            }
        }
    }

}
