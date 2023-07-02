package bdd.automation.api.support.domain.builders;

import bdd.automation.api.support.domain.Loja;

public class LojaBuilder {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public LojaBuilder() {
        reset();
    }

    public LojaBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public LojaBuilder withPetId(int petId) {
        this.petId = petId;
        return this;
    }

    public LojaBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public LojaBuilder withShipDate(String shipDate) {
        this.shipDate = shipDate;
        return this;
    }

    public LojaBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public LojaBuilder withComplete(Boolean complete) {
        this.complete = complete;
        return this;
    }

    public Loja build() {
        return new Loja(
                id,
                petId,
                quantity,
                shipDate,
                status,
                complete
        );
    }

    public void reset() {
        id = 5;
        petId = 22;
        quantity = 10;
        shipDate = "2023-07-02";
        status = "approved";
        complete = true;
    }
}