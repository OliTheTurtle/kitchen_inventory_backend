package de.kitchen_inventory_gras.java_backend.API.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.kitchen_inventory_gras.java_backend.API.mappers.LocationMapper;

import de.kitchen_inventory_gras.java_backend.API.models.location.LocationRequestModel;
import de.kitchen_inventory_gras.java_backend.API.models.location.LocationResponseModel;
import de.kitchen_inventory_gras.java_backend.BIZ.location.LocationDomain;
import de.kitchen_inventory_gras.java_backend.BIZ.location.LocationService;
import jakarta.validation.Valid;

@RestController
public class Locations {
    private final LocationService locationService;

    public Locations(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public List<LocationResponseModel> getLocations() {
        return this.locationService.getAll().stream().map(LocationMapper::toModel).toList();
    }

    @PostMapping("/locations")
    public ResponseEntity<Long> postLocation(@Valid @RequestBody LocationRequestModel locationModel) {
        LocationDomain domain = LocationMapper.toDomain(locationModel);

        LocationDomain saved = this.locationService.create(domain);
        return new ResponseEntity<Long>(saved.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/locations/{locationId}")
    public ResponseEntity<Long> putItem(@Valid @RequestBody LocationRequestModel locationModel,
            @PathVariable Long locationId) {
        LocationDomain domain = this.locationService.getById(locationId);

        // update
        LocationDomain updateDomain = LocationMapper.toDomain(locationModel);
        domain.setName(updateDomain.getName());
        this.locationService.save(domain);
        return new ResponseEntity<Long>(domain.getId(), HttpStatus.OK);
    }

    @DeleteMapping("/locations/{locationId}")
    public ResponseEntity<Long> deleteItem(@PathVariable Long locationId) {
        LocationDomain domain = this.locationService.getById(locationId);
        this.locationService.delete(domain);
        return new ResponseEntity<Long>(domain.getId(), HttpStatus.OK);
    }
}
