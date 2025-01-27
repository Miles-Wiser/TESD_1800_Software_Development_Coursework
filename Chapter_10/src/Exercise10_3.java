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
        int anyIntger = 10;
        System.out.println("Any integer: " + anyIntger);
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
        System.out.println(num.equals(23));
        System.out.println(num.equals(num1));

        // // Test static "parse" methods
        // System.out.println();
        // char[] myChar = {'1', '2', '3'};
        // // System.out.println(MyInteger.parseInt(myChar);
        // System.out.println(MyInteger.parseInt("-145"));
    }
}
