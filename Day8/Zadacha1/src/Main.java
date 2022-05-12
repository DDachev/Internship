import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        while (!inputLine.equals("END")) {
            try {
                int number = Integer.parseInt(inputLine);
                System.out.println("Number");
            }
            catch (NumberFormatException e) {
                System.out.println("Not a number");
            }
            inputLine = sc.nextLine();
        }
    }
}