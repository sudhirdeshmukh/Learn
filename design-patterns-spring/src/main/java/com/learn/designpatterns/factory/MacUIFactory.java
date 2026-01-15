package com.learn.designpatterns.factory;

/**
 * Concrete Factory: Creates Mac UI components
 * 
 * This factory creates a family of Mac-styled UI components
 * All components are consistent with Mac design guidelines
 */
public class MacUIFactory implements UIFactory {
    
    @Override
    public Button createButton() {
        return new MacButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
