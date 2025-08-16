package de.gras.java_backend.BIZ.item;

import de.gras.java_backend.BIZ.location.LocationMapper;
import de.gras.java_backend.DATA.orm.Item;

public class ItemMapper {
    public static ItemDomain toDomain(Item entity) {
        return new ItemDomain(
                entity.getId(),
                entity.getName(),
                entity.getBestBeforeDate(),
                entity.getLocation() != null ? LocationMapper.toDomain(entity.getLocation()) : null);
    }

    public static Item toEntity(ItemDomain domain) {
        Item entity = new Item();
        entity.setName(domain.getName());
        entity.setBestBeforeDate(domain.getBestBeforeDate());
        entity.setLocation(LocationMapper.toEntity(domain.getLocation()));
        return entity;
    }
}
