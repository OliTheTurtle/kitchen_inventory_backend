package de.kitchen_inventory_gras.java_backend.DATA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.kitchen_inventory_gras.java_backend.DATA.orm.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByLocationId(Long locationId);
}
