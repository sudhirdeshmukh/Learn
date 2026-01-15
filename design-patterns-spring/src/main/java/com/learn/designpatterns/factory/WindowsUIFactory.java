package com.learn.designpatterns.factory;

/**
 * Concrete Factory: Creates Windows UI components
 * 
 * This factory creates a family of Windows-styled UI components
 * All components are consistent with Windows design guidelines
 */
public class WindowsUIFactory implements UIFactory {
    
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
