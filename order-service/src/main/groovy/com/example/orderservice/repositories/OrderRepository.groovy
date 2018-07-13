package com.example.orderservice.repositories

import com.example.orderservice.entities.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id)
}
