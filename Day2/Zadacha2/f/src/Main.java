import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to enter and length of the sequence: ");
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
        int highestSum = 0;
        StringBuilder result = new StringBuilder();

        //find the longest increasing subsequence with highest sum
        for (int i = 0; i < arr2.length; i++) {
            for (int j = i; j < i + K; j++) {
                if (i + K > arr2.length) {
                    break;
                }
                sum += arr2[j];
            }

            if (sum > highestSum) {
                highestSum = sum;
                result.setLength(0);
                for (int k = i; k < i+K; k++) {
                    result.append(arr2[k]).append(" ");
                }
            }
            sum = 0;
        }

        System.out.println("The maximum sum is: " + highestSum);
        System.out.println("The sequence is: " + result);
    }
}