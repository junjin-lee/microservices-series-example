package com.example.catalogservice.services

import com.example.catalogservice.entities.Product
import com.example.catalogservice.repositories.ProductRepository
import com.example.catalogservice.utils.MyThreadLocalHolder
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Service
@Transactional
@Slf4j
class ProductService {

    @Autowired
    final ProductRepository productRepository

    @Autowired
    final InventoryServiceClient inventoryServiceClient

    List<Product> findAllProducts() {
        return productRepository.findAll()
    }

    Optional<Product> findByCode(String code) {
        Optional<Product> productOptional = productRepository.findByCode(code)

        if (productOptional.isPresent()) {

            String correlationId = UUID.randomUUID().toString()
            MyThreadLocalHolder.setCorrelationId correlationId

            log.info("Before CorrelationID: "+ MyThreadLocalHolder.getCorrelationId());

            Optional<ProductInventoryResponse> inventoryOptional = inventoryServiceClient.getProductInventoryByCode(code)

            if (inventoryOptional.isPresent()) {
                Integer qty = inventoryOptional.get().getAvailableQuantity()
                log.info "Product QTY is " + qty
                productOptional.get().setInStock( qty > 0)
            }
            log.info("After CorrelationID: "+ MyThreadLocalHolder.getCorrelationId());
        }

        return productOptional
    }

}

