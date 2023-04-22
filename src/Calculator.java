import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char c = 'y';
        System.out.println("*****Calculator*****");
        System.out.println("1.Addition\n2.Subtract\n3.Multiply\n4.Divide");
        do {
            System.out.println("Choice: ");
            while(!scan.hasNextInt()){
                System.out.println("Invalid input please choose a number: ");
                scan.next();
            }
            int choice = scan.nextInt();
            while(choice<1 || choice>4){
                while(!scan.hasNextInt()){
                    System.out.println("Invalid input please choose a number between 1 and 4: ");
                    scan.next();
                }
                choice = scan.nextInt();
            }
            System.out.println("Give number 1: ");
            while(!scan.hasNextDouble()){
                System.out.println("Invalid choice please choose a number: ");
                scan.next();
            }
            double num1 = scan.nextDouble();
            System.out.println("Give number 2: ");
            while(!scan.hasNextDouble()){
                System.out.println("Invalid choice please choose a number: ");
                scan.next();
            }
            double num2 = scan.nextDouble();
            switch (choice) {
                case 1: 
                    add(num1,num2);
                    break;
                case 2:
                    sub(num1, num2);
                    break;
                case 3:
                    mul(num1, num2);
                    break;
                case 4:
                    div(num1, num2);
                    break;
            }
            System.out.println("Do you want to quit, press 'q'");
            scan.nextLine();
            c = scan.next().charAt(0);
        } while (!(c=='q'));
        scan.close();
    }

    static void add(double num1, double num2){
        System.out.println("Sum is: "+(num1+num2));
    }
    static void sub(double num1, double num2){
        System.out.println("Difference is: "+(num1-num2));
    }
    static void mul(double num1, double num2){
        System.out.println("Product is: "+(num1*num2));
    }
    static void div(double num1, double num2){
        System.out.println("Quotient is: "+(num1/num2));
    }
}
