package com.example.hystrixdashboard

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard

@EnableHystrixDashboard
@SpringBootApplication
class HystrixDashBoardApplication {
    static void main(String[] args) {
        SpringApplication.run HystrixDashBoardApplication, args
    }
}