package com.learn.designpatterns.factory;

/**
 * Concrete Product: Mac Button
 */
public class MacButton implements Button {
    @Override
    public String render() {
        return "Rendering Mac style button";
    }
}
