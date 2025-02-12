public class Triangle extends GeometricObject implements Colorable {
    private double side1;
    private double side2;
    private double side3;
    Triangle() {
        super();
    }

    Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /** Getters */
    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side2;
    }
    public double getSide3() {
        return side3;
    }

    /** toString method */
    @Override
    public String toString() {
        return "Triangle: s1 = " + side1 + ", s2 = " + side2 + ", s3 = " + side3
            + ", " + super.toString();
    }

    /**
     * Returns the {@code double} area of the triangle.
     * Special cases:
     * <ul><li>If the value of any one side is greater than sum of the other two,
     * the divisor will be 0 and returns NaN.
     * <li>If the value of any one side is equal to the sum of the other two,
     * the result will be 0, meaning a degenerate triangle. </ul>
     * Otherwise, the result is the {@code double} value closest to the area as
     * defined by Heron's formula.
    */
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /** getPerimeter method */
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    /** interface Colorable: howToColor() */
    @Override
    public void howToColor() {
        if (this.getColor() != null)
            System.out.println("Color all three sides.");
    }
}
