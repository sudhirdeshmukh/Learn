package com.learn.designpatterns.decorator;

/**
 * Concrete Component: Basic Coffee (Espresso)
 * 
 * This is the base object that can be decorated
 */
public class Espresso implements Coffee {
    
    @Override
    public String getDescription() {
        return "Espresso";
    }
    
    @Override
    public double getCost() {
        return 2.00;
    }
}
