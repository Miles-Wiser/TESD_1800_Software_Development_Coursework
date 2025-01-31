/*
Author: Miles Wiser
Date: 1/30/2025

This asks the user to enter the side lengths of a triangle, it's color, and whether
    or not it is filled. This is used to create a Triangle object. Finally, various
    information is displayed to the user.
 */

import java.util.Scanner;

public class Exercise11_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        /// Set the side lengths
        double side1 = 0.0;
        double side2 = 0.0;
        double side3 = 0.0;

        System.out.println("Enter the side lengths of a triangle.");
        side1 = input.nextDouble();
        side2 = input.nextDouble();
        side3 = input.nextDouble();

        /// Set color and filled
        String color = "";
        boolean filled = false;

        System.out.println("Enter the triangle's color.");
        color = input.next();

        System.out.println("The triangle is filled, true/false:");
        filled = input.nextBoolean();

        

        /// Instantiate triangle
        Triangle triangle = new Triangle(color, filled, side1, side2, side3);
        
        // Display "all the things."
        // Why was all of this not put in the toString() method?
        // On that topic, why wasn't the toString() method used?
        System.out.println("Area of triangle: " + triangle.getArea());
        System.out.println("Perimiter of triangle: " + triangle.getPerimeter());
        System.out.println("Color of triangle: " + triangle.getColor());
        System.out.println("Created on " + triangle.getDateCreated());
        System.out.println("triangle filled: " + triangle.isFilled());
    }
}