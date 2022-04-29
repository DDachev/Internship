import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //a)
    /*    System.out.print("Enter a sentence: ");
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
        System.out.println(count);*/

        //c) check if there are . ? !
        System.out.print("Enter a sentence: ");
        String input3 = sc.nextLine();
        StringBuilder sentence = new StringBuilder();
        for (int i=0; i<input3.length(); i++) {
            sentence.append(input3.charAt(i));
            if (input3.charAt(i) == '.' || input3.charAt(i) == '?' || input3.charAt(i) == '!') {
                System.out.println(sentence.toString().trim());
                sentence.delete(0, sentence.length());
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