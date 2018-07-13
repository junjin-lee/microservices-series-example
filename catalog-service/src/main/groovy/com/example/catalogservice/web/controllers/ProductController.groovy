package com.example.catalogservice.web.controllers

import com.example.catalogservice.entities.Product
import com.example.catalogservice.exceptions.ProductNotFoundException
import com.example.catalogservice.services.ProductService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
@Slf4j
class ProductController {
    @Autowired
    final ProductService productService

    @GetMapping("")
    List<Product> allProducts() {
        return productService.findAllProducts()
    }

    @GetMapping("/{code}")
    Product productByCode(@PathVariable String code) {
        return productService.findByCode(code).orElseThrow({ ->
            new ProductNotFoundException("Product with code [" + code + "] does not exist.")
        })
    }

}