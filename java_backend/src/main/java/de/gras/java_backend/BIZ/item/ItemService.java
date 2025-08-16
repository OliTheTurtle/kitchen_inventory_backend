package de.gras.java_backend.BIZ.item;

import java.util.List;

import org.springframework.stereotype.Service;

import de.gras.java_backend.DATA.orm.Item;
import de.gras.java_backend.DATA.repositories.ItemRepository;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDomain> getAll() {
        return this.itemRepository.findAll().stream().map(ItemMapper::toDomain).toList();
    }

    public ItemDomain getById(Long id) {
        return this.itemRepository.findById(id).map(ItemMapper::toDomain).get();
    }

    public ItemDomain create(ItemDomain domain) {
        var entity = ItemMapper.toEntity(domain);

        var saved = this.itemRepository.save(entity);

        return this.getById(saved.getId());
    }

    public void save(ItemDomain itemDomain) {
        this.itemRepository.save((Item) itemDomain.getEntity());
    }

    public void delete(ItemDomain itemDomain) {
        this.itemRepository.delete((Item) itemDomain.getEntity());
    }
}
