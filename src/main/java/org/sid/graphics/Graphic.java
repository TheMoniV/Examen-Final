package org.sid.graphics;

import lombok.Data;
import org.sid.graphics.parameters.Observer;
import org.sid.graphics.parameters.Parameters;

import java.io.Serializable;

@Data
public abstract class Graphic implements Observer, Serializable {
    protected Parameters parameters = new Parameters();
    public abstract double getPerimeter();
    public abstract double getSurface();
    public abstract void draw();
}
