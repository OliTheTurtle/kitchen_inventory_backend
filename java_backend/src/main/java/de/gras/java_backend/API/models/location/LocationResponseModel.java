package de.gras.java_backend.API.models.location;

import jakarta.validation.constraints.NotNull;

public class LocationResponseModel {
    private Long id;
    @NotNull
    private String name;

    public LocationResponseModel(Long id, String name) {
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
