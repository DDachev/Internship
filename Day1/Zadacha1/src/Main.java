import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // a)
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        String stringNumber = String.valueOf(number);
        char result = stringNumber.charAt(0);
        System.out.println(result);

        // second way with loop
        System.out.print("Enter a number: ");
        int number2 = sc.nextInt();
        String stringNumber2 = String.valueOf(number2);

        int k = 0;
        do {
            char result2 = stringNumber2.charAt(k);
            System.out.println(result2);
            break;
        } while (k < stringNumber2.length());


        //b)
        System.out.print("Enter a number: ");
        int number3 = sc.nextInt();
        String stringNumber3 = String.valueOf(number3);
        StringBuilder result3 = new StringBuilder(stringNumber3);
        result3.reverse();
        System.out.println("Reversed number: " + result3);

        // second way with loop
        System.out.print("Enter a number: ");
        int number4 = sc.nextInt();
        String stringNumber4 = String.valueOf(number4);
        int length4 = stringNumber4.length() - 1;
        StringBuilder result4 = new StringBuilder();
        System.out.print("Reversed number: ");
        for (int i = length4; i >= 0; i--) {
            char result5 = stringNumber4.charAt(i);
            result4.append(result5);
        }
        System.out.println(result4);

        // third way with loop
        System.out.print("Enter a number: ");
        int number6 = sc.nextInt();
        String stringNumber6 = String.valueOf(number6);
        System.out.print("Reversed number: ");
        for (int i = stringNumber6.length() - 1; i >= 0; i--) {
            System.out.print(stringNumber6.charAt(i));
        }
        System.out.println();

        // c)
        System.out.print("Enter a number: ");
        int number7 = sc.nextInt();
        String stringNumber7 = String.valueOf(number7);
        int length7 = stringNumber7.length();
        int sum = 0;
        for (int i = 0; i < length7; i++) {
            char result7 = stringNumber7.charAt(i);
            int digit = Character.getNumericValue(result7);
            sum += digit;
        }
        System.out.println("Sum: " + sum);

        // second way with loop
        System.out.print("Enter a number: ");
        int number8 = sc.nextInt();
        String stringNumber8 = String.valueOf(number8);
        int sum2 = 0;
        for (int i = 0; i < stringNumber8.length(); i++) {
            sum2 += Integer.parseInt(String.valueOf(stringNumber8.charAt(i)));
        }
        System.out.println("Sum2: " + sum2);

        //d)
        System.out.print("Enter a number: ");
        int number9 = sc.nextInt();
        for (int i = 1; i < number9; i++) {
            if (number9 % i == 0) {
                System.out.print(i + " ");
            }
        }

        //e)
        // method that checks if a number is prime
        System.out.print("Enter a number: ");
        int number10 = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= number10; i++) {
            if (number10 % i == 0) {
                count++;
            }
        }
        System.out.println(count==2);


        //f)
        System.out.print("Enter a number: ");
        int number11 = sc.nextInt();
        System.out.println(Integer.toBinaryString(number11));
        System.out.println(Integer.toHexString(number11));
    }
}