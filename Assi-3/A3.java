import java.util.Scanner;

class NumberIsZeroException extends Exception {
    public NumberIsZeroException(String msg) { super(msg); }
}

public class A3 {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            if (n == 0) throw new NumberIsZeroException("Number is 0");
            System.out.println(n + (isPrime(n) ? " is a prime number." : " is not a prime number."));
        } catch (NumberIsZeroException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}