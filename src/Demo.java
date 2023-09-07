import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // ListCreater listCreater = new ListCreater();
        // listCreater.menu();
        Scanner scan = new Scanner(System.in);
        InfixToPostfix demo = new InfixToPostfix("( 3 + ( 4 * 5 ) ) * 5 + ( 6 / 3 )");  // Ans:117
        scan.close();
        System.out.println(demo.evaluate());
        PostFix postFix = new PostFix(demo.evaluate());
        System.out.println(postFix.evaluate());
    }
}
