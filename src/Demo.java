import java.util.Scanner;

import dataStrcutures.stack.ListStack;

public class Demo {
    final static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        // ListCreater listCreater = new ListCreater();
        // listCreater.menu();
        
        // Infix to Postfix
        InfixConverter demo = new InfixConverter("A * ( B + D ) / E - F * ( G + H / K )"); // Ans:117
        // A B D + E / * F G H K / + * - 
        System.out.println(demo.evaluateToPostfix());
        // PostFix postFix = new PostFix(demo.evaluate());
        // System.out.println(postFix.evaluate());
        
        // Infix to Prefix
        // - / * A + B D E * F + G / H K
        System.out.println(demo.evaluateToPrefix());

        // Reverse String using stack
        // System.out.println(reverse("This is a test sentence"));
        
        // Check Parenthesis for balanced
        // checkParenthesis();
    }

    private static void checkParenthesis() {
        System.out.println("() : "+ParenthesisBalanced("()")); // Balanced
        System.out.println("(()) : "+ParenthesisBalanced("(())")); // Balanced
        System.out.println("( : "+ParenthesisBalanced("(")); // UnBalanced
        System.out.println(") : "+ParenthesisBalanced(")")); // UnBalanced
        System.out.println("()() : "+ParenthesisBalanced("()()")); // Balanced
        System.out.println("(())() : "+ParenthesisBalanced("(())()")); // Balanced
        System.out.println("(())()) : "+ParenthesisBalanced("(())())")); // UnBalanced
        System.out.println("()()( : "+ParenthesisBalanced("()()(")); // UnBalanced
    }

    private static String reverse(String string) {
        String str[] = string.split(" ");
        ListStack<String> stack = new ListStack<>();
        for (String word : str) {
            stack.push(word);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : stack) {
            stringBuilder.append(word + " ");
        }
        return stringBuilder.toString();
    }

    public static String ParenthesisBalanced(String string) {
        ListStack<String> stack = new ListStack<>();
        for (String token : string.split("")) {
            if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                if (stack.isEmpty())
                    return "Parenthesis UnBalanced";
                stack.pop();
            }
        }
        return stack.isEmpty() ? "Parenthesis Balanced" : "Parenthesis UnBalanced";
    }
}
