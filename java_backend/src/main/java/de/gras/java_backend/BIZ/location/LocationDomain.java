package de.gras.java_backend.BIZ.location;

import de.gras.java_backend.BIZ.BaseDomain;

public class LocationDomain extends BaseDomain {
    private Long id;
    private String name;

    public LocationDomain(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
