package de.gras.java_backend.API.mappers;

import java.util.Optional;

import de.gras.java_backend.API.models.item.ItemRequestModel;
import de.gras.java_backend.API.models.item.ItemResponseModel;
import de.gras.java_backend.API.models.location.LocationResponseModel;
import de.gras.java_backend.BIZ.item.ItemDomain;
import de.gras.java_backend.BIZ.location.LocationDomain;

public class ItemMapper {
    public static ItemResponseModel toModel(ItemDomain domain) {
        Optional<LocationResponseModel> locationModel = domain.getLocation().isPresent()
                ? Optional.ofNullable(LocationMapper.toModel(domain.getLocation().get()))
                : Optional.empty();

        return new ItemResponseModel(
                domain.getId(),
                domain.getName(),
                domain.getBestBeforeDate(),
                locationModel);
    }

    public static ItemDomain toDomain(ItemRequestModel model, Optional<LocationDomain> locationDomain) {
        return new ItemDomain(
                null,
                model.getName(),
                model.getBestBeforeDate(),
                locationDomain);
    }
}
