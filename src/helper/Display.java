package helper;

public class Display {

    public static <T> void array(T array[]){
        for(T item: array){
            System.out.println(item);
        }
        System.out.println();
    }

    public static void array(int array[]) {   //method to display int array on output screen
        for(int item: array){
            System.out.print(item+" ");
        }
        System.out.println();
    }

    public static void array(char array[]) {   //method to display char array on output screen
        for(char item: array){
            System.out.print(item+" ");
        }
        System.out.println();
    }

    public static void array(float array[]) {   //method to display float array on output screen
        for(float item: array){
            System.out.print(item+" ");
        }
        System.out.println();
    }

    public static void array(long array[]) {   //method to display long array on output screen
        for(long item: array){
            System.out.print(item+" ");
        }
        System.out.println();
    }

    public static void array(double array[]) {  //method to display double array on output screen
        for(double item: array){
            System.out.print(item+" ");
        }
        System.out.println();
    }
}
