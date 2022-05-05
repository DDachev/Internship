import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (!isBalanced(input)) {
            System.out.println("false");
        } else {
            System.out.println(validParentheses(input));
        }
    }

    public static boolean isBalanced(String input) {
        int openRoundedBrackets = 0;
        int openSquareBrackets = 0;
        int openCurlyBrackets = 0;
        int closedRoundedBrackets = 0;
        int closedSquareBrackets = 0;
        int closedCurlyBrackets = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            switch (currentChar) {
                case '(' -> openRoundedBrackets++;
                case ')' -> closedRoundedBrackets++;
                case '{' -> openCurlyBrackets++;
                case '}' -> closedCurlyBrackets++;
                case '[' -> openSquareBrackets++;
                case ']' -> closedSquareBrackets++;
            }
        }

        return openCurlyBrackets == closedCurlyBrackets && openSquareBrackets == closedSquareBrackets &&
                openRoundedBrackets == closedRoundedBrackets;
    }

    public static boolean validParentheses(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}