import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class InfixToPostfix {

    private String expression;
    private ArrayDeque<String> stack;
    private StringBuilder output = new StringBuilder();
    private final HashSet<String> OPERATORS = new HashSet<>(Set.of("+", "-", "*", "/", "^", "(", ")"));

    public InfixToPostfix(String expression) {
        setExpression(expression);
        stack = new ArrayDeque<>();
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String evaluate() {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isOperator(token))
                evalOperator(token);
            else
                output.append(token + " ");
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop() + " ");
        }
        return output.toString();
    }

    private void evalOperator(String token) {

        int valStack = precedence(stack.peek());
        int valToken = precedence(token);

        if (token.equals(")")) {
            while (!stack.peek().equals("(")) {
                output.append(stack.pop() + " ");
            }
            stack.pop();
            return;
        }
        if (!token.equals("(") && valStack > valToken)
            output.append(stack.pop() + " ");

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
