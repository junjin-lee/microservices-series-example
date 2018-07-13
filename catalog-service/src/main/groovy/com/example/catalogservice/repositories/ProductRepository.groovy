package com.example.catalogservice.repositories

import com.example.catalogservice.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String code);
}