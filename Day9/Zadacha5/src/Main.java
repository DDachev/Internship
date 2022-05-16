import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] words = sc.nextLine().split("\\s+");
            String target = words[0];
            String replacement = words[1];
            text = text.replaceFirst(target, replacement);
        }
        System.out.println(text);
    }
}