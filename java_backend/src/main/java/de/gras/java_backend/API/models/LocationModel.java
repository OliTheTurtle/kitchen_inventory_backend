package de.gras.java_backend.API.models;

import jakarta.validation.constraints.NotNull;

public class LocationModel {
    private Long id;
    @NotNull
    private String name;

    public LocationModel(Long id, String name) {
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
