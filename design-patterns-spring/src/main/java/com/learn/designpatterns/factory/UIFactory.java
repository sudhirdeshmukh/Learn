package com.learn.designpatterns.factory;

/**
 * Abstract Factory Interface
 * 
 * WHAT IS ABSTRACT FACTORY?
 * Abstract Factory provides an interface for creating families of related or dependent
 * objects without specifying their concrete classes.
 * 
 * DIFFERENCE FROM FACTORY METHOD:
 * - Factory Method creates ONE type of product
 * - Abstract Factory creates FAMILIES of related products
 * 
 * Real-World Example: UI Component Factory for different operating systems
 * Each OS (Windows, Mac) has its own style of UI components (buttons, checkboxes, etc.)
 */
public interface UIFactory {
    
    /**
     * Create a button for the specific OS
     */
    Button createButton();
    
    /**
     * Create a checkbox for the specific OS
     */
    Checkbox createCheckbox();
}
