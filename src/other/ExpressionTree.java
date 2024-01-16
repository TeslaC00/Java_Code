package other;
import dataStrcutures.stack.ListStack;

public class ExpressionTree {

    private class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public ExpressionTree() {
        root = null;
    }

    public void createTree(String expression) {
        String[] tokens = expression.split(" ");
        ListStack<Node> stack = new ListStack<>();
        for (String token : tokens) {
            Node node = new Node(token.charAt(0));
            if (isOperand(node)) {
                stack.push(node);
            } else if (isOperator(node)) {
                Node right = stack.pop();
                Node left = stack.pop();
                node.left = left;
                node.right = right;
                stack.push(node);
            }
        }
        root = stack.pop();
    }

    private boolean isOperator(Node node) {
        final String OPERATORS = "+-*/^";
        return OPERATORS.contains(String.valueOf(node.data));
    }

    private boolean isOperand(Node node) {
        return Character.isDigit(node.data);
    }

    public void printInOrder(Node node) {
        if (node != null) {
            if (isOperator(node)) {
                System.out.print("(");
            }
            printInOrder(node.left);
            System.out.print(node.data);
            printInOrder(node.right);
            if (isOperator(node)) {
                System.out.print(")");
            }
        }
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println(); // Add a newline for formatting
    }

}