package com.learn.designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application for Design Patterns Learning Project
 * 
 * This application demonstrates various design patterns with practical implementations.
 * The patterns are organized into packages for easy navigation:
 * - Creational Patterns: Singleton, Factory, Builder, Prototype
 * - Behavioral Patterns: Strategy, Observer
 * - Structural Patterns: Decorator
 * 
 * Each pattern includes:
 * - Well-documented implementation with detailed comments
 * - Real-world examples
 * - Unit tests
 * - REST API endpoints for demonstration (where applicable)
 * 
 * Access Swagger UI at: http://localhost:8080/swagger-ui.html
 * 
 * @author Learn Project
 * @version 1.0.0
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
