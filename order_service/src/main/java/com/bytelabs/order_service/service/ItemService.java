package com.bytelabs.order_service.service;

import com.bytelabs.order_service.entity.ItemEntity;
import com.bytelabs.order_service.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemEntity> listItems() {
        return itemRepository.findAll();
    }

    public ItemEntity addItem(ItemEntity itemEntity) {
        return itemRepository.save(itemEntity);
    }
}
