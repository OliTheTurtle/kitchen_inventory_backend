package de.gras.java_backend.API.models.mappers;

import de.gras.java_backend.API.models.ItemModel;
import de.gras.java_backend.BIZ.item.ItemDomain;

public class ItemMapper {
    public static ItemModel toModel(ItemDomain domain) {
        return new ItemModel(domain.getId(), domain.getName(), domain.getBestBeforeDate(),
                domain.getLocation() != null ? LocationMapper.toModel(domain.getLocation()) : null);
    }

    public static ItemDomain toDomain(ItemModel model) {
        return new ItemDomain(
                model.getId(),
                model.getName(),
                model.getBestBeforeDate(),
                model.getLocation() != null ? LocationMapper.toDomain(model.getLocation()) : null);
    }
}
