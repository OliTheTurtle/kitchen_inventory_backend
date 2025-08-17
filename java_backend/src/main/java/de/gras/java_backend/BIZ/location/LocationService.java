package de.gras.java_backend.BIZ.location;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.gras.java_backend.DATA.orm.Location;
import de.gras.java_backend.DATA.repositories.LocationRepository;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDomain> getAll() {
        return this.locationRepository.findAll().stream().map(LocationMapper::toDomain).toList();
    }

    public LocationDomain getById(Long id) {
        Optional<Location> location = this.locationRepository.findById(id);
        if (!location.isPresent()) {
            return null;
        }
        return location.map(LocationMapper::toDomain).get();
    }

    public LocationDomain create(LocationDomain domain) {
        var entity = LocationMapper.toEntity(domain);
        var saved = this.locationRepository.save(entity);
        return this.getById(saved.getId());
    }

    // ab damit in ne Basis-Klasse
    public void save(LocationDomain locationDomain) {
        this.locationRepository.save((Location) locationDomain.getEntity());
    }

    public void delete(LocationDomain locationDomain) {
        this.locationRepository.delete((Location) locationDomain.getEntity());
    }
}
