/*
Author: Miles Wiser
Date: 3/3/2025

    This program generates 100 random numbers and writes them to a new file.
Those numbers are then displayed to the terminal seperated by spaces.
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise17_1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("Exercise17_01.txt");

        // Populates file with int values
        if (!file.exists())
            try (FileOutputStream output = new FileOutputStream(file);
            ) {
                // Generate random ints and write to file
                for (int i = 0; i < 100; i++) {
                    int intRand = (int)(Math.random() * 100);
                    output.write(intRand);
                }
            }

        // Retrieve ints seperated by a space
        try (FileInputStream input = new FileInputStream(file);
        ) {
            int value;
            int numCount = 0;

            while ((value = (int)(input.read())) != -1) {
                System.out.print(value + " ");
                // Create uniform spacing
                if (value < 10)
                    System.out.print(" ");

                numCount++;
                // New line after 10 ints
                if (numCount >= 10) {
                    System.out.println();
                    numCount = 0;
                }
            }
        }
    }
}