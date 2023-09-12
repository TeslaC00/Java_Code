import java.util.HashSet;
import java.util.Set;

import dataStrcutures.stack.ListStack;

public class InfixConverter {

    private String expression;
    private ListStack<String> stack;
    private StringBuilder output;
    private final HashSet<String> OPERATORS = new HashSet<>(Set.of("+", "-", "*", "/", "^", "(", ")"));

    public InfixConverter() {
        stack = new ListStack<>();
    }

    public InfixConverter(String expression) {
        this();
        setExpression(expression);
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String evaluateToPostfix() {
        output = new StringBuilder();
        return evaluate("(", ")");
    }

    public String evaluateToPrefix() {
        output = new StringBuilder();
        setExpression(reverseString(expression));
        String prefix = evaluate(")", "(");
        return reverseString(prefix);
    }

    private String evaluate(String startBracket, String endBracket) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isOperator(token))
                handleOperator(token, startBracket, endBracket);
            else
                output.append(token+" ");
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()+" ");
        }
        return output.toString();
    }

    private void handleOperator(String token, String startBracket, String endBracket) {

        if (token.equals(endBracket)) {
            while (!stack.peek().equals(startBracket)) {
                output.append(stack.pop()+" ");
            }
            stack.pop();
            return;
        }

        int valStack = precedence(stack.peek());
        int valToken = precedence(token);

        while (!token.equals(startBracket) && valStack > valToken) {
            output.append(stack.pop()+" ");
            valStack = precedence(stack.peek());
        }

        stack.push(token);

    }

    private int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            case "(":
            case ")":
                return 0;
            case null:
            default:
                return -1;
        }
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private String reverseString(String expression) {
        StringBuilder reversed = new StringBuilder();
        for (int i = expression.length() - 1; i >= 0; i--) {
            reversed.append(expression.charAt(i));
        }
        return reversed.toString();
    }
}
