package com.example.inventoryservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class InventoryServiceApplication {
    static void main(String[] args) {
        SpringApplication.run InventoryServiceApplication, args
    }
}