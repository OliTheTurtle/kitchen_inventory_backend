package de.gras.java_backend.API.models.item;

import java.sql.Date;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFormat;

import de.gras.java_backend.API.models.location.LocationResponseModel;
import jakarta.validation.constraints.NotNull;

public class ItemResponseModel {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date bestBeforeDate;

    @NotNull
    private Optional<LocationResponseModel> location;

    public ItemResponseModel(Long id, String name, Date bestBeforeDate, Optional<LocationResponseModel> location) {
        this.id = id;
        this.name = name;
        this.bestBeforeDate = bestBeforeDate;
        this.location = location;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBestBeforeDate() {
        return this.bestBeforeDate;
    }

    public void setBestBeforeDate(Date bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }

    public Optional<LocationResponseModel> getLocation() {
        return this.location;
    }

    public void setLocation(Optional<LocationResponseModel> location) {
        this.location = location;
    }

}
