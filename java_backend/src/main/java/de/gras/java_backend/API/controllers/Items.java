package de.gras.java_backend.API.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.gras.java_backend.API.mappers.ItemMapper;
import de.gras.java_backend.API.models.item.ItemRequestModel;
import de.gras.java_backend.API.models.item.ItemResponseModel;
import de.gras.java_backend.BIZ.item.ItemService;
import de.gras.java_backend.BIZ.location.LocationDomain;
import de.gras.java_backend.BIZ.location.LocationService;
import jakarta.validation.Valid;

@RestController
public class Items {
    private final ItemService itemService;
    private final LocationService locationService;

    public Items(ItemService itemService, LocationService locationService) {
        this.itemService = itemService;
        this.locationService = locationService;
    }

    @GetMapping("/items")
    public List<ItemResponseModel> getItems() {
        return this.itemService.getAll().stream().map(ItemMapper::toModel).toList();
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

        var domain = ItemMapper.toDomain(itemModel, locationDomain);

        var saved = this.itemService.create(domain);
        return new ResponseEntity<Long>(saved.getId(), HttpStatus.CREATED);
    }
}
