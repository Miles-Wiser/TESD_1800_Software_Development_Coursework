/*
 * Author: Miles Wiser
 * Date: 3/5/2025
 * 
 *  This program asks the user for a file to encrypt as well as the name of the
 * files to hold the encryption and the new decrypted data.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Exercise17_15 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        // Gather information from user to us in encryptFile() and decryptFile()
        System.out.println("Enter the name of the file to be encrypted: ");
        File originalfile = new File(input.next());
        System.out.println("Enter the name of the encrypted file: ");
        File encryptedFile = new File(input.next());
        System.out.println("Enter the name of the decrypted file name: ");
        File decryptedFile = new File(input.next());
        input.close();

        encryptFile(originalfile, encryptedFile);
        decryptFile(encryptedFile, decryptedFile);
    }

    /// Encrypt Method
    public static void encryptFile(File inputFile, File outputFile) throws FileNotFoundException, IOException {
        try (
            RandomAccessFile inputRAF = new RandomAccessFile(inputFile, "r");
            RandomAccessFile outputRAF = new RandomAccessFile(outputFile, "rw");
        ) {
            int value;
            int count = 0;

            while ((value = (int)(inputRAF.read())) != -1) {
                inputRAF.seek(count);
                outputRAF.seek(count);

                outputRAF.write(inputRAF.read() + (byte)5);

                count++;
            }
        };
    }

    // Exercise17_14.dat    encrypted.dat   decrypted.dat
    /// Decrypt Method
    public static void decryptFile(File inputFile, File outputFile) throws FileNotFoundException, IOException {
        try (
            RandomAccessFile inputRAF = new RandomAccessFile(inputFile, "r");
            RandomAccessFile outputRAF = new RandomAccessFile(outputFile, "rw");
        ) {
            int value;
            int count = 0;

            while ((value = (int)(inputRAF.read())) != -1) {
                inputRAF.seek(count);
                outputRAF.seek(count);

                outputRAF.write(inputRAF.read() - (byte)5);

                count++;
            }
        };
    }
}
