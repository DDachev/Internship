import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(isBalanced(input));
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
        System.out.println("openRoundedBrackets: " + openRoundedBrackets);
        System.out.println("closedRoundedBrackets: " + closedRoundedBrackets);
        System.out.println("openCurlyBrackets: " + openCurlyBrackets);
        System.out.println("closedCurlyBrackets: " + closedCurlyBrackets);
        System.out.println("openSquareBrackets: " + openSquareBrackets);
        System.out.println("closedSquareBrackets: " + closedSquareBrackets);

        return openCurlyBrackets == closedCurlyBrackets && openSquareBrackets == closedSquareBrackets && openRoundedBrackets == closedRoundedBrackets;
    }
}