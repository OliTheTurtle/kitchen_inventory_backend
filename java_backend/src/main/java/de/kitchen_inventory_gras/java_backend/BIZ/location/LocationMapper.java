package de.kitchen_inventory_gras.java_backend.BIZ.location;

import de.kitchen_inventory_gras.java_backend.DATA.orm.Location;

public class LocationMapper {
    public static LocationDomain toDomain(Location entity) {
        LocationDomain locationDomain = new LocationDomain(entity.getId(), entity.getName(), entity.getItems());
        locationDomain.setEntity(entity);
        return locationDomain;
    }

    public static Location toEntity(LocationDomain domain) {
        Location entity = new Location();
        entity.setName(domain.getName());
        return entity;
    }
}
