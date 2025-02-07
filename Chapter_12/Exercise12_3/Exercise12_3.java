import java.util.Scanner;

public class Exercise12_3 {
    public static void main(String[] args) {
        int[] listInt = new int[100];
        for (int i = 0; i < listInt.length; i++)
            listInt[i] = (int)(Math.random() * 100);

        boolean complete = false;

        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter an index value: ");

                int indexVal = input.nextInt();
                System.out.println("Array[" + indexVal + "] = " + listInt[indexVal]);
                
                complete = true;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Out of Bounds");
            }
        } while (!complete);
    }
}
