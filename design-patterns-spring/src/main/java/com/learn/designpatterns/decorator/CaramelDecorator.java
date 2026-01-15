package com.learn.designpatterns.decorator;

/**
 * Concrete Decorator: Caramel
 * 
 * Adds caramel flavor to any coffee
 */
public class CaramelDecorator extends CoffeeDecorator {
    
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Caramel";
    }
    
    @Override
    public double getCost() {
        return wrappedCoffee.getCost() + 0.80;
    }
}
