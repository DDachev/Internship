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

        int sum = 0;
        int maxSum = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                end = i;
            } else if (sum < 0) {
                sum = 0;
                start = i;
            }

        }

        System.out.print("The sequence with the largest sum is: ");
        for (int i = start + 1; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}