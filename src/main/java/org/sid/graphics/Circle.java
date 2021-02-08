package org.sid.graphics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Circle extends Graphic implements Serializable {
    private Point center;
    private double rayon;

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * rayon;
    }

    @Override
    public double getSurface() {
        return Math.PI * Math.pow(rayon, 2);
    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public void update() {
        System.out.println("Something in the parameters has changed!");
        System.out.println(parameters);
    }
}
