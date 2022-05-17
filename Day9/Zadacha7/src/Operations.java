public class Operations {

    public static boolean hasPriority(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if (op1 == '^')
            return false;
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    static boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    static boolean isLeftBracket(char c) {
        return c == '(';
    }

    static boolean isRightBracket(char c) {
        return c == ')';
    }

    public static double applyOperation(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case '^':
                return Math.pow(a, b);
        }
        return 0;
    }
}
