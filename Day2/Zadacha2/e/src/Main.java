import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to enter: ");
        int m = sc.nextInt();
        int[] arr = new int[m];
        System.out.print("Enter the numbers: ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sequence = new StringBuilder();
        StringBuilder longestSequence = new StringBuilder();
        sequence.append(arr[0]).append(" ");

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                sequence.append(arr[i]).append(" ");
            } else {
                sequence.setLength(0);
                sequence.append(arr[i]).append(" ");
            }
            if (sequence.length() > longestSequence.length()) {
                longestSequence.setLength(0);
                longestSequence.append(sequence);
            }
        }
        System.out.println(longestSequence);
    }
}