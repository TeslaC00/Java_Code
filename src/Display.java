public class Display {
    
    Display(){}

    public static <T> void array(T a[]){
        for(T i: a){
            System.out.println(i);
        }
    }

    public static void array(int a[]) {   //method to display int array on output screen
        for(int i: a){
            System.out.print(i+" ");
        }
    }

    public static void array(char a[]) {   //method to display char array on output screen
        for(char i: a){
            System.out.print(i+" ");
        }
    }

    public static void array(float a[]) {   //method to display float array on output screen
        for(float i: a){
            System.out.print(i+" ");
        }
    }

    public static void array(long a[]) {   //method to display long array on output screen
        for(long i: a){
            System.out.print(i+" ");
        }
    }

    public static void array(double a[]) {  //method to display double array on output screen
        for(double i: a){
            System.out.print(i+" ");
        }
    }
}
