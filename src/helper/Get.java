package helper;

import java.util.Scanner;
public class Get {
    
    Get(){}
    static Scanner scan = new Scanner(System.in);

    public static void array(int arr[], int size){ //method to scan int array of size "size"
        for(int i=0; i<size; i++){
            System.out.println("Type the "+(i+1)+" element of array: ");
            arr[i] = scan.nextInt();               //scan the input of int type
        }
    }

    public static void array(char arr[], int size){ //method to scan char array of size "size"
        for(int i=0; i<size; i++){
            System.out.println("Type the "+(i+1)+" element of array: ");
            arr[i] = scan.next().charAt(0);  //scan the input of char type
        }
    }

    public static void array(float arr[], int size){ //method to scan float array of size "size"
        for(int i=0; i<size; i++){
            System.out.println("Type the "+(i+1)+" element of array: ");
            arr[i] = scan.nextFloat();             //scan the input of float type
        }
    }

    public static void array(long arr[], int size){ //method to scan long array of size "size"
        for(int i=0; i<size; i++){
            System.out.println("Type the "+(i+1)+" element of array: ");
            arr[i] = scan.nextLong();              //scan the input of long type
        }
    }

    public static void array(double arr[], int size){ //method to scan double array of size "size"
        for(int i=0; i<size; i++){
            System.out.println("Type the "+(i+1)+" element of array: ");
            arr[i] = scan.nextDouble();            //scan the input of double type
        }
    }
}
