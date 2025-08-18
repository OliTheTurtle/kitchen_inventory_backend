package de.kitchen_inventory_gras.java_backend.BIZ.location;

import java.util.List;

import de.kitchen_inventory_gras.java_backend.BIZ.base.BaseDomain;
import de.kitchen_inventory_gras.java_backend.BIZ.base.EntityProperty;
import de.kitchen_inventory_gras.java_backend.BIZ.item.ItemDomain;
import de.kitchen_inventory_gras.java_backend.BIZ.item.ItemMapper;
import de.kitchen_inventory_gras.java_backend.DATA.orm.Item;

public class LocationDomain extends BaseDomain {
    private Long id;
    private List<Item> items;

    private EntityProperty<String> name;

    public LocationDomain(Long id, String name, List<Item> items) {
        this.id = id;
        this.items = items;

        // Initialize ObservableProperties with sync logic
        this.name = new EntityProperty<>(name, v -> {
            if (getEntity() instanceof de.kitchen_inventory_gras.java_backend.DATA.orm.Location entity) {
                entity.setName(v);
            }
        });
    }

    public Long getId() {
        return id;
    }

    // Expose get/set for name through ObservableProperty
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public List<ItemDomain> getItems() {
        List<ItemDomain> itemDomains = this.items.stream().map(ItemMapper::toDomain).toList();
        return itemDomains;
    }
}
