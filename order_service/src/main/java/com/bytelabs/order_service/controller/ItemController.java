package com.bytelabs.order_service.controller;

import com.bytelabs.order_service.entity.ItemEntity;
import com.bytelabs.order_service.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<ItemEntity>> findAll() {
        List<ItemEntity> items = itemService.listItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<ItemEntity> addItem(@RequestBody ItemEntity itemEntity) {
        ItemEntity item = itemService.addItem(itemEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
