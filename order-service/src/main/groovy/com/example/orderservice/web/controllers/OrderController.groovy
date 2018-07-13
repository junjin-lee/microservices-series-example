package com.example.orderservice.web.controllers

import com.example.orderservice.entities.Order
import com.example.orderservice.exceptions.OrderNotFoundException
import com.example.orderservice.repositories.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/orders")
class OrderController {

    @Autowired
    OrderRepository orderRepository

    @PostMapping("")
    Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order)
    }

    @GetMapping("{id}")
    Order findOrderById(@PathVariable Long id) {

        return orderRepository.findById(id).orElseThrow({  -> new OrderNotFoundException("Order with Id [" + id + "] does not exist.")})
    }

}
