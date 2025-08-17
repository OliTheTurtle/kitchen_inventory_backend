package de.kitchen_inventory_gras.java_backend.API.mappers;

import java.util.List;

import de.kitchen_inventory_gras.java_backend.API.models.item.ItemResponseModel;
import de.kitchen_inventory_gras.java_backend.API.models.location.LocationRequestModel;
import de.kitchen_inventory_gras.java_backend.API.models.location.LocationResponseModel;
import de.kitchen_inventory_gras.java_backend.API.models.location.LocationResponseModelSimple;
import de.kitchen_inventory_gras.java_backend.BIZ.item.ItemDomain;
import de.kitchen_inventory_gras.java_backend.BIZ.location.LocationDomain;

public class LocationMapper {
    public static LocationResponseModel toModel(LocationDomain domain) {
        List<ItemDomain> items = domain.getItems();
        List<ItemResponseModel> itemModels = items.stream().map(ItemMapper::toModel).toList();
        return new LocationResponseModel(domain.getId(), domain.getName(), itemModels);
    }

    public static LocationResponseModelSimple toModelSimple(LocationDomain domain) {
        return new LocationResponseModelSimple(domain.getId(), domain.getName());
    }

    public static LocationDomain toDomain(LocationRequestModel model) {
        return new LocationDomain(
                null,
                model.getName(),
                List.of());
    }
}
