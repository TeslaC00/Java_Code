public class InfixToPrefix {

    String expression = "";

    public InfixToPrefix(String expression) {
        this.expression = expression;
    }

    public String evaluate(){
        InfixToPostfix temp = new InfixToPostfix(reverseString(expression));
        String output = temp.evaluate();
        return reverseString(output);
    }

    public String reverseString(String expression) {
        StringBuilder reversed = new StringBuilder();
        for (int i = expression.length()-1; i >=0; i--) {
            reversed.append(expression.charAt(i));
        }
        return reversed.toString();
    }
}
