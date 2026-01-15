package com.learn.designpatterns.decorator;

/**
 * Concrete Decorator: Mocha
 * 
 * Adds mocha flavor to any coffee
 */
public class MochaDecorator extends CoffeeDecorator {
    
    public MochaDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Mocha";
    }
    
    @Override
    public double getCost() {
        return wrappedCoffee.getCost() + 0.70;
    }
}
