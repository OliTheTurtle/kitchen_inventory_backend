package de.kitchen_inventory_gras.java_backend.API.models.location;

import jakarta.validation.constraints.NotNull;

public class LocationRequestModel {
    @NotNull
    private String name;

    public LocationRequestModel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
