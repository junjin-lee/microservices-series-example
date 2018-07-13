package com.example.inventoryservice.entities

import lombok.Data

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Data
@Entity
@Table(name = "inventory")
class InventoryItem {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(name = "product_code", nullable = false, unique = true)
    String productCode

    @Column(name = "quantity")
    Integer availableQuantity = 0
}
