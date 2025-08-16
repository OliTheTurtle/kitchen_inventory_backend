package de.gras.java_backend.API.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.gras.java_backend.API.models.ItemModel;
import de.gras.java_backend.API.models.mappers.ItemMapper;
import de.gras.java_backend.BIZ.item.ItemService;
import de.gras.java_backend.DATA.orm.Item;
import jakarta.validation.Valid;

@RestController
public class Items {
    private final ItemService itemService;

    public Items(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<ItemModel> getItems() {
        return this.itemService.getAll().stream().map(ItemMapper::toModel).toList();
    }

    @PostMapping("/items")
    public ResponseEntity<Item> postItem(@Valid @RequestBody ItemModel itemModel) {
        var domain = ItemMapper.toDomain(itemModel);
        var saved = this.itemService.create(domain);
        return new ResponseEntity<Item>(HttpStatus.CREATED);
    }
}
