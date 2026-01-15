package com.learn.designpatterns.factory;

/**
 * Concrete Product: Mac Checkbox
 */
public class MacCheckbox implements Checkbox {
    @Override
    public String render() {
        return "Rendering Mac style checkbox";
    }
}
