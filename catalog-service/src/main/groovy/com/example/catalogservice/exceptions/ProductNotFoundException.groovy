package com.example.catalogservice.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.NOT_FOUND)
class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException() {
        super()
    }

    ProductNotFoundException(String message) {
        super(message)
    }

    ProductNotFoundException(String message, Throwable cause) {
        super(message, cause)
    }

    ProductNotFoundException(Throwable cause) {
        super(cause)
    }
}