package com.example.catalogservice.entities

import lombok.Data

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Transient

@Data
@Entity
@Table(name="products")
class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(nullable = false, unique = true)
    String code

    @Column(nullable = false)
    String name

    String description
    double price

    @Transient
    boolean inStock = false
}