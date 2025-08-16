package de.gras.java_backend.BIZ.item;

import java.sql.Date;
import java.util.Optional;

import de.gras.java_backend.BIZ.base.BaseDomain;
import de.gras.java_backend.BIZ.base.ObservableProperty;
import de.gras.java_backend.BIZ.location.LocationDomain;
import de.gras.java_backend.DATA.orm.Location;

public class ItemDomain extends BaseDomain {
    private Long id;

    private ObservableProperty<String> name;
    private ObservableProperty<Date> bestBeforeDate;
    private ObservableProperty<Optional<LocationDomain>> location;

    public ItemDomain(Long id, String name, Date bestBeforeDate, Optional<LocationDomain> location) {
        this.id = id;

        // Initialize ObservableProperties with sync logic
        this.name = new ObservableProperty<>(name, v -> {
            if (getEntity() instanceof de.gras.java_backend.DATA.orm.Item entity) {
                entity.setName(v);
            }
        });

        this.bestBeforeDate = new ObservableProperty<>(bestBeforeDate, v -> {
            if (getEntity() instanceof de.gras.java_backend.DATA.orm.Item entity) {
                entity.setBestBeforeDate(v);
            }
        });

        this.location = new ObservableProperty<>(location, v -> {
            if (getEntity() instanceof de.gras.java_backend.DATA.orm.Item entity) {
                entity.setLocation((Location) v.map(loc -> loc.getEntity()).orElse(null));
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

    public Date getBestBeforeDate() {
        return bestBeforeDate.get();
    }

    public void setBestBeforeDate(Date bestBeforeDate) {
        this.bestBeforeDate.set(bestBeforeDate);
    }

    public Optional<LocationDomain> getLocation() {
        return location.get();
    }

    public void setLocation(Optional<LocationDomain> location) {
        this.location.set(location);
    }

}
