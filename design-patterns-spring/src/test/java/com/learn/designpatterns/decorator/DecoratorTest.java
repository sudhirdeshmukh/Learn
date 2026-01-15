package com.learn.designpatterns.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Decorator Pattern
 */
class DecoratorTest {
    
    @Test
    void testBasicCoffee() {
        Coffee espresso = new Espresso();
        
        assertEquals("Espresso", espresso.getDescription());
        assertEquals(2.00, espresso.getCost(), 0.01);
    }
    
    @Test
    void testSingleDecorator() {
        Coffee coffee = new MilkDecorator(new Espresso());
        
        assertEquals("Espresso, Milk", coffee.getDescription());
        assertEquals(2.50, coffee.getCost(), 0.01);
    }
    
    @Test
    void testMultipleDecorators() {
        Coffee coffee = new MochaDecorator(
                            new MilkDecorator(
                                new Espresso()));
        
        assertEquals("Espresso, Milk, Mocha", coffee.getDescription());
        assertEquals(3.20, coffee.getCost(), 0.01); // 2.00 + 0.50 + 0.70
    }
    
    @Test
    void testComplexDecoration() {
        Coffee coffee = new CaramelDecorator(
                            new WhippedCreamDecorator(
                                new MochaDecorator(
                                    new MilkDecorator(
                                        new Espresso()))));
        
        String expectedDescription = "Espresso, Milk, Mocha, Whipped Cream, Caramel";
        assertEquals(expectedDescription, coffee.getDescription());
        assertEquals(4.60, coffee.getCost(), 0.01); // 2.00 + 0.50 + 0.70 + 0.60 + 0.80
    }
    
    @Test
    void testDifferentBaseWithDecorators() {
        Coffee coffee = new MochaDecorator(
                            new MilkDecorator(
                                new HouseBlend()));
        
        assertEquals("House Blend Coffee, Milk, Mocha", coffee.getDescription());
        assertEquals(2.70, coffee.getCost(), 0.01); // 1.50 + 0.50 + 0.70
    }
    
    @Test
    void testDoubleDecorator() {
        // Same decorator can be applied multiple times
        Coffee coffee = new MilkDecorator(
                            new MilkDecorator(
                                new Espresso()));
        
        assertEquals("Espresso, Milk, Milk", coffee.getDescription());
        assertEquals(3.00, coffee.getCost(), 0.01); // 2.00 + 0.50 + 0.50
    }
    
    @Test
    void testDecoratorIndependence() {
        Coffee base = new Espresso();
        Coffee decorated1 = new MilkDecorator(base);
        Coffee decorated2 = new MochaDecorator(base);
        
        // Decorators should not affect each other
        assertEquals("Espresso, Milk", decorated1.getDescription());
        assertEquals("Espresso, Mocha", decorated2.getDescription());
        
        // Base should remain unchanged
        assertEquals("Espresso", base.getDescription());
    }
}
