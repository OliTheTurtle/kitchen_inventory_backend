package de.kitchen_inventory_gras.java_backend.API.models.location;

import jakarta.validation.constraints.NotNull;

public class LocationResponseModelSimple {
    private Long id;
    @NotNull
    private String name;

    public LocationResponseModelSimple(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
