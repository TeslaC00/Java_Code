public class Demo {
    public static void main(String[] args) {
        // ListCreater listCreater = new ListCreater();
        // listCreater.menu();
        InfixToPostfix demo = new InfixToPostfix("( 3 + 2 ^ 1 ) / ( 5 - 3 ) + 7");
        System.out.println(demo.evaluate());
        PostFix postFix = new PostFix(demo.evaluate());
        int ans = postFix.evaluate();
        System.out.println(ans);
    }
}
