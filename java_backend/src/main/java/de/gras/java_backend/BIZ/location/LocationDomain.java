package de.gras.java_backend.BIZ.location;

import de.gras.java_backend.BIZ.base.BaseDomain;
import de.gras.java_backend.BIZ.base.ObservableProperty;

public class LocationDomain extends BaseDomain {
    private Long id;

    private ObservableProperty<String> name;

    public LocationDomain(Long id, String name) {
        this.id = id;

        // Initialize ObservableProperties with sync logic
        this.name = new ObservableProperty<>(name, v -> {
            if (getEntity() instanceof de.gras.java_backend.DATA.orm.Location entity) {
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
}
