/**
 * Author: Miles Wiser
 * Date: 3/4/2025
 *
 *      This program creates two Loan and a File objects. The loan instances'
 * information is written onto the file. Finally, a method reads, sums the
 * total of all loan amounts, and displays it to the terminal.
*/

import java.io.*;

public class Exercise17_7 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        Loan[] loanArray = {loan1, loan2};

        File file = new File("Exercise17_07.dat");
        
        try (
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
        ) {
            for (int i = 0; i < loanArray.length; i++) {
                output.writeDouble(loanArray[i].getAnnualInterestRate());
                output.writeInt(loanArray[i].getNumberOfYears());
                output.writeDouble(loanArray[i].getLoanAmount());
                output.writeObject(loanArray[i].getLoanDate());
            }
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }

        try {
            outputData(file);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    // Read and display total loan amount
    public static void outputData(File f) throws IOException, ClassNotFoundException {
        double sumLoan = 0;

        try (
            ObjectInputStream output = new ObjectInputStream(new FileInputStream(f));
        ) {
            while (true) {
                double annualInterestRate = output.readDouble();
                int numberOfYears = output.readInt();
                double loanAmount = output.readDouble();
                java.util.Date loanDate = (java.util.Date)(output.readObject());

                sumLoan += loanAmount;
            }
        }
        catch (EOFException ex) {
            System.out.println("Sum total of loans: " + sumLoan);
        }
    }
}
