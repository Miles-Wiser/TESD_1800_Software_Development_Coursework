/*
Author: Miles Wiser
Date: 2/13/2025

    This program creates an array of Triangle instances with random side
lengths, color, and filled status. The instances' areas are displayed. If they
are colorable, the instances implements the Colorable interface and describes
how to color them.
*/

public class Exercise13_7 {
    public static void main(String[] args) {
        GeometricObject[] myObjects = new Triangle[5];
        
        for (int i = 0; i < myObjects.length; i++) {
            // Generate three side lengths, random color (if any), and filled status.
            myObjects[i] = new Triangle(
                (int)(Math.random() * 10 + 1),
                (int)(Math.random() * 10 + 1),
                (int)(Math.random() * 10 + 1),
                (i % 2 == 0) ? ("Green" + i) : null,
                true);

            System.out.println("\nTriangle " + i + " Area: " + ((Triangle)myObjects[i]).getArea());

            ((Triangle)myObjects[i]).howToColor();
        }
    }
}