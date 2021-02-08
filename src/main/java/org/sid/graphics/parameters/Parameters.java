package org.sid.graphics.parameters;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Parameters implements Observable, Serializable {
    private int colorContour;
    private int colorRemplissage;
    private int epaisseurContour;
    private List<Observer> listeners = new ArrayList<>();
    @Override
    public void addListener(Observer listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(Observer listener) {
        listeners.remove(listener);
    }

    @Override
    public void notifyObservers() {
        for (Observer listener : listeners) {
            listener.update();
        }
    }

    public void setColorContour(int colorContour) {
        this.colorContour = colorContour;
        notifyObservers();
    }
    public void setColorRemplissage(int colorRemplissage) {
        this.colorRemplissage = colorRemplissage;
        notifyObservers();
    }
    public void setEpaisseurContour(int epaisseurContour) {
        this.epaisseurContour = epaisseurContour;
        notifyObservers();
    }
}
