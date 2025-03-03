/*
Author: Miles Wiser
Date: 3/3/2025

    If the file "Exercise17_03.dat" doesn't exist, the program will generate the
file and populate it with 100 random integers. If it does exist, it will add
an additional 100 integers to the file. Finally, the program will add all
integers in the file and display the sum.
*/

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise17_3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("Exercise17_03.dat");
        genFile(file);
        System.out.println("The sum of all integers in " + file.getName() +
        		" : " + sumFile(file));        
    }
    
    public static void genFile(File file) throws IOException, ClassNotFoundException {
    	// Populates file with int values
        if (!file.exists())
            try (DataOutputStream output = new DataOutputStream(new
            		FileOutputStream(file));
            ) {
                // Generate random ints and write to file
                for (int i = 0; i < 100; i++) {
                    int intRand = (int)(Math.random() * 100);
                    output.writeInt(intRand);;
                }
            }
        // Appends more ints to existing file
        else if (file.exists())
	        try (DataOutputStream output = new DataOutputStream(new
	        		FileOutputStream(file, true));
	        ) {
	            // Generate random ints and write to file
	            for (int i = 0; i < 100; i++) {
	                int intRand = (int)(Math.random() * 100);
	                output.writeInt(intRand);;
	            }
	        }
    }
    
    public static int sumFile(File file) throws IOException {
    	int sum = 0;
    	
    	// Retrieve ints separated by a space
        try (FileInputStream input = new FileInputStream(file);
        ) {
            int value;

            while ((value = (int)(input.read())) != -1) {
            	sum += value;
            }
        }
        
        return sum;
    }
}