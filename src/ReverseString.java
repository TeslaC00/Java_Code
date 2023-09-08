import dataStrcutures.stack.ListStack;

public class ReverseString {

    public static String reverse(String string) {
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
}
