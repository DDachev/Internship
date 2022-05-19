import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        subTaskA(sc);
        System.out.println();
        subTaskB(sc);
        System.out.println();
        subTaskC(sc);


    }

    public static void subTaskA(Scanner sc) {
        System.out.println("Enter random letters and numbers (positive and negative): ");
        String inputA = sc.nextLine();
        String[] arrA = inputA.split(" ");

        System.out.println("All integers");
        for (String s : arrA) {
            if (s.matches("[+-]?\\d+")) {
                System.out.print(s + " ");
            }
        }

        System.out.println("\nPositive integers");
        for (String s : arrA) {
            if (s.matches("[+]?\\d+")) {
                System.out.print(s + " ");
            }
        }
        System.out.println("\nNegative numbers");
        for (String s : arrA) {
            if (s.matches("[-]\\d+")) {
                System.out.print(s + " ");
            }
        }
    }

    public static void subTaskB(Scanner sc) {
        System.out.println("Enter symbols: ");
        String inputB = sc.nextLine();

        String[] arrB = inputB.split(" ");
        System.out.println("\nWeird symbols: ");
        for (String s : arrB) {
            if (!s.matches("[0-9a-zA-Z~!@#$%^&*()_+-=/\\]]")) {
                System.out.print(s + " ");
            }
        }
    }

    public static void subTaskC(Scanner sc) {
        String inputC = sc.nextLine();
        //String str3 = "INSERT INTO tableName (column1, column2, column3) VALUES (value1, value2, value3)";

        if (inputC.matches("INSERT INTO [a-zA-Z0-9_]+\\([a-zA-Z0-9_,]+\\) VALUES \\([a-zA-Z0-9_,]+\\)")) {
            System.out.println("Valid SQL query");
        } else {
            System.out.println("Invalid SQL query");
        }
    }
}