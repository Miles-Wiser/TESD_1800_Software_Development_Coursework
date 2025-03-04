import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Exercise17_15 {
    public static void main(String[] args) throws IOException {
        File file = new File("Exercise17_14.dat");

        encryptFile(file);
        decryptFile(new File("encryptedFile.dat"));
    }

    public static void encryptFile(File f) throws IOException {
        System.out.println("Enter name for encrypted file: ");

        // File nFile = new File("encryptedFile");

        Scanner nameInput = new Scanner(System.in);
        File nFile = new File(nameInput.next());

        RandomAccessFile nRAF = new RandomAccessFile(f, "r");
        
        try (
            RandomAccessFile input = new RandomAccessFile(nFile + ".dat", "rw");
        ) {
            int value;
            int count = 0;

            while ((value = (int)(nRAF.read())) != -1) {
                nRAF.seek(count);
                input.seek(count);

                input.write(nRAF.read() + (byte)5);

                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            nRAF.close();
        }
    }

    public static void decryptFile(File f) throws IOException {
        System.out.println("Enter name for decrypted file: ");
        Scanner nameInput = new Scanner(System.in);
        File nFile = new File(nameInput.next());

        // File nFile = new File("decryptedFile");
        RandomAccessFile nRAF = new RandomAccessFile(f, "r");

        try (
            RandomAccessFile input = new RandomAccessFile(nFile + ".dat", "rw");
        ) {
            int value;
            int count = 0;

            while ((value = (int)(nRAF.read())) != -1) {
                nRAF.seek(count);
                input.seek(count);

                input.write(nRAF.read() - (byte)5);

                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            nRAF.close();
        }
    }
}
