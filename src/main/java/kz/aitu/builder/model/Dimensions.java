package kz.aitu.builder.model;

public final class Dimensions {

    private final double length;
    private final double width;
    private final double height;

    public Dimensions(double length, double width, double height) {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "All dimensions must be greater than 0"
            );
        }

        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return length + " x " + width + " x " + height + " cm";
    }
}