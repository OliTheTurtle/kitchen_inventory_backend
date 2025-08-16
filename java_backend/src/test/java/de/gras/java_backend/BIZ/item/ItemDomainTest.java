package de.gras.java_backend.BIZ.item;

import de.gras.java_backend.BIZ.location.LocationDomain;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDomainTest {
    @Test
    void constructor_and_getters_work() {
        Long id = 10L;
        String name = "Apple";
        Date bestBefore = Date.valueOf("2025-12-31");
        Optional<LocationDomain> location = Optional.empty();
        ItemDomain domain = new ItemDomain(id, name, bestBefore, location);
        assertThat(domain.getId()).isEqualTo(id);
        assertThat(domain.getName()).isEqualTo(name);
        assertThat(domain.getBestBeforeDate()).isEqualTo(bestBefore);
        assertThat(domain.getLocation()).isEmpty();
    }

    @Test
    void setters_work() {
        ItemDomain domain = new ItemDomain(1L, "Bread", null, Optional.empty());
        domain.setName("Milk");
        assertThat(domain.getName()).isEqualTo("Milk");
        Date date = Date.valueOf("2026-01-01");
        domain.setBestBeforeDate(date);
        assertThat(domain.getBestBeforeDate()).isEqualTo(date);
        LocationDomain loc = new LocationDomain(2L, "Fridge");
        domain.setLocation(Optional.of(loc));
        assertThat(domain.getLocation()).isPresent();
        assertThat(domain.getLocation().get().getName()).isEqualTo("Fridge");
    }
}
