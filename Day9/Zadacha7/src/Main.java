import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.printf("%.6f", evaluate(input));
    }

    public static double evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;

            if (Operations.isOperand(tokens[i])) {
                StringBuilder sb = new StringBuilder();

                while (i < tokens.length && Operations.isOperand(tokens[i]) || tokens[i] == '.') {
                    sb.append(tokens[i++]);
                }

                values.push(Double.parseDouble((sb.toString())));
                i--;

            } else if (Operations.isLeftBracket(tokens[i])) ops.push(tokens[i]);

            else if (Operations.isRightBracket(tokens[i])) {

                while (!Operations.isLeftBracket(ops.peek())) {
                    values.push(Operations.applyOperation(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();

            } else if (Operations.isOperator(tokens[i])) {

                while (!ops.empty() && Operations.hasPriority(tokens[i], ops.peek())) {
                    values.push(Operations.applyOperation(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
        }
        while (!ops.empty()) values.push(Operations.applyOperation(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }
}
