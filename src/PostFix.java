import java.util.HashSet;
import java.util.Set;

import dataStrcutures.stack.ListStack;

public class PostFix {

    private ListStack stack;
    private String expression;
    private HashSet<String> OPERATORS = new HashSet<>(Set.of("+","-","*","/","^"));

    public PostFix(String expression) {
        this.expression = expression;
        stack = new ListStack();
    }

    public int evaluate() {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isOperand(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                int opperand1 = stack.pop();
                int opperand2 = stack.pop();
                int value = operate(opperand2, opperand1, token);
                stack.push(value);
            }
        }
        return stack.pop();
    }

    private int operate(int a, int b, String token) {
        switch (token) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0)
                    return a / b;
                else
                    throw new ArithmeticException("Dividng by zero not allowed");
            case "^":
                return (int) Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Token not found");
        }
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private boolean isOperand(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
