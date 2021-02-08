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
public class Rectangle extends Graphic implements Serializable {
    private Point location;
    private double height;
    private double length;

    @Override
    public double getPerimeter() {
        return 2 * (height + length);
    }

    @Override
    public double getSurface() {
        return height * length;
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
