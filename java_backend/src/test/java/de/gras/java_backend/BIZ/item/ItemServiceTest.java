package de.gras.java_backend.BIZ.item;

import de.gras.java_backend.DATA.repositories.ItemRepository;
import de.gras.java_backend.DATA.orm.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.Optional;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ItemServiceTest {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll_returnsMappedDomains() {
        Item item = new Item();
        item.setName("Test");
        when(itemRepository.findAll()).thenReturn(List.of(item));
        List<ItemDomain> result = itemService.getAll();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Test");
    }

    @Test
    void getById_returnsMappedDomain() {
        Item item = new Item();
        item.setName("Test2");
        when(itemRepository.findById(2L)).thenReturn(Optional.of(item));
        ItemDomain result = itemService.getById(2L);
        assertThat(result.getName()).isEqualTo("Test2");
    }
}
