package de.gras.java_backend.BIZ.item;

import java.sql.Date;

import de.gras.java_backend.BIZ.location.LocationDomain;

public class ItemDomain {
    private Long id;
    private String name;
    private Date bestBeforeDate;
    private LocationDomain location;

    public ItemDomain(Long id, String name, Date bestBeforeDate, LocationDomain location) {
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

    public LocationDomain getLocation() {
        return this.location;
    }

}
