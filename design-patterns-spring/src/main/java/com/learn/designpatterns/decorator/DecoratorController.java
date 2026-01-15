package com.learn.designpatterns.decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller demonstrating Decorator Pattern
 */
@RestController
@RequestMapping("/api/decorator")
@Tag(name = "Decorator Pattern", description = "Demonstrates Decorator pattern for dynamic feature addition")
public class DecoratorController {
    
    @Autowired
    private CoffeeService coffeeService;
    
    /**
     * Order coffee with additions
     */
    @PostMapping("/coffee/order")
    @Operation(summary = "Order coffee", 
               description = "Creates coffee with specified additions using Decorator pattern")
    public Map<String, Object> orderCoffee(
            @RequestParam String base,
            @RequestParam(required = false) List<String> additions) {
        
        Coffee coffee = coffeeService.createCoffee(base, additions);
        
        Map<String, Object> result = new HashMap<>();
        result.put("order", coffee.getDescription());
        result.put("cost", String.format("$%.2f", coffee.getCost()));
        result.put("breakdown", getBreakdown(base, additions));
        
        return result;
    }
    
    /**
     * Get available options
     */
    @GetMapping("/coffee/options")
    @Operation(summary = "Get coffee options", 
               description = "Lists available base coffees and additions")
    public Map<String, Object> getOptions() {
        Map<String, Object> options = new HashMap<>();
        options.put("bases", new String[]{"ESPRESSO", "HOUSE_BLEND"});
        options.put("additions", new String[]{"MILK", "MOCHA", "WHIPPED_CREAM", "CARAMEL"});
        options.put("prices", Map.of(
            "ESPRESSO", 2.00,
            "HOUSE_BLEND", 1.50,
            "MILK", 0.50,
            "MOCHA", 0.70,
            "WHIPPED_CREAM", 0.60,
            "CARAMEL", 0.80
        ));
        return options;
    }
    
    /**
     * Demonstrate decorator pattern with examples
     */
    @GetMapping("/demo")
    @Operation(summary = "Demo Decorator pattern", 
               description = "Shows how decorators can be dynamically added")
    public String demonstrateDecorator() {
        StringBuilder result = new StringBuilder();
        result.append("Demo: Decorator Pattern\n\n");
        
        // Example 1: Simple coffee
        Coffee coffee1 = new Espresso();
        result.append("1. Simple Espresso:\n");
        result.append("   Description: ").append(coffee1.getDescription()).append("\n");
        result.append("   Cost: $").append(String.format("%.2f", coffee1.getCost())).append("\n\n");
        
        // Example 2: Coffee with one decorator
        Coffee coffee2 = new MilkDecorator(new Espresso());
        result.append("2. Espresso with Milk:\n");
        result.append("   Description: ").append(coffee2.getDescription()).append("\n");
        result.append("   Cost: $").append(String.format("%.2f", coffee2.getCost())).append("\n\n");
        
        // Example 3: Coffee with multiple decorators
        Coffee coffee3 = new CaramelDecorator(
                            new WhippedCreamDecorator(
                                new MochaDecorator(
                                    new MilkDecorator(
                                        new Espresso()))));
        result.append("3. Fully Loaded Espresso:\n");
        result.append("   Description: ").append(coffee3.getDescription()).append("\n");
        result.append("   Cost: $").append(String.format("%.2f", coffee3.getCost())).append("\n\n");
        
        // Example 4: Different base with decorators
        Coffee coffee4 = new MochaDecorator(
                            new MilkDecorator(
                                new HouseBlend()));
        result.append("4. House Blend with Milk and Mocha:\n");
        result.append("   Description: ").append(coffee4.getDescription()).append("\n");
        result.append("   Cost: $").append(String.format("%.2f", coffee4.getCost())).append("\n\n");
        
        result.append("Key Points:\n");
        result.append("- Each decorator adds functionality without modifying original object\n");
        result.append("- Decorators can be stacked in any order\n");
        result.append("- Same decorator can be applied multiple times\n");
        result.append("- New decorators can be added without changing existing code\n");
        result.append("- Much better than creating subclass for every combination!");
        
        return result.toString();
    }
    
    /**
     * Helper method to generate price breakdown
     */
    private String getBreakdown(String base, List<String> additions) {
        StringBuilder breakdown = new StringBuilder();
        breakdown.append(base).append(": $").append(base.equals("ESPRESSO") ? "2.00" : "1.50");
        
        if (additions != null) {
            for (String addition : additions) {
                String price = switch (addition.toUpperCase()) {
                    case "MILK" -> "0.50";
                    case "MOCHA" -> "0.70";
                    case "WHIPPED_CREAM" -> "0.60";
                    case "CARAMEL" -> "0.80";
                    default -> "0.00";
                };
                breakdown.append(" + ").append(addition).append(": $").append(price);
            }
        }
        
        return breakdown.toString();
    }
}
