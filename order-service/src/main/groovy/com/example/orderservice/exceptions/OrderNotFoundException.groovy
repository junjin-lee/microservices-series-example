package com.example.orderservice.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class OrderNotFoundException extends RuntimeException {
    OrderNotFoundException() {
        super()
    }
    OrderNotFoundException(String message) {
        super(message)
    }
    OrderNotFoundException(Throwable cause) {
        super(cause)
    }
    OrderNotFoundException(String message, Throwable cause) {
        super(message, cause)
    }
}
