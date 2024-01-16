package other;

public class ADA {
    public static void main(String[] args) {

        System.out.println("Fibonnacci: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i)+" ");
        }
        System.out.println();
        System.out.println("Factorial: "+factorial(5));

    }

    public static int fibonacci(int number) {
        if (number == 0)
            return 0;
        if (number == 1)
            return 1;
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static int factorial(int number) {
        if (number == 0)
            return 1;
        return number * factorial(number - 1);
    }

}
