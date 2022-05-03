import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.print("Enter second string: ");
        String input2 = sc.nextLine();

        longestCommonSubstring(input, input2);
    }

    public static void longestCommonSubstring(String input, String input2) {
        int[][] table = new int[input.length() + 1][input2.length() + 1];
        int maxLength = 0;
        int lastIndex = 0;
        String result;

        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= input2.length(); j++) {
                if (input.charAt(i - 1) == input2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                    if (table[i][j] > maxLength) {
                        maxLength = table[i][j];
                        lastIndex = i;
                    }
                }
            }
        }
        result = input.substring(lastIndex - maxLength, lastIndex);
        System.out.println(result);
    }
}