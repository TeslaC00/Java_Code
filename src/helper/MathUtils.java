package helper;

public class MathUtils {

    public static int gcd(int a, int b) {
        int min = Math.min(a, b);
        int number = min;
        while (number > 1) {
            if (a % number == 0 && b % number == 0) {
                return number;
            }
            number--;
        }
        return 1;
    }

    public static boolean isPrime(int number) {
        int counter = 2;
        while (counter * counter <= number) {
            if (number % counter == 0)
                return false;
            counter++;
        }
        return true;
    }

    public static long factorial(int number){
        long result = 1;
        while (number>0) {
            result*=number--;
        }
        return result;
    }

}
