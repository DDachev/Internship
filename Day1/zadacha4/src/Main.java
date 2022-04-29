import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //a)
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != 'a' && input.charAt(i) != 'e' && input.charAt(i) != 'i' && input.charAt(i) != 'o' && input.charAt(i) != 'u') {
                result.append((input.charAt(i)));
            }
        }
        System.out.println(result);

        //b)
        System.out.print("Enter a sentence: ");
        String input2 = sc.nextLine();
        String cleanInput = input2.trim().replaceAll("[^a-zA-Z]", " ");

        String[] words = cleanInput.split("\\s");

        int count = 0;
        for (String word : words) {
            if (word.matches("[a-zA-Z]+") && word.length() > 1) {
                count++;
            }
        }
        System.out.println(count);

        //c)
        System.out.print("Enter a sentence: ");
        String input3 = sc.nextLine();


        String[] sentences = input3.split("\\.");
        
        if (sentences.length > 1) {
            for (String sentence : sentences) {
                System.out.println(sentence);
            }
        }

        String[] sentences2 = input3.split("\\?");
        if (sentences2.length > 1) {
            for (String sentence : sentences2) {
                System.out.println(sentence);
            }
        }

        String[] sentences3 = input3.split("\\!");
        if (sentences3.length > 1) {
            for (String sentence : sentences3) {
                System.out.println(sentence);
            }
        }

        //d)
        System.out.print("Enter a sentence: ");
        String input4 = sc.nextLine();

        String[] numbers = input4.split("\\s");
        int sum = 0;

        for (String number : numbers) {
            if (number.matches("[0-9]+")) {
                sum += Integer.parseInt(number);
            }
        }
        System.out.println(sum);
    }
}