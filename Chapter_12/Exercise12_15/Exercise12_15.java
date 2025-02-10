/*
Author: Miles Wiser
Date: 2/10/2025

    This program checks for file "Exercise12_15.txt." If it doesn't exist, a
new file with the same name is created containing 100 integers. Finally, the
integers will be read and displayed to the user in ascending order.
*/

import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise12_15 {
    public static void main(String[] args) throws java.io.IOException {
        // Check for file's existence
        java.io.File file = new java.io.File("Exercise12_15.txt");

        if (file.exists()) {
            System.out.println("File already exists");
        }
        else {
            // Generate a file
            PrintWriter output = new PrintWriter(file);
            
            for (int i = 0; i < 100; i++)
                output.print((int)(Math.random() * 100 + 1) + " ");
            
            output.close();
        }

        // Read from file
        Scanner input = new Scanner(file);
        int[] inputArray = new int[100];

        int i = 0;
        while (input.hasNext()) {
            inputArray[i] = input.nextInt();
            i++;
        }
        input.close();

        // Sort and Display
        java.util.Arrays.sort(inputArray);
        for (int j = 0; j < inputArray.length; j++) {
            // Display in rows of 10
            if (j % 10 == 0)
                System.out.println();

            System.out.print(inputArray[j] + " ");
        }
    }
}
