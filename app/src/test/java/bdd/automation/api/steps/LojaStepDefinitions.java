package bdd.automation.api.steps;

import bdd.automation.api.support.domain.Loja;
import bdd.automation.api.support.domain.builders.LojaBuilder;
import io.cucumber.java.pt.Dado;

public class LojaStepDefinitions {
    @Dado("alguma coisa")
    public void algumaCoisa() {
        Loja loja1 = new LojaBuilder()
                .withId(1)
                .withPetId(23)
                .withQuantity(4)
                .build();

        Loja loja2 = new LojaBuilder().build();


        System.out.println("teste");
    }
}
