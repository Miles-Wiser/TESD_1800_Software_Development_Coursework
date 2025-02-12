/*
Author: Miles Wiser
Date: 2/12/2025

    This program defines a concrete Triangle class extended from an abstract
GeometricObject class. Then a Triangle is created given side lengths, color,
and filled status from the user. Finally, this information is displayed.
*/

import java.util.Scanner;

public class Exercise13_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /** Create triangle with side lengths */
        System.out.println("Enter three side lengths: ");
        Triangle myTri = new Triangle(input.nextDouble(), input.nextDouble(), input.nextDouble(),
        null, false);

        /** Set color and filled */
        System.out.println("Enter the color of the shape: ");
        myTri.setColor(input.next());

        System.out.println("Is the shape filled, true/false: ");
        myTri.setFilled(input.nextBoolean());

        input.close();

        /** Display triangle information */
        System.out.println(myTri.toString());
        System.out.println("Area: " + myTri.getArea());
        System.out.println("Perimeter: " + myTri.getPerimeter());
    }
}
