import dataStrcutures.stack.ListStack;

public class Prefix {

    String expression;
    ListStack<Integer> stack;
    String OPERATORS = "+-*/^";

    public Prefix(String expression) {
        this.expression = expression;
        stack = new ListStack<>();
    }

    public int evaluate() {
        String[] tokens = expression.split(" ");
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (isOperand(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else if (isOperator(tokens[i])) {
                int opperand1 = stack.pop();
                int opperand2 = stack.pop();
                int answer = operate(opperand1, opperand2, tokens[i]);
                stack.push(answer);
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
                throw new IllegalArgumentException("Token not valid");
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
