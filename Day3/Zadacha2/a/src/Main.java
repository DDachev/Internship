import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String input) {

        if (input.length() == 0) {
            return true;
        }
        if (input.length() == 1) {
            return true;
        } else {
            StringBuilder reverseString = new StringBuilder();
            reverseString.append(input);
            reverseString.reverse();
            String reverse = reverseString.toString();
            return input.equals(reverse);
        }
    }
}