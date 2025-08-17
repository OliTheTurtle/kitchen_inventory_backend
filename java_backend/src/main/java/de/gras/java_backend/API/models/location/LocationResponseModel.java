package de.gras.java_backend.API.models.location;

import java.util.List;

import de.gras.java_backend.API.models.item.ItemResponseModel;
import jakarta.validation.constraints.NotNull;

public class LocationResponseModel {
    private Long id;
    @NotNull
    private String name;
    private List<ItemResponseModel> items;

    public LocationResponseModel(Long id, String name, List<ItemResponseModel> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<ItemResponseModel> getItems() {
        return this.items;
    }
}
