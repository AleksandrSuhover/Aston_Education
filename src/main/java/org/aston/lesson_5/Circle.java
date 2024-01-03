package org.aston.lesson_5;

public class Circle extends FigureImpl{
    private final double radius;

    public Circle(Color fillingColor, Color borderColor, double radius) {
        super(fillingColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
