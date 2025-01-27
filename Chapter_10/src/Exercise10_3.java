public class Exercise10_3 {
    public static void main(String[] args) {

        MyInteger num = new MyInteger(-10);
        
        // Test methods related to instances
        System.out.println(num.getValue());
        System.out.println("Even: " + num.isEven());
        System.out.println("Odd: " + num.isOdd());
        System.out.println("Prime: " + num.isPrime());
        
        // Test static methods
        System.out.println();
        System.out.println("Even: " + MyInteger.isEven(5));
        System.out.println("Odd: " + MyInteger.isOdd(5));
        System.out.println("Prime: " + MyInteger.isPrime(5));
    }
}
