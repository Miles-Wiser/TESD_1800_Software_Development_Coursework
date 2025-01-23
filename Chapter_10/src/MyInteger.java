/*
        MyInteger
-------------------------
+isEven(value: int): boolean
+isOdd(value: int): boolean
+isPrime(value: int): boolean

+isEven(MyInteger: int): boolean
+isOdd(MyInteger: int): boolean
+isPrime(MyInteger: int): boolean

static parseInt(charArray: char[]): int
static parseInt(stringArray: String[])
 */

import javax.swing.plaf.TreeUI;

class MyInteger {
    static int numObject = 0;
    private int value;

    public MyInteger() {
        this.value = ++numObject;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        if (value % 2 == 0)
            return true;
        else
            return false;
    }
    public boolean isOdd() {
        if (value % 2 == 1)
            return true;
        else;
            return false;
    }
    public boolean isPrime() {
        for (int i = 1; i < value; i++) {
            if (value % i == 0)
                return true;
        }
        return false;
    }
 }