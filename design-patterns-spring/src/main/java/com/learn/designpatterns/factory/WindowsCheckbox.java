package com.learn.designpatterns.factory;

/**
 * Concrete Product: Windows Checkbox
 */
public class WindowsCheckbox implements Checkbox {
    @Override
    public String render() {
        return "Rendering Windows style checkbox";
    }
}
