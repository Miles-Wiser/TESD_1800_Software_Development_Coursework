/*
Author: Miles Wiser
Date: 1/9/2025

This program is used to simulate creating a bank account with a set
    balance. Then withdrawals and deposits will be made. Finally,
    the balance, monthly interest, and the date of account creation
    will be displayed.
 */

 public class Exercise9_7 {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        Account.setAnnualInterstRate(4.5);

        account.withdraw(2500);
        account.deposit(3000);

        //System.out.println(account.dateCreated);

        System.out.println("Account " + account.getId());
        System.out.printf("Balance: $%,4.2f\n" +
            "Monthly Interest: $%,4.2f\n" +
            "Account Created: %s\n",
            account.getBalance(), account.getMonthlyInterst(), account.getDateCreated());

    }
 }