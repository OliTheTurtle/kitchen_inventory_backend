package de.gras.java_backend.API.models.mappers;

import de.gras.java_backend.API.models.LocationModel;
import de.gras.java_backend.BIZ.location.LocationDomain;

public class LocationMapper {
    public static LocationModel toModel(LocationDomain domain) {
        return new LocationModel(domain.getId(), domain.getName());
    }

    public static LocationDomain toDomain(LocationModel model) {
        return new LocationDomain(
                model.getId(),
                model.getName());
    }
}
