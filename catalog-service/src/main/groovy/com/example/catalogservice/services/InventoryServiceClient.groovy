package com.example.catalogservice.services

import com.example.catalogservice.utils.MyThreadLocalHolder
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
import groovy.util.logging.Slf4j
import lombok.Data
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
@Slf4j
class InventoryServiceClient {

    static final String INVENTORY_SERVICE_URL = "http://inventory-service/api/";

    @Autowired
    final RestTemplate restTemplate

    @HystrixCommand(commandKey = "inventory-by-productcode", fallbackMethod = "getDefaultProductInventoryByCode"
            /*
            , commandProperties = [
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
            ]
            */
    )
    Optional<ProductInventoryResponse> getProductInventoryByCode(String productCode) {
        ResponseEntity<ProductInventoryResponse> itemResponseEntity = restTemplate.getForEntity(
                INVENTORY_SERVICE_URL + "/inventory/{code}",
                ProductInventoryResponse.class,
                productCode);


        log.info("CorrelationID: "+ MyThreadLocalHolder.getCorrelationId());

        if (itemResponseEntity.getStatusCode() == HttpStatus.OK) {
            return Optional.ofNullable(itemResponseEntity.getBody());
        } else {
            return Optional.empty();
        }
    }

    Optional<ProductInventoryResponse> getDefaultProductInventoryByCode(String productCode) {
        ProductInventoryResponse resp = new ProductInventoryResponse()
        resp.setProductCode(productCode)
        resp.setAvailableQuantity(50)
        return Optional.ofNullable(resp)
    }
}

@Data
class ProductInventoryResponse {
    String productCode
    int availableQuantity
}
