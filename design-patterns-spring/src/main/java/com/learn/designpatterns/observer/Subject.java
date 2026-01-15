package com.learn.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject Interface (Observable)
 * 
 * Subject maintains a list of observers and notifies them of state changes
 */
public interface Subject {
    
    /**
     * Attach an observer to this subject
     * 
     * @param observer Observer to attach
     */
    void attach(Observer observer);
    
    /**
     * Detach an observer from this subject
     * 
     * @param observer Observer to detach
     */
    void detach(Observer observer);
    
    /**
     * Notify all attached observers of a state change
     * 
     * @param event Event information
     */
    void notifyObservers(String event);
}
