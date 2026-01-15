package com.learn.designpatterns.factory;

/**
 * Concrete Product: Windows Button
 */
public class WindowsButton implements Button {
    @Override
    public String render() {
        return "Rendering Windows style button";
    }
}
