package com.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot Application entry point for Restaurant Table Booking System
 * This is a production-ready Java application for managing restaurant table reservations
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurant.model", "com.restaurant.service", "com.restaurant.controller"})
public class RestaurantBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantBookingApplication.class, args);
    }
}
