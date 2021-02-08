package org.sid.graphics.algorithms;

import java.io.Serializable;

public class ProcessImplementation implements IProcess, Serializable {
    @Override
    public void process() {
        System.out.println("Calling ProcessImplementation 1");
    }
}
