package de.kitchen_inventory_gras.java_backend.BIZ.base;

import de.kitchen_inventory_gras.java_backend.DATA.orm.BaseEntity;

public class BaseDomain {
    private BaseEntity entity;

    public void setEntity(BaseEntity entity) {
        this.entity = entity;
    }

    public BaseEntity getEntity() {
        return this.entity;
    }
}
