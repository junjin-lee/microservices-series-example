package com.example.catalogservice.utils

class MyThreadLocalHolder {
    private static final ThreadLocal<String> CORRELATION_ID = new ThreadLocal<>()

    static void setCorrelationId(String correlationId) {
        CORRELATION_ID.set correlationId
    }

    static String getCorrelationId() {
        return CORRELATION_ID.get()
    }
}
