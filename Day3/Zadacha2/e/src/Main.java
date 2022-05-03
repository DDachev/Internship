import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();
        System.out.print("Enter second string: ");
        String input2 = sc.nextLine().toLowerCase();

        boolean isPossible = true;

        for (int i = 0; i < input2.length(); i++) {
            if (!input.contains(String.valueOf(input2.charAt(i)))) {
                isPossible = false;
                break;
            } else {
                input = input.replaceFirst(String.valueOf(input2.charAt(i)), "");
            }
        }
        System.out.println(isPossible);
    }
}