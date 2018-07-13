package com.example.inventoryservice.repositories

import com.example.inventoryservice.entities.InventoryItem
import org.springframework.data.jpa.repository.JpaRepository


interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    Optional<InventoryItem> findByProductCode(String productCode)
}
