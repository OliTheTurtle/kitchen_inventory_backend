package de.kitchen_inventory_gras.java_backend.API.mappers;

import java.util.Optional;

import de.kitchen_inventory_gras.java_backend.API.models.item.ItemRequestModel;
import de.kitchen_inventory_gras.java_backend.API.models.item.ItemResponseModel;
import de.kitchen_inventory_gras.java_backend.API.models.item.ItemResponseModelSimple;
import de.kitchen_inventory_gras.java_backend.API.models.location.LocationResponseModelSimple;
import de.kitchen_inventory_gras.java_backend.BIZ.item.ItemDomain;
import de.kitchen_inventory_gras.java_backend.BIZ.location.LocationDomain;

public class ItemMapper {
    public static ItemResponseModel toModel(ItemDomain domain) {
        Optional<LocationResponseModelSimple> locationModel = domain.getLocation().isPresent()
                ? Optional.ofNullable(LocationMapper.toModelSimple(domain.getLocation().get()))
                : Optional.empty();

        return new ItemResponseModel(
                domain.getId(),
                domain.getName(),
                domain.getBestBeforeDate(),
                locationModel);
    }

    public static ItemResponseModelSimple toModelSimple(ItemDomain domain) {
        return new ItemResponseModelSimple(
                domain.getId(),
                domain.getName(),
                domain.getBestBeforeDate());
    }

    public static ItemDomain toDomain(ItemRequestModel model, Optional<LocationDomain> locationDomain) {
        return new ItemDomain(
                null,
                model.getName(),
                model.getBestBeforeDate(),
                locationDomain);
    }
}
