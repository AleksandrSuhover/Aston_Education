package org.aston.lesson_5;

public class Triangle extends FigureImpl {
    private final double FIRST_SIDE_LENGTH;
    private final double SECOND_SIDE_LENGTH;
    private final double THIRD_SIDE_LENGTH;

    public Triangle(Color fillingColor, Color borderColor, double FIRST_SIDE_LENGTH, double SECOND_SIDE_LENGTH, double THIRD_SIDE_LENGTH) {
        super(fillingColor, borderColor);
        this.FIRST_SIDE_LENGTH = FIRST_SIDE_LENGTH;
        this.SECOND_SIDE_LENGTH = SECOND_SIDE_LENGTH;
        this.THIRD_SIDE_LENGTH = THIRD_SIDE_LENGTH;
    }

    @Override
    public double getPerimeter() {
        return FIRST_SIDE_LENGTH + SECOND_SIDE_LENGTH + THIRD_SIDE_LENGTH;
    }

    @Override
    public double getArea() {
        double pp = (this.getPerimeter()) / 2.0;
        return Math.sqrt(pp * (pp - FIRST_SIDE_LENGTH) * (pp - SECOND_SIDE_LENGTH) * (pp - THIRD_SIDE_LENGTH));
    }
}
