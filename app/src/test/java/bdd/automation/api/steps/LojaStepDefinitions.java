package bdd.automation.api.steps;

import bdd.automation.api.support.api.PetApi;
import bdd.automation.api.support.api.StoreApi;
import bdd.automation.api.support.domain.Order;
import bdd.automation.api.support.domain.Pet;
import bdd.automation.api.support.domain.builders.OrderBuilder;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.is;

public class LojaStepDefinitions {

    PetApi petApi;
    Pet expectedPet;
    StoreApi storeApi;
    Order expectedOrder;


    public LojaStepDefinitions(){

        petApi = new PetApi();
        storeApi = new StoreApi();
    }

    @Dado("que eu possua um animal {word}")
    public void queEuPossuaUmAnimalAvailable(String status) {
        Pet pet = Pet.builder()
                .id(85)
                .status(status)
                .build();

        expectedPet = petApi.createPet(pet);

    }

    @Quando("faco o pedido desse animal")
    public void facoOPedidoDesseAnimal() {

        Order order = new OrderBuilder()
                .withId(120)
                .withPetId(expectedPet.getId())
                .build();
        expectedOrder = storeApi.createOrder(order);
    }

    @Entao("o pedido e aprovado")
    public void oPedidoEAprovado() {
        Response actualOrderResponse = storeApi.getOrder(expectedOrder.getId());
        actualOrderResponse.
                then().
                body(
                        "id", is(expectedOrder.getId()),
                        "petId", is(expectedPet.getId()),
                        "quantity", is(expectedOrder.getQuantity()),
                        "status", is("approved")
                        );
    }
}
