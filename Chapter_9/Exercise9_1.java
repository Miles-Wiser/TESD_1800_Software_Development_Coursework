/*
Author: Miles Wiser
Date: 1/9/2025

This program creates two rectangle objects and displays their width,
    height, area and perimeter.
 */

public class Exercise9_1 {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(4, 40);

        System.out.println("Rectangle 1 Info");
        System.out.println("Width: " + rect1.width +
            "\nHeight: " + rect1.height +
            "\nArea: " + rect1.getArea() +
            "\nPerimeter: " + rect1.getPerimeter());

        Rectangle rect2 = new Rectangle(3.5, 35.9);

        System.out.println("\nRectangle 2 Info");
        System.out.println("Width: " + rect2.width +
            "\nHeight: " + rect2.height +
            "\nArea: " + rect2.getArea() +
            "\nPerimeter: " + rect2.getPerimeter());
    }
}