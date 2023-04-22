import java.util.Scanner;
import java.util.Random;
class Guess{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int guess = 0,attempt=0;
        int num = new Random().nextInt(100)+1;
        System.out.println("WELCOME TO THE GUESSING GAME");
        System.out.println("Guess a Number Between 1 and 100");
        while(guess != num){
            System.out.println("Enter your number: ");
            guess = scan.nextInt();
            attempt ++;
            if(guess > num) System.out.println("Guess is too High");
            else if(guess < num) System.out.println("Guess is too Low");
            else System.out.println("Correct Attempts: "+attempt);
        }
        scan.close();
    }
}