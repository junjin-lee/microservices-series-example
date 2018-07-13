package com.example.orderservice.entities

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Data
@Entity
@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
class OrderItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    Long productId
    int quantity
    BigDecimal productPrice

    BigDecimal getPrice() {
        return productPrice.multiply(new BigDecimal(quantity))
    }
}
