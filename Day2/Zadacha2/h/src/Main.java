import java.util.Arrays;
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

        Arrays.sort(arr);
        int lonelyNumber = 0;
        int count = 0;

        for (int i : arr) {
            for (int j : arr) {
                if (i == j) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                lonelyNumber = i;
            }
            count = 0;
        }
        System.out.println(lonelyNumber);
    }
}


