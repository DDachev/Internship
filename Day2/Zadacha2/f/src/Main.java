import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to enter and which number to look for: ");
        int[] input = new int[2];

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }
        int M = input[0];
        int K = input[1];

        int[] arr2 = new int[M];
        System.out.print("Enter the numbers: ");

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        int sum = 0;
        int maxSum = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr2.length; i++) {
            for (int j = i; j < K; j++) {
                sum += arr2[j];
                result.append(arr2[j]).append(" ");
            }
            if (sum > maxSum) {
                maxSum = sum;
                sum = 0;
                result.delete(0, result.length());
            } else {
                sum = 0;
            }

        }
        System.out.println("The maximum sum is: " + maxSum);
        System.out.println("The sequence is: " + result);
    }
}