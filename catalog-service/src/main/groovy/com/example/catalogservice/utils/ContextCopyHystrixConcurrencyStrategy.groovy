package com.example.catalogservice.utils

import com.netflix.hystrix.strategy.HystrixPlugins
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

import java.util.concurrent.Callable

@Component
@Slf4j
class ContextCopyHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
    ContextCopyHystrixConcurrencyStrategy(){
        HystrixPlugins.getInstance().registerConcurrencyStrategy(this)
    }

    @Override
    def <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new MyCallable<T>(callable, MyThreadLocalHolder.getCorrelationId())
    }
}

@Slf4j
class MyCallable<T> implements Callable<T> {
    final Callable<T> actual
    final String correlationId

    MyCallable(Callable<T> actual, String correlationId) {

        log.info "MyCallable constructor"

        this.actual = actual
        this.correlationId = correlationId
    }

    @Override
    T call() throws Exception {

        MyThreadLocalHolder.setCorrelationId correlationId

        try {
            log.info correlationId
            return actual.call()
        } finally {
            MyThreadLocalHolder.setCorrelationId null
            log.info MyThreadLocalHolder.getCorrelationId()
        }
    }
}
