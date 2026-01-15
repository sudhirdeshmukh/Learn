package com.learn.designpatterns.decorator;

/**
 * Concrete Decorator: Whipped Cream
 * 
 * Adds whipped cream to any coffee
 */
public class WhippedCreamDecorator extends CoffeeDecorator {
    
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Whipped Cream";
    }
    
    @Override
    public double getCost() {
        return wrappedCoffee.getCost() + 0.60;
    }
}
