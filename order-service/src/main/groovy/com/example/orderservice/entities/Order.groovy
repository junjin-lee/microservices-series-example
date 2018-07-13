package com.example.orderservice.entities

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String customerEmail

    String cusotmerAddress

    @OneToMany(cascade = CascadeType.ALL)
    List<OrderItem> items
}
