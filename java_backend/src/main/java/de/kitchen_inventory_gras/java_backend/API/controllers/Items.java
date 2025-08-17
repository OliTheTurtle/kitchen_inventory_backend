package de.kitchen_inventory_gras.java_backend.API.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.kitchen_inventory_gras.java_backend.API.mappers.ItemMapper;
import de.kitchen_inventory_gras.java_backend.API.models.item.ItemRequestModel;
import de.kitchen_inventory_gras.java_backend.API.models.item.ItemResponseModel;
import de.kitchen_inventory_gras.java_backend.BIZ.item.ItemDomain;
import de.kitchen_inventory_gras.java_backend.BIZ.item.ItemService;
import de.kitchen_inventory_gras.java_backend.BIZ.location.LocationDomain;
import de.kitchen_inventory_gras.java_backend.BIZ.location.LocationService;
import jakarta.validation.Valid;

@RestController
public class Items {
    private final ItemService itemService;
    private final LocationService locationService;

    public Items(ItemService itemService, LocationService locationService) {
        this.itemService = itemService;
        this.locationService = locationService;
    }

    // TODO: move sorting to ORM layer
    @GetMapping("/items")
    public ResponseEntity<List<ItemResponseModel>> getItems(
            @RequestParam(value = "orderBy", required = false, defaultValue = "bestBeforeDate") String orderBy,
            @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction) {
        var items = this.itemService.getAll();
        java.util.Comparator<ItemDomain> comparator;
        if (orderBy == null || orderBy.equals("bestBeforeDate")) {
            comparator = (a, b) -> {
                if (a.getBestBeforeDate() == null && b.getBestBeforeDate() == null)
                    return 0;
                if (a.getBestBeforeDate() == null)
                    return 1;
                if (b.getBestBeforeDate() == null)
                    return -1;
                return a.getBestBeforeDate().compareTo(b.getBestBeforeDate());
            };
        } else if (orderBy.equals("name")) {
            comparator = java.util.Comparator.comparing(ItemDomain::getName,
                    java.util.Comparator.nullsLast(String::compareTo));
        } else {
            comparator = (a, b) -> 0; // no sorting if unknown
        }
        if (direction.equalsIgnoreCase("desc")) {
            comparator = comparator.reversed();
        }
        return new ResponseEntity<List<ItemResponseModel>>(items.stream()
                .sorted(comparator)
                .map(ItemMapper::toModel)
                .toList(), HttpStatus.OK);
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<ItemResponseModel> getItems(@PathVariable Long itemId) {
        ItemDomain itemDomain = this.itemService.getById(itemId);
        if (itemDomain == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ItemResponseModel>(ItemMapper.toModel(itemDomain), HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<Long> postItem(@Valid @RequestBody ItemRequestModel itemModel) {
        Optional<LocationDomain> locationDomain = Optional.empty();
        Long locationId = itemModel.getLocationId();
        if (locationId != null) {
            locationDomain = Optional.ofNullable(locationService.getById(itemModel.getLocationId()));
            if (!locationDomain.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }

        ItemDomain domain = ItemMapper.toDomain(itemModel, locationDomain);

        ItemDomain saved = this.itemService.create(domain);
        return new ResponseEntity<Long>(saved.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<Long> putItem(@Valid @RequestBody ItemRequestModel itemModel,
            @PathVariable Long itemId) {
        Optional<LocationDomain> locationDomain = Optional.empty();
        Long locationId = itemModel.getLocationId();
        if (locationId != null) {
            locationDomain = Optional.ofNullable(locationService.getById(itemModel.getLocationId()));
            if (!locationDomain.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }
        ItemDomain domain = this.itemService.getById(itemId);

        // update
        ItemDomain updateDomain = ItemMapper.toDomain(itemModel, locationDomain);
        domain.setName(updateDomain.getName());
        domain.setBestBeforeDate(updateDomain.getBestBeforeDate());
        domain.setLocation(updateDomain.getLocation());
        this.itemService.save(domain);
        return new ResponseEntity<Long>(domain.getId(), HttpStatus.OK);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Long> deleteItem(@PathVariable Long itemId) {
        ItemDomain domain = this.itemService.getById(itemId);
        this.itemService.delete(domain);
        return new ResponseEntity<Long>(domain.getId(), HttpStatus.OK);
    }
}
