package de.gras.java_backend.API.mappers;

import de.gras.java_backend.API.models.location.LocationRequestModel;
import de.gras.java_backend.API.models.location.LocationResponseModel;
import de.gras.java_backend.BIZ.location.LocationDomain;

public class LocationMapper {
    public static LocationResponseModel toModel(LocationDomain domain) {
        return new LocationResponseModel(domain.getId(), domain.getName());
    }

    public static LocationDomain toDomain(LocationRequestModel model) {
        return new LocationDomain(
                null,
                model.getName());
    }
}
