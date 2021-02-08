package org.sid.graphics.parameters;

public interface Observable {
    void addListener(Observer listener);
    void removeListener(Observer listener);
    void notifyObservers();
}
