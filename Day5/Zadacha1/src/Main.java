import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        while (!command.equalsIgnoreCase("END")) {
            String[] tokens = command.split("\\s");
            double a = Double.parseDouble(tokens[1]);
            double b = Double.parseDouble(tokens[2]);
            Calculator calc = new Calculator(a, b);

            switch (tokens[0]) {
                case "SUM":
                    System.out.printf("%.3f", calc.sum());
                    break;
                case "SUB":
                    System.out.printf("%.3f", calc.subtract());
                    break;
                case "MUL":
                    System.out.printf("%.3f", calc.multiply());
                    break;
                case "DIV":
                    System.out.printf("%.3f", calc.divide());
                    break;
                case "PER":
                    System.out.printf("%.3f", calc.percentage());
                    break;
                default:
                    System.out.println("Invalid operation");
                    break;
            }
            System.out.println();
            command = sc.nextLine();
        }
    }
}