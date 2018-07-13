package com.example.inventoryservice.web.controllers

import com.example.inventoryservice.entities.InventoryItem
import com.example.inventoryservice.repositories.InventoryItemRepository
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Slf4j
@RequestMapping("/api/inventory")
class InventoryController {

    @Autowired
    final InventoryItemRepository inventoryItemRepository

    @GetMapping("")
    List<InventoryItem> getInventories() {
        return inventoryItemRepository.findAll()
    }

    @GetMapping("{productCode}")
    ResponseEntity<InventoryItem> findInventoryByProductCode(@PathVariable String productCode) {

        // test hystrix for timeout
        // Thread.sleep(5000)

        Optional<InventoryItem> inventoryItem = inventoryItemRepository.findByProductCode(productCode)
        if (inventoryItem.isPresent()) {
            return new ResponseEntity(inventoryItem.get(), HttpStatus.OK)
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
