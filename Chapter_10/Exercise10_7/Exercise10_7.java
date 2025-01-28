/*
Author: Miles Wiser
Date: 1/28/2025

This program initializes 10 Account objects. A loop, that repeats for eternity,
    asks the user to enter an account ID. Once entered, another prompt will ask
    to perform 4 funtions: check balance, withdraw, deposit, and exit. Upon
    exiting, the program will loop to the beginning asking the user to enter an
    account ID.
 */
import java.util.Scanner;

 public class Exercise10_7 {
    public static void main(String[] args) {

        // Create and initialize objects 
        Account accounts[] = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100.00);
        }

        while (true) {
            /// Ask/check for ID
            System.out.print("Enter account ID: ");

            Scanner input = new Scanner(System.in);
            int idEntry = input.nextInt();

            while (idEntry < 0 || idEntry > accounts.length - 1) {
                System.out.println("Incorrect ID entry.\nEnter account ID: ");
                idEntry = input.nextInt();
            }

            /// Functions menu

            // Used to end loop
            int funInput = -1;

            while (funInput != 4) {
                // Checks for correct method entry
                do {
                System.out.println("\nMain Menu\n");
                System.out.println("1: Check Balance" + "\n2: Withdraw Money" + "\n3: Deposit Money" + "\n4: Exit");

                System.out.print("Choose a function: ");
                funInput = input.nextInt();

                } while (funInput < 1 || funInput > 4);

                // Perform the desired function
                switch (funInput) {
                    // Check Balance
                    case 1:
                        System.out.println("Current Balance: $" + accounts[idEntry].getBalance());
                        break;
                    
                    // Withdraw
                    case 2:
                        System.out.print("Withdrawl Amount: $");

                        double wAmount = input.nextDouble();

                        // Ensures user doesn't exceed account balance or depost (negative digit) money
                        while (wAmount > accounts[idEntry].getBalance() || wAmount < 0) {
                            if (wAmount > accounts[idEntry].getBalance())
                                System.out.println("\nAmount exceeds account balance.");
                            else if (wAmount < 0)
                                System.out.println("\nImpossible function.");

                            System.out.println("Current Balance: $" + accounts[idEntry].getBalance());

                            System.out.print("Withdrawl Amount: $");
                            wAmount = input.nextDouble();
                        }

                        accounts[idEntry].withdraw(wAmount);

                        break;
                    
                    // Deposit
                    case 3:
                        System.out.print("Deposit Amount: $");

                        double dAmmount = input.nextDouble();

                        // Ensures user doesn't withdraw (negative digit) money
                        while (dAmmount < 0) {
                            System.out.println("\nImpossible function.");

                            System.out.print("Deposit Amount: $");
                            dAmmount = input.nextDouble();
                        }

                        accounts[idEntry].deposit(dAmmount);
                        break;

                    // Exit
                    case 4:
                        System.out.println("Exiting\n");
                        break;
                }
            }
        }
    }
 }