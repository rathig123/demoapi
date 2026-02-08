package com.example.demoapi.controller;

import com.example.demoapi.model.Item;
import com.example.demoapi.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	
	private final ItemService itemService;

  	public ItemController(ItemService itemService) {
	        this.itemService = itemService;
	    }

    // Add new item
    @PostMapping
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
        return ResponseEntity.ok(itemService.addItem(item));
    }

    // Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        if (item == null) {
            return ResponseEntity.status(404).body("Item not found");
        }
        return ResponseEntity.ok(item);
    }

    // Get all items (extra)
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }
    
    // Update item
    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @Valid @RequestBody Item item) {
        Item updated = itemService.updateItem(id, item);
        if (updated == null) {
            return ResponseEntity.status(404).body("Item not found");
        }
        return ResponseEntity.ok(updated);
    }

    // Delete item
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        boolean deleted = itemService.deleteItem(id);
        if (!deleted) {
            return ResponseEntity.status(404).body("Item not found");
        }
        return ResponseEntity.ok("Item deleted successfully");
    }
	

}
