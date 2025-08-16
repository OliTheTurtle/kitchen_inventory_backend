package de.gras.java_backend.BIZ.item;

import java.sql.Date;
import java.util.Optional;

import de.gras.java_backend.BIZ.BaseDomain;
import de.gras.java_backend.BIZ.location.LocationDomain;

public class ItemDomain extends BaseDomain {
    private Long id;
    private String name;
    private Date bestBeforeDate;
    private Optional<LocationDomain> location;

    public ItemDomain(Long id, String name, Date bestBeforeDate, Optional<LocationDomain> location) {
        this.id = id;
        this.name = name;
        this.bestBeforeDate = bestBeforeDate;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBestBeforeDate() {
        return bestBeforeDate;
    }

    public void setBestBeforeDate(Date bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }

    public Optional<LocationDomain> getLocation() {
        return this.location;
    }

    public void setLocation(Optional<LocationDomain> location) {
        this.location = location;
    }

}
