package com.learn.designpatterns.decorator;

/**
 * Concrete Decorator: Milk
 * 
 * Adds milk to any coffee
 */
public class MilkDecorator extends CoffeeDecorator {
    
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    /**
     * Add milk to the description
     * Calls wrapped object's getDescription() and adds milk
     */
    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Milk";
    }
    
    /**
     * Add milk cost to the total
     * Calls wrapped object's getCost() and adds milk price
     */
    @Override
    public double getCost() {
        return wrappedCoffee.getCost() + 0.50;
    }
}
