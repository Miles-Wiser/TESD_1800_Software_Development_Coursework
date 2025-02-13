public class Octagon extends GeometricObject
        implements Comparable<Octagon>, Cloneable {
    private double side = 0;

    public Octagon() {
        super();
    }

    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    /**
     * Returns the side length of the object.
     * 
     * @return {@code this.side}
     */
    public double getSide() {
        return side;
    }
    /**
     * Sets the side equal to {@code side}.
     * 
     * @param side
     */
    public void setSide(double side) {
        this.side = side;
    }

    public String toString() {
        return "Octagon: side = " + this.side + ", " + super.toString();
    }

    /**
     * Returns a {@code double} value for the perimeter of this object. Note:
     * Does not check for negative values. Can return negative perimeters.
     * 
     * @return a double value for this object's perimeter.
     * 
     */
    @Override
    public double getPerimeter() {
        return side * 8;
    }

    /**
     * Returns a {@code double} value for the area of this object. Note: Does
     * not check for negative values. Can return negative areas.
     * 
     * @return a double value for this object's area.
     */
    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    /**
     * Compares this object's area to object {@code o}'s area. Returns a negative
     * integer, zero, or positive integer as the area is less than, equal to, or
     * greater than {@code o}.
     * 
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than {@code o}.
     */
    @Override
    public int compareTo(Octagon o) {
        if (this.getArea() < o.getArea())
            return -1;
        else if (this.getArea() > o.getArea())
            return 1;
        else
            return 0;
    }

    @Override
    public Octagon clone() throws CloneNotSupportedException {
        try {
            Octagon octagonClone = (Octagon)super.clone();

            octagonClone.side = side;
            return octagonClone;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }

}
