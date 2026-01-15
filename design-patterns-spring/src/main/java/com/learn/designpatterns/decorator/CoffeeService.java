package com.learn.designpatterns.decorator;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to create decorated coffee
 */
@Service
public class CoffeeService {
    
    /**
     * Create coffee with specified base and additions
     * 
     * @param base Base coffee type
     * @param additions List of additions to apply
     * @return Decorated coffee object
     */
    public Coffee createCoffee(String base, List<String> additions) {
        // Start with base coffee
        Coffee coffee = createBaseCoffee(base);
        
        // Apply decorators one by one
        // Each decorator wraps the previous coffee object
        if (additions != null) {
            for (String addition : additions) {
                coffee = applyDecorator(coffee, addition);
            }
        }
        
        return coffee;
    }
    
    /**
     * Create base coffee
     */
    private Coffee createBaseCoffee(String type) {
        return switch (type.toUpperCase()) {
            case "ESPRESSO" -> new Espresso();
            case "HOUSE_BLEND" -> new HouseBlend();
            default -> throw new IllegalArgumentException("Unknown coffee type: " + type);
        };
    }
    
    /**
     * Apply decorator based on addition type
     * This demonstrates decorator chaining
     */
    private Coffee applyDecorator(Coffee coffee, String addition) {
        return switch (addition.toUpperCase()) {
            case "MILK" -> new MilkDecorator(coffee);
            case "MOCHA" -> new MochaDecorator(coffee);
            case "WHIPPED_CREAM" -> new WhippedCreamDecorator(coffee);
            case "CARAMEL" -> new CaramelDecorator(coffee);
            default -> throw new IllegalArgumentException("Unknown addition: " + addition);
        };
    }
}
