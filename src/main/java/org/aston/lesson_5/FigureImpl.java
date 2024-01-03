package org.aston.lesson_5;

public abstract class FigureImpl implements Figure {
    private final Color FILLING_COLOR;
    private final Color borderColor;

    public FigureImpl(Color FILLING_COLOR, Color borderColor) {
        this.FILLING_COLOR = FILLING_COLOR;
        this.borderColor = borderColor;
    }

    @Override
    public String toString() {
        return "FigureImpl{" +
                "Perimeter:" + this.getPerimeter() + ";" +
                "Area:" + this.getArea() + ";" +
                "fillingColor=" + FILLING_COLOR + ";" +
                "BorderColor=" + borderColor + ";" +
                '}';
    }
}
