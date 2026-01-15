package com.learn.designpatterns.decorator;

/**
 * Abstract Decorator class
 * 
 * HOW DECORATOR PATTERN WORKS:
 * 1. Decorator implements the same interface as the component
 * 2. Decorator wraps a component object
 * 3. Decorator delegates calls to the wrapped object
 * 4. Decorator can add behavior before/after delegating
 * 
 * KEY CONCEPT:
 * Decorator IS-A Component (implements same interface)
 * Decorator HAS-A Component (wraps it)
 */
public abstract class CoffeeDecorator implements Coffee {
    
    // Reference to the wrapped coffee object
    // This can be a concrete component OR another decorator
    // This enables decorator chaining: Milk(Mocha(Espresso))
    protected Coffee wrappedCoffee;
    
    public CoffeeDecorator(Coffee coffee) {
        this.wrappedCoffee = coffee;
    }
    
    /**
     * Default implementation delegates to wrapped object
     * Concrete decorators can override to add behavior
     */
    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription();
    }
    
    @Override
    public double getCost() {
        return wrappedCoffee.getCost();
    }
}
