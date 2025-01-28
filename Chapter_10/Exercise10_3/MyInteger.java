class MyInteger {
    private int value;
 
    public MyInteger(int value) {
        this.value = value;
    }
 
    public int getValue() {
        return value;
    }

    /// is Even Methods

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
    // is instance.getValue even
    public static boolean isEven(MyInteger instance) {
        if (instance.getValue() % 2 == 0)
            return true;
        else
            return false;
    }

    /// isOdd Methods

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
    // is instance.getValue odd
    public static boolean isOdd(MyInteger instance) {
        if (instance.getValue() % 2 == 1)
            return true;
        else;
            return false;
    }

    /// isPrime Methods

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
    // is instance.getValue() prime
    public static boolean isPrime(MyInteger instance) {
        if (instance.getValue() <= 1)
            return false;

        for (int i = 2; i <= instance.getValue(); i++) {
            if (instance.getValue() % i == 0 && instance.getValue() == i)
                return true;
            else if (instance.getValue() % i == 0)
                return false;
        }
        
        return false;
    }

    /// equals() methods
    
    public boolean equals(int anyIntger) {
        if (this.value == anyIntger)
            return true;

        else
            return false;
    }

    public boolean equals(MyInteger instance) {
        if (this.value == instance.getValue())
            return true;

        else
            return false;
    }


    /// parseInt() methods
    
    // This method considers digits as their decimal value, not their ASCII values.
    // I.e. char '1' is equal to int 1.
    // Other characters will work but will be subtracted by 48 first.
    // This is to make digits work as descibed above.
    public static int parseInt(char[] charArray) {
        int sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            sum += charArray[i] - 48;
        }

        return sum;
    }

    // This method considers digits as their decimal value, not their ASCII values.
    // I.e. char '1' is equal to int 1.
    // Other characters will work but will be subtracted by 48 first.
    // This is to make digits work as descibed above.
    public static int parseInt(String s) {
        int sum = 0;
        boolean pos = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) == '\u002D' && i == 0) {
                pos = false;
                continue;
            }
            sum += (s.charAt(i) - 48) * Math.pow(10, s.length() - i - 1);
        }

        if (!pos)
            sum *= -1;

        return sum;
    }
}
