package org.sid.graphics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Figures extends Graphic implements Serializable {
    private List<Graphic> list = new ArrayList<>();

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public double getSurface() {
        return 0;
    }

    @Override
    public void draw() {
        for (Graphic figure : list) {
            figure.draw();
        }
    }

    @Override
    public void update() {
        for (Graphic figure : list) {
            figure.update();
        }
    }
}
