import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.print("Enter command (encode or decode): ");
        String command = sc.nextLine();

        if (command.equals("encode")) {
            StringBuilder encoded = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (Character.isLetter(c)) {
                    encoded.append((char) (c + 1));
                } else {
                    encoded.append(c);
                }
            }

            System.out.println("Encoded: " + encoded);

        } else if (command.equals("decode")) {
            StringBuilder decoded = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (Character.isLetter(c)) {
                    decoded.append((char) (c - 1));
                } else {
                    decoded.append(c);
                }
            }
            System.out.println("Decoded: " + decoded);
        }
    }
}