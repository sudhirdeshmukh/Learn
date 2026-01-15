package com.learn.designpatterns.decorator;

/**
 * Concrete Component: House Blend Coffee
 */
public class HouseBlend implements Coffee {
    
    @Override
    public String getDescription() {
        return "House Blend Coffee";
    }
    
    @Override
    public double getCost() {
        return 1.50;
    }
}
