import java.io.PrintWriter;
import java.util.ArrayList;
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
            
            for (int i = 0; i < 10; i++)
                output.print((int)(Math.random() * 10) + " ");
            
            output.close();
        }

        // Read from file
        Scanner input = new Scanner(file);
        ArrayList<Integer> inputArray = new ArrayList<>();

        // Display in order
        while (input.hasNext()) {
            inputArray.add(input.nextInt());
        }
        for (int i = 0; i < inputArray.size(); i ++)
            System.out.print(inputArray.get(i) + " ");
    }
}