package bdd.automation.api.steps;

import bdd.automation.api.support.api.PetApi;
import bdd.automation.api.support.domain.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.messages.internal.com.google.common.base.CharMatcher;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

public class PetStepDefinitions {

    private PetApi petApi;
    private List<Pet> actualPets;

    public PetStepDefinitions(){
        petApi = new PetApi();
    }


    @Dado("que eu possua animais {word}")
    public void queEuPossuaAnimaisAvailable(String status) {
//        Pet pet = Pet.builder().build();
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(pet);
//        System.out.println(json);
    }

    @Quando("eu pesquiso por todos os animais {word}")
    public void euPesquisoPorTodosOsAnimaisAvailable(String status) {
        actualPets = petApi.getPetsByStatus(status);
    }

    @Entao("eu recebo a lista de animais available")
    public void euReceboAListaDeAnimaisAvailable() {
        assertThat(actualPets, is(not(empty())));
    }

    @E("eu recebo uma outra lista de animais {word}")
    public void euReceboUmaOutraListaDeAnimaisAvailable(String status) {
        Response actualPetsResponse = petApi.getPetsResponseByStatus(status);

        actualPets = actualPetsResponse.body().jsonPath().getList("",Pet.class);

        actualPetsResponse.
            then().
                statusCode(HttpStatus.SC_OK).
            body(
                    "size()", is(actualPets.size()),
                    "findAll { it.status == 'available' }.size()", is(actualPets.size())
            );
    }

    @Entao("recebo a lista com {int} animal/animais")
    public void receboAListaComAnimais(int petsQuantity) {
        assertThat(actualPets, is(petsQuantity));
    }

    @Dado("que eu nao possua animais {word}")
    public void queEuNaoPossuaAnimaisSold(String status) {
        petApi.deletePetsByStatus(status);
    }
}
