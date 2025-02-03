/*
Author: Miles Wiser
Date: 2/3/25

This programs creates three seperate account objects: a general Account,
    SavingsAccount, and Checking account. It then uses the unique overriden
    method "toString()" for each object. The SavingsAccount and CheckingAccount
    classes both have an overriden method, "withdraw()", to ensure the user
    can't withdraw more money than the overdraft limit allows or below $0.00
    for SavingsAccount objects.
 */

public class Exercise11_3 {
    public static void main(String[] args) {
        Account myAccount = new Account();
        SavingsAccount mySavingsAccount = new SavingsAccount();
        CheckingAccount myCheckingAccount = new CheckingAccount();
        
        System.out.println(myAccount.toString());
        System.out.println(mySavingsAccount.toString());
        System.out.println(myCheckingAccount.toString());
    }
}
