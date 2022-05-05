public class Calculator {
    private final double a;
    private final double b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double sum() {
        return a + b;
    }

    public double subtract() {
        return a - b;
    }

    public double multiply() {
        return a * b;
    }

    public double divide() {
        return a / b;
    }

    public double percentage() {
        return a * (b / 100);
    }
}
