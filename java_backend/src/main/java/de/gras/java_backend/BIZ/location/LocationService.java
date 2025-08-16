package de.gras.java_backend.BIZ.location;

import java.util.List;

import org.springframework.stereotype.Service;

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
        return this.locationRepository.findById(id).map(LocationMapper::toDomain).get();
    }

    public LocationDomain create(LocationDomain domain) {
        var entity = LocationMapper.toEntity(domain);
        var saved = this.locationRepository.save(entity);
        return this.getById(saved.getId());
    }
}
