/*
        MyInteger
-------------------------
static parseInt(charArray: char[]): int
static parseInt(stringArray: String[]): int
 */

class MyInteger {
    private int value;
 
    public MyInteger(int value) {
        this.value = value;
    }
 
    public int getValue() {
        return value;
    }

    // is this.value even
    public boolean isEven() {
        if (value % 2 == 0)
            return true;
        else
            return false;
    }
    // is any number input into the method even
    public static boolean isEven(int anyNumber) {
        if (anyNumber % 2 == 0)
            return true;
        else
            return false;
    }
    // is this.value odd
    public boolean isOdd() {
        if (value % 2 == 1)
            return true;
        else;
            return false;
    }
    // is any number input into the method odd
    public static boolean isOdd(int anyNumber) {
        if (anyNumber % 2 == 1)
            return true;
        else;
            return false;
    }
    // is this.value prime
    public boolean isPrime() {
        if (value <= 1)
            return false;

        for (int i = 2; i <= value; i++) {
            if (value % i == 0 && value == i)
                return true;
            else if (value % i == 0)
                return false;
        }
        
        return false;
    }
    // is any number input into the method prime
    public static boolean isPrime(int anyNumber) {
        if (anyNumber <= 1)
            return false;

        for (int i = 2; i <= anyNumber; i++) {
            if (anyNumber % i == 0 && anyNumber == i)
                return true;
            else if (anyNumber % i == 0)
                return false;
        }
        
        return false;
    }
}
