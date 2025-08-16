package de.gras.java_backend.BIZ.item;

import java.util.Optional;

import de.gras.java_backend.BIZ.location.LocationDomain;
import de.gras.java_backend.BIZ.location.LocationMapper;
import de.gras.java_backend.DATA.orm.Item;
import de.gras.java_backend.DATA.orm.Location;

public class ItemMapper {
    public static ItemDomain toDomain(Item entity) {
        Optional<LocationDomain> locationDomain = entity.getLocation() != null
                ? Optional.ofNullable(LocationMapper.toDomain(entity.getLocation()))
                : Optional.empty();

        ItemDomain itemDomain = new ItemDomain(
                entity.getId(),
                entity.getName(),
                entity.getBestBeforeDate(),
                locationDomain);
        itemDomain.setEntity(entity);
        return itemDomain;
    }

    public static Item toEntity(ItemDomain domain) {
        Item entity = new Item();
        entity.setName(domain.getName());
        entity.setBestBeforeDate(domain.getBestBeforeDate());
        if (domain.getLocation().isPresent()) {
            LocationDomain locationDomain = domain.getLocation().get();
            entity.setLocation((Location) locationDomain.getEntity());
        }
        return entity;
    }
}
