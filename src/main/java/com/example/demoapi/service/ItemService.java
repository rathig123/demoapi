package com.example.demoapi.service;

import com.example.demoapi.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service

public class ItemService {

	private List<Item> items = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    public Item addItem(Item item) {
        item.setId(idCounter.incrementAndGet());
        items.add(item);
        return item;
    }

    public Item getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Item> getAllItems() {
        return items;
    }
    
    public Item updateItem(Long id, Item updatedItem) {
        Item existingItem = getItemById(id);
        if (existingItem == null) {
            return null;
        }

        existingItem.setName(updatedItem.getName());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setPrice(updatedItem.getPrice());

        return existingItem;
    }

    public boolean deleteItem(Long id) {
        return items.removeIf(item -> item.getId().equals(id));
    }
}
