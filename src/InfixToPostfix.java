import java.util.HashSet;
import java.util.Set;

import dataStrcutures.stack.ListStack;

public class InfixToPostfix {

    private String expression;
    private ListStack<String> stack;
    private StringBuilder output = new StringBuilder();
    private final HashSet<String> OPERATORS = new HashSet<>(Set.of("+", "-", "*", "/", "^", "(", ")"));

    public InfixToPostfix(String expression) {
        setExpression(expression);
        stack = new ListStack<>();
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String evaluate() {
        String[] tokens = expression.split("");
        for (String token : tokens) {
            if (isOperator(token))
                handleOperator(token, "(", ")");
            else
                output.append(token + " ");
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop() + " ");
        }
        return output.toString();
    }

    private void handleOperator(String token, String startBracket, String endBracket) {

        int valStack = precedence(stack.peek());
        int valToken = precedence(token);

        if (token.equals(endBracket)) {
            while (!stack.peek().equals(startBracket)) {
                output.append(stack.pop() + " ");
            }
            stack.pop();
            return;
        }
        while (!token.equals(startBracket) && valStack > valToken) {
            output.append(stack.pop() + " ");
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
}
