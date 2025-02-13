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

    /**
     * Return a {@code String} implementation of this object.
    */
    @Override
    public String toString() {
        return "Triangle: s1 = " + side1 + ", s2 = " + side2 + ", s3 = " + side3
            + ", " + super.toString();
    }

    /**
     * Returns the {@code double} area of a {@code Triangle} instance.
     * <p>Special cases:
     * <ul><li>If the value of any one side is greater than sum of the other two,
     * the divisor will be {@code 0} and returns {@code NaN}.
     * <li>If the value of any one side is equal to the sum of the other two,
     * the result will be {@code 0} and returns {@code 0}. </ul>
     * Otherwise, the result is the {@code double} value closest to the area as
     * defined by Heron's formula.
    */
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * Returns the {@code double} perimeter of a {@code Triangle} instance.
     * <p>Note:
     * <ul><li>This does not check for negative lengths. Can return negative
     * perimeters if unchecked.</ul>
    */
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    /**
     * Prints a {@code String} defining how to color the instance.
     */
    @Override
    public void howToColor() {
        if (this.getColor() != null)
            System.out.println("Color all three sides.");
    }
}
