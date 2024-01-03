package org.aston.lesson_5;

public class Square extends FigureImpl{
    private final double SIDE_LENGTH;

    public Square(Color fillingColor, Color borderColor, int SIDE_LENGTH) {
        super(fillingColor, borderColor);
        this.SIDE_LENGTH = SIDE_LENGTH;
    }

    @Override
    public double getPerimeter() {
        return SIDE_LENGTH * 4;
    }

    @Override
    public double getArea() {
        return SIDE_LENGTH * SIDE_LENGTH;
    }
}
