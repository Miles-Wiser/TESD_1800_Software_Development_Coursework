/*
Author: Miles Wiser
Date: 1/28/2025

This program allows for the creation of the object "MyInteger". It comes with methods to determine if the given
    value, object values, or any integer are even, odd, and/or prime. Additionally, there are methods to
    determine if any integer or another instance's value are equal to the specified object. Finally, there are
    methods to sum an array of characters and convert a String of digits to an integer.
*/

public class Exercise10_3 {
    public static void main(String[] args) {

        MyInteger num = new MyInteger(-10);
        MyInteger num1 = new MyInteger(22);
        MyInteger num2 = new MyInteger(47);

        // Test no-arg methods
        System.out.println("Instance num: " + num.getValue());
        System.out.println("Even: " + num.isEven());
        System.out.println("Odd: " + num.isOdd());
        System.out.println("Prime: " + num.isPrime() + "\n");

        // Test "int" methods
        int anyIntger = 62;
        System.out.println("anyInteger: " + anyIntger);
        System.out.println("Even: " + MyInteger.isEven(anyIntger));
        System.out.println("Odd: " + MyInteger.isOdd(anyIntger));
        System.out.println("Prime: " + MyInteger.isPrime(anyIntger) + "\n");

        // Test "MyInteger" methods
        System.out.println("Instance num(value = " + num.getValue() + "):");
        System.out.println("Even: " + MyInteger.isEven(num));
        System.out.println("Instance num1(value = " + num1.getValue() + "):");
        System.out.println("Odd: " + MyInteger.isOdd(num1));
        System.out.println("Instance num2(value = " + num2.getValue() + "):");
        System.out.println("Prime: " + MyInteger.isPrime(num2) + "\n");

        // Test "equals()" methods
        System.out.print("Does num (value = " + num.getValue()
            + ") equal \"anyIntger\" (value = " + anyIntger + "): ");
        System.out.println(num.equals(anyIntger));
        System.out.print("Does num (value = " + num.getValue()
            + ") equal num1 (value = " + num1.getValue() + "): ");
        System.out.println(num.equals(num1));

        // Test static "parse" methods
        System.out.println();
        char[] myChar = {'1', '2', '3', '7'};
        String myString = "-2584";
        System.out.print("myChar: ");
        System.out.println(MyInteger.parseInt(myChar));
        System.out.print("myString: ");
        System.out.println(MyInteger.parseInt(myString));
    }
}
