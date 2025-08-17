package de.kitchen_inventory_gras.java_backend.DATA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.kitchen_inventory_gras.java_backend.DATA.orm.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
